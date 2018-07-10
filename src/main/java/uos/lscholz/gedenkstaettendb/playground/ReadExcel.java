package uos.lscholz.gedenkstaettendb.playground;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;

public class ReadExcel {

    /**
     * Utility function to determine if a given workbook adheres to the format expectations of the program
     * @param workbook
     * @return
     */
    private static Boolean checkWorkbookFormat(Workbook workbook){

        for(Sheet sheet:workbook){
            int firstRowNum = sheet.getFirstRowNum();
            int nrHeaderColumns = sheet.getRow(firstRowNum).getLastCellNum();
            if(nrHeaderColumns != sheet.getRow(firstRowNum).getPhysicalNumberOfCells()+1){
                System.out.println("Inadmissable workbook 1");
                return false;
            }
            int numOfRows = sheet.getPhysicalNumberOfRows();
            int rowsVisited = 1;
            for(int i = firstRowNum+1;rowsVisited<numOfRows-1;i++){
                Row row = sheet.getRow(i);
                if(row != null) {
                    rowsVisited++;
                    for (Cell cell : row) {
                        System.out.print(cell + " ");
                    }
                    if (row.getLastCellNum() > nrHeaderColumns) {
                        return false;
                    }
                }
            }
        }
        return true;
    }


    public static void main(String [] args){
        String filepath = "/home/lscholz/Dokumente/nonexistent/UkraineGekuerzt.xlsx";
        try (FileInputStream inputStream = new FileInputStream(filepath)) {
            Workbook workbook = new XSSFWorkbook(inputStream);
            if(!checkWorkbookFormat(workbook)){
                System.out.println("Inadmissable workbook");
                System.exit(0);
            }
            int noOfSheets = workbook.getNumberOfSheets();
            for(int i= 0; i<noOfSheets;i++){
                Sheet sheet = workbook.getSheetAt(i);
                for(Row row: sheet) {
                    if(row.getPhysicalNumberOfCells()!=0) {
                        for (Cell cell : row) {
                            System.out.print(cell + " ");
                        }
                        System.out.println();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
