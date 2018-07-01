package org.dhbw.stuttgart.ita16.reqmaster.components;

import javax.swing.*;

/**
 * Adaption der Swing JList-Klasse fuer individuelle Anpassungen an das Projekt
 */
public class UIList extends JList {

    /**
     * Konstruktor der Klasse
     */
    public UIList(DefaultListModel<String>listModel) {
        super(listModel);
    }
}
