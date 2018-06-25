package org.dhbw.stuttgart.ita16.reqmaster.view;

import java.awt.*;
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

	/******Variablen der Klasse******************/
	private UIMainPanel mainPanel;
	private UIFunctionPointPanel functionPointPanel;
	private UIMenu menu;
	/*******************************************/

	/**
	 * Konstruktor der Klasse
	 * erstellt UIMainPanel und erscheint auf der Bildfläche
	 */
	public UIMainFrame(View view) {
		super("REQ-Master");

		/****Instanzierung****************/
		mainPanel = new UIMainPanel(view);
		//functionPointPanel = new UIFunctionPointPanel(view);
		menu = new UIMenu(view, functionPointPanel);
		/*********************************/

		/*********Settings****************/
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.add(mainPanel);
		this.setJMenuBar(menu);
		//this.add(functionPointPanel);
		this.setDefaultCloseOperation(UIFrame.EXIT_ON_CLOSE);
		/**********************************/
	}

	/**
	 * updatet das mainPanel und updatet das Layout
	 * @param model Instanz des Model des MVC-Pattern
	 */
	@Override
	public void update(IModel model) {
		mainPanel.update(model);        //update mainPanel
		//functionPointPanel.update(model);
		this.validate();                //update Layout
	}

}
