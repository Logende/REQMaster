package org.dhbw.stuttgart.ita16.reqmaster.components;

import org.dhbw.stuttgart.ita16.reqmaster.view.IView;
import javax.swing.*;

/**
 * Adaption der Swing-JToolBar für Projektzwecke
 */
public class UIMenuBar extends JMenuBar {

	private IView view;

	/**
	 * Standardkonstruktor der Klasse
	 */
	public UIMenuBar(IView view) {
		super();
		this.view = view;
	}

	/**
	 * getter Methode: liefert Instanz der View des MVC-Patterns zurück
	 * @return View des MVC-Pattern
	 */
	public IView getView() {
		return this.view;
	}
}
