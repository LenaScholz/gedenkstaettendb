package uos.lscholz.gedenkstaettendb.playground;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.regex.Matcher;

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
                return false;
            }
            int numOfRows = sheet.getPhysicalNumberOfRows();
            int rowsVisited = 1;
            for(int i = firstRowNum+1;rowsVisited<numOfRows-1;i++){
                Row row = sheet.getRow(i);
                if(row != null) {
                    rowsVisited++;
                    for (Cell cell : row) {
                    }
                    if (row.getLastCellNum() > nrHeaderColumns) {
                        return false;
                    }
                }
            }
        }
        return true;
    }


    public static Workbook openWorkbook(String filepath){
        Workbook workbook;
        try (FileInputStream inputStream = new FileInputStream(filepath)){

            if(filepath.matches(".*\\.xlsx")) {
                workbook = new XSSFWorkbook(inputStream);
                if(!checkWorkbookFormat(workbook)){
                    throw new RuntimeException("Inadmissable Workbook");
                }
            }else {
                throw new RuntimeException("Given Filepath does not match any supported file format");
            }
            return workbook;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    public static void main(String [] args){
//        String filepath = "/home/lscholz/Dokumente/nonexistent/UkraineGekuerzt.xlsx";
        String filepath = "/home/lena/Bachelorarbeit/Dateien_Augustaschacht/UkraineGekuerzt.xlsx";
        Workbook workbook = null;
        try (FileInputStream inputStream = new FileInputStream(filepath)){
            workbook = new DataWorkbook(inputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(workbook == null){
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

    }
}
