package org.dhbw.stuttgart.ita16.reqmaster.view;

import org.dhbw.stuttgart.ita16.reqmaster.components.UIButton;
import org.dhbw.stuttgart.ita16.reqmaster.components.UIMenuBar;
import org.dhbw.stuttgart.ita16.reqmaster.components.UIMenuItem;
import org.dhbw.stuttgart.ita16.reqmaster.events.UIActionMenuLoadEvent;
import org.dhbw.stuttgart.ita16.reqmaster.events.UIEvent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Grafikkomponente: enthält die Menüeinträge der GUI
 */
public class UIMenu extends UIMenuBar {

    //Menü-Einträge
    private UIMenuItem docNeu;
    private UIMenuItem docImport;
    private UIMenuItem docExportXml;
    private UIMenuItem fpNeu;

    /**
     * Konstruktor der Klasse
     */
    public UIMenu(View view) {
        super();

        // Instantiierung der Objekte
        docNeu = new UIMenuItem("Neues Dokument anlegen");
        docImport = new UIMenuItem("Dokument importieren");
        docExportXml = new UIMenuItem("Dokument in XML exportieren");
        fpNeu = new UIMenuItem("Neue Aufwandsabschätzung");

        // Hinzufügen der Menüeinträge
        this.add(docNeu);
        this.add(docImport);
        this.add(docExportXml);
        this.add(fpNeu);
        this.setBorder(BorderFactory.createEmptyBorder(10,0,10,0));



    }
}
