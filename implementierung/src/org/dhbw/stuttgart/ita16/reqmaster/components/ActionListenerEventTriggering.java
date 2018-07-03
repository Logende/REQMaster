package org.dhbw.stuttgart.ita16.reqmaster.components;

import org.dhbw.stuttgart.ita16.reqmaster.events.IEventFailable;
import org.dhbw.stuttgart.ita16.reqmaster.events.UIEvent;
import org.dhbw.stuttgart.ita16.reqmaster.view.IView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * Erweiterung des eigenen ActionListeners der Fokus-Regeln befolgt durch automatisiertes Senden und Verwalten von Events.
 * Diese Art von ActionListener wird verwendet, um UI-Komponenten ein Event senden zu lassen.
 */
public abstract class ActionListenerEventTriggering extends ActionListenerCustom {

    private IView view;

    /**
     * Konstruktor.
     * @param view View.
     */
    public ActionListenerEventTriggering(IView view) {
        this.view = view;
    }

    @Override
    public void executeAction(ActionEvent e){
            UIEvent event = this.generateEvent(e.getSource());
            view.getObsController().observe(event);

            if(event instanceof IEventFailable){
                if(!((IEventFailable) event).isSuccess()){
                    JOptionPane.showMessageDialog((Component) e.getSource(), ((IEventFailable) event).getErrorMessage(),
                            "Aktion nicht valide", JOptionPane.WARNING_MESSAGE);
                }else{
                    finishedAction();
                }
            }else{
                finishedAction();
            }
    }

    /**
     * Wird automatisch ausgeführt, nachdem erfolgreich die Aktion ausgeführt wurde, um nachfolgende Aktionen zu ermöglichen.
     * Macht standardmäßig nichts: kann überschrieben werden.
     */
    public void finishedAction(){
        //can be overwritten
    }


    /**
     * Zu implementierende Methode, die Events generiert, welche bei einem ActionEvent an den Controller gesendet werden.
     * Falls Events fehlschlagen sollten, wird automatisch deren Fehlermeldung ausgegeben.
     * @param source ActionEvent source.
     * @return UIEvent, dass an Controller  gesendet werden soll.
     */
    public abstract UIEvent generateEvent(Object source);
}
