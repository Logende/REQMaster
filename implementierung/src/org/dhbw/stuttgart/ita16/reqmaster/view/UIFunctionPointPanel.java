package org.dhbw.stuttgart.ita16.reqmaster.view;

import java.awt.*;
import java.io.*;
import java.util.*;
import org.dhbw.stuttgart.ita16.reqmaster.components.*;
import org.dhbw.stuttgart.ita16.reqmaster.model.IModel;

/**
 * Grafikkomponenten: ein Panel, das wiederum alle Grafikkomponenten fuer
 * die Aufwandsschätzung beinhaltet
 */
public class UIFunctionPointPanel extends UIPanel {

    private UIFunctionPointEinstufungen einstufungen;
    private UIGewichtsfaktoren gewichtsfaktoren;
    private UIControl control;


    public UIFunctionPointPanel(IView view) {
        super(view);
        setLayout(new GridLayout(2,2));
        this.add(einstufungen = new UIFunctionPointEinstufungen(view));
        //gewichtsfaktoren = new UIGewichtsfaktoren(view);
        control = new UIControl(view);
        this.add(control);

        this.setVisible(true);

    }

    public void update(IModel model){
        einstufungen.update(model);
        //TODO: Update values
    }
}
