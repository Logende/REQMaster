package org.dhbw.stuttgart.ita16.reqmaster.view;

import org.dhbw.stuttgart.ita16.reqmaster.components.UIButton;
import org.dhbw.stuttgart.ita16.reqmaster.components.UILabel;
import org.dhbw.stuttgart.ita16.reqmaster.components.UIPanel;
import org.dhbw.stuttgart.ita16.reqmaster.components.UIScrollBar;
import org.dhbw.stuttgart.ita16.reqmaster.events.UIActionAddProduktFunktionEvent;
import org.dhbw.stuttgart.ita16.reqmaster.model.DataId;
import org.dhbw.stuttgart.ita16.reqmaster.model.DataProduktFunktion;
import org.dhbw.stuttgart.ita16.reqmaster.model.IModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Grafikkomponente: Panel, das die Produktfunktionen beinhaltet
 */

public class UIProduktFunktionen extends UIPanel implements UIUpdateable{

    //Variablen der Klasse
    private List<UIProduktFunktion> produktFunktionen;
    private UIButton add;
    private UIPanel buttonPanel;
    private UIPanel funktionsPanel;
    private UIScrollBar vertikalBar;

    /**
     * Konstruktor der Klasse
     * @param view Instanz der View des MVC-Patterns
     */
    public UIProduktFunktionen(IView view){

        //Instanziierung
        super(view);
        produktFunktionen = new ArrayList<>();
        add = new UIButton();
        funktionsPanel = new UIPanel();
        buttonPanel = new UIPanel();
        vertikalBar = new UIScrollBar();

        //Panel Settings
        funktionsPanel.setLayout(new GridLayout(2,1));
        add.setText("Hinzufügen");
        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.add(add, FlowLayout.LEFT);

        add.setSize(20,20);

        this.setBounds(10,60,80,200);
        this.setBorder(BorderFactory.createTitledBorder("Produktfunktionen"));
        this.setLayout(new BorderLayout());
        this.add(buttonPanel, BorderLayout.PAGE_START);
        this.add(funktionsPanel, BorderLayout.CENTER);
        this.add(vertikalBar, BorderLayout.EAST);
        this.setVisible(true);

        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UIActionAddProduktFunktionEvent addEvent;
                getView().getObsController().observe(addEvent = new UIActionAddProduktFunktionEvent());
            }
        });
    }

    /**
     *Updaten der Produktfunktionen
     * 1. schauen ob eine bestehende Produktfunktion im Model gelöscht wurde, wenn ja auch in der GUI löschen
     * 2. alle bestehenden Produktfunktionen in der GUI aktualisieren
     * 3. alle neuen Produktfunktionen im Model, die nicht in der GUI sind, hinzufügen
     * @param model Instanz des IModel des MVC-Patterns, das die Daten enthält
     */
    @Override
    public void update(IModel model){
        //Update bestehende Funktionen und loesche mittlerweile aus dem Model entfernte Funktionen
        List<UIProduktFunktion> toDelete = new ArrayList<>();
        for(UIProduktFunktion uiProduktFunktion : produktFunktionen){
            DataProduktFunktion dataProduktFunktion = model.getIDataAnforderungssammlung().getDataProduktFunktionen().get(uiProduktFunktion.getId());
            if(dataProduktFunktion == null){
                toDelete.add(uiProduktFunktion);
            }else{
                uiProduktFunktion.update(model);
            }
        }
        for(UIProduktFunktion uiProduktFunktion : toDelete){
            produktFunktionen.remove(uiProduktFunktion);
            this.repaint();
            //TODO: remove function from actual GUI panel, not just from list in memory
        }
        //Fuege neue zum Model hinzugefuegte Funktionen dazu
        for(DataProduktFunktion dataProduktFunktion : model.getIDataAnforderungssammlung().getDataProduktFunktionen().values()){
            boolean isNew = true;
            for(UIProduktFunktion uiProduktFunktion : produktFunktionen){
                if(uiProduktFunktion.getId() == dataProduktFunktion.getId()){
                    isNew = false;
                    break;
                }
            }
            if(isNew){
                produktFunktionen.add(new UIProduktFunktion(getView(), dataProduktFunktion.getId()));
                //TODO: add function to actual GUI panel, not just from list in memory
            }
        }
    }


}
