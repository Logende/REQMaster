package org.dhbw.stuttgart.ita16.reqmaster.components;

import org.dhbw.stuttgart.ita16.reqmaster.events.UIEvent;
import org.dhbw.stuttgart.ita16.reqmaster.view.View;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Adaption der Swing JMenuItem-Klasse fuer individuelle Anpassungen an das Projekt
 */
public class UIMenuItem extends JMenuItem {

    /**
     * Konstruktor der Klasse
     * @param text String, nachdem das Item benannt werden soll
     */
    public UIMenuItem(String text) {
        super(text);
    }
}
