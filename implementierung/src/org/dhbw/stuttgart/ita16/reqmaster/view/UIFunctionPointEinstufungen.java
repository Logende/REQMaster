package org.dhbw.stuttgart.ita16.reqmaster.view;

import org.dhbw.stuttgart.ita16.reqmaster.components.UIPanel;
import org.dhbw.stuttgart.ita16.reqmaster.components.UIScrollPane;
import org.dhbw.stuttgart.ita16.reqmaster.model.*;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class UIFunctionPointEinstufungen extends UIPanel implements IUIUpdateable {

    //Variablen der Klasse
    private List<UIFunctionPointEinstufung> einstufungen;
    private UIPanel funktionsPanel;
    private UIScrollPane scrollPane;

    /** Konstruktor der Klasse
     * @param view Instanz der View des MVC-Patterns
     */
    public UIFunctionPointEinstufungen(IView view){
        super(view);
        einstufungen = new ArrayList<>();
        funktionsPanel = new UIPanel();
        scrollPane = new UIScrollPane( funktionsPanel,ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        //Hinzufügen der Komponenten sowie Settings
        funktionsPanel.setLayout(new BoxLayout(funktionsPanel, BoxLayout.Y_AXIS));
        scrollPane.setBorder(BorderFactory.createEmptyBorder(10,0,0,0));
        this.setBorder(BorderFactory.createTitledBorder("FunctionPoint Einstufungen"));
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(scrollPane);
        this.setVisible(true);
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
        List<UIFunctionPointEinstufung> toDelete = new ArrayList<>();
        for(UIFunctionPointEinstufung uiEinstufung : einstufungen){
            IIdentifiable iIdentifiable = model.getIDataAnforderungssammlung().getObject(uiEinstufung.getId());
            if(iIdentifiable == null){
                toDelete.add(uiEinstufung);
            }else{
                uiEinstufung.update(model);
            }
        }
        for(UIFunctionPointEinstufung einstufung : toDelete){
            einstufungen.remove(einstufung);
        }
        //Fuege neue zum Model hinzugefuegte Funktionen dazu
        for(DataProduktFunktion dataProduktFunktion : model.getIDataAnforderungssammlung().getDataProduktFunktionen().values()){
            boolean isNew = true;
            for(UIFunctionPointEinstufung uiEinstufung : einstufungen){
                if(uiEinstufung.getId() == dataProduktFunktion.getId()){
                    isNew = false;
                    break;
                }
            }
            if(isNew){
                einstufungen.add(new UIFunctionPointEinstufung(getView(), dataProduktFunktion.getId()));
            }
        }
        //Fuege neue zum Model hinzugefuegte Daten dazu
        for(DataProduktDatum dataProduktDatum : model.getIDataAnforderungssammlung().getDataProduktDaten().values()){
            boolean isNew = true;
            for(UIFunctionPointEinstufung uiEinstufung : einstufungen){
                if(uiEinstufung.getId() == dataProduktDatum.getId()){
                    isNew = false;
                    break;
                }
            }
            if(isNew){
                einstufungen.add(new UIFunctionPointEinstufung(getView(), dataProduktDatum.getId()));
            }
        }

        //funktionsPanel aktualisieren
        funktionsPanel.removeAll();
        for (UIFunctionPointEinstufung uiFunctionPointEinstufung : einstufungen){
            funktionsPanel.add(uiFunctionPointEinstufung);
        }
    }
}
