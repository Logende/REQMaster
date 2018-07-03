package org.dhbw.stuttgart.ita16.reqmaster.view;

import org.dhbw.stuttgart.ita16.reqmaster.components.ActionListenerCustom;
import org.dhbw.stuttgart.ita16.reqmaster.components.ActionListenerEventTriggering;
import org.dhbw.stuttgart.ita16.reqmaster.components.UIMenuBar;
import org.dhbw.stuttgart.ita16.reqmaster.components.UIMenuItem;
import org.dhbw.stuttgart.ita16.reqmaster.events.UIActionMenuSaveEvent;
import org.dhbw.stuttgart.ita16.reqmaster.events.UIEvent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Grafikkomponente: enthält die Menüeinträge der GUI, die im Hauptfenster angezeigt werden
 */
public class UIMenu extends UIMenuBar {

    //Variablen der Klasse
    private IView view;
    private UIMenuItem docExportXml;
    private UIMenuItem functionPointAnz;
    private UIMainFrame mainFrame;

    /**
     * Konstruktor der Klasse
     * @param view Instanz der View des MVC-Patterns
     * @param mainFrame Instanz des Hauptfensters, um zwischen Anforderungssammlung und FP-Analyse umzuschalten
     */
    public UIMenu(IView view, UIMainFrame mainFrame) {
        super(view);
        this.view = view;
        this.mainFrame = mainFrame;

        //Instanzierung
        docExportXml = new UIMenuItem("Dokument in XML exportieren");
        functionPointAnz = new UIMenuItem("Aufwandsabschätzung");

        //Settings
        this.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        this.setLayout(new FlowLayout());
        this.add(docExportXml, FlowLayout.LEFT);
        this.add(functionPointAnz, FlowLayout.LEFT);

        //ActionListener definieren
        docExportXml.addActionListener(new ActionListenerEventTriggering(view) {
            @Override
            public UIEvent generateEvent(Object source) {
                return new UIActionMenuSaveEvent();
            }
            @Override
            public void finishedAction(){
                JOptionPane.showMessageDialog(UIMenu.this, "Ihr Dokument wurde gespeichert",
                        "Speichern", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        functionPointAnz.addActionListener(new ActionListenerCustom() {
            @Override
            public void executeAction(ActionEvent e) {
                mainFrame.toggleMode(functionPointAnz);
            }
        });
    }
}
