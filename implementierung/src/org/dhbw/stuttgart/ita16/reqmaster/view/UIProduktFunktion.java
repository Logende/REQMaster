package org.dhbw.stuttgart.ita16.reqmaster.view;

import org.dhbw.stuttgart.ita16.reqmaster.components.UIButton;
import org.dhbw.stuttgart.ita16.reqmaster.components.UIPanel;
import org.dhbw.stuttgart.ita16.reqmaster.components.UITextField;
import org.dhbw.stuttgart.ita16.reqmaster.model.IModel;

/**
 * Grafikkomponente: legt Aufbau einer Produktfunktion fest
 */
public class UIProduktFunktion extends UIPanel implements UIUpdateable{

    UITextField id;
    UIButton delete;
    UITextField name;
    UITextField quelle;
    UITextField akteur;
    UITextField beschreibung;
    UITextField verweise;


    /**
     * Konstruktor der Klasse
     */
    public UIProduktFunktion() {


    }


    /**
     *
     * @param model
     */
    @Override
    public void update(IModel model){

    }
}

