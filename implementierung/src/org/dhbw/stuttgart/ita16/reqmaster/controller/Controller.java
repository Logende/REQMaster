package org.dhbw.stuttgart.ita16.reqmaster.controller;

import org.dhbw.stuttgart.ita16.reqmaster.events.*;
import org.dhbw.stuttgart.ita16.reqmaster.model.*;
import org.dhbw.stuttgart.ita16.reqmaster.view.IView;

import java.io.File;
import java.util.*;

public class Controller implements IObserverController, IController{


    private IModel model;
    private IView view;

    private IValidator validator;
    private IAufwandRechner aufwandRechner;

    private Map<Class<? extends UIEvent>, EventReaction> reactions;

    public Controller(IModel iModel, IView iView, IValidator validator, IAufwandRechner aufwandRechner) {
        reactions = new HashMap<>();
        this.validator = validator;
        this.aufwandRechner = aufwandRechner;
        this.view = iView;
        this.model = iModel;

        //ADD
        reactions.put(UIActionAddProduktDatumEvent.class, (model, view, event)->{
            DataProduktDatum dataProduktDatum = new DataProduktDatum(DefaultValues.PRODUKTDATUM_NAME, generateUniqueID("/LD", "/"),
                    new ArrayList<>(), DefaultValues.PRODUKTDATUM_VERWEISE);
            model.getIDataAnforderungssammlung().getDataProduktDaten().put(dataProduktDatum.getId(), dataProduktDatum);
            return true;
        });

        reactions.put(UIActionAddProduktFunktionEvent.class, (model, view, event)->{
            DataProduktFunktion dataProduktFunktion = new DataProduktFunktion(DefaultValues.PRODUKTFUNKTION_NAME,
                    DefaultValues.PRODUKTFUNKTION_BESCHREIBUNG, DefaultValues.PRODUKTFUNKTION_AKTEUR, DefaultValues.PRODUKTFUNKTION_QUELLE,
                    DefaultValues.PRODUKTFUNKTION_VERWEISE, generateUniqueID("/LF", "/"));
            model.getIDataAnforderungssammlung().getDataProduktFunktionen().put(dataProduktFunktion.getId(), dataProduktFunktion);
            return true;
        });

        //DELETE
        reactions.put(UIActionDeleteFPAnalyseEvent.class, (model, view, event)->{
            model.getIDataAnforderungssammlung().deleteIDataFunctionPointAnalyse();
            return true;
        });

        reactions.put(UIActionDeleteProduktDatumEvent.class, (model, view, event)->{
            UIActionDeleteProduktDatumEvent e = (UIActionDeleteProduktDatumEvent) event;

            Collection<DataProduktDatum> list = model.getIDataAnforderungssammlung().getDataProduktDaten().values();
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

            Collection<DataProduktFunktion> list = model.getIDataAnforderungssammlung().getDataProduktFunktionen().values();
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
            DataProduktDatum proposal = e.getProposal();
            DataProduktDatum current = model.getIDataAnforderungssammlung().getDataProduktDaten().get(e.getId());
            String errorMessage = validator.isValid(model, current, proposal);
            if(errorMessage == null){
                boolean containsChange = current.modify(proposal);
                e.setSuccess(true);
                return containsChange;
            }else{
                e.setErrorMessage(errorMessage);
                return false;
            }
        });

        reactions.put(UIModifyProduktFunktionEvent.class, (model, view, event)->{
            UIModifyProduktFunktionEvent e = (UIModifyProduktFunktionEvent) event;
            DataProduktFunktion proposal = e.getProposal();
            DataProduktFunktion current = model.getIDataAnforderungssammlung().getDataProduktFunktionen().get(e.getId());
            String errorMessage = validator.isValid(model, current, proposal);
            if(errorMessage == null){
                boolean containsChange = current.modify(proposal);
                e.setSuccess(true);
                return containsChange;
            }else{
                e.setErrorMessage(errorMessage);
                return false;
            }
        });

        reactions.put(UIModifyZielbestimmungEvent.class, (model, view, event)->{
            UIModifyZielbestimmungEvent e = (UIModifyZielbestimmungEvent) event;
            DataZielbestimmung proposal = e.getProposal();
            String errorMessage = validator.isValid(model, proposal);
            if(errorMessage == null){
                model.getIDataAnforderungssammlung().getDataZielbestimmung().modify(proposal);
                e.setSuccess(true);
                return true;
            }else{
                e.setErrorMessage(errorMessage);
                return false;
            }
        });

        reactions.put(UIModifyUmgebungEvent.class, (model, view, event)->{
            UIModifyUmgebungEvent e = (UIModifyUmgebungEvent) event;
            DataUmgebung proposal = e.getProposal();
            String errorMessage = validator.isValid(model, proposal);
            if(errorMessage == null){
                model.getIDataAnforderungssammlung().getDataUmgebung().modify(proposal);
                e.setSuccess(true);
                return true;
            }else{
                e.setErrorMessage(errorMessage);
                return false;
            }
        });

        reactions.put(UIModifyProdukteinsatzEvent.class, (model, view, event)->{
            UIModifyProdukteinsatzEvent e = (UIModifyProdukteinsatzEvent) event;
            DataProdukteinsatz proposal = e.getProposal();
            String errorMessage = validator.isValid(model, proposal);
            if(errorMessage == null){
                model.getIDataAnforderungssammlung().getDataProdukteinsatz().modify(proposal);
                e.setSuccess(true);
                return true;
            }else{
                e.setErrorMessage(errorMessage);
                return false;
            }
        });

        reactions.put(UIModifyFunctionPointEinstufungEvent.class, (model, view, event)->{
            UIModifyFunctionPointEinstufungEvent e = (UIModifyFunctionPointEinstufungEvent) event;
            IIdentifiable iIdentifiable = model.getIDataAnforderungssammlung().getObject(e.getID());
            IDataFunctionPointEinstufung current = model.getIDataAnforderungssammlung().getIDataFunctionPointAnalyse().getEinstufung(iIdentifiable);
            IDataFunctionPointEinstufung proposal = e.getProposal();
            String errorMessage = validator.isValid(model, current, proposal, iIdentifiable);
            if(errorMessage == null){
                current.modify(proposal);
                e.setSuccess(true);
                return true;
            }else{
                e.setErrorMessage(errorMessage);
                return false;
            }
        });


        reactions.put(UIModifyRealerAufwand.class, (model, view, event)->{
            UIModifyRealerAufwand e = (UIModifyRealerAufwand) event;
            double proposal = e.getProposal();
            String errorMessage = validator.isValid(model, proposal);
            if(errorMessage == null){
                model.getIDataAnforderungssammlung().getIDataFunctionPointAnalyse().setRealerAufwand(proposal);
                e.setSuccess(true);
                return true;
            }else{
                e.setErrorMessage(errorMessage);
                return false;
            }
        });

        reactions.put(UIModifyGewichtsfaktorenEvent.class, (model, view, event)->{
            UIModifyGewichtsfaktorenEvent e = (UIModifyGewichtsfaktorenEvent) event;
            IDataSchaetzKonfiguration proposal = e.getProposal();
            String errorMessage = validator.isValid(model, proposal);
            if(errorMessage == null){
                model.setSchaetzKonfiguration(proposal);
                e.setSuccess(true);
                return true;
            }else{
                e.setErrorMessage(errorMessage);
                return false;
            }
        });

        //ACTION
        reactions.put(UIActionFPAufwandAnzeigenEvent.class, (model, view, event)->{
            UIActionFPAufwandAnzeigenEvent e = (UIActionFPAufwandAnzeigenEvent) event;
            aufwandRechner.calculateAufwand(model, e.getVaf());
            return true;
        });

        reactions.put(UIActionFPGewichtsfaktorenOptimierenEvent.class, (model, view, event)->{
            UIActionFPGewichtsfaktorenOptimierenEvent e = (UIActionFPGewichtsfaktorenOptimierenEvent) event;
            aufwandRechner.optimiereFaktor(model, e.getVaf(), e.getIndex());
            return true;
        });


        //MENU
        reactions.put(UIActionMenuCreateEvent.class, (model, view, event)->{
            File f = ((UIActionMenuCreateEvent)event).getFileAnforderungssammlung();
            model.createAnforderungssammlung(f);
            return false;
        });

        reactions.put(UIActionMenuLoadEvent.class, (model, view, event)->{
            File f = ((UIActionMenuLoadEvent)event).getFileAnforderungssammlung();
            model.loadAnforderungssammlung(f);
            return false;
        });

        reactions.put(UIActionMenuSaveEvent.class, (model, view, event)->{
            model.saveAnforderungssammlung();
            model.saveSchaetzkonfiguration();
            return false;
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


    private DataId generateUniqueID(String prefix, String suffix){
        int i = 0;
        DataId id ;
        while(model.getIDataAnforderungssammlung().getObject(id = new DataId(prefix + String.valueOf(i) + suffix)) != null){
            i+=5;
        }
        return id;
    }

}
