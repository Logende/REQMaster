package org.dhbw.stuttgart.ita16.reqmaster.view;

import org.dhbw.stuttgart.ita16.reqmaster.components.*;
import org.dhbw.stuttgart.ita16.reqmaster.events.UIActionDeleteProduktFunktionEvent;
import org.dhbw.stuttgart.ita16.reqmaster.events.UIModifyProduktFunktionEvent;
import org.dhbw.stuttgart.ita16.reqmaster.model.DataId;
import org.dhbw.stuttgart.ita16.reqmaster.model.DataProduktFunktion;
import org.dhbw.stuttgart.ita16.reqmaster.model.DefaultValues;
import org.dhbw.stuttgart.ita16.reqmaster.model.IModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

/**
 * Grafikkomponente: Ermöglicht es dem Anwender, eine Produktfunktion seiner Anforderungssammlung zu definieren.
 */
public class UIProduktFunktion extends UIPanel implements IUIUpdateable {

    private final DataId dataId; //always the real DataId instance, as being used within the model
    private UILabel title;
    private UIButton delete;
    private UITextField id;
    private UITextField name;
    private UITextField quelle;
    private UITextField akteur;
    private UITextField beschreibung;
    private UITextField verweise;
    private UILabel idText;
    private UILabel nameText;
    private UILabel quelleText;
    private UILabel akteurText;
    private UILabel beschreibungText;
    private UILabel verweiseText;

    /**
     * Konstruktor der Klasse
     * @param view Instanz der View des MVC-Patterns
     */
    public UIProduktFunktion(IView view, DataId dataId) {
        super(view);
        this.dataId = dataId;
        this.setLayout(new GridLayout(9,2));
        addComponents();
        setComponents();
        this.update(view.getModel());
        this.setVisible(true);

        // Definition eines ActionListeners für den Delete Button, der ein Event an den Controller schickt,
        // um eine Produktfunktion zu löschen
        delete.addActionListener(actionEvent -> {
        if(View.forcesFocus == null || UIProduktFunktion.this == View.forcesFocus) {
            getView().getObsController().observe(new UIActionDeleteProduktFunktionEvent(this.dataId));
            View.forcesFocus = null;
        }
        });
    }

    /**
     *  Hinzufügen der Grafikkomponenten zum Panel sowie
     *  Definition des Fokuslistener
     */
    private void addComponents() {
        /**
         * Für jedes UITextField der ProduktFunktion wird einmalig ein
         * FocusListener definiert, den die Textfelder im Konstruktor übergeben bekommen
         * focusLost und focusGained sind Komponenten der GUI die den Fokus bekommen oder verlieren
         */
        UIListenerComponentLostFocus listener = (focusLost, focusGained) -> {
            if(focusGained != null) {
                    if (focusLost.getParent() == focusGained.getParent()) {
                        return; //do nothing if new component has same parent
                    }
            }
            // Wenn der Fokus von einer Komponente der Produktfunktion auf irgendeine andere Komponente der GUI gelegt wird,
            // wird zur Validierung der Produktfunktion, ein Event an den Controller gesendet
            DataProduktFunktion proposal = new DataProduktFunktion(name.getText(), beschreibung.getText(), akteur.getText(),
                    quelle.getText(), verweise.getText(), new DataId(id.getText()));
            UIModifyProduktFunktionEvent modifyEvent = new UIModifyProduktFunktionEvent(dataId, proposal);
            getView().getObsController().observe(modifyEvent);
            if(!modifyEvent.isSuccess()){
                JOptionPane.showMessageDialog(focusLost.getParent(), modifyEvent.getErrorMessage(),
                        "Änderung nicht valide", JOptionPane.WARNING_MESSAGE);
                View.forcesFocus = UIProduktFunktion.this; // falls Validierung der Produktfunktion negativ, Fokus zurück auf Komponente
                focusLost.requestFocus();
            }else{
                View.forcesFocus = null;
            }
        };

        this.add(new UILabel());
        this.add(new UILabel());
        this.add(title = new UILabel());
        this.add(delete = new UIButton());
        this.add(idText = new UILabel());
        this.add(id = new UITextField(listener));
        this.add(nameText = new UILabel());
        this.add(name = new UITextField(listener));
        this.add(quelleText = new UILabel());
        this.add(quelle = new UITextField(listener));
        this.add(akteurText = new UILabel());
        this.add( akteur = new UITextField(listener));
        this.add(beschreibungText = new UILabel());
        this.add(beschreibung = new UITextField(listener));
        this.add(verweiseText = new UILabel());
        this.add(verweise = new UITextField(listener));
    }

    /**
     * Größe der Komponenten und Inhalt setzen
     */
    private void setComponents(){
        title.setForeground(Color.BLUE);
        delete.setText("Löschen");
        idText.setText(DefaultValues.ID);
        nameText.setText(DefaultValues.PRODUKTFUNKTION_NAME);
        quelleText.setText(DefaultValues.PRODUKTFUNKTION_QUELLE);
        akteurText.setText(DefaultValues.PRODUKTFUNKTION_AKTEUR);
        beschreibungText.setText(DefaultValues.PRODUKTFUNKTION_BESCHREIBUNG);
        verweiseText.setText(DefaultValues.VERWEISE);
    }

    /**
     * Aktualisiert alle dazugehörigen UI Komponenten mit den neuen Daten des Models.
     * @param model Instanz des Models des MVC-Patterns
     */
    @Override
    public void update(IModel model){
            DataProduktFunktion newFunktion = model.getIDataAnforderungssammlung().getDataProduktFunktionen().get(dataId);
            id.setText(dataId.getId());
            name.setText(newFunktion.getName());
            quelle.setText(newFunktion.getQuelle());
            akteur.setText(newFunktion.getAkteur());
            beschreibung.setText(newFunktion.getBeschreibung());
            verweise.setText(newFunktion.getVerweise());
            title.setText(newFunktion.getId().getId());
    }

    /**
     * Getter Methode für ID der Produktfunktion
     * @return DataId der Produktfunktion
     */
    public DataId getId(){
        return this.dataId;
   }
}

