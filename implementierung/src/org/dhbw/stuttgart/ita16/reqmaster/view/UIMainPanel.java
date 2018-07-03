package org.dhbw.stuttgart.ita16.reqmaster.view;

import java.awt.*;

import org.dhbw.stuttgart.ita16.reqmaster.model.IModel;
import org.dhbw.stuttgart.ita16.reqmaster.components.UIPanel;

/**
 * Grafikkomponente: Ermöglicht es, die Anordnung der grafischen Bestandteile
 * einer Anforderungssammlung zu verwalten
 */
public class UIMainPanel extends UIPanel implements IUIUpdateable {

	// Variablen der Klasse
	private UIProduktFunktionen panelFunktionen;
	private UIProduktDaten panelDaten;
	private UIProdukteinsatz panelProdukteinsatz;
	private UIZielbestimmung panelZielbestimmung;
	private UIUmgebung panelUmgebung;
	private Image image;

	/**
	 * Konstruktor der Klasse
	 * erstellt Instanzen der Komponenten der Anforderungssammlung und macht diese sichtbar in der GUI
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
		this.setVisible(true);
	}

	/**
	 * Aktualisiert alle dazugehörigen UI Komponenten mit den neuen Daten des Models.
	 * @param model Model des MVC-Patterns, mit dem die View aktualisiert werden soll
	 */
	public void update(IModel model){
		panelFunktionen.update(model);
		panelDaten.update(model);
		panelProdukteinsatz.update(model);
		panelZielbestimmung.update(model);
		panelUmgebung.update(model);
		this.validate(); // aktualisiere Layout
	}
}
