package uos.lscholz.gedenkstaettendb.view.dataquerypanes;

import uos.lscholz.gedenkstaettendb.model.DataType;

public class QuerySectionFactory {

    public static QuerySection createQuerySection(String type) {

        DataType dataType = DataType.convertToType(type);
        switch (dataType){
            case TEXT:
                return new TextQuerySection();
            case DATE:
                return new DateQuerySection();
            case FLOAT:
                return new FloatQuerySection();
            case INTEGER:
                return new IntegerQuerySection();
            case BOOLEAN:
                return new BooleanQuerySection();
            default:
                throw new RuntimeException("Type is not supported");
        }

    }
}
