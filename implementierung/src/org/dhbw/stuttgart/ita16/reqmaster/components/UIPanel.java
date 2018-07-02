package org.dhbw.stuttgart.ita16.reqmaster.components;

import javax.swing.*;
import javax.swing.plaf.PanelUI;

import org.dhbw.stuttgart.ita16.reqmaster.controller.IObserverController;
import org.dhbw.stuttgart.ita16.reqmaster.view.*;

import java.awt.*;

/**
 * Adaption der Swing JPanel-Klasse fuer individuelle Anpassungen an das Projekt
 */

public class UIPanel extends JPanel {

    private IView view;
    protected int gridx, gridy, gridwidth, gridheight, fill, anchor, ipadx, ipady;
    protected Insets insets;

    /**
     * Konstruktor der Klasse UIPanel
     * @param view Instanz der View, um auf IOberverController Instanz zuzugreifen
     */
    public UIPanel(IView view) {
        super();
        this.view = view;
    }

    /**
     * Standardkonstruktor der Klasse
     */
    public UIPanel() {
    }

    /**
     * Getter Methode für die View
     * @return liefert die Instanz der View des MVC-Patterns zurück
     */
    public IView getView() {
        return view;
    }
}
