package org.dhbw.stuttgart.ita16.reqmaster.view;

import org.dhbw.stuttgart.ita16.reqmaster.components.UIMenuBar;
import org.dhbw.stuttgart.ita16.reqmaster.components.UIMenuItem;
import org.dhbw.stuttgart.ita16.reqmaster.events.UIActionMenuSaveEvent;

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
        docExportXml.addActionListener(new ActionListener() {
            /**
             * definiert, dass ein Event an den Controller gesendet wird,
             * wenn auf den Button geklickt wird, um das Dokument zu exportieren
             * @param e ActionEvent Event, auf das reagiert werden soll
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                if (View.forcesFocus == null) {
                    UIActionMenuSaveEvent safeEvent = new UIActionMenuSaveEvent();
                    getView().getObsController().observe(safeEvent);
                    //Anzeige der Information, dass Dokument gespeichert wurde
                    JOptionPane.showMessageDialog(UIMenu.this, "Ihr Dokument wurde gespeichert",
                            "Speichern", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

        functionPointAnz.addActionListener(new ActionListener() {
            /**
             * wenn auf den Button geklickt wird, wird zur Aufwandsabschätzung umgeschalten
             * @param e ActionEvent Event, auf das reagiert werden soll
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                if (View.forcesFocus == null) {
                    mainFrame.toggleMode(functionPointAnz);
                }
            }
        });
    }
}
