package org.dhbw.stuttgart.ita16.reqmaster.view;

import org.dhbw.stuttgart.ita16.reqmaster.components.UIScrollPane;
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

	//Variablen der Klasse
	private UITextArea text;
	private UIScrollPane scrollPane;

	/**
	 * Konstruktor der Klasse
	 * @param view Instanz der View des MVC-Patterns
	 */
	public UIProdukteinsatz(View view) {

    	super(view);
    	//Initialisierung
		text = new UITextArea();
		scrollPane = new UIScrollPane(text, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);

		//Settings
		text.setLineWrap(true);
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.add(scrollPane);
		this.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder("Produkteinsatz"), BorderFactory.createEmptyBorder(30,10,20,10)));
		this.setVisible(true);

		//Fokuslistener für TextArea
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
				getView().getObsController().observe(modifyEvent =
						new UIModifyProdukteinsatzEvent(new DataProdukteinsatz(text.getText())));
				if(!(modifyEvent.isSuccess())){
					View.forcesFocus = UIProdukteinsatz.this;
					text.requestFocus();	//Abfrage, ob Änderung valide ist, ansonsten Fokus auf TextArea behalten
				}else{
					View.forcesFocus = null;
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
