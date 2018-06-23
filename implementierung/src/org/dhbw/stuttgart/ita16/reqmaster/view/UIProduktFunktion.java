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
        this.update(view.getModel());

        // keinen Layoutmanager verwenden und Größe setzen
        this.setLayout(null);
        this.setBounds(10,10,300,500);

        // Komponenten verwalten
        addComponents();
        setComponents();
        // sichtbar
        this.setVisible(true);

        delete.addActionListener((actionListener -> getView().getObsController().observe(new UIActionDeleteProduktFunktionEvent(new DataId(id.getText())))));
    }

    /**
     *  Hinzufügen der Grafikkomponenten zum Panel sowie
     *  Definition des Fokuslistener
     */
    private void addComponents() {
        //Für jedes UITextField in ProduktFunktion wird einmalig ein
        //FocusListener definiert, den die Textfelder im Konstruktor übergeben bekommen
        FocusListener focusListener = new FocusListener() {

             //Wenn das Textfeld den Fokus verliert, soll nichts passieren
            @Override
            public void focusGained(FocusEvent e) { }

             //Wenn das Textfeld den Fokus verliert, wird ein Event an den Controller geschickt,
             //um den Inhalt des Textfeldes zu validieren
            @Override
            public void focusLost(FocusEvent e) {
                //TODO DataProduktFunktion definieren (extra Methode)
                DataProduktFunktion proposal = new DataProduktFunktion(null, null, null, null, null, null);
                UIModifyProduktFunktionEvent modifyEvent = new UIModifyProduktFunktionEvent(dataId, proposal);
                getView().getObsController().observe(modifyEvent);
                if(!modifyEvent.isSuccess()){
                    //TODO
                }
            }
        };

        this.add(delete = new UIButton());
        this.add(id = new UITextField(focusListener));
        this.add(name = new UITextField(focusListener));
        this.add(quelle = new UITextField(focusListener));
        this.add( akteur = new UITextField(focusListener));
        this.add(beschreibung = new UITextField(focusListener));
        this.add(verweise = new UITextField(focusListener));

        this.add(idText = new UILabel());
        this.add(nameText = new UILabel());
        this.add(quelleText = new UILabel());
        this.add(akteurText = new UILabel());
        this.add(beschreibungText = new UILabel());
        this.add(verweiseText = new UILabel());
    }

    /**
     * Größe der Komponenten und Inhalt setzen
     */
    private void setComponents(){

        delete.setText("Löschen");
        delete.setBounds(190,10,90,20);
        id.setBounds(130,35,150,20);
        name.setBounds(130,60, 150,20);
        quelle.setBounds(130,85,150,20);
        akteur.setBounds(130,110, 150,20);
        beschreibung.setBounds(130,135,150,50);
        verweise.setBounds(130,190, 150, 20);

        idText.setText("ID");
        idText.setBounds(10,35,90,20);
        nameText.setText("Name");
        nameText.setBounds(10,60, 90,20);
        quelleText.setText("Quelle");
        quelleText.setBounds(10,85,90,20);
        akteurText.setText("Akteur");
        akteurText.setBounds(10,110,90,20);
        beschreibungText.setText("Beschreibung");
        beschreibungText.setBounds(10,135,90,20);
        verweiseText.setText("Verweise");
        verweiseText.setBounds(10,190,90,20);
    }

    @Override
    public void update(IModel model){
        DataProduktFunktion newFunktion = model.getIDataAnforderungssammlung().getDataProduktFunktionen().get(dataId);
        id.setText(dataId.getId());
        name.setText(newFunktion.getName());
        quelle.setText(newFunktion.getQuelle());
        akteur.setText(newFunktion.getAkteur());
        beschreibung.setText(newFunktion.getBeschreibung());
        // TODO wie geht das mit den Verweisen, siehe Produktdatum
    }

    public DataId getId(){
        return this.dataId;
    }
}

