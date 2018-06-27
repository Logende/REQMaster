package org.dhbw.stuttgart.ita16.reqmaster.view;

import org.dhbw.stuttgart.ita16.reqmaster.components.*;
import org.dhbw.stuttgart.ita16.reqmaster.events.UIActionMenuCreateEvent;
import org.dhbw.stuttgart.ita16.reqmaster.events.UIActionMenuLoadEvent;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

/**
 * Grafikkomponente: Anfangsdialog,
 * der den Benutzer auffordert,
 * ein Dokument zu importieren oder ein neues anzulegen
 */
public class UIAnfangsDialog extends UIFrame {

    /******Variablen der Klasse****/
    private UIButton docNeu;
    private UIButton docImport;
    private UIPanel buttonPanel;
    private UIMainFrame mainFrame;
    /******************************/

    /**
     * Konstruktor der Klasse
     * @param view Instanz der View des MVC-Patterns
     * @param mainFrame das Hauptfenster, das angezeigt wird, wenn einer der Buttons geklickt wird
     */
    public UIAnfangsDialog(IView view, UIMainFrame mainFrame){
        super(view);
        this.mainFrame = mainFrame;

        /**********Instanzierung******************/
        docNeu = new UIButton();
        docImport = new UIButton();
        buttonPanel = new UIPanel();
        /*****************************************/

        /*************Settings*********************/
        docNeu.setText("Neues Dokument");
        docNeu.setBounds(45,20,180,30);
        docImport.setText("Dokument importieren");
        docImport.setBounds(45,60, 180,30);

        buttonPanel.setBounds(10,10,250,160);
        buttonPanel.setLayout(null);
        buttonPanel.add(docNeu);
        buttonPanel.add(docImport);

        this.setTitle("Anfangsdialog");
        this.setLocationRelativeTo(null);
        this.setSize(300,160);
        this.setLayout(null);
        this.setResizable(false);
        this.requestFocus();
        this.setDefaultCloseOperation(UIFrame.EXIT_ON_CLOSE);
        this.add(buttonPanel);
        this.setVisible(true);
        /******************************************/


        /********ActionListener definieren für Buttons**********/
        docNeu.addActionListener(new ActionListener() {
            /**
             * wenn auf den Button geklickt wird, wird ein Speicherort und ein Name ausgewählt und
             * ein Event an den Controller geschickt,
             * um ein neues Dokument zu erstellen
             * @param e auf zu reagierendes Event
             */
            @Override
            public void actionPerformed(ActionEvent e) {

                File file;
                file = UIPathSelector.forcePathSelection("Neues Dokument anlegen", ".xml",true,
                        "C:\\Users\\%name%\\Documents", true);
                if(file != null){
                    view.getObsController().observe(new UIActionMenuCreateEvent(file));
                    mainFrame.setVisible(true);
                    dispose();
                }
            }
        });

        docImport.addActionListener(new ActionListener() {
            /**
             * wenn auf den Button geklickt wird, wird eine Datei ausgewählt,
             * die geöffnet werden soll und ein Event an den Controller geschickt
             * @param e auf zu reagierendes Event
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                File file;
                file = UIPathSelector.forcePathSelection("Dokument importieren", ".xml",true,
                        "C:\\Users\\%name%\\Documents", false);
                if(file !=null) {
                    getView().getObsController().observe(new UIActionMenuLoadEvent(file));
                    mainFrame.setVisible(true);
                    dispose();
                }
            }
        });
    }
}
