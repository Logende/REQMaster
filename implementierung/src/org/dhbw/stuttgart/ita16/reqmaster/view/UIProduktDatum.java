package org.dhbw.stuttgart.ita16.reqmaster.view;

import org.dhbw.stuttgart.ita16.reqmaster.components.UIButton;
import org.dhbw.stuttgart.ita16.reqmaster.components.UILabel;
import org.dhbw.stuttgart.ita16.reqmaster.components.UIPanel;
import org.dhbw.stuttgart.ita16.reqmaster.components.UITextField;
import org.dhbw.stuttgart.ita16.reqmaster.events.UIActionDeleteProduktDatumEvent;
import org.dhbw.stuttgart.ita16.reqmaster.events.UIModifyProduktDatumEvent;
import org.dhbw.stuttgart.ita16.reqmaster.model.DataId;
import org.dhbw.stuttgart.ita16.reqmaster.model.DataProduktDatum;
import org.dhbw.stuttgart.ita16.reqmaster.model.IIdentifiable;
import org.dhbw.stuttgart.ita16.reqmaster.model.IModel;

import java.awt.event.*;


/**
 * Grafikkomponente: legt Aufbau eines Produktdatums fest
 */
public class UIProduktDatum extends UIPanel implements UIUpdateable {

    // Variablen der Klasse
    private DataId dataId; //TODO

    // Button
    private UIButton delete;

    //Textfelder
    private UITextField name;
    private UITextField id;
    private UITextField attribute;
    private UITextField verweise;

    //Labels
    private UILabel nameText;
    private UILabel idText;
    private UILabel attributeText;
    private UILabel verweiseText;

    /**
     * Konstruktor der Klasse
     * @param view Instanz der View des MVC-Patterns
     */
    public UIProduktDatum (View view, DataId dataId) {

        super(view);
        this.dataId = dataId;

        //keinen Layoutmanager verwenden und Größe setzen
        this.setLayout(null);
        this.setBounds(310,10,300,500);

        //Hinzufügen und verwalten der Komponenten
        addComponents();
        setComponents();
        //sichtbar
        this.setVisible(true);

        delete.addActionListener(new ActionListener() {
            /**
             * wenn der Löschen-Button geklickt wird, wird ein UIActionDeleteProduktDatumEvent
             * an den Controller weitergeleitet mit der ID des Produktdatums
             * @param e
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                getView().getObsController().observe(new UIActionDeleteProduktDatumEvent(dataId));
            }
        });
    }

    /**
     * Hinzufügen der Grafikkomponenten
     */
    private void addComponents() {

        /*
        **  Für jedes UITextField in ProduktDatum wird einmalig ein
        *   FocusListener definiert, den die Textfelder im Konstruktor übergeben bekommen
        */
        FocusListener focusListener = new FocusListener() {
            /**
             * Wenn das Textfeld den Fokus verliert, soll nichts passieren
             * @param e
             */
            @Override
            public void focusGained(FocusEvent e) { }

            /**
             * Wenn das Textfeld den Fokus verliert, wird ein Event an den Controller geschickt,
             * um den Inhalt des Textfeldes zu validieren
             * @param e
             */
            @Override
            public void focusLost(FocusEvent e) {
                //TODO DataProduktDatum definieren (extra Methode)
                DataProduktDatum proposal = new DataProduktDatum(null, null, null, null);
                UIModifyProduktDatumEvent modifyEvent = new UIModifyProduktDatumEvent(dataId, proposal);
                getView().getObsController().observe(modifyEvent);
                if(!modifyEvent.isSuccess()){
                    //TODO focus request (vtl. in Runnable damit nicht direkt danach)
                    //
                }
                else {
                    dataId = proposal.getId();
                }
            }
        };

        this.add(delete = new UIButton());
        this.add(id = new UITextField(focusListener));
        this.add(name = new UITextField(focusListener));
        this.add(attribute = new UITextField(focusListener));
        this.add(verweise = new UITextField(focusListener));

        this.add(nameText = new UILabel());
        this.add(idText = new UILabel());
        this.add(attributeText = new UILabel());
        this.add(verweiseText = new UILabel());
    }


    /**
     *  Methode zum Setzen der Position, Größe und des Inhalts der Komponenten
     */
    private void setComponents() {

        delete.setText("Löschen");
        delete.setBounds(150,10,90,20);
        name.setBounds(90,35,150,20);
        id.setBounds(90,60,150,20);
        attribute.setBounds(90,85,150,20);
        verweise.setBounds(90,110,150,20);

        nameText.setText("Name");
        nameText.setBounds(10,35,90,20);
        idText.setText("ID");
        idText.setBounds(10,60,90,20);
        attributeText.setText("Attribute");
        attributeText.setBounds(10,85,90,20);
        verweiseText.setText("Verweise");
        verweiseText.setBounds(10,110,90,20);

    }

    /**
     *
     * @param model
     */
    @Override
    public void update(IModel model){
        DataProduktDatum newDatum = model.getIDataAnforderungssammlung().getDataProduktDaten().get(dataId);
        this.dataId = newDatum.getId();
        this.id.setText(dataId.getId());
        name.setText(newDatum.getName());

        //TODO auslesen attribute und verweise und setzen in der GUI
        //TODO Wie werden Attribute und Verweise angezeigt? in Textfeld oder in mehreren Textfeldern da im Model eine Liste?
        //Ggf. scrollbar mit mehreren Textfeldern für verschiedene Verweise und Attribute
    }


}
