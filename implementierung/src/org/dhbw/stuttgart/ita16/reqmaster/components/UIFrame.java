package org.dhbw.stuttgart.ita16.reqmaster.components;

import org.dhbw.stuttgart.ita16.reqmaster.view.IView;
import org.dhbw.stuttgart.ita16.reqmaster.view.View;

import javax.swing.*;

/**
 * Adaption der Swing-JFrame Komponente für Projektzwecke
 */
public class UIFrame extends JFrame {

    private IView view;

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

    /**
     * KOnstruktor der Klasse
     * @param view Instanz der View des MVC-Patterns
     */
    public UIFrame(IView view){
        this.view = view;
    }

    /**
     * getter Methode, um die Instanz der View des MVC-Patterns zu bekommen
     * @return Instanz der View
     */
    public IView getView() {
        return view;
    }
}
