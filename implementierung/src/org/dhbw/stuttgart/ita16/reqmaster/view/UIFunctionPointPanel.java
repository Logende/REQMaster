package org.dhbw.stuttgart.ita16.reqmaster.view;

import java.awt.*;

import org.dhbw.stuttgart.ita16.reqmaster.components.*;
import org.dhbw.stuttgart.ita16.reqmaster.model.IModel;

/**
 * Grafikkomponenten: ein Panel, das alle Grafikkomponenten fuer
 * die Aufwandsschätzung beinhaltet
 */
public class UIFunctionPointPanel extends UIPanel {

    private UIFunctionPointEinstufungen einstufungen;
    private UIFunctionPointErgebnis fpErgebnis;
    private UIGewichtsfaktoren gewichtsfaktoren;

    public UIFunctionPointPanel(IView view) {
        super(view);
        setLayout(new GridLayout(2,2));
        this.add(einstufungen = new UIFunctionPointEinstufungen(view));
        this.add(gewichtsfaktoren = new UIGewichtsfaktoren(view));
        fpErgebnis = new UIFunctionPointErgebnis(view);
        this.add(fpErgebnis);

        this.setVisible(true);

    }

    /**
     * Aktualisiert alle dazugehörigen UI Komponenten mit den neuen Daten des Models.
     * @param model
     */
    public void update(IModel model){
        einstufungen.update(model);
        //TODO: Update values
    }
}
