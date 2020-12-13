package esi.atl.g53735.view;

import esi.atl.g53735.controller.ControllerFX;
import java.beans.PropertyChangeListener;
import javafx.stage.Stage;

/**
 * Interface that represents the methods that must be in the viewFX.
 *
 * @author g53735
 */
public interface InterfaceViewFX extends PropertyChangeListener {

    /**
     * Set a controler.
     *
     * @param controller the given controller to set.
     */
    public void setController(ControllerFX controller);

    /**
     * Start of the viewFX.
     *
     * @param stage the stage.
     */
    public void start(Stage stage);
}
