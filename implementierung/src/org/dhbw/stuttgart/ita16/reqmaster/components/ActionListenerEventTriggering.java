package org.dhbw.stuttgart.ita16.reqmaster.components;

import org.dhbw.stuttgart.ita16.reqmaster.events.IEventFailable;
import org.dhbw.stuttgart.ita16.reqmaster.events.UIEvent;
import org.dhbw.stuttgart.ita16.reqmaster.view.IView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public abstract class ActionListenerEventTriggering extends ActionListenerCustom {

    private IView view;

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

    public void finishedAction(){
        //can be overwritten
    }



    public abstract UIEvent generateEvent(Object source);
}
