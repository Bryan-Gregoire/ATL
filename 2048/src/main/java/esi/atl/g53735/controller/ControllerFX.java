package esi.atl.g53735.controller;

import esi.atl.g53735.model.Model;
import esi.atl.g53735.view.InterfaceViewFX;
import java.beans.PropertyChangeListener;
import java.util.Objects;

/**
 *
 * @author g53735
 */
public class ControllerFX {

    private final Model model;
    private final InterfaceViewFX view;

    public ControllerFX(Model game, InterfaceViewFX ViewFX) {
        Objects.requireNonNull(game, "Model is required");
        Objects.requireNonNull(ViewFX, "View is required");
        this.model = game;
        this.view = ViewFX;
    }

    public void addModelListener(PropertyChangeListener listener) {
        model.addPropertChangeListener(listener);
    }

    public void removeModelListener(PropertyChangeListener listener) {
        model.removePropertyChangeListener(listener);
    }
}
