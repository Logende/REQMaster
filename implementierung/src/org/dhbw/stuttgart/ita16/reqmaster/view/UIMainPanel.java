package org.dhbw.stuttgart.ita16.reqmaster.view;

import java.awt.*;
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
	public UIMainPanel(View view)
	{
		super(view);
		setLayout(new GridLayout(2,2));
		this.add(panelFunktionen=new UIProduktFunktionen(view));
		this.add(panelDaten=new UIProduktDaten(view));
		this.add(panelProdukteinsatz=new UIProdukteinsatz(view));
		this.add(panelZielbestimmung=new UIZielbestimmung(view));
		this.add(panelUmgebung=new UIUmgebung(view));
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
