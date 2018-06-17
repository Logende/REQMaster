package org.dhbw.stuttgart.ita16.reqmaster.controller;

import org.dhbw.stuttgart.ita16.reqmaster.events.*;
import org.dhbw.stuttgart.ita16.reqmaster.model.DataId;
import org.dhbw.stuttgart.ita16.reqmaster.model.DataProduktDatum;
import org.dhbw.stuttgart.ita16.reqmaster.model.DataProduktFunktion;
import org.dhbw.stuttgart.ita16.reqmaster.model.IModel;
import org.dhbw.stuttgart.ita16.reqmaster.view.IView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Controller implements IObserverController, IController{


    private IModel model;
    private IView view;

    private IValidator validator;

    private Map<Class<? extends UIEvent>, EventReaction> reactions;

    public Controller() {
        reactions = new HashMap<>();

        //ADD
        reactions.put(UIActionAddProduktDatumEvent.class, (model, view, event)->{
            DataProduktDatum dataProduktDatum = new DataProduktDatum(DefaultValues.PRODUKTDATUM_NAME, generateUniqueID(),
                    new ArrayList<>(), new ArrayList<>());
            model.getIDataAnforderungssammlung().getDataProduktDaten().add(dataProduktDatum);
            return true;
        });

        reactions.put(UIActionAddProduktFunktionEvent.class, (model, view, event)->{
            DataProduktFunktion dataProduktFunktion = new DataProduktFunktion(DefaultValues.PRODUKTFUNKTION_NAME,
                    DefaultValues.PRODUKTFUNKTION_BESCHREIBUNG, DefaultValues.PRODUKTFUNKTION_AKTEUR, DefaultValues.PRODUKTFUNKTION_QUELLE,
                    new ArrayList<>(), generateUniqueID());
            model.getIDataAnforderungssammlung().getDataProduktFunktionen().add(dataProduktFunktion);
            return true;
        });

        //DELETE
        reactions.put(UIActionDeleteFPAnalyseEvent.class, (model, view, event)->{
            model.getIDataAnforderungssammlung().deleteIDataFunctionPointAnalyse();
            return true;
        });

        reactions.put(UIActionDeleteProduktDatumEvent.class, (model, view, event)->{
            UIActionDeleteProduktDatumEvent e = (UIActionDeleteProduktDatumEvent) event;

            List<DataProduktDatum> list = model.getIDataAnforderungssammlung().getDataProduktDaten();
            DataProduktDatum toDelete = null;
            for(DataProduktDatum entry : list){
                if(entry.getId().equals(e.getId())){
                    toDelete = entry;
                    break;
                }
            }
            if(toDelete == null){
                throw new NullPointerException("Invalid " + event.getClass().getName() +" event: No entry with id '" + e.getId() + "' found.");
            }else{
                list.remove(toDelete);
            }
            return true;
        });

        reactions.put(UIActionDeleteProduktFunktionEvent.class, (model, view, event)->{
            UIActionDeleteProduktFunktionEvent e = (UIActionDeleteProduktFunktionEvent) event;

            List<DataProduktFunktion> list = model.getIDataAnforderungssammlung().getDataProduktFunktionen();
            DataProduktFunktion toDelete = null;
            for(DataProduktFunktion entry : list){
                if(entry.getId().equals(e.getId())){
                    toDelete = entry;
                    break;
                }
            }
            if(toDelete == null){
                throw new NullPointerException("Invalid " + event.getClass().getName() +" event: No entry with id '" + e.getId() + "' found.");
            }else{
                list.remove(toDelete);
            }
            return true;
        });

        //MODIFY
        reactions.put(UIModifyProduktDatumEvent.class, (model, view, event)->{
            UIModifyProduktDatumEvent e = (UIModifyProduktDatumEvent) event;

            List<DataProduktFunktion> list = model.getIDataAnforderungssammlung().getDataProduktFunktionen();
            DataProduktFunktion toDelete = null;
            for(DataProduktFunktion entry : list){
                if(entry.getId().equals(e.getId())){
                    toDelete = entry;
                    break;
                }
            }
            if(toDelete == null){
                throw new NullPointerException("Invalid " + event.getClass().getName() +": No entry with id '" + e.getId() + "' found.");
            }else{
                list.remove(toDelete);
            }
            return true;
        });

    }

    @Override
    public void observe(UIEvent event) {
        if(!reactions.containsKey(event.getClass())){
            throw new IllegalArgumentException("Unknown event type: '" + event.getClass().getName() + "'");
        }
        if(reactions.get(event.getClass()).react(model, view, event)){
            model.wasModified();
        }
    }


    private DataId generateUniqueID(){

    }

}
