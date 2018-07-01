package org.dhbw.stuttgart.ita16.reqmaster.view;

import org.dhbw.stuttgart.ita16.reqmaster.components.*;
import org.dhbw.stuttgart.ita16.reqmaster.controller.IObserverController;
import org.dhbw.stuttgart.ita16.reqmaster.events.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

/**
 * Die Klasse enthält alle Eingabefelder der Function-Ponit analyse, welche nicht zur Klasse UIFunktionenDaten oder UIGewichtsfaktoren gehören.
 */
public class UIControl extends UIPanel {

    //Variablen der Klasse
    private UIButton aufwandAnzeigen;
    private UIButton aufwandMMAnzeigen;
    private UIButton gewichtsfaktorOpt;
    private UILabel aufwandFP;
    private UILabel aufwandMM;
    private UITextField realerAufwand;

    public UIControl(IView view) {

		super(view);

		//Die Klassenvariablen Instanzieren
        aufwandAnzeigen=new UIButton();
        aufwandMMAnzeigen=new UIButton();
        gewichtsfaktorOpt=new UIButton();
        aufwandMM=new UILabel();
        aufwandFP= new UILabel();
        realerAufwand=new UITextField();

        this.add(aufwandAnzeigen);
        this.add(aufwandFP);
        this.add(aufwandMMAnzeigen);
        this.add(aufwandMM);
        this.add(gewichtsfaktorOpt);
        this.add(realerAufwand);

        aufwandAnzeigen.setText("Aufwand in FP anzeigen");
        aufwandMMAnzeigen.setText("Aufwand in MM Anzeigen");
        gewichtsfaktorOpt.setText("Optimieren");

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
                getView().getObsController().observe(new UIActionFPGewichtsfaktorenOptimierenEvent());
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

