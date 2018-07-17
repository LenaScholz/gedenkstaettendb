package uos.lscholz.gedenkstaettendb.view.dataentrypanes;

public class DataSectionFactory {

    /**
     *
     * @param type
     * @param pagination
     * @param content
     * @return
     */
    public static DataEntrySection createDataSection(String type, boolean pagination, String content) {
        switch (type) {
            case "TEXT":
                return new TextDataPane(pagination,content);
            case "DATE":
                return new DateDataSection(pagination,content);
            case "FLOAT":
            case "DOUBLE":
            case "DECIMAL":
                return new FloatDataSection(pagination,content);
            case "INTEGER":
            case "INT":
            case "BIGINT":
                return new IntegerDataSection(pagination,content);
            case "BOOLEAN":
            case "BOOL":
                return new BooleanDataSection(pagination,content);
            default:
                throw new RuntimeException("Typ wird nicht unterstützt");
        }
    }
}
