package org.dhbw.stuttgart.ita16.reqmaster.view;

import org.dhbw.stuttgart.ita16.reqmaster.components.UIButton;
import org.dhbw.stuttgart.ita16.reqmaster.components.UIMenuBar;
import org.dhbw.stuttgart.ita16.reqmaster.components.UIMenuItem;
import org.dhbw.stuttgart.ita16.reqmaster.components.UIPanel;

/**
 * Grafikkomponente: Anfangsdialog,
 * der den Benutzer auffordert,
 * ein Dokument zu importieren oder ein neues anzulegen
 */
public class UIAnfangsDialog extends UIPanel {

    private UIButton docNeu;
    private UIButton docImport;

    public UIAnfangsDialog(View view){
        super(view);

        docNeu = new UIButton();
        docImport = new UIButton();

        docNeu.setText("Neues Dokument anlegen");
        docImport.setText("Dokument importieren");
    }
}
