package uos.lscholz.gedenkstaettendb.view.dataentrypanes;

public class DataPaneFactory {

    /**
     * @param label
     * @param type
     * @param contents
     * @return
     */
    public static DataPane createDataPane(String label, String type, String [] contents) {
        switch (type) {
            case "TEXT":
                return new TextDataPane(label, type, contents);
            case "DATE":
                return new DateDataPane(label, type, contents);
            case "FLOAT":
            case "DOUBLE":
            case "DECIMAL":
                return new FloatDataPane(label, type, contents);
            case "INTEGER":
            case "INT":
            case "BIGINT":
                return new IntegerDataPane(label, type, contents);
            case "BOOLEAN":
            case "BOOL":
                return new BooleanDataPane(label, type, contents);
            default:
                throw new RuntimeException("Typ wird nicht unterstützt");
        }
    }
}
