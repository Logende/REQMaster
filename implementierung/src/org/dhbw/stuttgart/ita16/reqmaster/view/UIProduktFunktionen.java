package org.dhbw.stuttgart.ita16.reqmaster.view;

import org.dhbw.stuttgart.ita16.reqmaster.components.UIButton;
import org.dhbw.stuttgart.ita16.reqmaster.components.UIPanel;
import org.dhbw.stuttgart.ita16.reqmaster.components.UIScrollPane;
import org.dhbw.stuttgart.ita16.reqmaster.events.UIActionAddProduktFunktionEvent;
import org.dhbw.stuttgart.ita16.reqmaster.model.DataProduktFunktion;
import org.dhbw.stuttgart.ita16.reqmaster.model.DefaultValues;
import org.dhbw.stuttgart.ita16.reqmaster.model.IModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

/**
 * Grafikkomponente: Beinhaltet alle durch den Anwender hinzufgefügten Produktfunktionen (durch UIProduktFunktion dargestellt)
 * und ermöglicht Löschen/Hinzufügen/Bearbeiten von Produktfunktionen.
 */

public class UIProduktFunktionen extends UIPanel implements IUIUpdateable {

    //Variablen der Klasse
    private List<UIProduktFunktion> produktFunktionen;
    private UIButton add;
    private UIPanel funktionsPanel;
    private UIScrollPane scrollPane;

    /** Konstruktor der Klasse
     * @param view Instanz der View des MVC-Patterns
     */
    public UIProduktFunktionen(IView view){

        //Instanzierung
        super(view);
        produktFunktionen = new ArrayList<>();
        add = new UIButton();
        funktionsPanel = new UIPanel();
        scrollPane = new UIScrollPane( funktionsPanel,ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        //Hinzufügen der Komponenten sowie Settings
        this.setBorder(BorderFactory.createTitledBorder(DefaultValues.PRODUKTFUNKTIONEN));
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(add);
        this.add(scrollPane);
        this.setVisible(true);
        funktionsPanel.setLayout(new BoxLayout(funktionsPanel, BoxLayout.Y_AXIS));
        scrollPane.setBorder(BorderFactory.createEmptyBorder(10,0,0,0));
        scrollPane.getVerticalScrollBar().setUnitIncrement(15);
        add.setText("Hinzufügen");

        //ActionListener fuer Hinzufügen-Button
        add.addActionListener(new ActionListener() {
            /**
             * Wenn der Button gedrückt wird,
             * wird ein Event an den Controller gesendet, um eine neue Produktfunktion hinzuzufügen
             * @param e Event, auf das reagiert werden soll
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                if (View.forcesFocus == null) {
                    getView().getObsController().observe(new UIActionAddProduktFunktionEvent());
                }
            }
        });
    }

    /**
     * Aktualisiert alle dazugehörigen UI Komponenten mit den neuen Daten des Models.
     * 1. schauen ob eine bestehende Produktfunktion im Model gelöscht wurde, wenn ja auch in der GUI löschen
     * 2. alle bestehenden Produktfunktionen in der GUI aktualisieren
     * 3. alle neuen Produktfunktionen im Model, die noch nicht in der GUI sind, hinzufügen
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
            }
        }

        //Entfernen aller Produktfunktionen vom Panel und danach neu hinzufügen
        funktionsPanel.removeAll();
        for (UIProduktFunktion i : produktFunktionen){
            funktionsPanel.add(i);
        }
    }
}
