package org.dhbw.stuttgart.ita16.reqmaster.view;

import org.dhbw.stuttgart.ita16.reqmaster.components.UIButton;
import org.dhbw.stuttgart.ita16.reqmaster.components.UILabel;
import org.dhbw.stuttgart.ita16.reqmaster.components.UIPanel;
import org.dhbw.stuttgart.ita16.reqmaster.events.UIActionAddProduktFunktionEvent;
import org.dhbw.stuttgart.ita16.reqmaster.model.DataProduktFunktion;
import org.dhbw.stuttgart.ita16.reqmaster.model.IModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

/**
 * Grafikkomponente: Panel, das die Produktfunktionen beinhaltet
 */

public class UIProduktFunktionen extends UIPanel implements UIUpdateable{

    //Variablen der Klasse
    private List<UIProduktFunktion> produktFunktionen;
    private UIButton add;
    private UIPanel buttonPanel;
    private UIPanel funktionsPanel;

    /**
     * Konstruktor der Klasse
     * @param view Instanz der View des MVC-Patterns
     */
    public UIProduktFunktionen(View view){

        //Instanziierung
        super(view);
        produktFunktionen = new ArrayList<>();
        add = new UIButton();
        funktionsPanel = new UIPanel();
        buttonPanel = new UIPanel();

       //TODO UIProduktFunktion test = new UIProduktFunktion(view);
        //TODO UIProduktFunktion test1 = new UIProduktFunktion(view);
        //Panel Settings
        funktionsPanel.setLayout(new GridLayout(2,1));
       //TODO funktionsPanel.add(test);
        //TODO funktionsPanel.add(test1);
        add.setText("Hinzufügen");

        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.add(add, FlowLayout.LEFT);

        add.setSize(20,20);

        this.setBounds(10,60,80,200);
        this.setBorder(BorderFactory.createTitledBorder("Produktfunktionen"));
        this.setLayout(new BorderLayout());
        this.add(buttonPanel, BorderLayout.PAGE_START);
        this.add(funktionsPanel, BorderLayout.CENTER);
        this.setVisible(true);

        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getView().getObsController().observe(new UIActionAddProduktFunktionEvent());
            }
        });
    }

    /**
     *Updaten der Produktfunktionen
     * 1. schauen ob eine bestehende Produktfunktion im Model gelöscht wurde, wenn ja auch in der GUI löschen
     * 2. alle bestehenden Produktfunktionen in der GUI aktualisieren
     * 3. alle neuen Produktfunktionen im Model, die nicht in der GUI sind, hinzufügen
     * @param model Instanz des Model des MVC-Patterns, das die Daten enthält
     */
    @Override
    public void update(IModel model){
        for(UIProduktFunktion o : produktFunktionen){
         // TODO: wie durchläuft man die Map?   for(DataProduktFunktion i:)
        }
    }


}
