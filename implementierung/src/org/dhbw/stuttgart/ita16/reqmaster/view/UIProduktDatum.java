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


/**
 * Grafikkomponente: legt Aufbau eines Produktdatums fest
 */
public class UIProduktDatum extends UIPanel implements UIUpdateable {

    private final DataId dataId;

    private UIButton delete;
    private UITextField name;
    private UITextField id;
    private UITextField attribute;
    private UITextField verweise;
    private UILabel nameText;
    private UILabel idText;
    private UILabel attributeText;
    private UILabel verweiseText;


    /**
     * Konstruktor der Klasse
     * @param view Instanz der View des MVC-Patterns
     * @param dataId ID des Produktdatums
     */

    public UIProduktDatum (IView view, DataId dataId) {
        super(view);
        this.dataId = dataId;
        this.update(view.getModel());

        this.setLayout(new GridLayout(6,2));
        addComponents();
        setComponents();
        this.setVisible(true);

        // Definition eines ActionListeners für den Delete Button, der ein Event an den Controller schickt,
        // um ein Produktdatum zu löschen
        delete.addActionListener(actionListener -> getView().getObsController().observe(new UIActionDeleteProduktDatumEvent(dataId)));
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
            public void focusGained(FocusEvent e) { }

            /**
             * Wenn das Textfeld den Fokus verliert, wird ein Event an den Controller geschickt,
             * um den Inhalt des Textfeldes zu validieren
             * @param e auf zu reagierendes Event
             */
            @Override
            public void focusLost(FocusEvent e) {
                //TODO DataProduktDatum definieren (extra Methode)
                DataProduktDatum proposal = new DataProduktDatum(name.getText(), new DataId(id.getText()), attribute.getText(), verweise.getText());
                UIModifyProduktDatumEvent modifyEvent = new UIModifyProduktDatumEvent(dataId, proposal);
                getView().getObsController().observe(modifyEvent);
                if(!modifyEvent.isSuccess()){
                    //TODO focus request (vtl. in Runnable damit nicht direkt danach)
                    //
                }
            }
        };

        this.add(delete = new UIButton());
        this.add(new UILabel());
        this.add(idText = new UILabel());
        this.add(id = new UITextField(focusListener));
        this.add(nameText = new UILabel());
        this.add(name = new UITextField(focusListener));
        this.add(attributeText = new UILabel());
        this.add(attribute = new UITextField(focusListener));
        this.add(verweiseText = new UILabel());
        this.add(verweise = new UITextField(focusListener));
    }


    /**
     *  Methode zum Setzen des Inhalts der Komponenten
     */
    private void setComponents() {
        delete.setText("Löschen");
        nameText.setText("Name");
        idText.setText("ID");
        attributeText.setText("Attribute");
        verweiseText.setText("Verweise");
    }


    @Override
    public void update(IModel model){
//        DataProduktDatum newDatum = model.getIDataAnforderungssammlung().getDataProduktDaten().get(dataId);
  //      this.id.setText(dataId.getId());
    //    name.setText(newDatum.getName());

        //TODO auslesen attribute und verweise und setzen in der GUI
        //TODO Wie werden Attribute und Verweise angezeigt? in Textfeld oder in mehreren Textfeldern da im Model eine Liste?

    }

    /**
     * getter-Methode für die ID des Produktdatums
     * @return DataId des Produktdatum
     */
    public DataId getId() {
        return dataId;
    }
}
