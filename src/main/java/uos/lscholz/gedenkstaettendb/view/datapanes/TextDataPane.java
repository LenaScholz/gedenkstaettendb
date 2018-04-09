package uos.lscholz.gedenkstaettendb.view.datapanes;

public class TextDataPane extends DataPane {
    /**
     * @param label    Name of the datafield
     * @param type     Type of the data stored in the datafield
     * @param contents Array of the data already stored for that datafield
     */
    public TextDataPane(String label, String type, String[] contents) {
        super(label, type, contents);
    }
}
