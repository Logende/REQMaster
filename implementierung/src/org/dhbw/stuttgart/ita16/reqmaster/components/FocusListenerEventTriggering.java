package org.dhbw.stuttgart.ita16.reqmaster.components;

import org.dhbw.stuttgart.ita16.reqmaster.events.IEventFailable;
import org.dhbw.stuttgart.ita16.reqmaster.events.UIEvent;
import org.dhbw.stuttgart.ita16.reqmaster.view.IView;
import org.dhbw.stuttgart.ita16.reqmaster.view.View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.Random;

/**
 * Implementierung des FokusListeners, welche die Fokus-Regeln von REQ-Master beherrscht:
 * Komponenten, die ihren Fokus verlieren (v.a. Textfelder), senden Modify Events an den Controller,
 * welcher diese akzeptieren und den Datenbestand ändern, oder ablehnen kann.
 * Wenn der Controller ein Event ablehnt, wird automatisch eine Fehlermeldung ausgegeben und die ursprüngliche Komponente,
 * deren Änderung abgelehnt wurde, erzwingt erneut ihren Fokus. Damit wird gewährleistet, dass der Fokus erst dann gewechselt werden kann,
 * sobald alle Eingabewerte valide sind.
 */
public abstract class FocusListenerEventTriggering implements FocusListener{

    private IView view;
    private boolean allowNeighbourFocus;

    public FocusListenerEventTriggering(IView view){
        this(view, true);
    }

    public FocusListenerEventTriggering(IView view, boolean allowNeighbourFocus){
        this.view = view;
        this.allowNeighbourFocus = allowNeighbourFocus;
    }


    @Override
    public void focusGained(FocusEvent e) {
    }

    @Override
    public void focusLost(FocusEvent e) {
        this.lostFocus(e.getComponent(), e.getOppositeComponent());
    }

    private void lostFocus(Component lostFocus, Component gotFocus){
        if(gotFocus != null && allowNeighbourFocus) {
            if (lostFocus.getParent() == gotFocus.getParent()) {
                return; //do nothing if new component has same parent
            }
        }

        UIEvent event = this.generateEvent(lostFocus, gotFocus);
        if(event == null) {
            View.forcesFocus = lostFocus;
            View.allowNeighbourFocus = this.allowNeighbourFocus;
            lostFocus.requestFocus();
            JOptionPane.showMessageDialog(lostFocus.getParent(), "Invalide Eingabewerte",
                    "Änderung nicht valide", JOptionPane.WARNING_MESSAGE);
            return;
        }

        view.getObsController().observe(event);
        if(event instanceof IEventFailable) {
            IEventFailable failable = (IEventFailable) event;
            if(failable.isSuccess()){
                View.forcesFocus = null;
            }else{
                View.forcesFocus = lostFocus;
                View.allowNeighbourFocus = this.allowNeighbourFocus;
                lostFocus.requestFocus();
                JOptionPane.showMessageDialog(lostFocus.getParent(), failable.getErrorMessage(),
                        "Änderung nicht valide", JOptionPane.WARNING_MESSAGE);
            }
        }

    }

    /**
     * Zu implementierende Methode, die bei Focus Änderungen Events generiert, welche an den Controller gesendet werden.
     * Falls Events fehlschlagen sollten, wird automatisch deren Fehlermeldung ausgegeben und die Komponente lostFocus fordert ihren Fokus erneut an.
     * @param lostFocus Komponente die Fokus hatte, ihn aber (temporär) verloren hat.
     * @param  gotFocus Komponente, die Fokus neu bekommen hat.
     * @return UIEvent, dass an Controller  gesendet werden soll.
     */
    public abstract UIEvent generateEvent(Component lostFocus, Component gotFocus);

}
