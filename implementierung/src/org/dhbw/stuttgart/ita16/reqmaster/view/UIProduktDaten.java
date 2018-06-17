package org.dhbw.stuttgart.ita16.reqmaster.view;

import org.dhbw.stuttgart.ita16.reqmaster.components.UIButton;
import org.dhbw.stuttgart.ita16.reqmaster.components.UILabel;
import org.dhbw.stuttgart.ita16.reqmaster.components.UIPanel;
import org.dhbw.stuttgart.ita16.reqmaster.model.IModel;

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
    public UIProduktDaten(){
        title = new UILabel();
        produktDaten = new ArrayList<>();
        add = new UIButton();
        this.setBounds(130,60, 80, 200);
        // weitere Einstellungen
    }

    /**
     *
     * @param model
     */
    @Override
    public void update(IModel model){

    }
}
