package uos.lscholz.gedenkstaettendb.view.dataquerypanes;

public class QuerySectionFactory {

    public static QuerySection createQuerySection(String type) {
        switch (type) {
            case "TEXT":
                return new TextQuerySection();
            case "DATE":
                return new DateQuerySection();
            case "FLOAT":
            case "DOUBLE":
            case "DECIMAL":
                return new FloatQuerySection();
            case "INTEGER":
            case "INT":
            case "BIGINT":
                return new IntegerQuerySection();
            case "BOOLEAN":
            case "BOOL":
                return new BooleanQuerySection();
            default:
                throw new RuntimeException("Typ wird nicht unterstützt");
        }
    }
}
