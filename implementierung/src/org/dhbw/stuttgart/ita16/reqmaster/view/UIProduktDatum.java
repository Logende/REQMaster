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

        this.add(delete = new UIButton());
        this.add(id = new UITextField());
        this.add(name = new UITextField());
        this.add(attribute = new UITextField());
        this.add(verweise = new UITextField());

        delete.setText("Löschen");
        delete.setBounds(10,10,90,20);
        name.setText("Name");
        name.setBounds(10,35,150,20);
        id.setText("ID");
        id.setBounds(10,60,150,20);
        attribute.setText("Attribute");
        attribute.setBounds(10,85,150,20);
        verweise.setText("Verweise");
        verweise.setBounds(10,110,150,20);

        this.setVisible(true);
    }


    /**
     *
     * @param model
     */
    @Override
    public void update(IModel model){

    }
}
