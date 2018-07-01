package org.dhbw.stuttgart.ita16.reqmaster.view;

import org.dhbw.stuttgart.ita16.reqmaster.controller.IObserverController;
import org.dhbw.stuttgart.ita16.reqmaster.model.IModel;

import javax.swing.*;
import java.awt.*;

/**
 *  Klasse View des VMC-Patterns
 *  legt die Hauptbestandteile der grafischen Oberfläche an
 */
public class View implements IView, IObserverView {

    //Variablen der Klasse
    public static Component forcesFocus;
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

    /**
     * Setter Methode für den Observer des Controllers
     * @param obsController Instanz des Observers
     */
    public void setObserverController(IObserverController obsController){
        this.obsController = obsController;
    }

    /**
     * Implementierung der update-Methode des IObserverView-Interface
     * Aufruf der update-Methode des mainFrames
     */
    @Override
    public void update(){
        mainFrame.update(model);
    }

    /**
     * Implementierung des IView-Interface
     * Getter-Methode für den IObserverController
     * @return Instanz des Observers des Controllers des MVC-Patterns
     */
    @Override
    public IObserverController getObsController(){
        return obsController;
    }

    /**
     * Implementierung des IView Interface
     * Getter Methode für das Model
     * @return Instanz des Model des MVC-Patterns
     */
    @Override
    public IModel getModel() {
        return model;
    }
}
