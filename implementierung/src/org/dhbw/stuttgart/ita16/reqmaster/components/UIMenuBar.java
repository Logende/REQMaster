package org.dhbw.stuttgart.ita16.reqmaster.components;

import org.dhbw.stuttgart.ita16.reqmaster.view.View;
import javax.swing.*;

/**
 * Adaption der Swing-JToolBar für Projektzwecke
 */
public class UIMenuBar extends JMenuBar {

	private View view;

	/**
	 * Standardkonstruktor der Klasse
	 */
	public UIMenuBar() {
		super();
	}

	/**
	 * getter Methode: liefert Instanz der View des MVC-Patterns zurück
	 * @return View des MVC-Pattern
	 */
	public View getView() {
		return this.view;
	}
}
