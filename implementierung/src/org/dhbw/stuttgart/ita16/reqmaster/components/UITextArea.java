package org.dhbw.stuttgart.ita16.reqmaster.components;

import javax.swing.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

/**
 * Adaption der Swing-JTextArea fuer individuelle Anpassungen an das Projekt
 */
public class UITextArea extends JTextArea{

    /**
     * Konstruktor der Klasse
     */
    public UITextArea() {
        super();
    }

    public UITextArea(final FocusListener listener){
        this.addFocusListener(listener);
    }
}
