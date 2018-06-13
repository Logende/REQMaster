package org.dhbw.stuttgart.ita16.reqmaster.view;

import java.io.*;
import java.util.*;
import org.dhbw.stuttgart.ita16.reqmaster.model.IModel;
import org.dhbw.stuttgart.ita16.reqmaster.components.UIPanel;

import javax.swing.*;

/**
 * Grafikkomponente: legt Aufbau einer Anforderungssammlung TODO ist das richtig ?
 */

public class UIMainPanel extends UIPanel implements UIUpdateable {

	private UIProduktFunktionen panelFunktionen;
	private UIProduktDaten panelDaten;
	private UIProdukteinsatz panelProdukteinsatz;
	private UIZielbestimmung panelZielbestimmung;
	private UIUmgebung panelUmgebung;

	/**
	 * Konstruktor der Klasse
	 * erstellt Instanzen der Klassen UIProduktFunktionen, UIProduktDaten, UIProdukteinsatz, UIZielbestimmung und UIUmgebung
	 * und erscheint auf der Bildfläche
	 */
	public UIMainPanel()
	{
		super();
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		this.add(panelFunktionen=new UIProduktFunktionen());
		this.add(panelDaten=new UIProduktDaten());
		this.add(panelProdukteinsatz=new UIProdukteinsatz());
		this.add(panelZielbestimmung=new UIZielbestimmung());
		this.add(panelUmgebung=new UIUmgebung());
		this.setVisible(true);
	}

	/**
	 * updatet die Instanzen der Klassen UIProduktFunktionen, UIProduktDaten, UIProdukteinsatz, UIZielbestimmung und UIUmgebung
	 * und validiert die eigeneKlasse
	 * @param model
	 */
	public void update(IModel model)
	{
		//update Klassenvariablen
		panelFunktionen.update(model);
		panelDaten.update(model);
		panelProdukteinsatz.update(model);
		panelZielbestimmung.update(model);
		panelUmgebung.update(model);
		this.validate();
	}



}
