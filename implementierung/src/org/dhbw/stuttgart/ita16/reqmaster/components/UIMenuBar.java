package org.dhbw.stuttgart.ita16.reqmaster.components;

import org.dhbw.stuttgart.ita16.reqmaster.view.IView;
import javax.swing.*;

/**
 * Adaption der Swing-JToolBar fuer individuelle Anpassungen an das Projekt
 */
public class UIMenuBar extends JMenuBar {

	private IView view;

	/**
	 * Standardkonstruktor der Klasse
	 * @param view Instanz der View des MVC-Patterns
	 */
	public UIMenuBar(IView view) {
		super();
		this.view = view;
	}

	/**
	 * Getter Methode: liefert Instanz der View des MVC-Patterns zurück
	 * @return View des MVC-Pattern
	 */
	public IView getView() {
		return this.view;
	}
}
