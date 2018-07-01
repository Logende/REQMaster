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

    public void addGB(Component component, UIPanel parent, int gridx, int gridy, int gridwidth, int gridheight, Insets insets) {
        addGB(component, parent, gridx, gridy, gridwidth, gridheight, GridBagConstraints.NONE, 0.0, 0.0,
                GridBagConstraints.CENTER, insets, 0, 0);
    }

    public void addGB(Component component, UIPanel parent, int gridx, int gridy, int gridwidth, int gridheight, int fill, Insets insets) {
        addGB(component, parent, gridx, gridy, gridwidth, gridheight, fill, 0.0, 0.0, GridBagConstraints.CENTER,
                insets, 0, 0);
    }
    private void addGB(Component component, UIPanel parent, int gridx, int gridy, int gridwidth, int gridheight,
                       int fill, double weightx, double weighty, int anchor, Insets insets, int ipadx, int ipady) {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = gridx;
        constraints.gridy = gridy;
        constraints.gridwidth = gridwidth;
        constraints.gridheight = gridheight;
        constraints.fill = fill;
        constraints.weightx = weightx;
        constraints.weighty = weighty;
        constraints.anchor = anchor;
        constraints.insets = insets;
        constraints.ipadx = ipadx;
        constraints.ipady = ipady;
        parent.add(component, constraints);
    }
}
