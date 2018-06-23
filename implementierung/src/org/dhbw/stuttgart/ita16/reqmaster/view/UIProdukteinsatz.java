package org.dhbw.stuttgart.ita16.reqmaster.view;

import org.dhbw.stuttgart.ita16.reqmaster.components.UITextArea;
import org.dhbw.stuttgart.ita16.reqmaster.events.UIModifyProdukteinsatzEvent;
import org.dhbw.stuttgart.ita16.reqmaster.model.DataProdukteinsatz;
import org.dhbw.stuttgart.ita16.reqmaster.model.IModel;
import org.dhbw.stuttgart.ita16.reqmaster.components.UIPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

/**
 * Grafikkomponente: legt Aufbau des Produkteinsatzes fest
 */
public class UIProdukteinsatz extends UIPanel implements UIUpdateable {

	// Variablen der Klasse
	private UITextArea text;

	/**
	 * Konstruktor der Klasse
	 * Initialisierd text als eie Instanz der Klasse UITextField
	 * Definiert die Eigenschaften des Textfeldes Text
	 */
	public UIProdukteinsatz(View view) {

    	super(view);

		text = new UITextArea();
		text.setPreferredSize(new Dimension(350,200));
		text.setLineWrap(true);
		this.add(text, BorderLayout.CENTER);
		this.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder("Produkteinsatz"), BorderFactory.createEmptyBorder(30,0,0,0)));
		this.setVisible(true);


		text.addFocusListener(new FocusListener() {
			/**
			 * legt fest, dass wenn das Textfeld den Fokus erhält, nichts passiert
			 * @param e FocusEvent
			 */
			@Override
			public void focusGained(FocusEvent e) { }

			/**
			 * legt fest, dass wenn das Textfeld den Fokus verliert, ein ModifyEvent an den Controller weitergereicht wird,
			 * der darüber entscheidet, ob der Inhalt valide ist, und somit der Fokus behalten oder freigegeben wird
			 * @param e FocusEvent
			 */
			public void focusLost(FocusEvent e) {
				UIModifyProdukteinsatzEvent modifyEvent;
				getView().getObsController().observe(modifyEvent = new UIModifyProdukteinsatzEvent(new DataProdukteinsatz(text.getText())));//teile das Ereignis dem Controller mit
				if(!(modifyEvent.isSuccess())){
					text.requestFocus();
				}
			}
		});
	}

	/**
	 * updatet den Inhalt des Textfeldes
	 * @param model Istanz des Model des MVC-Patterns
	 */
	public void update(IModel model) {

		text.setText(model.getIDataAnforderungssammlung().getDataProdukteinsatz().getText());		//hole Daten aus dem Model und schreibe sie in das Textfeld
	}


}
