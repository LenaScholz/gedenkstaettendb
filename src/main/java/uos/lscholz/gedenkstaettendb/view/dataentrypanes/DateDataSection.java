package uos.lscholz.gedenkstaettendb.view.dataentrypanes;

import javafx.scene.control.Control;
import javafx.scene.control.DatePicker;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class DateDataSection extends DataEntrySection {
    /**
     *
     * @param pagination
     * @param content
     */
    public DateDataSection(boolean pagination, String content) {
        super(pagination, content);
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
