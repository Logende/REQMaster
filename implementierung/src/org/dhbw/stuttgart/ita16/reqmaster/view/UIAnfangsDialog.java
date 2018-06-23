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

    public UIAnfangsDialog(IView view){
        super(view);

        docNeu = new UIButton();
        docImport = new UIButton();
        buttonPanel = new UIPanel();

        docNeu.setText("Neues Dokument anlegen");
        docImport.setText("Dokument importieren");


        this.setTitle("Anfangsdialog");
        this.setBounds(250,250,300,100);
        this.requestFocus();
        this.setDefaultCloseOperation(UIFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        buttonPanel.setSize(80,80);
        buttonPanel.add(docNeu);
        buttonPanel.add(docImport);
        this.add(buttonPanel, BorderLayout.CENTER);
        this.setVisible(true);

        docNeu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               //TODO Event getView().getObsController().observe();
            }
        });

        docImport.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getView().getObsController().observe(new UIActionMenuLoadEvent());
                //TODO successfull auslesen falls vorhanden
            }
        });
    }
}
