package org.dhbw.stuttgart.ita16.reqmaster.view;

import org.dhbw.stuttgart.ita16.reqmaster.components.UIButton;
import org.dhbw.stuttgart.ita16.reqmaster.components.UIPanel;
import org.dhbw.stuttgart.ita16.reqmaster.components.UITextField;
import org.dhbw.stuttgart.ita16.reqmaster.model.IModel;

/**
 *
 */
public class UIProduktDatum extends UIPanel implements UIUpdateable {


    UIButton delete;
    UITextField name;
    UITextField id;
    UITextField attribute;
    UITextField verweise;


    /**
     * Konstruktor der Klasse
     */
    public UIProduktDatum (View view) {

        super(view);
    }


    /**
     *
     * @param model
     */
    @Override
    public void update(IModel model){

    }
}
