package org.dhbw.stuttgart.ita16.reqmaster.view;

import org.dhbw.stuttgart.ita16.reqmaster.components.*;
import org.dhbw.stuttgart.ita16.reqmaster.events.UIModifyFunctionPointEinstufungEvent;
import org.dhbw.stuttgart.ita16.reqmaster.model.*;
import java.awt.*;

/**
 * Grafikkomponente: enthält den Namen einer Produktfunktion oder eines Produktdatums,
 * um es klassifizieren zu können und eine Komplexität zuweisen zu können
 */
public class UIFunctionPointEinstufung extends UIPanel implements IUIUpdateable {

    //Variablen der Klasse
    private final DataId dataId; //always the real DataId instance, as being used within the model
    private UILabel idText;
    private UILabel nameText;
    private UILabel klassifizierungText;
    private UILabel komplexitaetText;
    private UIChoice<FPKlassifizierung> klassifizierungUIChoice;
    private UIChoice<FPKomplexitaet> komplexitaetUIChoice;

    /**
     * Konstruktor der Klasse
     * @param view Instanz der View des MVC-Patterns
     * @param dataId ID des Produktdatums
     */
    public UIFunctionPointEinstufung(IView view, DataId dataId) {
        super(view);
        this.dataId = dataId;

        //Settings
        this.setLayout(new GridLayout(4,2));
        addComponents();
        setComponents();
        this.update(view.getModel());
        this.setVisible(true);
    }

    /**
     * Hinzufügen der Grafikkomponenten sowie Definition eines FokusListener
     */
    private void addComponents() {
        this.add(idText = new UILabel());
        this.add(nameText = new UILabel());
        this.add(klassifizierungText = new UILabel());
        this.add(klassifizierungUIChoice = new UIChoice<>(FPKlassifizierung.values(), (component, selected) -> this.changedValue()));
        this.add(komplexitaetText = new UILabel());
        this.add(komplexitaetUIChoice = new UIChoice<>(FPKomplexitaet.values(), (component, selected) -> this.changedValue()));
    }

    /**
     * Settings der Komponenten
     */
    private void setComponents() {
        this.idText.setForeground(Color.BLUE);
        this.nameText.setForeground(Color.BLUE);
        klassifizierungText.setText("Klassifizierung");
        komplexitaetText.setText("Komplexitaet");
    }

    public void changedValue(){
        FPKlassifizierung klassifizierung = (FPKlassifizierung) klassifizierungUIChoice.getSelectedItem();
        String klassifizierungName = klassifizierung.name();
        FPFunktionsTyp funktionsTyp = FPFunktionsTyp.valueOf(klassifizierungName.substring(0, klassifizierungName.indexOf("_")));
        FPKomplexitaet komplexitaet = (FPKomplexitaet) komplexitaetUIChoice.getSelectedItem();

        IIdentifiable iIdentifiable = getView().getModel().getIDataAnforderungssammlung().getObject(this.dataId);
        IDataFunctionPointEinstufung einstufung = getView().getModel().getIDataAnforderungssammlung().getIDataFunctionPointAnalyse().getEinstufung(iIdentifiable);
        if(einstufung.getFunktionstyp() == funktionsTyp && einstufung.getKlassifizierung() == klassifizierung && einstufung.getKomplexitaet() == komplexitaet){
            return; //no changes to make
        }

        IDataFunctionPointEinstufung proposal = new DataFunctionPointEinstufung(funktionsTyp, klassifizierung, komplexitaet);
        UIModifyFunctionPointEinstufungEvent event = new UIModifyFunctionPointEinstufungEvent(this.dataId, proposal);
        getView().getObsController().observe(event);
        if(!event.isSuccess()){
            this.update(getView().getModel());
        }
    }

    /**
     * Implementierung der update-Methode
     * wenn sich ein Produktdatum geändert hat, wird diese Methode aufgerufen,
     * um die GUI zu aktualisieren
     * @param model Instanz des Models des MVC-Patterns
     */
    @Override
    public void update(IModel model){
        IIdentifiable iIdentifiable = model.getIDataAnforderungssammlung().getObject(this.dataId);
        IDataFunctionPointEinstufung einstufung = model.getIDataAnforderungssammlung().getIDataFunctionPointAnalyse().getEinstufung(iIdentifiable);
        this.idText.setText("Id: " + dataId.getId());
        this.nameText.setText("Name: " + iIdentifiable.getName());
        //this.funktionsTypUIChoice.setChoice(einstufung.getFunktionstyp());
        this.klassifizierungUIChoice.setChoice(einstufung.getKlassifizierung());
        this.komplexitaetUIChoice.setChoice(einstufung.getKomplexitaet());

    }

    /**
     * Getter Methode für die ID des Produktdatums
     * @return DataId des Produktdatum
     */
    public DataId getId() {
        return dataId;
    }
}
