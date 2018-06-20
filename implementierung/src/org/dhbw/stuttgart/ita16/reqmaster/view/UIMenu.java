package org.dhbw.stuttgart.ita16.reqmaster.view;

import org.dhbw.stuttgart.ita16.reqmaster.components.UIButton;
import org.dhbw.stuttgart.ita16.reqmaster.components.UIPanel;
import org.dhbw.stuttgart.ita16.reqmaster.components.UIToolBar;

/**
 * Grafikkomponente: enthält die Menüeinträge der GUI
 */
public class UIMenu extends UIToolbar {

    //Variablen der Klasse
    private UIToolBar toolBar;          //Toolbar

    private UIButton neuesDoc;          // Buttons für Menüeinträge
    private UIButton docImport;
    private UIButton docExportXml;
    private UIButton docExportPdf;
    private UIButton neueFp;

    /**
     * Konstruktor der Klasse
     */
    public UIMenu() {
        super();

        // Instantiierung der Objekte
        toolBar = new UIToolBar();
        neuesDoc = new UIButton();
        docImport = new UIButton();
        docExportXml = new UIButton();
        docExportPdf = new UIButton();
        neueFp = new UIButton();

        // Hinzufügen der Menübuttons
        toolBar.add(neuesDoc);
        neuesDoc = new

    }
}
