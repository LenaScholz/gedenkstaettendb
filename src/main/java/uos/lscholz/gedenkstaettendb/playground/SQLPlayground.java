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
            System.out.print(e.getStackTrace());
        }
    }

    public static void main(String[] args) {
        System.out.println("Stuff");
        createDB();
    }
}
