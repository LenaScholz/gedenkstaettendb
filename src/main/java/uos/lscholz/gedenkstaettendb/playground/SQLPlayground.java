package uos.lscholz.gedenkstaettendb.playground;

import java.sql.*;

public class SQLPlayground {

    public static void createDB(){
        try(Connection conn= DriverManager.getConnection(url);
            Statement statement = conn.createStatement()){
            statement.execute(testCreation);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static void executeUpdate(String stmt){
        try(Connection conn= DriverManager.getConnection(url);
            Statement statement = conn.createStatement()){
            statement.executeUpdate(stmt);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static ResultSet executeQuery(String query){
        try(Connection conn= DriverManager.getConnection(url);
            Statement statement = conn.createStatement()){
            return statement.executeQuery(query);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }


    private static String url = "jdbc:sqlite:gedenkstaettendb.db";

    private static String testCreation = "DROP TABLE IF EXISTS Test; CREATE TABLE Test (Value VARCHAR);";

    private static String creationStmt=
            "CREATE TABLE IF NOT EXISTS TextProperty (\n" +
            "  ID         INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, \n" +
            "  Value      varchar(255), \n" +
            "  PropertyID integer(10) NOT NULL, \n" +
            "  FOREIGN KEY(PropertyID) REFERENCES Property(ID));\n" +
            "CREATE TABLE IF NOT EXISTS DateProperty (\n" +
            "  ID         INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, \n" +
            "  Value      date, \n" +
            "  PropertyID integer(10) NOT NULL, \n" +
            "  FOREIGN KEY(PropertyID) REFERENCES Property(ID));\n" +
            "CREATE TABLE IF NOT EXISTS FloatProperty (\n" +
            "  ID         INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, \n" +
            "  Value      numeric(19, 0), \n" +
            "  PropertyID integer(10) NOT NULL, \n" +
            "  FOREIGN KEY(PropertyID) REFERENCES Property(ID));\n" +
            "CREATE TABLE IF NOT EXISTS IntProperty (\n" +
            "  ID         INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, \n" +
            "  Value      integer(20), \n" +
            "  PropertyID integer(10) NOT NULL, \n" +
            "  FOREIGN KEY(PropertyID) REFERENCES Property(ID));\n" +
            "CREATE TABLE IF NOT EXISTS BooleanProperty (\n" +
            "  ID         INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, \n" +
            "  Value      numeric(19, 0), \n" +
            "  PropertyID integer(10) NOT NULL, \n" +
            "  FOREIGN KEY(PropertyID) REFERENCES Property(ID));\n" +
            "CREATE TABLE IF NOT EXISTS \"Tag\" (\n" +
            "  ID    integer(10) NOT NULL, \n" +
            "  Label varchar(255) NOT NULL UNIQUE, \n" +
            "  PRIMARY KEY (ID));\n" +
            "CREATE TABLE IF NOT EXISTS Source (\n" +
            "  ID   integer(10) NOT NULL, \n" +
            "  Name varchar(255) NOT NULL UNIQUE, \n" +
            "  PRIMARY KEY (ID));\n" +
            "CREATE TABLE IF NOT EXISTS Property (\n" +
            "  ID              integer(10) NOT NULL, \n" +
            "  Pagination      varchar(255), \n" +
            "  PropertyLabelID integer(10) NOT NULL, \n" +
            "  PRIMARY KEY (ID), \n" +
            "  FOREIGN KEY(PropertyLabelID) REFERENCES PropertyLabel(ID));\n" +
            "CREATE TABLE IF NOT EXISTS Person (\n" +
            "  ID integer(10) NOT NULL, \n" +
            "  PRIMARY KEY (ID));\n" +
            "CREATE TABLE IF NOT EXISTS PropertyLabel (\n" +
            "  ID    integer(10) NOT NULL, \n" +
            "  Label varchar(255) NOT NULL UNIQUE, \n" +
            "  PRIMARY KEY (ID));\n" +
            "CREATE TABLE IF NOT EXISTS Person_Property (\n" +
            "  PersonID   integer(10) NOT NULL, \n" +
            "  PropertyID integer(10) NOT NULL, \n" +
            "  PRIMARY KEY (PersonID, \n" +
            "  PropertyID), \n" +
            "  FOREIGN KEY(PersonID) REFERENCES Person(ID), \n" +
            "  FOREIGN KEY(PropertyID) REFERENCES Property(ID));\n" +
            "CREATE TABLE IF NOT EXISTS Property_Source (\n" +
            "  PropertyID integer(10) NOT NULL, \n" +
            "  SourceID   integer(10) NOT NULL, \n" +
            "  PRIMARY KEY (PropertyID, \n" +
            "  SourceID), \n" +
            "  FOREIGN KEY(PropertyID) REFERENCES Property(ID), \n" +
            "  FOREIGN KEY(SourceID) REFERENCES Source(ID));\n" +
            "CREATE TABLE IF NOT EXISTS Property_Tag (\n" +
            "  PropertyID integer(10) NOT NULL, \n" +
            "  TagID      integer(10) NOT NULL, \n" +
            "  PRIMARY KEY (PropertyID, \n" +
            "  TagID), \n" +
            "  FOREIGN KEY(PropertyID) REFERENCES Property(ID), \n" +
            "  FOREIGN KEY(TagID) REFERENCES \"Tag\"(ID));\n" +
            "CREATE TABLE IF NOT EXISTS PropertyLabel_Source (\n" +
            "  PropertyLabelID integer(10) NOT NULL, \n" +
            "  SourceID        integer(10) NOT NULL, \n" +
            "  PRIMARY KEY (PropertyLabelID, \n" +
            "  SourceID), \n" +
            "  FOREIGN KEY(PropertyLabelID) REFERENCES PropertyLabel(ID), \n" +
            "  FOREIGN KEY(SourceID) REFERENCES Source(ID));\n" +
            "CREATE UNIQUE INDEX Tag_ID \n" +
            "  ON \"Tag\" (ID);\n" +
            "CREATE UNIQUE INDEX Source_ID \n" +
            "  ON Source (ID);\n" +
            "CREATE UNIQUE INDEX Property_ID \n" +
            "  ON Property (ID);\n" +
            "CREATE UNIQUE INDEX Person_ID \n" +
            "  ON Person (ID);\n" +
            "CREATE UNIQUE INDEX PropertyLabel_ID \n" +
            "  ON PropertyLabel (ID);";
}
