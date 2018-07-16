package uos.lscholz.gedenkstaettendb.view.dataquerypanes;

import javafx.scene.control.DatePicker;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class DateQuerySection extends QuerySection {
    
    private DatePicker firstDatePicker;
    private DatePicker secondDatePicker;
    
    public DateQuerySection (){
        this("1900-01-01");
    }
    
    public DateQuerySection (String ... contents){
        LocalDate firstDate = null;
        LocalDate secondDate = null;
        try{
            switch (contents.length){
                case 0: break;
                case 2: secondDate = LocalDate.parse(contents[1]);
                case 1: firstDate = LocalDate.parse(contents[0]); break;
                default: throw new RuntimeException("Too many arguments in contents");
            }
        }catch (DateTimeParseException e){
            throw new RuntimeException("Given contents could not be parsed to dates");
        }
        this.firstDatePicker = new DatePicker(firstDate);
        this.secondDatePicker = new DatePicker(secondDate);
        this.add(firstDatePicker,1,1);
        this.add(secondDatePicker,2,1);
    }

    @Override
    protected String getHelpInfo() {
        return null;
    }
}
