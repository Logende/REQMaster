package org.dhbw.stuttgart.ita16.reqmaster.components;

import org.dhbw.stuttgart.ita16.reqmaster.view.View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public abstract class ActionListenerCustom implements ActionListener {


    public ActionListenerCustom() {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("action custom with forcesfocus " + View.forcesFocus);
        if(View.forcesFocus == null){
            this.executeAction(e);
        }
    }

    public abstract void executeAction(ActionEvent e);


}
