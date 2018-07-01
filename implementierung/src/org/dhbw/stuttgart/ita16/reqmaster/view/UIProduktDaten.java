
package org.dhbw.stuttgart.ita16.reqmaster.view;

import org.dhbw.stuttgart.ita16.reqmaster.components.UIButton;
import org.dhbw.stuttgart.ita16.reqmaster.components.UIPanel;
import org.dhbw.stuttgart.ita16.reqmaster.components.UIScrollPane;
import org.dhbw.stuttgart.ita16.reqmaster.events.UIActionAddProduktDatumEvent;
import org.dhbw.stuttgart.ita16.reqmaster.model.DataProduktDatum;
import org.dhbw.stuttgart.ita16.reqmaster.model.DefaultValues;
import org.dhbw.stuttgart.ita16.reqmaster.model.IModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

/**
 * Grafikkomponente: Beinhaltet alle durch den Anwender hinzufgefügten Produktdaten (durch UIProduktDatum dargestellt)
 * und ermöglicht Löschen/Hinzufügen/Bearbeiten von ProduktDaten.
 */
public class UIProduktDaten extends UIPanel implements IUIUpdateable {

    //Variablen der Klasse
    private List<UIProduktDatum> produktDaten;
    private UIButton add;
    private UIPanel datenPanel;
    private UIScrollPane scrollPane;

    /**
     * Konstruktor der Klasse
     * @param view Instanz der View des MVC-Patterns
     */
    public UIProduktDaten(IView view){
        super(view);

        //Instanzierung
        produktDaten = new ArrayList<>();
        add = new UIButton();
        datenPanel = new UIPanel();
        scrollPane = new UIScrollPane(datenPanel,ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        // Hinzufügen der Komponenten zum Panel sowie Settings
        this.setBorder(BorderFactory.createTitledBorder(DefaultValues.PRODUKTDATEN));
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(add);
        this.add(scrollPane, BorderLayout.PAGE_START);
        this.setVisible(true);
        add.setText("Hinzufügen");
        datenPanel.setLayout(new BoxLayout(datenPanel, BoxLayout.Y_AXIS));
        scrollPane.setBorder(BorderFactory.createEmptyBorder(10,0,0,0));
        scrollPane.getVerticalScrollBar().setUnitIncrement(15);

        //Definition eines ActionListener
        add.addActionListener(new ActionListener() {
            /**
             * Wenn Button gedrückt wird, wird ein Event an den Controller geschickt, um ein neues
             * Produktdatum hinzuzufügen
             * @param e auf zu reagierendes Event
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                if (View.forcesFocus == null) {
                    UIActionAddProduktDatumEvent addEvent;
                    getView().getObsController().observe(addEvent = new UIActionAddProduktDatumEvent());
                }
            }
        });
    }

    /**
     * Aktualisiert alle dazugehörigen UI Komponenten mit den neuen Daten des Models.
     * 1. schauen ob eine bestehende Produktfunktion im Model gelöscht wurde, wenn ja auch in der GUI löschen
     * 2. alle bestehenden Produktfunktionen in der GUI aktualisieren
     * 3. alle neuen Produktfunktionen im Model, die nicht in der GUI sind, hinzufügen
     * @param model Instanz des Model des MVC-Patterns, das die Daten enthält
     */
    @Override
    public void update(IModel model){
        //Update bestehende Daten und loesche mittlerweile aus dem Model entfernte Daten
        List<UIProduktDatum> toDelete = new ArrayList<>();
        for(UIProduktDatum uiProduktDatum : produktDaten){
            DataProduktDatum dataProduktDatum = model.getIDataAnforderungssammlung().getDataProduktDaten().get(uiProduktDatum.getId());
            if(dataProduktDatum == null){
                toDelete.add(uiProduktDatum);
            }else{
                uiProduktDatum.update(model);
            }
        }
        for(UIProduktDatum uiProduktDatum : toDelete){
            produktDaten.remove(uiProduktDatum);
        }
        //Fuege neue zum Model hinzugefuegte Funktionen dazu
        for(DataProduktDatum dataProduktDatum : model.getIDataAnforderungssammlung().getDataProduktDaten().values()){
            boolean isNew = true;
            for(UIProduktDatum uiProduktDatum : produktDaten){
                if(uiProduktDatum.getId() == dataProduktDatum.getId()){
                    isNew = false;
                    break;
                }
            }
            if(isNew){
                produktDaten.add(new UIProduktDatum(getView(), dataProduktDatum.getId()));
            }
        }
        //datenPanel aktualisieren, indem alle Produktdatum des Panel entfernt werden und dann
        //wieder hinzugefügt werden
        datenPanel.removeAll();
        for (UIProduktDatum i : produktDaten) {
            datenPanel.add(i);
        }
    }
}
