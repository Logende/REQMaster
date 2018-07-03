package org.dhbw.stuttgart.ita16.reqmaster.controller;

import org.dhbw.stuttgart.ita16.reqmaster.events.*;
import org.dhbw.stuttgart.ita16.reqmaster.model.*;
import org.dhbw.stuttgart.ita16.reqmaster.view.IView;

import java.io.File;
import java.util.*;

/**
 * Controller des MVC Pattern.
 * In der lage, auf UIEvents zu reagieren, in dem er z.B. Daten im Model ändert oder Fehlermeldungen zurückgibt.
 */
public class Controller implements IObserverController, IController{


    private IModel model;
    private IView view;

    private IValidator validator;
    private IAufwandRechner aufwandRechner;

    /**
     * Hinweis zu Eventhandling:
     * Damit nicht in einer riesigen Methode auf alle Events separat reagiert werden muss (riesige Fallunterscheidung),
     * wird hier die dazugehörige Reaktion auf ein Event für alle möglichen Eventklassen gelagert.
     * Wieso Event Reaktionen überhaupt im Controller stehen und nicht in den Event Klassen selbst?
     * Separation of concerns: Die Events werden von der View erstellt und verwaltet, sie gehören zur View.
     * Reaktionen sind allerdings Aufgabe des Controllers und müssen deswegen unabhängig von den Events (die zur View gehören) sein.
     *
     * Gleichzeitig erlaubt dieser Ansatz enorme Erweiterbarkeit: Es könnten theoretisch dynamisch bzw. durch außenstehende Komponenten
     * neue Event-Reaktionen registriert oder bestehende ersetzt werden.
     * Damit könnte der Controller von außen durch neue Funktionalität erweitert werden.
     */
    private Map<Class<? extends UIEvent>, EventReaction> reactions;

    /**
     * Erstellt neue Controller Instanz.
     * @param iModel Model mit allen Daten.
     * @param iView View, welche Events senden wird.
     * @param validator Der Validator ermöglicht es zu prüfen, ob Eingabedaten von Nutzer valide sind.
     * @param aufwandRechner Damit kann der Controller den Aufwand einer Anforderungssammlung bestimmen oder Gewichtsfaktoren optimieren.
     */
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


        reactions.put(UIModifyRealerAufwandEvent.class, (model, view, event)->{
            UIModifyRealerAufwandEvent e = (UIModifyRealerAufwandEvent) event;
            double proposal = e.getProposal();
            String errorMessage = validator.isValid(model, proposal);
            if(errorMessage == null){
                System.out.println("set realer aufwand to " + proposal);
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
            String errorMessage = aufwandRechner.calculateAufwand(model, e.getVaf());
            if(errorMessage == null) {
                e.setSuccess(true);
                return true;
            }else{
                e.setErrorMessage(errorMessage);
                return false;
            }
        });

        reactions.put(UIActionFPGewichtsfaktorenOptimierenEvent.class, (model, view, event)->{
            UIActionFPGewichtsfaktorenOptimierenEvent e = (UIActionFPGewichtsfaktorenOptimierenEvent) event;
            String errorMessage = aufwandRechner.optimiereFaktor(model, e.getVaf(), e.getIndex());
            if(errorMessage == null) {
                e.setSuccess(true);
                return true;
            }else{
                e.setErrorMessage(errorMessage);
                return false;
            }
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
