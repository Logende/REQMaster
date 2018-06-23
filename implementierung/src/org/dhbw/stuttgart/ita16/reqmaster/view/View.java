package org.dhbw.stuttgart.ita16.reqmaster.view;

import org.dhbw.stuttgart.ita16.reqmaster.controller.IObserverController;
import org.dhbw.stuttgart.ita16.reqmaster.model.IModel;

/**
 *  Klasse View des VMC-Patterns
 *  legt das mainFrame an und implementiert das Obeserver-Interface, um die UI-Komponenten
 *  updaten zu können
 *  beinhaltet eine Instanz von IModel
 */

public class View implements IView, IObserverView {

    private IModel model;
    private IObserverController obsController;
    private UIMainFrame mainFrame;
    private UIAnfangsDialog anfangsDialog;

    /**
     * Konstruktor der Klasse
     * @param model Instanz der Klasse IModel des VMC-Patterns
     */
    public View(IModel model) {
        this.model = model;
        mainFrame = new UIMainFrame(this);
        anfangsDialog = new UIAnfangsDialog(this, mainFrame);
    }

    public void setObserverController(IObserverController obsController){
        this.obsController = obsController;
    }

    /**
     * Implementierung der update-Methode
     * Aufruf der update-Methode des mainFrames
     */
    @Override

    public void update(){

        mainFrame.update(model);
    }

    /**
     * getter-Methode für IObserverController
     * @return
     */
    @Override
    public IObserverController getObsController(){
        return obsController;
    }

    @Override
    public IModel getModel() {
        return model;
    }
}
