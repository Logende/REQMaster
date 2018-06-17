package org.dhbw.stuttgart.ita16.reqmaster.controller;

import org.dhbw.stuttgart.ita16.reqmaster.events.*;

import java.util.HashMap;
import java.util.Map;

public class Controller implements IObserverController, IController{


    private IModel model;
    private IView view;

    private IValidator validator;

    private Map<Class<? extends UIEvent>, EventReaction> reactions;

    public Controller() {
        reactions = new HashMap<>();
        reactions.put(UIActionAddProduktDatumEvent.class, (model, view, event)->{
        });
    }

    @Override
    public void observe(UIEvent event) {
        if(!reactions.containsKey(event.getClass())){
            throw new IllegalArgumentException("Unknown event type: '" + event.getClass().getName() + "'");
        }
        reactions.get(event.getClass()).react(model, view, event);
    }



}
