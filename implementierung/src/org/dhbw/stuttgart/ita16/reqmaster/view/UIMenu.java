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
                UIActionMenuSaveEvent safeEvent = new UIActionMenuSaveEvent();
                getView().getObsController().observe(safeEvent);
                //Anzeige der Information, dass Dokument gespeichert wurde
                JOptionPane.showMessageDialog(UIMenu.this, "Ihr Dokument wurde gespeichert",
                        "Speichern", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        functionPointAnz.addActionListener(new ActionListener() {
            /**
             * definiert, dass ein Event an den Controller gesendet wird,
             * wenn auf den Button geklickt wird, um zur Aufwandsabschätzung umzuschalten
             * @param e ActionEvent Event, auf das reagiert werden soll
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.toggleMode(functionPointAnz);
            }
        });
    }
}
