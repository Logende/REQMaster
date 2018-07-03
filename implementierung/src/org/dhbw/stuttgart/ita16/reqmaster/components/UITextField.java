package org.dhbw.stuttgart.ita16.reqmaster.components;

import java.awt.event.FocusListener;
import javax.swing.*;
import java.awt.event.*;

/**
 * Adaption der Swing JButton-Klasse fuer individuelle Anpassungen an das Projekt
 */
public class UITextField extends JTextField {

    /**
     * Konstruktor der Klasse
     * @param listener definierter listener in den UIKomponenten der View
     */
    public UITextField(FocusListener listener){
        this.addFocusListener(listener);
    }

    /**
     * Standardkonstruktor der Klasse
     */
    public UITextField() {
    }
}
