package org.dhbw.stuttgart.ita16.reqmaster.components;

import org.dhbw.stuttgart.ita16.reqmaster.view.IView;
import org.dhbw.stuttgart.ita16.reqmaster.view.View;

import javax.swing.*;

/**
 * Adaption der Swing-JFrame Komponente für Projektzwecke
 */
public class UIFrame extends JFrame {

    IView view;

    /**
     * Konstruktor der Klasse
     * @param text Name, den das Frame haben soll
     */
    public UIFrame(String text) {

        super(text);
    }

    /**
     * Standardkonstruktor der Klasse
     */
    public UIFrame(){

    }

    public UIFrame(IView view){
        this.view = view;
    }


    public IView getView() {
        return view;
    }
}
