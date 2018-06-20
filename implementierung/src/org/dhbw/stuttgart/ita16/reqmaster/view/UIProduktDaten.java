package org.dhbw.stuttgart.ita16.reqmaster.view;

import org.dhbw.stuttgart.ita16.reqmaster.components.UIButton;
import org.dhbw.stuttgart.ita16.reqmaster.components.UILabel;
import org.dhbw.stuttgart.ita16.reqmaster.components.UIPanel;
import org.dhbw.stuttgart.ita16.reqmaster.model.IModel;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Grafikkomponente: Panel, das die Produktdaten enthaelt
 */
public class UIProduktDaten extends UIPanel implements UIUpdateable {

    UILabel title;
    List<UIProduktDatum> produktDaten;
    UIButton add;

    /**
     * Konstruktor der Klasse
     */
    public UIProduktDaten(View view){
        super(view);
        title = new UILabel();
        produktDaten = new ArrayList<>();
        add = new UIButton();
        this.setBounds(130,60, 80, 200);
        this.setBorder(BorderFactory.createTitledBorder("Produktdaten"));
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
