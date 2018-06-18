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

    private UIButton aufwandAnzeigen;
    private UIButton aufwandMMAnzeigen;
    private UIButton gewichtsfaktorOptimieren;
    private UITextField aufwandMM;
    private UITextField realerAufwand;
    private UITextField aufwandFP;
	public UIControll(View view) {

	    //Superklasse Konstruktor aufrufen
		super(view);

		//Die Klassenvariablen Instanziieren

        aufwandAnzeigen=new UIButton();
        aufwandAnzeigen.setText("Aufwand in FP anzeigen");
        this.add(aufwandAnzeigen);
        aufwandAnzeigen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getView().getObsController().observe(new UIActionFPAufwandAnzeigenEvent());
            }
        });
        aufwandMMAnzeigen=new UIButton();
        aufwandMMAnzeigen.setText("Aufwand in MM Anzeigen");
        this.add(aufwandMMAnzeigen);
        aufwandAnzeigen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getView().getObsController().observe(new UIActionFPAufwandAnzeigenMannmonateEvent());
            }
        });
        gewichtsfaktorOptimieren=new UIButton();
        aufwandMM=new UITextField();
        aufwandMM.setEnabled(false);
        this.add(gewichtsfaktorOptimieren);
        gewichtsfaktorOptimieren.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getView().getObsController().observe(new UIActionFPGewichtsfaktorenOptimierenEvent());
            }
        });
        aufwandFP= new UITextField();

        aufwandFP.setEnabled(false);
        this.add(aufwandFP);
        realerAufwand=new UITextField();
        this.add(realerAufwand);
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

