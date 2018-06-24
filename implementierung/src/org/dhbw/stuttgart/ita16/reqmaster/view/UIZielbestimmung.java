package org.dhbw.stuttgart.ita16.reqmaster.view;

import org.dhbw.stuttgart.ita16.reqmaster.components.UIPanel;
import org.dhbw.stuttgart.ita16.reqmaster.components.UIScrollPane;
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

	/*****Variablen der Klasse*********/
	private UITextArea text;
	private UIScrollPane scrollPane;
	/**********************************/

	/**
	 * Konstruktor der Klasse
	 * @param view Instanz der View des MVC-Patterns
	 */
	public UIZielbestimmung(IView view) {
		super(view);

		/*****Instanzierung***********/
		text = new UITextArea();
		scrollPane = new UIScrollPane(text, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		/*****************************/

		/*****Settings****************/
		text.setLineWrap(true);
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.add(scrollPane);
		this.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder("Zielbestimmung"), BorderFactory.createEmptyBorder(30,10,20,10)));
		this.setVisible(true);
		/*****************************/

		/********Definition eines FocusListener für TextArea********/
		text.addFocusListener(new FocusListener() {

			/**
			 * legt fest, dass wenn der Fokus auf das Textfeld gelegt wird (Mausklick), nichts passieren soll
			 * @param e auf zu reagierendes Event
			 */
			@Override
			public void focusGained(FocusEvent e) { }

			/**
			 * legt fest, dass wenn das Textfeld den Fokus verliert, ein ModifyEvent an den Controller
			 * weitergereicht wird, der über das Behalten oder die Freigabe des Fokus entscheidet (validieren des Textfeldinhalts)
			 * @param e auf zu reagierendes Event
			 */
			public void focusLost(FocusEvent e) {
				UIModifyZielbestimmungEvent modifyEvent;
				getView().getObsController().observe(modifyEvent =
						new UIModifyZielbestimmungEvent(new DataZielbestimmung(text.getText())));
				if(!(modifyEvent.isSuccess()))
				text.requestFocus(); // Abfrage, ob Änderung valide, ansonsten Fokus beibehalten
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
