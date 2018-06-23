package org.dhbw.stuttgart.ita16.reqmaster.view;

import org.dhbw.stuttgart.ita16.reqmaster.components.UIPanel;
import org.dhbw.stuttgart.ita16.reqmaster.components.UITextArea;
import org.dhbw.stuttgart.ita16.reqmaster.controller.IObserverController;
import org.dhbw.stuttgart.ita16.reqmaster.events.UIModifyProdukteinsatzEvent;
import org.dhbw.stuttgart.ita16.reqmaster.events.UIModifyZielbestimmungEvent;
import org.dhbw.stuttgart.ita16.reqmaster.model.DataProdukteinsatz;
import org.dhbw.stuttgart.ita16.reqmaster.model.DataZielbestimmung;
import org.dhbw.stuttgart.ita16.reqmaster.model.IModel;
import org.dhbw.stuttgart.ita16.reqmaster.components.UITextField;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

/**
 * Grafikkomponente: legt Aufbau einer Zielbestimmung fest
 */
public class UIZielbestimmung extends UIPanel implements UIUpdateable {

	//Variablen der Klasse
	private UITextArea text;
	private UIModifyZielbestimmungEvent modifyEvent;

	/**
	 * Konstruktor der Klasse
	 * Initialisiert text als eie Instanz der Klasse UITextField
	 * Definiert die Eigenschaften des Textfeldes Text
	 */
	public UIZielbestimmung(IView view) {


		super(view);

		text = new UITextArea();
		text.setPreferredSize(new Dimension(350,200));
		text.setLineWrap(true);
		this.add(text, BorderLayout.CENTER);							//füge Text zum Panel hinzu
		this.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder("Zielbestimmung"), BorderFactory.createEmptyBorder(30,0,0,0)));
		this.setVisible(true);




		text.addFocusListener(new FocusListener() {

			/**
			 * legt fest, dass wenn der Fokus auf das Textfeld gelegt wird (Mausklick), nichts passieren soll
			 * @param e
			 */
			@Override
			public void focusGained(FocusEvent e) { }

			/**
			 * legt fest, dass wenn das Textfeld den Fokus verliert, ein ModifyEvent an den Controller
			 * weitergereicht wird, der über das Behalten oder die Freigabe des Fokus entscheidet (validieren des Textfeldinhalts)
			 * @param e
			 */
			public void focusLost(FocusEvent e) {
				getView().getObsController().observe(modifyEvent = new UIModifyZielbestimmungEvent(new DataZielbestimmung(text.getText())));//teile das Ereignis dem Controller mit
				if(!(modifyEvent.isSuccess()))
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
