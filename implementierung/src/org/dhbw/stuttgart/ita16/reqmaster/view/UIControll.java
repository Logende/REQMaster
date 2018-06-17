package org.dhbw.stuttgart.ita16.reqmaster.view;

import org.dhbw.stuttgart.ita16.reqmaster.components.*;
import org.dhbw.stuttgart.ita16.reqmaster.controller.IObserverController;
import org.dhbw.stuttgart.ita16.reqmaster.events.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

/**
 * Die Klasse enthält alle Eingabefelder der Function-Ponit analyse, welche nicht zur Klasse UIFunktionenDaten oder UIGewichtsfaktoren gehören.
 */
public class UIControll extends UIPanel {

    private UIButton Aufwandanzeigen;
    private UIButton AufwandMManzeigen;
    private UIButton GewichtsfaktorOptimieren;
    private UITextField AufwandMM;
    private UITextField AufwandFP;
    private UITextField RealerAufwand;

	public UIControll() {

	    //Superklasse Konstruktor aufrufen
		super();

		//Die Klassenvariablen Instanziieren

        Aufwandanzeigen=new UIButton();
        Aufwandanzeigen.setText("Aufwand in FP anzeigen");
        this.add(Aufwandanzeigen);
        Aufwandanzeigen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                IObserverView.observe(new UIActionFPAufwandAnzeigenEvent());
            }
        });
        AufwandMManzeigen=new UIButton();
        AufwandMManzeigen.setText("Aufwand in MM Anzeigen");
        this.add(AufwandMManzeigen);
        Aufwandanzeigen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                IObserverView.observe(new UIActionFPMMAufwandFPEvent());
            }
        });
        GewichtsfaktorOptimieren=new UIButton();
        AufwandMM=new UITextField();
        AufwandMM.setEnabled(false);
        this.add(GewichtsfaktorOptimieren);
        GewichtsfaktorOptimieren.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                IObserverView.observe(new UIActionFPGewichtsfaktorenOptimierenEvent());
            }
        });
        AufwandFP= new UITextField();

        AufwandFP.setEnabled(false);
        this.add(AufwandFP);
        RealerAufwand=new UITextField();
        this.add(RealerAufwand);
        RealerAufwand.addActionListener(new ActionListener() {
            /**
             * legt fest, dass wenn ein Action Event (Enter drücken) ausgelöst wird während der Fokus auf dem textfeld liegt,
             * dies an den Controller weitergegeben wird und der fokus auf des Textfeld verschwindet
             * @param e
             */
            @Override
            public void actionPerformed(ActionEvent e){
                RealerAufwand.setFocusable(false);														//entziehe den Fokus
                IObserverController.observe(new UIModifyRealerAufwand(RealerAufwand.getText()));	//teile das Ereignis dem Controller mit
                RealerAufwand.setFocusable(true);														// gebe die Möglichkeit zum Fokussieren zurück.
            }});

        RealerAufwand.addFocusListener(new FocusListener() {
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
                IObserverController.observe(new UIModifyRealerAufwand(RealerAufwand.getText()));//teile das Ereignis dem Controller mit
            }
        });



    }
    }

