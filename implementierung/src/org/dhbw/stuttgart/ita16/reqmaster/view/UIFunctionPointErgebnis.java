package org.dhbw.stuttgart.ita16.reqmaster.view;

import org.dhbw.stuttgart.ita16.reqmaster.components.*;
import org.dhbw.stuttgart.ita16.reqmaster.controller.IObserverController;
import org.dhbw.stuttgart.ita16.reqmaster.events.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

/**
 * Die Klasse enthält alle Eingabefelder der Function-Ponit analyse, welche nicht zur Klasse UIFunktionenDaten oder UIGewichtsfaktoren gehören.
 */
public class UIFunctionPointErgebnis extends UIPanel {

    //Variablen der Klasse
    private UIButton aufwandAnzeigen;
    private UIButton aufwandMMAnzeigen;
    private UIButton gewichtsfaktorOpt;
    private UILabel aufwandFP;
    private UILabel aufwandMM;
    private UITextField realerAufwand;
    private int gridx, gridy, gridwidth, gridheight, fill, anchor, ipadx, ipady;
    private Insets insets;

    public UIFunctionPointErgebnis(IView view) {

		super(view);

		//Die Klassenvariablen instanzieren
        aufwandAnzeigen=new UIButton();
        aufwandMMAnzeigen=new UIButton();
        gewichtsfaktorOpt=new UIButton();
        aufwandMM=new UILabel();
        aufwandFP= new UILabel();
        realerAufwand=new UITextField();
        insets = new Insets(10,10,10,10);

        //Hinzufügen der Komponenten sowie Settings
        this.setLayout(new GridBagLayout());
        this.setBorder(BorderFactory.createTitledBorder("Ergebnis"));
        //Definieren des Layout wegen GridBagLayout
        addGB(aufwandAnzeigen,this, gridx = 1, gridy = 1, gridwidth = 1, gridheight = 1, fill = GridBagConstraints.HORIZONTAL, insets);
        addGB(aufwandFP,this, gridx = 2, gridy = 1, gridwidth = 1, gridheight = 1, insets);
        addGB(aufwandMMAnzeigen,this, gridx = 1, gridy = 2, gridwidth = 1, gridheight = 1, fill = GridBagConstraints.HORIZONTAL, insets);
        addGB(aufwandMM,this, gridx = 2, gridy = 2, gridwidth = 1, gridheight = 1, insets);
        addGB(gewichtsfaktorOpt,this,gridx = 1, gridy = 3, gridwidth = 1, gridheight = 1, fill = GridBagConstraints.HORIZONTAL, insets);
        addGB(realerAufwand,this, gridx = 2, gridy = 3, gridwidth = 1, gridheight = 1, fill = GridBagConstraints.BOTH, insets);

        aufwandAnzeigen.setText("Aufwand in FP anzeigen");
        aufwandMMAnzeigen.setText("Aufwand in MM Anzeigen");
        gewichtsfaktorOpt.setText("Optimieren");
        realerAufwand.setPreferredSize(new Dimension(100,20));
        realerAufwand.setMinimumSize(new Dimension(50,20));

        aufwandAnzeigen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getView().getObsController().observe(new UIActionFPAufwandAnzeigenEvent());
            }
        });

        aufwandAnzeigen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getView().getObsController().observe(new UIActionFPAufwandAnzeigenMannmonateEvent());
            }
        });

        gewichtsfaktorOpt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //getView().getObsController().observe(new UIActionFPGewichtsfaktorenOptimierenEvent());
            }
        });

        realerAufwand.addActionListener(new ActionListener() {
            /**
             * legt fest, dass wenn ein Action Event (Enter drücken) ausgelöst wird während der Fokus auf dem textfeld liegt,
             * dies an den Controller weitergegeben wird und der fokus auf des Textfeld verschwindet
             * @param e
             */
            @Override
            public void actionPerformed(ActionEvent e){
                realerAufwand.setFocusable(false);														//entziehe den Fokus
                getView().getObsController().observe(new UIModifyRealerAufwand(Double.parseDouble(realerAufwand.getText())));	//teile das Ereignis dem Controller mit
                realerAufwand.setFocusable(true);														// gebe die Möglichkeit zum Fokussieren zurück.
            }});

        realerAufwand.addFocusListener(new FocusListener() {
            /**
             * legt fest, dass wenn ein der Focus auf das Textfeld gelegt wird (Mousklick), nichts passieren soll
             *
             * @param e
             */
            @Override
            public void focusGained(FocusEvent e) {
            }

            /**
             * legt fest, dass wenn ein der Focus auf das Textfeld gelegt wird (Mousklick in ein anderes Feld),
             * dies an den Controller weitergegeben wird und der fokus auf des Textfeld verschwindet
             *
             * @param e
             */
            public void focusLost(FocusEvent e) {
                getView().getObsController().observe(new UIModifyRealerAufwand(Double.parseDouble(realerAufwand.getText())));//teile das Ereignis dem Controller mit
            }
        });

    }
}

