package org.dhbw.stuttgart.ita16.reqmaster.view;

import org.dhbw.stuttgart.ita16.reqmaster.components.UIButton;
import org.dhbw.stuttgart.ita16.reqmaster.components.UILabel;
import org.dhbw.stuttgart.ita16.reqmaster.components.UIPanel;
import org.dhbw.stuttgart.ita16.reqmaster.components.UITextField;
import org.dhbw.stuttgart.ita16.reqmaster.events.UIActionDeleteProduktDatumEvent;
import org.dhbw.stuttgart.ita16.reqmaster.events.UIModifyProduktDatumEvent;
import org.dhbw.stuttgart.ita16.reqmaster.model.DataId;
import org.dhbw.stuttgart.ita16.reqmaster.model.DataProduktDatum;
import org.dhbw.stuttgart.ita16.reqmaster.model.IModel;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.UUID;


/**
 * Grafikkomponente: legt Aufbau eines Produktdatums fest
 */
public class UIProduktDatum extends UIPanel implements UIUpdateable {

    //Variablen der Klasse
    private final DataId dataId; //always the real DataId instance, as being used within the model
    private UIButton delete;
    private UIButton addAttr;
    private UITextField name;
    private UITextField id;
    private UITextField attribute;
    private UITextField verweise;
    private UILabel nameText;
    private UILabel idText;
    private UILabel attributeText;
    private UILabel verweiseText;
    private UIPanel attributPanel;
    private UIPanel datumPanel;


    /**
     * Konstruktor der Klasse
     * @param view Instanz der View des MVC-Patterns
     * @param dataId ID des Produktdatums
     */

    public UIProduktDatum (IView view, DataId dataId) {
        super(view);
        this.dataId = dataId;

        //Settings
        this.setLayout(new GridLayout(8,2));
        addComponents();
        setComponents();
        this.update(view.getModel());
        this.setVisible(true);

        // Definition eines ActionListeners für den Delete Button, der ein Event an den Controller schickt,
        // um ein Produktdatum zu löschen
        delete.addActionListener(actionEvent -> {
            if(View.forcesFocus == null || UIProduktDatum.this == View.forcesFocus) {
                getView().getObsController().observe(new UIActionDeleteProduktDatumEvent(dataId));
                View.forcesFocus = null;
            }
        });
    }

    /**
     * Hinzufügen der Grafikkomponenten sowie Definition eines FokusListener
     */
    private void addComponents() {

        // Für jedes UITextField in ProduktDatum wird einmalig ein
        // FocusListener definiert, den die Textfelder im Konstruktor übergeben bekommen
        FocusListener focusListener = new FocusListener() {

            /**
             * Wenn das Textfeld den Fokus verliert, soll nichts passieren
             * @param e auf zu reagierendes Event
             */
            @Override
            public void focusGained(FocusEvent e) {

            }

            /**
             * Wenn das Textfeld den Fokus verliert, wird ein Event an den Controller geschickt,
             * um den Inhalt des Textfeldes zu validieren
             * @param e auf zu reagierendes Event
             */
            @Override
            public void focusLost(FocusEvent e) {
                if(e.getOppositeComponent() != null) {
                    if (e.getComponent().getParent() == e.getOppositeComponent().getParent()) {
                        return; //do nothing if new component has same parent
                    }
                }
                DataProduktDatum proposal = new DataProduktDatum(name.getText(), new DataId(id.getText()), new ArrayList<>(), verweise.getText());
                UIModifyProduktDatumEvent modifyEvent = new UIModifyProduktDatumEvent(dataId, proposal);
                getView().getObsController().observe(modifyEvent);
                if(!modifyEvent.isSuccess()){
                    View.forcesFocus = UIProduktDatum.this;
                    e.getComponent().requestFocus();
                }else{
                    View.forcesFocus = null;
                }
            }
        };

        this.add(delete = new UIButton());
        this.add(new UILabel());
        this.add(idText = new UILabel());
        this.add(id = new UITextField(focusListener));
        this.add(nameText = new UILabel());
        this.add(name = new UITextField(focusListener));
        this.add(verweiseText = new UILabel());
        this.add(verweise = new UITextField(focusListener));
        this.add(attributeText = new UILabel());
        this.add(addAttr = new UIButton());
        this.add(attribute = new UITextField(focusListener));
    }


    /**
     *  Methode zum Setzen des Inhalts der Komponenten
     */
    private void setComponents() {
        delete.setText("Löschen");
        addAttr.setText("Attribut hinzufügen");
        nameText.setText("Name");
        idText.setText("ID");
        attributeText.setText("Attribute");
        verweiseText.setText("Verweise");
    }

    /**
     * Implementierung der Update-Methode
     * wenn sich ein Produktdatum geändert hat, wird diese Methode aufgerufen,
     * um die GUI zu aktualisieren
     * @param model Instanz des Models des MVC-Patterns
     */
    @Override
    public void update(IModel model){
        DataProduktDatum newDatum = model.getIDataAnforderungssammlung().getDataProduktDaten().get(dataId);
        this.id.setText(dataId.getId());
        this.name.setText(newDatum.getName());
        this.verweise.setText(newDatum.getVerweise());
        //TODO: attribute

    }

    /**
     * getter-Methode für die ID des Produktdatums
     * @return DataId des Produktdatum
     */
    public DataId getId() {
        return dataId;
    }
}
