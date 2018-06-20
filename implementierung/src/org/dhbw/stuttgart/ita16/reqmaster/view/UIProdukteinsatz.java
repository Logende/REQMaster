package org.dhbw.stuttgart.ita16.reqmaster.view;

import org.dhbw.stuttgart.ita16.reqmaster.controller.IObserverController;
import org.dhbw.stuttgart.ita16.reqmaster.events.UIModifyProdukteinsatzEvent;
import org.dhbw.stuttgart.ita16.reqmaster.model.DataProdukteinsatz;
import org.dhbw.stuttgart.ita16.reqmaster.model.IModel;
import org.dhbw.stuttgart.ita16.reqmaster.components.UITextField;
import org.dhbw.stuttgart.ita16.reqmaster.components.UIPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

/**
 * Grafikkomponente: legt Aufbau des Produkteinsatzes fest
 */
public class UIProdukteinsatz extends UIPanel implements UIUpdateable {

	// Variablen der Klasse
	private UITextField text;
	private UIModifyProdukteinsatzEvent modifyEvent;

	/**
	 * Konstruktor der Klasse
	 * Initialisierd text als eie Instanz der Klasse UITextField
	 * Definiert die Eigenschaften des Textfeldes Text
	 */
    public UIProdukteinsatz(View view) {
		super(view);
		this.add(text = new UITextField());									//füge Text zum Panel hinzu
		this.setBorder(BorderFactory.createTitledBorder("Produkteinsatz"));	//setzte den Titel des Panels
		this.setVisible(true);													//mache das Panel sichtbar


		text.addFocusListener(new FocusListener() {
			/**
			 * legt fest, dass wenn das Textfeld den Fokus erhält, nichts passiert
			 * @param e
			 */
			@Override
			public void focusGained(FocusEvent e) { }

			/**
			 * legt fest, dass wenn das Textfeld den Fokus verliert, ein ModifyEvent an den Controller weitergereicht wird,
			 * der darüber entscheidet, ob der Inhalt valide ist, und somit der Fokus behalten oder freigegeben wird
			 * @param e
			 */
			public void focusLost(FocusEvent e) {
				getView().getObsController().observe(modifyEvent = new UIModifyProdukteinsatzEvent(new DataProdukteinsatz(text.getText())));//teile das Ereignis dem Controller mit
				if(!(modifyEvent.isSuccess())){
					text.requestFocus();
				}
			}
		});
	}

	/**
	 * updatet den Inhalt des Textfeldes
	 * @param model
	 */
	public void update(IModel model) {

		text.setText(model.getIDataAnforderungssammlung().getDataProdukteinsatz().getText());		//hole Daten aus dem Model und schreibe sie in das Textfeld
	}


}
