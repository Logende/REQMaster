package org.dhbw.stuttgart.ita16.reqmaster.view;

import java.io.*;
import java.util.*;
import org.dhbw.stuttgart.ita16.reqmaster.model.IModel;
import org.dhbw.stuttgart.ita16.reqmaster.components.UIFrame;

import javax.swing.*;

/**
 * Grafikkomponente: UIMainFrame ist das Standardfenster
 * für die Grafikkomponenten
 */
public class UIMainFrame extends UIFrame implements UIUpdateable {

	private UIMainPanel mainPanel;
	private UIFunctionPointPanel functionPointPanel;
	private UIMenu menu;

	/**
	 * Konstruktor der Klasse
	 * erstellt UIMainPanel und erscheint auf der Bildfläche
	 */
	public UIMainFrame(View view) {
		super("REQ-Master");                        		//rufe Superklasse auf
		mainPanel = new UIMainPanel(view);						//erstelle Instanz von UIMainPanel
		menu = new UIMenu(view);
		//functionPointPanel = new UIFunctionPointPanel(view); 	// erstelle Instanz von UIFunctionPointPanel
		this.setSize(1200,680);						//Grösse festlegen
		this.setResizable(false);								//Grösse des Frames nicht veränderbar
		this.add(mainPanel);									//füge mainPanel zu Frame hinzu
		this.setJMenuBar(menu);
		//this.add(functionPointPanel);							//füge functionPointPanel zu Frame hinzu
		this.setDefaultCloseOperation(UIFrame.EXIT_ON_CLOSE);
		this.setVisible(true);          						//mache Frame sichtbar
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
