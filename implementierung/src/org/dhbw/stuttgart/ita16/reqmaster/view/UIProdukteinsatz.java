package org.dhbw.stuttgart.ita16.reqmaster.view;

import org.dhbw.stuttgart.ita16.reqmaster.controller.IObserverController;
import org.dhbw.stuttgart.ita16.reqmaster.events.UIModifyProdukteinsatzEvent;
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

	private UITextField text;

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
		text.addActionListener(new ActionListener() {
			/**
			 * legt fest, dass wenn ein Action Event (Enter drücken) ausgelöst wird während der Fokus auf dem textfeld liegt,
			 * dies an den Controller weitergegeben wird und der fokus auf des Textfeld verschwindet
			 * @param e
			 */
			@Override
			public void actionPerformed(ActionEvent e) {
				text.setFocusable(false);															//entziehe den Fokus
				getObsControllerFromPanel().observe(new UIModifyProdukteinsatzEvent(text.getText()));		//teile das Ereignis dem Controller mit
				text.setFocusable(true);															// gebe die Möglichkeit zum Fokussieren zurück.
			}
		});

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
				getObsControllerFromPanel().observe(new UIModifyProdukteinsatzEvent(text.getText()));
				//teile das Ereignis dem Controller mit
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
