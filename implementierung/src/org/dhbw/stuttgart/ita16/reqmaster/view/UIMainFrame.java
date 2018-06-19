package org.dhbw.stuttgart.ita16.reqmaster.view;

import java.io.*;
import java.util.*;
import org.dhbw.stuttgart.ita16.reqmaster.model.IModel;
import org.dhbw.stuttgart.ita16.reqmaster.components.UIFrame;

/**
 * Grafikkomponente: UIMainFrame ist das Standardfenster
 * für die Grafikkomponenten
 */
public class UIMainFrame extends UIFrame implements UIUpdateable {

	private UIMainPanel mainPanel;

	/**
	 * Konstruktor der Klasse
	 * erstellt UIMainPanel und erscheint auf der Bildfläche
	 */
	public UIMainFrame(View view) {
		super();                        //rufe Superklasse auf
		mainPanel = new UIMainPanel(view);    //erstelle Instanz von UIMainPanel()
		this.add(mainPanel);            //füge mainPanel zu Frame hinzu
		this.setVisible(true);          //mache Frame sichtbar
	}

	/**
	 * updatet panel und validiert die Klasse
	 *
	 * @param model
	 */
	@Override
	public void update(IModel model) {

		mainPanel.update(model);        //update mainPanel
		this.validate();                //update Layout
	}

}
