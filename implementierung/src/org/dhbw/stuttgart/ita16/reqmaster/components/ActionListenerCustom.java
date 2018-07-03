package org.dhbw.stuttgart.ita16.reqmaster.components;

import org.dhbw.stuttgart.ita16.reqmaster.view.View;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Abstrakte Implementierung des ActionListeners, die in der Lage ist mit den Fokus-Regeln von REQ-Master umzugehen.
 * Aktionen werden nur dann erlaubt, wenn gerade keine Komponente ihren Fokus erzwingt oder wenn eine Nachbarkomponente den Fokus erzwingt, aber die Fokusweitergabe erlaubt.
 */
public abstract class ActionListenerCustom implements ActionListener {


    public ActionListenerCustom() {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(View.forcesFocus == null || (View.allowNeighbourFocus &&((Component)e.getSource()).getParent() == View.forcesFocus.getParent())){
            this.executeAction(e);
        }
    }

    /**
     * Diese Methode wird für eigene Aktionen implementiert, die die Fokus-Regeln befolgen solgen.
     * @param e Event.
     */
    public abstract void executeAction(ActionEvent e);


}
