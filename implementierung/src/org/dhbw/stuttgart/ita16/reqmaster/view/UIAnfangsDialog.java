package org.dhbw.stuttgart.ita16.reqmaster.view;

import org.dhbw.stuttgart.ita16.reqmaster.components.*;
import org.dhbw.stuttgart.ita16.reqmaster.events.UIActionMenuLoadEvent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Grafikkomponente: Anfangsdialog,
 * der den Benutzer auffordert,
 * ein Dokument zu importieren oder ein neues anzulegen
 */
public class UIAnfangsDialog extends UIFrame {

    private UIButton docNeu;
    private UIButton docImport;
    private UIPanel buttonPanel;
    private UIMainFrame mainFrame;

    /**
     * Konstruktor der Klasse
     * @param view Instanz der View des MVC-Patterns
     * @param mainFrame das Hauptfenster, das angezeigt wird, wenn einer der Buttons geklickt wird
     */
    public UIAnfangsDialog(IView view, UIMainFrame mainFrame){
        super(view);
        this.mainFrame = mainFrame;
        docNeu = new UIButton();
        docImport = new UIButton();
        buttonPanel = new UIPanel();
        docNeu.setText("Neues Dokument anlegen");
        docImport.setText("Dokument importieren");

        buttonPanel.setSize(80,80);
        buttonPanel.add(docNeu);
        buttonPanel.add(docImport);
        this.setTitle("Anfangsdialog");
        this.setBounds(550,250,300,200);
        this.requestFocus();
        this.setDefaultCloseOperation(UIFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        this.add(buttonPanel, BorderLayout.CENTER);
        this.setVisible(true);

        docNeu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
             //   getView().getObsController().observe(new);
                mainFrame.setVisible(true);
                dispose();
            }
        });

        docImport.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
             //TODO File übergeben   getView().getObsController().observe(new UIActionMenuLoadEvent());
                //TODO successfull auslesen falls vorhanden
                mainFrame.setVisible(true);
                dispose();
            }
        });
    }
}
