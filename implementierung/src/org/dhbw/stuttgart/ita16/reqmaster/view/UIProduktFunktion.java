package org.dhbw.stuttgart.ita16.reqmaster.view;

import org.dhbw.stuttgart.ita16.reqmaster.components.UIButton;
import org.dhbw.stuttgart.ita16.reqmaster.components.UIPanel;
import org.dhbw.stuttgart.ita16.reqmaster.components.UITextField;
import org.dhbw.stuttgart.ita16.reqmaster.model.IModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Grafikkomponente: legt Aufbau einer Produktfunktion fest
 */
public class UIProduktFunktion extends UIPanel implements UIUpdateable{

    /*Variablen der Klasse*/
    private UIButton delete;
    private UITextField id;
    private UITextField name;
    private UITextField quelle;
    private UITextField akteur;
    private UITextField beschreibung;
    private UITextField verweise;


    /**
     * Konstruktor der Klasse
     */
    public UIProduktFunktion(View view) {

        super(view);

        this.add(delete = new UIButton());
        this.add(id = new UITextField());
        this.add(name = new UITextField());
        this.add(quelle = new UITextField());
        this.add( akteur = new UITextField());
        this.add(beschreibung = new UITextField());
        this.add(verweise = new UITextField());

        delete.setBounds(10,10,90,20);
        delete.setText("Löschen");
        id.setText("ID");
        id.setBounds(10,35,150,20);
        name.setBounds(10,60, 150,20);
        name.setText("Name");
        quelle.setBounds(10,85,150,20);
        quelle.setText("Quelle");
        akteur.setBounds(10,110, 150,20);
        akteur.setText("Akteur");
        beschreibung.setBounds(10,135,150,50);
        beschreibung.setText("Beschreibung");
        verweise.setBounds(10,190, 150, 20);
        verweise.setText("Verweise");

        this.setVisible(true);

        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }


    /**
     *
     * @param model
     */
    @Override
    public void update(IModel model){


    }
}

