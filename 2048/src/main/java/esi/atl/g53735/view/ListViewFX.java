package esi.atl.g53735.view;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javafx.scene.control.ListView;

/**
 *
 * @author g53735
 */
public class ListViewFX extends ListView {

    public ListViewFX() {
        this.setMouseTransparent(true); //Transparent to mouse event.
        this.setFocusTraversable(false);//so that you couldn't interact 
        //with the node by focusing in other ways.
    }

    public void addMessageList(String message) {
        DateFormat format = new SimpleDateFormat("hh:mm:ss");
        Calendar calendar = Calendar.getInstance();
        String lgListView = format.format(calendar.getTime())
                + message;
        this.getItems().add(lgListView);
    }
}
