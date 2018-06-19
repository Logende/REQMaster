package org.dhbw.stuttgart.ita16.reqmaster.view;

import org.dhbw.stuttgart.ita16.reqmaster.components.UIButton;
import org.dhbw.stuttgart.ita16.reqmaster.components.UILabel;
import org.dhbw.stuttgart.ita16.reqmaster.components.UIPanel;
import org.dhbw.stuttgart.ita16.reqmaster.model.IModel;

import javax.swing.*;
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

    public UIProduktFunktionen(View view){
        super(view);
        title = new UILabel();
        produktFunktionen = new ArrayList<>();
        add = new UIButton();

        this.setBounds(10,60,80,200);
        this.setBorder(BorderFactory.createTitledBorder("Produktfunktionen"));
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
