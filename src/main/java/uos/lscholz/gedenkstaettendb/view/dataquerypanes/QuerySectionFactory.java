package uos.lscholz.gedenkstaettendb.view.dataquerypanes;

public class QuerySectionFactory {

    public static QuerySection createQuerySection(String type){
        switch (type) {
            case "TEXT": break;
            case "DATE": break;
            case "FLOAT":
            case "DOUBLE":
            case "DECIMAL": break;
            case "INTEGER":
            case "INT":
            case "BIGINT": break;
            case "BOOLEAN":
            case "BOOL": break;
            default:
                throw new RuntimeException("Typ wird nicht unterstützt");
        }
        return null;
    }
}
