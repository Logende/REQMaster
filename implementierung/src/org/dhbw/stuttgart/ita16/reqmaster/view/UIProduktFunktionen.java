package org.dhbw.stuttgart.ita16.reqmaster.view;

import org.dhbw.stuttgart.ita16.reqmaster.components.UIButton;
import org.dhbw.stuttgart.ita16.reqmaster.components.UILabel;
import org.dhbw.stuttgart.ita16.reqmaster.components.UIPanel;
import org.dhbw.stuttgart.ita16.reqmaster.model.IModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Grafikkomponente: Panel, das die Produktfunktionen beinhaltet
 */

public class UIProduktFunktionen extends UIPanel implements UIUpdateable{

    UILabel title;
    List<UIProduktFunktion> produktFunktionen;
    UIButton add;

    /**
     * Konstruktor der Klasse
     */

    public UIProduktFunktionen(){
        super();
        title = new UILabel();
        produktFunktionen = new ArrayList<>();
        add = new UIButton();
        this.setBounds(10,60,80,200);
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
