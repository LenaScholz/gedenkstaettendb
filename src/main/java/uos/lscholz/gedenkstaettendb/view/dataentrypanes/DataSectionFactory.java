package uos.lscholz.gedenkstaettendb.view.dataentrypanes;

import uos.lscholz.gedenkstaettendb.model.DataType;

public class DataSectionFactory {

    /**
     *
     * @param type
     * @param pagination
     * @param content
     * @return
     */
    public static DataEntrySection createDataSection(String type, boolean pagination, String content) {

        DataType dataType = DataType.convertToType(type);
        switch (dataType){
            case TEXT:
                return new TextDataPane(pagination,content);
            case DATE:
                return new DateDataSection(pagination,content);
            case FLOAT:
                return new FloatDataSection(pagination,content);
            case INTEGER:
                return new IntegerDataSection(pagination,content);
            case BOOLEAN:
                return new BooleanDataSection(pagination,content);
            default:
                throw new RuntimeException("Type is not supported");
        }
    }
}
