package uos.lscholz.gedenkstaettendb.playground;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class DataWorkbook extends XSSFWorkbook {

    private ArrayList<String> headerRow;


    public DataWorkbook (InputStream inputStream) throws IOException {
        super(inputStream);
        if(!checkWorkbookFormat()){
            throw new RuntimeException("Given input is not formatted to be a valid DataWorkbook");
        }

    }

    private void setHeaderRow(){
        this.headerRow = new ArrayList<String>();
        Sheet sheet = this.getSheetAt(0);
        Row row = sheet.getRow(sheet.getFirstRowNum());
        short lastCell = row.getLastCellNum();
        int noOfNull =0;
        for(int i=0; i<lastCell; i++){
            Cell cell = row.getCell(i, Row.MissingCellPolicy.RETURN_BLANK_AS_NULL);
            if (cell== null){
                noOfNull++;
            }else {
                if(noOfNull>0){
                    for(int j= 0; j<noOfNull;j++){
                        headerRow.add("");
                    }
                }
                headerRow.add(cell.getStringCellValue());
            }
        }

    }

    /**
     *
     * @param i index of header column to change, zero-based
     * @param content string to which to change header column, not null
     */
    public void setHeader(int i, String content){
        if(i<0||i>headerRow.size()){
            throw new RuntimeException("Given value of i is not within bounds");
        }
        if(content == null){
            throw new RuntimeException("Content may not be null");
        }
        headerRow.set(i, content);
    }


    /**
     * Utility function to determine if a given workbook adheres to the format expectations of the program
     * @return
     */
    private boolean checkWorkbookFormat(){

        if(this.getNumberOfSheets()>1){
            return false;
        }
        Sheet sheet = this.getSheetAt(0);
        int firstRowNum = sheet.getFirstRowNum();
        int nrHeaderColumns = sheet.getRow(firstRowNum).getLastCellNum();
        if(nrHeaderColumns != sheet.getRow(firstRowNum).getPhysicalNumberOfCells()){
            return false;
        }
        int numOfRows = sheet.getPhysicalNumberOfRows();
        int rowsVisited = 1;
        for(int i = firstRowNum+1;rowsVisited<numOfRows-1;i++){
            Row row = sheet.getRow(i);
            if(row != null) {
                rowsVisited++;
                if (row.getLastCellNum() > nrHeaderColumns) {
                    return false;
                }
            }
        }
        return true;
    }
}
