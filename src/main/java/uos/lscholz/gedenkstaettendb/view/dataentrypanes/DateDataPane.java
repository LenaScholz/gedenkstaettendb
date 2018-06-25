package uos.lscholz.gedenkstaettendb.view.dataentrypanes;

import javafx.scene.control.Control;
import javafx.scene.control.DatePicker;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class DateDataPane extends DataPane {
    /**
     * @param label    Name of the datafield
     * @param type     Type of the data stored in the datafield
     * @param contents Array of the data already stored for that datafield
     */
    public DateDataPane(String label, String type, String[] contents) {
        super(label, type, contents);
    }

    @Override
    protected Control newContentControl(String content) {
        LocalDate date;
        try{
            date = LocalDate.parse(content);
        } catch (DateTimeParseException e){
            throw new RuntimeException("Given type and content do not match");
        }
        return new DatePicker(date);
    }

    @Override
    protected Control newContentControl() {
        return this.newContentControl("1900-01-01");
    }
}
