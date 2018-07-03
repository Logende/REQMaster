package org.dhbw.stuttgart.ita16.reqmaster.view;

import org.dhbw.stuttgart.ita16.reqmaster.components.UIScrollPane;
import org.dhbw.stuttgart.ita16.reqmaster.components.UITextArea;
import org.dhbw.stuttgart.ita16.reqmaster.events.UIModifyProdukteinsatzEvent;
import org.dhbw.stuttgart.ita16.reqmaster.model.DataProdukteinsatz;
import org.dhbw.stuttgart.ita16.reqmaster.model.DefaultValues;
import org.dhbw.stuttgart.ita16.reqmaster.model.IModel;
import org.dhbw.stuttgart.ita16.reqmaster.components.UIPanel;
import javax.swing.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

/**
 * Grafikkomponente: Ermöglicht es dem Anwender, den Produkteinsatz seiner Anforderungssammlung zu definieren.
 */
public class UIProdukteinsatz extends UIPanel implements IUIUpdateable {

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
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.add(scrollPane);
		this.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder(DefaultValues.PRODUKTEINSATZ),
				BorderFactory.createEmptyBorder(30,10,20,10)));
		this.setVisible(true);
		text.setLineWrap(true);

		//Fokuslistener für TextArea
		text.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) { }

			/**
			 * Wenn die TextArea den Fokus verliert, werden alle Daten-Änderungen über ein Modify-Event an den Controller gereicht.
			 * Der Controller kann bei invaliden Daten das Event ablehnen, woraufhin die Komponente den Fokus erneut anfordert,
			 * damit der Anwender valide Daten eingibt.
			 * @param e auf zu reagierendes Event
			 */
			@Override
			public void focusLost(FocusEvent e) {
				UIModifyProdukteinsatzEvent modifyEvent;
				//Erstellen des Events
				getView().getObsController().observe(modifyEvent =
						new UIModifyProdukteinsatzEvent(new DataProdukteinsatz(text.getText())));
				//Auswerten des Events nach Controllerbehandlung
				if(!(modifyEvent.isSuccess())){
					JOptionPane.showMessageDialog(scrollPane, "Falsche Eingabe",
							"Änderung nicht valide", JOptionPane.WARNING_MESSAGE);
					View.forcesFocus = UIProdukteinsatz.this;
					text.requestFocus();	//Abfrage, ob Änderung valide ist, ansonsten Fokus auf TextArea behalten
				}else{
					View.forcesFocus = null;
				}
			}
		});
	}

	/**
	 * Aktualisiert die TextArea mit dem Wert im Model
	 * @param model Istanz des Model des MVC-Patterns
	 */
	@Override
	public void update(IModel model) {
		text.setText(model.getIDataAnforderungssammlung().getDataProdukteinsatz().getText());
	}
}
