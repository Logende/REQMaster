package org.dhbw.stuttgart.ita16.reqmaster.view;

import org.dhbw.stuttgart.ita16.reqmaster.components.*;
import org.dhbw.stuttgart.ita16.reqmaster.events.UIActionDeleteProduktDatumEvent;
import org.dhbw.stuttgart.ita16.reqmaster.events.UIEvent;
import org.dhbw.stuttgart.ita16.reqmaster.events.UIModifyProduktDatumEvent;
import org.dhbw.stuttgart.ita16.reqmaster.model.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Grafikkomponente: Ermöglicht es dem Anwender, ein Produktdatum seiner Anforderungssammlung zu definieren.
 */
public class UIProduktDatum extends UIPanel implements IUIUpdateable {

    //Variablen der Klasse
    private final DataId dataId; //always the real DataId instance, as being used within the model
    private UILabel title;
    private UIButton delete;
    private UIButton addAttr;
    private UIButton deleteAttr;
    private UITextField name;
    private UITextField id;
    private UITextField attribute;
    private UITextField verweise;
    private UILabel nameText;
    private UILabel idText;
    private UILabel attributeText;
    private UILabel verweiseText;
    private UIList attributList;
    private DefaultListModel<String> attributModel;
    private UIPanel datumPanel;
    private UIScrollPane scrollPaneAttr;

    /**
     * Konstruktor der Klasse
     * @param view Instanz der View des MVC-Patterns
     * @param dataId ID des Produktdatums
     */
    public UIProduktDatum (IView view, DataId dataId) {
        super(view);
        this.dataId = dataId;

        //Settings
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        addComponents();
        setComponents();
        this.update(view.getModel());
        this.setVisible(true);

        /**Definition eines ActionListeners für den Delete Button, der ein Event an den Controller schickt,
         * um ein Produktdatum zu löschen
         */
        delete.addActionListener(new ActionListenerEventTriggering(view) {
            @Override
            public UIEvent generateEvent(Object source) {
                return new UIActionDeleteProduktDatumEvent(dataId);
            }
            @Override
            public void finishedAction(){
                View.forcesFocus = null;
            }
        });


        /**
         * Definition eines ActionListeners, um ein Attribut zu einem Produktdatum hinzuzufügen,
         * wenn Button gedrückt wird
         */
        addAttr.addActionListener(new ActionListenerEventTriggering(view) {
            @Override
            public UIEvent generateEvent(Object source) {
                attributModel.addElement(attribute.getText());
                return UIProduktDatum.this.generateModifyEvent();
            }
        });

        /**
         * Definition eines ActionListeners, um ein Attribut von einem Produktdatum zu entfernen,
         * wenn Button gedrückt wird
         */
        deleteAttr.addActionListener(new ActionListenerEventTriggering(view) {
            @Override
            public UIEvent generateEvent(Object source) {
                attributModel.remove(attributList.getSelectedIndex());
                return UIProduktDatum.this.generateModifyEvent();
            }
        });
    }

    /**
     * Hinzufügen der Grafikkomponenten sowie Definition eines FokusListener
     */
    private void addComponents() {
        /**
         * Für jedes UITextField in ProduktDatum wird einmalig ein
         * FocusListener definiert, den die Textfelder im Konstruktor übergeben bekommen
         */
        FocusListenerEventTriggering listener = new FocusListenerEventTriggering(getView()) {
            @Override
            public UIEvent generateEvent(Component lostFocus, Component gotFocus) {
                return UIProduktDatum.this.generateModifyEvent();
            }
        };
        //Panel mit Gridlayout fuer alles ausser Attribute
        datumPanel = new UIPanel();
        datumPanel.add(new UILabel());
        datumPanel.add(new UILabel());
        datumPanel.add(new UILabel());
        datumPanel.add(new UILabel());
        datumPanel.add(title = new UILabel());
        datumPanel.add(delete = new UIButton());
        datumPanel.add(idText = new UILabel());
        datumPanel.add(id = new UITextField(listener));
        datumPanel.add(nameText = new UILabel());
        datumPanel.add(name = new UITextField(listener));
        datumPanel.add(verweiseText = new UILabel());
        datumPanel.add(verweise = new UITextField(listener));
        datumPanel.add(new UILabel());
        datumPanel.add(new UILabel());
        datumPanel.add(attributeText = new UILabel());
        datumPanel.add(attribute = new UITextField(listener));
        datumPanel.add(addAttr = new UIButton());
        datumPanel.add(deleteAttr = new UIButton());
        this.add(datumPanel);

        //Aufbau der Attributliste
        attributModel = new DefaultListModel<>();
        attributList = new UIList(attributModel);
        scrollPaneAttr = new UIScrollPane(attributList, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        this.add(scrollPaneAttr);
    }

    private UIEvent generateModifyEvent(){
        // Erstellen einer Liste mit den aktuellen Attributen
        List<DataAttribut> dataAttributeList = new ArrayList<>();
        for(int i = 0; i< attributModel.size(); i++){
            String attribut = attributModel.elementAt(i);
            dataAttributeList.add(new DataAttribut(attribut));
        }
        //Erstellen des geänderten Produktdatums und des Events
        DataProduktDatum proposal = new DataProduktDatum(name.getText(), new DataId(id.getText()), dataAttributeList, verweise.getText());
        UIModifyProduktDatumEvent modifyEvent = new UIModifyProduktDatumEvent(dataId, proposal);
        return modifyEvent;
    }

    /**
     *  Methode zum Setzen des Inhalts der Komponenten sowie weitere Einstellungen der Komponenten
     */
    private void setComponents() {
        datumPanel.setLayout(new GridLayout(9,2));
        delete.setText("Löschen");
        addAttr.setText("Attribut hinzufügen");
        deleteAttr.setText("Attribut löschen");
        nameText.setText(DefaultValues.PRODUKTDATUM_NAME);
        idText.setText(DefaultValues.ID);
        attributeText.setText(DefaultValues.PRODUKTDATUM_ATTRIBUTE);
        verweiseText.setText(DefaultValues.PRODUKTDATUM_VERWEISE);
        title.setForeground(Color.BLUE);
        attributList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        attributList.setSelectedIndex(0);
    }

    /**
     * Aktualisiert alle dazugehörigen UI Komponenten mit den neuen Daten des Models.
     * @param model Instanz des Models des MVC-Patterns
     */
    @Override
    public void update(IModel model){
        DataProduktDatum newDatum = model.getIDataAnforderungssammlung().getDataProduktDaten().get(dataId);
        this.title.setText(dataId.getId());
        this.id.setText(dataId.getId());
        this.name.setText(newDatum.getName());
        this.verweise.setText(newDatum.getVerweise());
        this.attributModel.removeAllElements();
        for(DataAttribut dataAttribut: newDatum.getAttribute()){
            attributModel.addElement(dataAttribut.getName());
        }
    }

    /**
     * Getter Methode für die ID des Produktdatums
     * @return DataId des Produktdatum
     */
    public DataId getId() {
        return dataId;
    }

}
