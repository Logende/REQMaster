package org.dhbw.stuttgart.ita16.reqmaster.view;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import org.dhbw.stuttgart.ita16.reqmaster.components.UIButton;
import org.dhbw.stuttgart.ita16.reqmaster.components.UIMenuItem;
import org.dhbw.stuttgart.ita16.reqmaster.model.IModel;
import org.dhbw.stuttgart.ita16.reqmaster.components.UIFrame;

import javax.swing.*;

/**
 * Grafikkomponente: UIMainFrame ist das Standardfenster
 * für die Grafikkomponenten
 */
public class UIMainFrame extends UIFrame implements IUIUpdateable {

	//Variablen der Klasse
	private boolean modeMainPanel;
	private UIMainPanel mainPanel;
	private UIFunctionPointPanel functionPointPanel;
	private UIMenu menu;


	/**
	 * Konstruktor der Klasse
	 * erstellt UIMainPanel und erscheint auf der Bildfläche
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
	 * updatet das mainPanel und updatet das Layout
	 * @param model Instanz des Model des MVC-Pattern
	 */
	@Override
	public void update(IModel model) {
		mainPanel.update(model);        //update mainPanel
		functionPointPanel.update(model);
		this.validate();
		this.repaint();	//update Layout
	}

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
		this.validate();
		this.repaint();	//update Layout
	}
}
