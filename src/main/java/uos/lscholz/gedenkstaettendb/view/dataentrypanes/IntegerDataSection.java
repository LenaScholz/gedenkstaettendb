package uos.lscholz.gedenkstaettendb.view.dataentrypanes;

import javafx.scene.control.Control;
import javafx.scene.control.TextField;

public class IntegerDataSection extends DataEntrySection{
    /**
     *
     * @param pagination
     * @param content
     */
    public IntegerDataSection(boolean pagination, String content) {
        super(pagination, content);
    }

    @Override
    protected Control newContentControl(String content) {
        return new TextField(content);
    }

    @Override
    protected Control newContentControl() {
        return this.newContentControl("");
    }
}
