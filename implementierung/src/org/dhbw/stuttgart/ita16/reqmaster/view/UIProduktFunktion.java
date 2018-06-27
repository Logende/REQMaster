package org.dhbw.stuttgart.ita16.reqmaster.view;

import org.dhbw.stuttgart.ita16.reqmaster.components.UIButton;
import org.dhbw.stuttgart.ita16.reqmaster.components.UILabel;
import org.dhbw.stuttgart.ita16.reqmaster.components.UIPanel;
import org.dhbw.stuttgart.ita16.reqmaster.components.UITextField;
import org.dhbw.stuttgart.ita16.reqmaster.events.UIActionDeleteProduktFunktionEvent;
import org.dhbw.stuttgart.ita16.reqmaster.events.UIModifyProduktDatumEvent;
import org.dhbw.stuttgart.ita16.reqmaster.events.UIModifyProduktFunktionEvent;
import org.dhbw.stuttgart.ita16.reqmaster.model.DataId;
import org.dhbw.stuttgart.ita16.reqmaster.model.DataProduktFunktion;
import org.dhbw.stuttgart.ita16.reqmaster.model.IModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

/**
 * Grafikkomponente: legt Aufbau einer Produktfunktion fest
 */

public class UIProduktFunktion extends UIPanel implements UIUpdateable{

    /*Variablen der Klasse*/
    private final DataId dataId; //always the real DataId instance, as being used within the model

    // Button
    private UIButton delete;

    //Textfelder
    private UITextField id;
    private UITextField name;
    private UITextField quelle;
    private UITextField akteur;
    private UITextField beschreibung;
    private UITextField verweise;

    //Labels
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
        delete.addActionListener(actionEvent -> {
        if(View.forcesFocus == null || UIProduktFunktion.this == View.forcesFocus) {
            getView().getObsController().observe(new UIActionDeleteProduktFunktionEvent(this.dataId));
            View.forcesFocus = null;
        }
        });
    }

    /**
     *  Hinzufügen der Grafikkomponenten zum Panel sowie
     *  Definition des Fokuslistener
     */
    private void addComponents() {

        /*Für jedes UITextField in ProduktFunktion wird einmalig ein
        *FocusListener definiert, den die Textfelder im Konstruktor übergeben bekommen
        */
        FocusListener focusListener = new FocusListener() {

            /**
             * Methode, die implementiert werden muss, aber nichts tun soll,
             * wenn eine Komponente den Fokus verliert
             * @param e auf das zu reagierende Event
             */
            @Override
            public void focusGained(FocusEvent e) {
            }

            /**
             * Wenn das Textfeld den Fokus verliert, wird ein Event an den Controller geschickt,
             * um den Inhalt des Textfeldes zu validieren
             * @param e
             */
            @Override
            public void focusLost(FocusEvent e) {
                if(e.getOppositeComponent() != null) {
                    if (e.getComponent().getParent() == e.getOppositeComponent().getParent()) {
                        return; //do nothing if new component has same parent
                    }
                }
                DataProduktFunktion proposal = new DataProduktFunktion(name.getText(), beschreibung.getText(), akteur.getText(),
                        quelle.getText(), verweise.getText(), new DataId(id.getText()));
                UIModifyProduktFunktionEvent modifyEvent = new UIModifyProduktFunktionEvent(dataId, proposal);
                getView().getObsController().observe(modifyEvent);
                if(!modifyEvent.isSuccess()){
                    View.forcesFocus = UIProduktFunktion.this;
                    e.getComponent().requestFocus();
                }else{
                    View.forcesFocus = null;
                }
            }
        };

        this.add(delete = new UIButton());
        this.add(new Label());
        this.add(new Label());
        this.add(new Label());
        this.add(idText = new UILabel());
        this.add(id = new UITextField(focusListener));
        this.add(nameText = new UILabel());
        this.add(name = new UITextField(focusListener));
        this.add(quelleText = new UILabel());
        this.add(quelle = new UITextField(focusListener));
        this.add(akteurText = new UILabel());
        this.add( akteur = new UITextField(focusListener));
        this.add(beschreibungText = new UILabel());
        this.add(beschreibung = new UITextField(focusListener));
        this.add(verweiseText = new UILabel());
        this.add(verweise = new UITextField(focusListener));
    }

    /**
     * Größe der Komponenten und Inhalt setzen
     */
    private void setComponents(){

        delete.setText("Löschen");
        idText.setText("ID");
        nameText.setText("Name");
        quelleText.setText("Quelle");
        akteurText.setText("Akteur");
        beschreibungText.setText("Beschreibung");
        verweiseText.setText("Verweise");
    }

    @Override
    public void update(IModel model){

            DataProduktFunktion newFunktion = model.getIDataAnforderungssammlung().getDataProduktFunktionen().get(dataId);
            id.setText(dataId.getId());
            name.setText(newFunktion.getName());
            quelle.setText(newFunktion.getQuelle());
            akteur.setText(newFunktion.getAkteur());
            beschreibung.setText(newFunktion.getBeschreibung());
            verweise.setText(newFunktion.getVerweise());

        // TODO wie geht das mit den Verweisen, siehe Produktdatum
    }

    /**
     * getter Methode für ID der Produktfunktion
     * @return DataId der Produktfunktion
     */
    public DataId getId(){
        return this.dataId;
   }
}

