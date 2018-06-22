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
     * @param focusListener definierter FokusListener in den UIKomponenten der View
     */
    public UITextField(FocusListener focusListener)
    {
        super();
        this.addFocusListener(focusListener);
    }



    //Platz für Programmspezifische anpassungen

    public UITextField(){
        //TODO: löschen wenn nicht gebraucht
    }
}
