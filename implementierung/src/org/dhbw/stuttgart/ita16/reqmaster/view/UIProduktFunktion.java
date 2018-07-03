package org.dhbw.stuttgart.ita16.reqmaster.view;

import org.dhbw.stuttgart.ita16.reqmaster.components.*;
import org.dhbw.stuttgart.ita16.reqmaster.events.UIActionDeleteProduktFunktionEvent;
import org.dhbw.stuttgart.ita16.reqmaster.events.UIEvent;
import org.dhbw.stuttgart.ita16.reqmaster.events.UIModifyProduktFunktionEvent;
import org.dhbw.stuttgart.ita16.reqmaster.model.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusListener;

/**
 * Grafikkomponente: Ermöglicht es dem Anwender, eine Produktfunktion seiner Anforderungssammlung zu definieren.
 */
public class UIProduktFunktion extends UIPanel implements IUIUpdateable {

    //Variablen der Klasse
    private final DataId dataId; //always the real DataId instance, as being used within the model
    private UILabel title;
    private UIButton delete;
    private UITextField id;
    private UITextField name;
    private UITextField quelle;
    private UITextField akteur;
    private UITextField beschreibung;
    private UITextField verweise;
    private UILabel idText;
    private UILabel nameText;
    private UILabel quelleText;
    private UILabel akteurText;
    private UILabel beschreibungText;
    private UILabel verweiseText;

    /**
     * Konstruktor der Klasse
     * @param view Instanz der View des MVC-Patterns
     */
    public UIProduktFunktion(IView view, DataId dataId) {
        super(view);
        this.dataId = dataId;
        this.setLayout(new GridLayout(9,2));
        addComponents();
        setComponents();
        this.update(view.getModel());
        this.setVisible(true);

        // Definition eines ActionListeners für den Delete Button, der ein Event an den Controller schickt,
        // um eine Produktfunktion zu löschen
        delete.addActionListener(new ActionListenerEventTriggering(view) {
            @Override
            public UIEvent generateEvent(Object source) {
                return new UIActionDeleteProduktFunktionEvent(UIProduktFunktion.this.dataId);
            }
            @Override
            public void finishedAction(){
                View.forcesFocus = null;
            }
        });
    }

    /**
     *  Hinzufügen der Grafikkomponenten zum Panel sowie
     *  Definition des Fokuslistener
     */
    private void addComponents() {
        /**
         * Für jedes UITextField der ProduktFunktion wird einmalig ein
         * FocusListener definiert, den die Textfelder im Konstruktor übergeben bekommen
         */
        FocusListener listener = new FocusListenerEventTriggering(getView()) {
            @Override
            public UIEvent generateEvent(Component lostFocus, Component gotFocus) {
                return UIProduktFunktion.this.generateModifyEvent();
            }
        };

        this.add(new UILabel());
        this.add(new UILabel());
        this.add(title = new UILabel());
        this.add(delete = new UIButton());
        this.add(idText = new UILabel());
        this.add(id = new UITextField(listener));
        this.add(nameText = new UILabel());
        this.add(name = new UITextField(listener));
        this.add(quelleText = new UILabel());
        this.add(quelle = new UITextField(listener));
        this.add(akteurText = new UILabel());
        this.add( akteur = new UITextField(listener));
        this.add(beschreibungText = new UILabel());
        this.add(beschreibung = new UITextField(listener));
        this.add(verweiseText = new UILabel());
        this.add(verweise = new UITextField(listener));
    }

    private UIEvent generateModifyEvent(){
        DataProduktFunktion proposal = new DataProduktFunktion(name.getText(), beschreibung.getText(), akteur.getText(),
                quelle.getText(), verweise.getText(), new DataId(id.getText()));
        UIModifyProduktFunktionEvent modifyEvent = new UIModifyProduktFunktionEvent(dataId, proposal);
        return modifyEvent;
    }

    /**
     * Größe der Komponenten und Inhalt setzen
     */
    private void setComponents(){
        title.setForeground(Color.BLUE);
        delete.setText("Löschen");
        idText.setText(DefaultValues.ID);
        nameText.setText(DefaultValues.PRODUKTFUNKTION_NAME);
        quelleText.setText(DefaultValues.PRODUKTFUNKTION_QUELLE);
        akteurText.setText(DefaultValues.PRODUKTFUNKTION_AKTEUR);
        beschreibungText.setText(DefaultValues.PRODUKTFUNKTION_BESCHREIBUNG);
        verweiseText.setText(DefaultValues.PRODUKTFUNKTION_VERWEISE);
    }

    /**
     * Aktualisiert alle dazugehörigen UI Komponenten mit den neuen Daten des Models.
     * @param model Instanz des Models des MVC-Patterns
     */
    @Override
    public void update(IModel model){
        DataProduktFunktion newFunktion = model.getIDataAnforderungssammlung().getDataProduktFunktionen().get(dataId);
        id.setText(dataId.getId());
        name.setText(newFunktion.getName());
        quelle.setText(newFunktion.getQuelle());
        akteur.setText(newFunktion.getAkteur());
        beschreibung.setText(newFunktion.getBeschreibung());
        verweise.setText(newFunktion.getVerweise());
        title.setText(newFunktion.getId().getId());
    }

    /**
     * Getter Methode für ID der Produktfunktion
     * @return DataId der Produktfunktion
     */
    public DataId getId(){
        return this.dataId;
    }
}

