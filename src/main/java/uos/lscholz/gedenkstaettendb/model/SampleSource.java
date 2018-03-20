package uos.lscholz.gedenkstaettendb.model;


import java.util.HashMap;
import java.util.LinkedHashMap;


/**
 * sample class to operate on while there is no actual database and data yet
 */
public class SampleSource {

    public LinkedHashMap<String,String> datatypes;
    public HashMap<String,String[]> contents;

    public SampleSource(){
        this.datatypes = new LinkedHashMap<String, String>();
        this.contents = new HashMap<String, String[]>();

        datatypes.put("Name","TEXT");
        datatypes.put("Vorname","TEXT");
        datatypes.put("Geburt","DATE");
        datatypes.put("Häftlingsnummer","INT");
        datatypes.put("Boolean","BOOLEAN");
        datatypes.put("Float","FLOAT");

        contents.put("Name", new String[]{"Beispiel", "Beiszpiel"});
        contents.put("Vorname",new String[]{"David","Dafid","Davit"});
        contents.put("Häftlingsnummer",new String[]{"12345"});
    }
}
