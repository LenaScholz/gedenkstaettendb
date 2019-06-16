package uos.lscholz.gedenkstaettendb;

import org.junit.Ignore;
import org.junit.Test;
import uos.lscholz.gedenkstaettendb.playground.SQLPlayground;

public class SQLPlaygroundTest{

    @Test
    //@Ignore
    public void testCreation(){
        SQLPlayground.createDB();
        SQLPlayground.executeUpdate("INSERT into Test VALUES ('Test')");
        assert( SQLPlayground.executeQuery("SELECT Value from Test")!=null);
    }

}
