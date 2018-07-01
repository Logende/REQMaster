package org.dhbw.stuttgart.ita16.reqmaster.view;

import org.dhbw.stuttgart.ita16.reqmaster.controller.IObserverController;
import org.dhbw.stuttgart.ita16.reqmaster.model.IModel;

/**
 * Das Interface legt fest, dass die darunterliegenden Klassen der View (UI-Klassen),
 * Zugriff auf das Model und den Observer des Controllers haben
 */
public interface IView {
    public IModel getModel();
    public IObserverController getObsController();
}
