package org.dhbw.stuttgart.ita16.reqmaster.components;

import javax.swing.*;

/**
 * Adaption der Swing Klasse JList fuer Projektzwecke
 */
public class UIList extends JList {

    /**
     * Konstruktor der Klasse
     */
    public UIList(DefaultListModel<String>listModel) {

        super(listModel);

    }
}
