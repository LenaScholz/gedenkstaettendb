package uos.lscholz.gedenkstaettendb.playground;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;

public class SQLPlayground {

    public static void createDB(){
        String url = "jdbc:sqlite:gedenkstaettendb.db";
        try(Connection conn= DriverManager.getConnection(url)){
            if (conn != null) {
                System.out.println("A new database has been created.");
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        createDB();
    }
}
