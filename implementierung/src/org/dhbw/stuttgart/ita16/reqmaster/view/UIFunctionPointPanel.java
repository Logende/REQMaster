package org.dhbw.stuttgart.ita16.reqmaster.view;

import java.io.*;
import java.util.*;
import org.dhbw.stuttgart.ita16.reqmaster.components.*;

/**
 * Grafikkomponenten: ein Panel, das wiederum alle Grafikkomponenten fuer
 * die Aufwandsschätzung beinhaltet
 */
public class UIFunctionPointPanel extends UIPanel {

    private UIFunktionenDaten funktionenDaten;
    private UIGewichtsfaktoren gewichtsfaktoren;
    private UIControl control;


    public UIFunctionPointPanel(View view) {

        super(view);
        funktionenDaten = new UIFunktionenDaten(view);
        gewichtsfaktoren = new UIGewichtsfaktoren(view);
        control = new UIControl(view);

    }
}
