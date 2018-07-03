package org.dhbw.stuttgart.ita16.reqmaster.components;

import org.dhbw.stuttgart.ita16.reqmaster.events.IEventFailable;
import org.dhbw.stuttgart.ita16.reqmaster.events.UIEvent;
import org.dhbw.stuttgart.ita16.reqmaster.view.IView;
import org.dhbw.stuttgart.ita16.reqmaster.view.View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public abstract class FocusListenerEventTriggering implements FocusListener{

    private IView view;

    public FocusListenerEventTriggering(IView view){
        this.view = view;
    }


    @Override
    public void focusGained(FocusEvent e) {
    }

    @Override
    public void focusLost(FocusEvent e) {
        this.lostFocus(e.getComponent(), e.getOppositeComponent());
    }

    private void lostFocus(Component lostFocus, Component gotFocus){
        String d = String.valueOf((int)(100.0*Math.random()));
        if(gotFocus != null) {
            if (lostFocus.getParent() == gotFocus.getParent()) {
                return; //do nothing if new component has same parent
            }
        }

        UIEvent event = this.generateEvent(lostFocus, gotFocus);
        if(event == null) {
            View.forcesFocus = lostFocus;
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
                lostFocus.requestFocus();
                JOptionPane.showMessageDialog(lostFocus.getParent(), failable.getErrorMessage(),
                        "Änderung nicht valide", JOptionPane.WARNING_MESSAGE);
            }
        }

    }

    public abstract UIEvent generateEvent(Component lostFocus, Component gotFocus);

}
