package org.dhbw.stuttgart.ita16.reqmaster.view;

import java.awt.*;

import org.dhbw.stuttgart.ita16.reqmaster.model.IModel;
import org.dhbw.stuttgart.ita16.reqmaster.components.UIPanel;

/**
 * Grafikkomponente: legt Aufbau einer Anforderungssammlung TODO ist das richtig ?
 */

public class UIMainPanel extends UIPanel implements IUIUpdateable {

	// Variablen der Klasse
	private UIProduktFunktionen panelFunktionen;
	private UIProduktDaten panelDaten;
	private UIProdukteinsatz panelProdukteinsatz;
	private UIZielbestimmung panelZielbestimmung;
	private UIUmgebung panelUmgebung;

	private UIFunctionPointEinstufungen einstufungen; //just here for testing purposes

	/**
	 * Konstruktor der Klasse
	 * erstellt Instanzen der Klassen UIProduktFunktionen, UIProduktDaten, UIProdukteinsatz, UIZielbestimmung und UIUmgebung
	 * und erscheint auf der Bildfläche
	 */
	public UIMainPanel(View view){
		super(view);
		//Instanzierung und Hinzufügen der Komponenten
		setLayout(new GridLayout(2,2));
		this.add(panelZielbestimmung=new UIZielbestimmung(view));
		this.add(panelProdukteinsatz=new UIProdukteinsatz(view));
		this.add(panelUmgebung=new UIUmgebung(view));
		this.add(panelFunktionen=new UIProduktFunktionen(view));
		this.add(panelDaten=new UIProduktDaten(view));
		this.add(einstufungen = new UIFunctionPointEinstufungen(view)); //just here for testing purposes
		this.setVisible(true);
	}

	/**
	 * updatet die Instanzen der Klassen UIProduktFunktionen, UIProduktDaten, UIProdukteinsatz, UIZielbestimmung und UIUmgebung
	 * und validiert die eigeneKlasse
	 * @param model
	 */
	public void update(IModel model){
		panelFunktionen.update(model);
		panelDaten.update(model);
		panelProdukteinsatz.update(model);
		panelZielbestimmung.update(model);
		panelUmgebung.update(model);
		einstufungen.update(model); //just here for testing purposes
		this.validate();
	}



}
