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

    public UITextArea(final UIListenerComponentLostFocus listener)
    {
        super();

        this.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
            }

            /**
             * Wenn eine Grafikkomponente den Fokus verliert, wird die für diesen Fall
             * implementierte Methode aufgerufen
             * @param e das FocusEvent, auf das reagiert werden soll
             */
            @Override
            public void focusLost(FocusEvent e) {
                listener.lostFocus(e.getComponent(), e.getOppositeComponent());
            }

            });
    }
}
