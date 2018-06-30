package org.dhbw.stuttgart.ita16.reqmaster.components;

import java.awt.event.FocusListener;
import java.io.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.*;

/**
 * Adaption der Swing JButton-Klasse fuer Projektzwecke
 */
public class UITextField extends JTextField {

    /**
     * Konstruktor der Klasse
     * @param listener definierter listener in den UIKomponenten der View
     */
    public UITextField(final UIListenerComponentLostFocus listener)
    {
        super();
        this.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
            }

            @Override
            public void focusLost(FocusEvent e) {
                listener.lostFocus(e.getComponent(), e.getOppositeComponent());
            }
        });
    }

    /**
     * Standardkonstruktor der Klasse
     */
    public UITextField() {

    }
}
