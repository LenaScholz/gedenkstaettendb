package uos.lscholz.gedenkstaettendb.model;

import org.apache.poi.ss.usermodel.CellType;

public enum DataType {
    TEXT, DATE, FLOAT, INTEGER, BOOLEAN;

    public static DataType convertToType(String s) {
        s.toUpperCase();
        switch (s) {
            case "TEXT":
                return DataType.TEXT;
            case "DATE":
                return DataType.DATE;
            case "FLOAT":
            case "DOUBLE":
            case "DECIMAL":
                return DataType.FLOAT;
            case "INTEGER":
            case "INT":
            case "BIGINT":
                return DataType.INTEGER;
            case "BOOLEAN":
            case "BOOL":
                return DataType.BOOLEAN;
            default:
                throw new RuntimeException("String not convertible to type");

        }
    }

    public static DataType convertToType(CellType c){
        switch(c){
            case BOOLEAN:
                return DataType.BOOLEAN;
            case NUMERIC:
                return DataType.FLOAT;
            default:
                return DataType.TEXT;
        }
    }
}
