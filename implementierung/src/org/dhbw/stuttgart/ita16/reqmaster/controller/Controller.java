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

    private Map<Class<? extends UIEvent>, EventReaction> reactions;

    public Controller(IModel iModel, IView iView, IValidator validator) {
        reactions = new HashMap<>();
        this.validator = validator;
        this.view = iView;
        this.model = iModel;

        //ADD
        reactions.put(UIActionAddProduktDatumEvent.class, (model, view, event)->{
            DataProduktDatum dataProduktDatum = new DataProduktDatum(DefaultValues.PRODUKTDATUM_NAME, generateUniqueID("/LF", "/"),
                    new ArrayList<>(), new ArrayList<>());
            model.getIDataAnforderungssammlung().getDataProduktDaten().put(dataProduktDatum.getId(), dataProduktDatum);
            return true;
        });

        reactions.put(UIActionAddProduktFunktionEvent.class, (model, view, event)->{
            DataProduktFunktion dataProduktFunktion = new DataProduktFunktion(DefaultValues.PRODUKTFUNKTION_NAME,
                    DefaultValues.PRODUKTFUNKTION_BESCHREIBUNG, DefaultValues.PRODUKTFUNKTION_AKTEUR, DefaultValues.PRODUKTFUNKTION_QUELLE,
                    new ArrayList<>(), generateUniqueID("/LD", "/"));
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
            if(validator.isValid(model, current, proposal)){
                current.modify(proposal);
                e.setSuccess(true);
                return true;
            }else{
                return false;
            }
        });

        reactions.put(UIModifyProduktFunktionEvent.class, (model, view, event)->{
            UIModifyProduktFunktionEvent e = (UIModifyProduktFunktionEvent) event;
            DataProduktFunktion proposal = e.getProposal();
            DataProduktFunktion current = model.getIDataAnforderungssammlung().getDataProduktFunktionen().get(e.getId());
            if(validator.isValid(model, current, proposal)){
                current.modify(proposal);
                e.setSuccess(true);
                return true;
            }else{
                return false;
            }
        });

        reactions.put(UIModifyZielbestimmungEvent.class, (model, view, event)->{
            UIModifyZielbestimmungEvent e = (UIModifyZielbestimmungEvent) event;
            DataZielbestimmung proposal = e.getProposal();
            if(validator.isValid(model, proposal)){
                model.getIDataAnforderungssammlung().getDataZielbestimmung().modify(proposal);
                e.setSuccess(true);
                return true;
            }else{
                return false;
            }
        });

        reactions.put(UIModifyProdukteinsatzEvent.class, (model, view, event)->{
            UIModifyProdukteinsatzEvent e = (UIModifyProdukteinsatzEvent) event;
            DataProdukteinsatz proposal = e.getProposal();
            if(validator.isValid(model, proposal)){
                model.getIDataAnforderungssammlung().getDataProdukteinsatz().modify(proposal);
                e.setSuccess(true);
                return true;
            }else{
                return false;
            }
        });

        reactions.put(UIModifyFunktionstypEvent.class, (model, view, event)->{
            UIModifyFunktionstypEvent e = (UIModifyFunktionstypEvent) event;
            FPFunktionsTyp proposalPart = e.getProposal();
            IIdentifiable iIdentifiable = model.getIDataAnforderungssammlung().getObject(e.getID());
            IDataFunctionPointEinstufung current = model.getIDataAnforderungssammlung().getIDataFunctionPointAnalyse().getEinstufung(iIdentifiable);
            IDataFunctionPointEinstufung proposal = new DataFunctionPointEinstufung(proposalPart, current.getKlassifizierung(), current.getKomplexitaet());
            if(validator.isValid(model, current, proposal, iIdentifiable)){
                current.modify(proposal);
                e.setSuccess(true);
                return true;
            }else{
                return false;
            }
        });

        reactions.put(UIModifyKlassifizierungEvent.class, (model, view, event)->{
            UIModifyKlassifizierungEvent e = (UIModifyKlassifizierungEvent) event;
            FPKlassifizierung proposalPart = e.getProposal();
            IIdentifiable iIdentifiable = model.getIDataAnforderungssammlung().getObject(e.getID());
            IDataFunctionPointEinstufung current = model.getIDataAnforderungssammlung().getIDataFunctionPointAnalyse().getEinstufung(iIdentifiable);
            IDataFunctionPointEinstufung proposal = new DataFunctionPointEinstufung(current.getFunktionstyp(), proposalPart, current.getKomplexitaet());
            if(validator.isValid(model, current, proposal, iIdentifiable)){
                current.modify(proposal);
                e.setSuccess(true);
                return true;
            }else{
                return false;
            }
        });

        reactions.put(UIModifyKomplexitaetEvent.class, (model, view, event)->{
            UIModifyKomplexitaetEvent e = (UIModifyKomplexitaetEvent) event;
            FPKomplexitaet proposalPart = e.getProposal();
            IIdentifiable iIdentifiable = model.getIDataAnforderungssammlung().getObject(e.getID());
            IDataFunctionPointEinstufung current = model.getIDataAnforderungssammlung().getIDataFunctionPointAnalyse().getEinstufung(iIdentifiable);
            IDataFunctionPointEinstufung proposal = new DataFunctionPointEinstufung(current.getFunktionstyp(), current.getKlassifizierung(), proposalPart);
            if(validator.isValid(model, current, proposal, iIdentifiable)){
                current.modify(proposal);
                e.setSuccess(true);
                return true;
            }else{
                return false;
            }
        });

        reactions.put(UIModifyRealerAufwand.class, (model, view, event)->{
            UIModifyRealerAufwand e = (UIModifyRealerAufwand) event;
            double proposal = e.getProposal();
            if(validator.isValid(model, proposal)){
                model.getIDataAnforderungssammlung().getIDataFunctionPointAnalyse().setRealerAufwand(proposal);
                e.setSuccess(true);
                return true;
            }else{
                return false;
            }
        });

        reactions.put(UIModifyGewichtsfaktorenEvent.class, (model, view, event)->{
            UIModifyGewichtsfaktorenEvent e = (UIModifyGewichtsfaktorenEvent) event;
            IDataSchaetzKonfiguration proposal = e.getProposal();
            if(validator.isValid(model, proposal)){
                model.setSchaetzKonfiguration(proposal);
                e.setSuccess(true);
                return true;
            }else{
                return false;
            }
        });

        //ACTION
        reactions.put(UIActionFPAufwandAnzeigenEvent.class, (model, view, event)->{
            //TODO calculate aufwand & send "show aufwand" signal to view
            return false;
        });

        reactions.put(UIActionFPGewichtsfaktorenOptimierenEvent.class, (model, view, event)->{
            //TODO
            return true;
        });

        reactions.put(UIActionFPAufwandAnzeigenMannmonateEvent.class, (model, view, event)->{
            //TODO
            return false;
        });

        //MENU
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
        while(model.getIDataAnforderungssammlung().getObject(id = new DataId(prefix + String.valueOf(i) + suffix))!= null){
            i+=5;
        }
        return id;
    }

}
