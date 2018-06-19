package org.dhbw.stuttgart.ita16.reqmaster.view;

import org.dhbw.stuttgart.ita16.reqmaster.components.UIPanel;
import org.dhbw.stuttgart.ita16.reqmaster.controller.IObserverController;
import org.dhbw.stuttgart.ita16.reqmaster.events.UIModifyProdukteinsatzEvent;
import org.dhbw.stuttgart.ita16.reqmaster.events.UIModifyZielbestimmungEvent;
import org.dhbw.stuttgart.ita16.reqmaster.model.DataProdukteinsatz;
import org.dhbw.stuttgart.ita16.reqmaster.model.DataZielbestimmung;
import org.dhbw.stuttgart.ita16.reqmaster.model.IModel;
import org.dhbw.stuttgart.ita16.reqmaster.components.UITextField;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

/**
 * Grafikkomponente: legt Aufbau einer Zielbestimmung fest
 */
public class UIZielbestimmung extends UIPanel implements UIUpdateable {

	//Variablen der Klasse
	private UITextField text;
	private UIModifyZielbestimmungEvent modifyEvent;

	/**
	 * Konstruktor der Klasse
	 * Initialisiert text als eie Instanz der Klasse UITextField
	 * Definiert die Eigenschaften des Textfeldes Text
	 */
	public UIZielbestimmung(View view) {


		super(view);

		this.add(text=new UITextField());										//füge Text zum Panel hinzu
		this.setBorder(BorderFactory.createTitledBorder("Zielbestimmung"));		//setze den Titel des Panels
		this.setVisible(true);													//mache das Panel sichtbar

		text.addFocusListener(new FocusListener() {
			/**
			 * legt fest, dass wenn ein der Focus auf das Textfeld gelegt wird (Mousklick), nichts passieren soll
			 * @param e
			 */
			@Override
			public void focusGained(FocusEvent e) {
			}
			/**
			 * legt fest, dass wenn ein der Focus auf das Textfeld gelegt wird (Mousklick in ein anderes Feld),
			 * dies an den Controller weitergegeben wird und der fokus auf des Textfeld verschwindet
			 * @param e
			 */
			public void focusLost(FocusEvent e) {
				getView().getObsController().observe(new UIModifyZielbestimmungEvent(new DataZielbestimmung(text.getText())));//teile das Ereignis dem Controller mit

				text.requestFocus(); // Abfrage, ob successfull
			}
		});
	}
	/**
	 * updatet den Inhalt des Textfeldes
	 * @param model
	 */
	public void update(IModel model) {

		text.setText(model.getIDataAnforderungssammlung().getDataZielbestimmung().getText());

	}

}
