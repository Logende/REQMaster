package org.dhbw.stuttgart.ita16.reqmaster.components;

import org.dhbw.stuttgart.ita16.reqmaster.view.IView;
import org.dhbw.stuttgart.ita16.reqmaster.view.View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
 * Adaption der Swing JFrame-Klasse fuer individuelle Anpassungen an das Projekt
 */
public class UIFrame extends JFrame{

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
     * Konstruktor der Klasse
     * @param view Instanz der View des MVC-Patterns
     */
    public UIFrame(IView view){
        this.view = view;
    }

    /**
     * Getter Methode, um die Instanz der View des MVC-Patterns zu bekommen
     * @return Instanz der View
     */
    public IView getView() {
        return view;
    }

}