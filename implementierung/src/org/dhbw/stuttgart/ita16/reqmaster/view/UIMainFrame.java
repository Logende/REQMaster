package org.dhbw.stuttgart.ita16.reqmaster.view;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import org.dhbw.stuttgart.ita16.reqmaster.components.UIMenuItem;
import org.dhbw.stuttgart.ita16.reqmaster.model.IModel;
import org.dhbw.stuttgart.ita16.reqmaster.components.UIFrame;

import javax.swing.*;

/**
 * Grafikkomponente: UIMainFrame ist das Hauptfenster
 * Es ermöglicht, das Hauptfenster zu gestalten
 */
public class UIMainFrame extends UIFrame implements IUIUpdateable {

	//Variablen der Klasse
	private boolean modeMainPanel;	//legt fest, ob mainPanel angezeigt wird
	private UIMainPanel mainPanel;
	private UIFunctionPointPanel functionPointPanel;
	private UIMenu menu;

	/**
	 * Konstruktor der Klasse
	 * Die Klasse erstellt die Panels für die Anforderungssammlung und die Aufwandsabschätzung
	 * und zeigt diese an
	 */
	public UIMainFrame(View view) {
		super("REQ-Master");
		//Instanzierung
		mainPanel = new UIMainPanel(view);
		functionPointPanel = new UIFunctionPointPanel(view);
		menu = new UIMenu(view, this);

		//Settings
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.add(mainPanel);
		modeMainPanel = true;
		this.setJMenuBar(menu);
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

		//Falls das Mainframe geschlossen werden soll, wird nachgefragt,
		//ob der Anwender das wirklich will
		addWindowListener(new WindowAdapter()
		{
			/**
			 * Fängt das WindowClosing Event ab, wenn man auf den [X] Button klickt
			 * und fragt den Benutzer, ob er das Programm beenden möchte
			 * @param e das Event, das ausgelöst wird, wenn man auf den [X] Button klickt
			 */
			@Override
			public void windowClosing(WindowEvent e)
			{
				if (JOptionPane.showConfirmDialog(UIMainFrame.this,
						"Möchten Sie wirklich beenden?", "Beenden?",
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
						UIMainFrame.this.dispose();
				}
			}
		});
	}

	/**
	 * Aktualisiert alle dazugehörigen UI Komponenten mit den neuen Daten des Models.
	 * @param model Instanz des Model des MVC-Pattern, mit dem die GUI aktualisiert werden soll
	 */
	@Override
	public void update(IModel model) {
		mainPanel.update(model);
		functionPointPanel.update(model);
		this.validate(); // aktualisiere Layout
		this.repaint();	// aktualisiere Layout
	}

	/**
	 * Methode, um zwischen Anforderungssammlung und Aufwandsabschätzung umzuschalten im Mainframe
	 * @param button der Button, der zwischen beiden umschalten soll, wenn gedrückt
	 */
	public synchronized void toggleMode(UIMenuItem button){
		modeMainPanel = !modeMainPanel;
		if(modeMainPanel){
			this.add(mainPanel);
			this.remove(functionPointPanel);
			button.setText("Zu Aufwandsabschätzung");
		}else{
			this.remove(mainPanel);
			this.add(functionPointPanel);
			button.setText("Zu Anforderungssammlung");
		}
		this.validate(); // aktualisiere Layout
		this.repaint();	// aktualisiere Layout
	}
}
