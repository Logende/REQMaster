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
     */
    public UIProduktDatum (IView view, DataId dataId) {
        super(view);
        this.dataId = dataId;
        this.update(view.getModel());

        //keinen Layoutmanager verwenden und Größe setzen
        this.setLayout(null);
        this.setBounds(310,10,300,500);

        //Hinzufügen und verwalten der Komponenten
        addComponents();
        setComponents();
        //sichtbar
        this.setVisible(true);

        delete.addActionListener(actionListener -> getView().getObsController().observe(new UIActionDeleteProduktDatumEvent(dataId)));
    }

    /**
     * Hinzufügen der Grafikkomponenten
     */
    private void addComponents() {
        // Für jedes UITextField in ProduktDatum wird einmalig ein
        // FocusListener definiert, den die Textfelder im Konstruktor übergeben bekommen
        FocusListener focusListener = new FocusListener() {
             //Wenn das Textfeld den Fokus verliert, soll nichts passieren
            @Override
            public void focusGained(FocusEvent e) { }

             //Wenn das Textfeld den Fokus verliert, wird ein Event an den Controller geschickt,
             //um den Inhalt des Textfeldes zu validieren
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


    @Override
    public void update(IModel model){
        DataProduktDatum newDatum = model.getIDataAnforderungssammlung().getDataProduktDaten().get(dataId);
        this.id.setText(dataId.getId());
        name.setText(newDatum.getName());

        //TODO auslesen attribute und verweise und setzen in der GUI
        //TODO Wie werden Attribute und Verweise angezeigt? in Textfeld oder in mehreren Textfeldern da im Model eine Liste?

    }


    public DataId getId() {
        return dataId;
    }
}
