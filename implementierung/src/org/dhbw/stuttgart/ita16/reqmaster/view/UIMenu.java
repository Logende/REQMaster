package org.dhbw.stuttgart.ita16.reqmaster.view;

import org.dhbw.stuttgart.ita16.reqmaster.components.UIButton;
import org.dhbw.stuttgart.ita16.reqmaster.components.UIMenuBar;
import org.dhbw.stuttgart.ita16.reqmaster.components.UIMenuItem;
import org.dhbw.stuttgart.ita16.reqmaster.events.UIActionMenuLoadEvent;
import org.dhbw.stuttgart.ita16.reqmaster.events.UIActionMenuSaveEvent;
import org.dhbw.stuttgart.ita16.reqmaster.events.UIEvent;
import org.dhbw.stuttgart.ita16.reqmaster.model.IModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Grafikkomponente: enthält die Menüeinträge der GUI
 */
public class UIMenu extends UIMenuBar {

    private IView view;

    //Menü-Einträge
    private UIMenuItem docExportXml;
    private UIMenuItem fpNeu;

    /**
     * Konstruktor der Klasse
     */
    public UIMenu(IView view) {
        super(view);
        this.view = view;

        // Instantiierung der Objekte
        docExportXml = new UIMenuItem("Dokument in XML exportieren");
        docExportXml.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.getModel().saveAnforderungssammlung();
            }
        });
        fpNeu = new UIMenuItem("Aufwandsabschätzung");

        // Hinzufügen der Menüeinträge
        this.add(docExportXml);
        this.add(fpNeu);
        this.setBorder(BorderFactory.createEmptyBorder(10,0,10,0));

        docExportXml.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UIActionMenuSaveEvent safeEvent = new UIActionMenuSaveEvent();
                getView().getObsController().observe(safeEvent);
              //TODO success fehlt  if(safeEvent.isSuccess){
                    // TODO Fenster mit Speicherortauswahl
                }
            //}
        });

        fpNeu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
             //TODO welches Event   getView().getObsController().observe(new UI);
            }
        });

    }
}
