
package org.dhbw.stuttgart.ita16.reqmaster.view;

import org.dhbw.stuttgart.ita16.reqmaster.components.UIButton;
import org.dhbw.stuttgart.ita16.reqmaster.components.UILabel;
import org.dhbw.stuttgart.ita16.reqmaster.components.UIPanel;
import org.dhbw.stuttgart.ita16.reqmaster.model.IModel;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Grafikkomponente: Panel, das die Produktdaten enthaelt
 */
public class UIProduktDaten extends UIPanel implements UIUpdateable {

    private List<UIProduktDatum> produktDaten;
    private UIButton add;
    private UIPanel buttonPanel;
    private UIPanel datenPanel;


    /**
     * Konstruktor der Klasse
     */
    public UIProduktDaten(View view){
        super(view);
        produktDaten = new ArrayList<>();
        add = new UIButton();
        buttonPanel = new UIPanel();
        datenPanel = new UIPanel();

//TODO        UIProduktDatum test = new UIProduktDatum(view);
//TODO        UIProduktDatum test1 = new UIProduktDatum(view);

        buttonPanel.add(add, FlowLayout.LEFT);
        add.setSize(30,20);
        add.setText("Hinzufügen");
        datenPanel.setLayout(new GridLayout(2,1));
        //TODO       datenPanel.add(test);
        //TODO datenPanel.add(test1);
        this.setBounds(130,60, 80, 200);
        this.setBorder(BorderFactory.createTitledBorder("Produktdaten"));
        this.setLayout(new BorderLayout());
        this.add(datenPanel, BorderLayout.CENTER);
        this.add(buttonPanel, BorderLayout.PAGE_START);
        this.setVisible(true);
        // weitere Einstellungen
    }

    /**
     *Updaten der Produktfunktionen
     * 1. schauen ob eine bestehende Produktfunktion im Model gelöscht wurde, wenn ja auch in der GUI löschen
     * 2. alle bestehenden Produktfunktionen in der GUI aktualisieren
     * 3. alle neuen Produktfunktionen im Model, die nicht in der GUI sind, hinzufügen
     * @param model Instanz des Model des MVC-Patterns, das die Daten enthält
     */
    @Override
    public void update(IModel model){

    }
}
