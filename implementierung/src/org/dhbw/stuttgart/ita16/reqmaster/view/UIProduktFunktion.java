package org.dhbw.stuttgart.ita16.reqmaster.view;

import org.dhbw.stuttgart.ita16.reqmaster.components.UIButton;
import org.dhbw.stuttgart.ita16.reqmaster.components.UIPanel;
import org.dhbw.stuttgart.ita16.reqmaster.components.UITextField;
import org.dhbw.stuttgart.ita16.reqmaster.model.IModel;

/**
 * Grafikkomponente: legt Aufbau einer Produktfunktion fest
 */
public class UIProduktFunktion extends UIPanel implements UIUpdateable{

    UIButton delete;
    UITextField id;
    UITextField name;
    UITextField quelle;
    UITextField akteur;
    UITextField beschreibung;
    UITextField verweise;


    /**
     * Konstruktor der Klasse
     */
    public UIProduktFunktion(View view) {

        super(view);

        delete = new UIButton();
        id = new UITextField();
        name = new UITextField();
        quelle = new UITextField();
        akteur = new UITextField();
        beschreibung = new UITextField();
        verweise = new UITextField();
    }


    /**
     *
     * @param model
     */
    @Override
    public void update(IModel model){


    }
}

