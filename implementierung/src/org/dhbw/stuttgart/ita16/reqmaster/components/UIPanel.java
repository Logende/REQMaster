package org.dhbw.stuttgart.ita16.reqmaster.components;

import javax.swing.*;
import javax.swing.plaf.PanelUI;

import org.dhbw.stuttgart.ita16.reqmaster.controller.IObserverController;
import org.dhbw.stuttgart.ita16.reqmaster.view.*;

/**
 * Adaption der Swing JPanel-Klasse fuer Projektzwecke
 */

public class UIPanel extends JPanel {

    View view;

    /**
     * Konstruktor der Klasse UIPanel
     * @param view Instanz der View, um auf IOberverController Instanz zuzugreifen
     */
    public UIPanel(View view) {

        super();
        this.view = view;

    }

    public IObserverController getObsControllerFromPanel() {
        return view.getObsControllerFromView();
    }
}
