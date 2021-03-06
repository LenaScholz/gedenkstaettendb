package uos.lscholz.gedenkstaettendb.playground;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import uos.lscholz.gedenkstaettendb.model.DataType;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class DataWorkbook extends XSSFWorkbook {

    private ArrayList<String> headerRow;
    private ArrayList<DataType> dataTypes;


    public DataWorkbook (InputStream inputStream) throws IOException {
        super(inputStream);
        if(!checkWorkbookFormat()){
            throw new RuntimeException("Given input is not formatted to be a valid DataWorkbook");
        }
        this.setHeaderRow();
        this.setTypes();

    }

    public String getHeader(int i){
        return headerRow.get(i);
    }

    public DataType getType(int i){
        return dataTypes.get(i);
    }

    /**
     *
     */
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
                    noOfNull = 0;
                }
                headerRow.add(cell.getStringCellValue());
            }
        }

    }

    /**
     *
     */
    private void setTypes(){
        this.dataTypes = new ArrayList<>(this.headerRow.size());
        Sheet sheet = this.getSheetAt(0);
        Row row = sheet.getRow(sheet.getFirstRowNum()+1);
        for(int i =0; i<dataTypes.size();i++){
            Cell cell = row.getCell(i);
            // getCellTypeEnum is listed as deprecated by API
            // getCellType is marked as deprecated by IDE
            // #justWhy
            CellType cellType = cell.getCellTypeEnum();
            dataTypes.add(DataType.convertToType(cellType));

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
     *
     * @param i index of column to change the data type of, zero-based
     * @param type type to which to change, not null
     */
    public void setType(int i, DataType type){
        if(i<0 || i>dataTypes.size()){
            throw new RuntimeException("Given value of i is not within bounds");
        }
        if(type == null){
            throw new RuntimeException("Type may not be null");
        }
        dataTypes.set(i,type);
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
