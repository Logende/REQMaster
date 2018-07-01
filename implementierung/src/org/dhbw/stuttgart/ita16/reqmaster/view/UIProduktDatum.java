package org.dhbw.stuttgart.ita16.reqmaster.view;

import org.dhbw.stuttgart.ita16.reqmaster.components.*;
import org.dhbw.stuttgart.ita16.reqmaster.events.UIActionDeleteProduktDatumEvent;
import org.dhbw.stuttgart.ita16.reqmaster.events.UIModifyProduktDatumEvent;
import org.dhbw.stuttgart.ita16.reqmaster.model.DataAttribut;
import org.dhbw.stuttgart.ita16.reqmaster.model.DataId;
import org.dhbw.stuttgart.ita16.reqmaster.model.DataProduktDatum;
import org.dhbw.stuttgart.ita16.reqmaster.model.IModel;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;


/**
 * Grafikkomponente: legt Aufbau eines Produktdatums fest
 */
public class UIProduktDatum extends UIPanel implements IUIUpdateable {

    //Variablen der Klasse
    private final DataId dataId; //always the real DataId instance, as being used within the model
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
    private UIPanel attributPanel;
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
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        // Definition eines ActionListeners für den Delete Button, der ein Event an den Controller schickt,
        // um ein Produktdatum zu löschen
        delete.addActionListener(actionEvent -> {
            if(View.forcesFocus == null || UIProduktDatum.this == View.forcesFocus) {
                getView().getObsController().observe(new UIActionDeleteProduktDatumEvent(dataId));
                View.forcesFocus = null;
            }
        });
    }

    /**
     * Hinzufügen der Grafikkomponenten sowie Definition eines FokusListener
     */
    private void addComponents() {

        // Für jedes UITextField in ProduktDatum wird einmalig ein
        // FocusListener definiert, den die Textfelder im Konstruktor übergeben bekommen
        UIListenerComponentLostFocus listener = (focusLost, focusGained) -> {
                if(focusGained != null) {
                    if (focusLost.getParent() == focusGained.getParent()) {
                        return; //do nothing if new component has same parent
                    }
                }
                DataProduktDatum proposal = new DataProduktDatum(name.getText(), new DataId(id.getText()), new ArrayList<>(), verweise.getText());
                UIModifyProduktDatumEvent modifyEvent = new UIModifyProduktDatumEvent(dataId, proposal);
                getView().getObsController().observe(modifyEvent);
                if(!modifyEvent.isSuccess()){
                    View.forcesFocus = UIProduktDatum.this;
                   focusLost.requestFocus();
                }else{
                    View.forcesFocus = null;
                }
            };

        this.add(datumPanel = new UIPanel());
        attributPanel = new UIPanel();
        attributModel = new DefaultListModel<String>();
        attributPanel.add(attributList = new UIList(attributModel = new DefaultListModel<String>()), BorderLayout.WEST);
        this.add(scrollPaneAttr = new UIScrollPane(attributList,
                ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER));
        scrollPaneAttr.add(attributPanel);
        datumPanel.add(new UILabel());
        datumPanel.add(new UILabel());
        datumPanel.add(new UILabel());
        datumPanel.add(delete = new UIButton());
        datumPanel.add(idText = new UILabel());
        datumPanel.add(id = new UITextField(listener));
        datumPanel.add(nameText = new UILabel());
        datumPanel.add(name = new UITextField(listener));
        datumPanel.add(verweiseText = new UILabel());
        datumPanel.add(verweise = new UITextField(listener));
        datumPanel.add(new UILabel());
        datumPanel.add(new UILabel());
        datumPanel.add(addAttr = new UIButton());
        datumPanel.add(deleteAttr = new UIButton());
        datumPanel.add(attributeText = new UILabel());
        datumPanel.add(attribute = new UITextField(listener));

    }

    /**
     *  Methode zum Setzen des Inhalts der Komponenten
     */
    private void setComponents() {
        delete.setText("Löschen");
        addAttr.setText("Attribut hinzufügen");
        deleteAttr.setText("Attribut löschen");
        nameText.setText("Name");
        idText.setText("ID");
        attributeText.setText("Attribut");
        verweiseText.setText("Verweise");

        datumPanel.setLayout(new GridLayout(8,2));
        attributPanel.setLayout(new BorderLayout());
        attributList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        attributList.setSelectedIndex(0);
        attributList.setPreferredSize(new Dimension(20,50));


        attributModel.addElement("bla");
        attributModel.addElement("asdf");
        attributModel.addElement("asdf");
        attributModel.addElement("bla");
        attributModel.addElement("asdf");
        attributModel.addElement("asdf");

    }

    /**
     * Implementierung der Update-Methode
     * wenn sich ein Produktdatum geändert hat, wird diese Methode aufgerufen,
     * um die GUI zu aktualisieren
     * @param model Instanz des Models des MVC-Patterns
     */
    @Override
    public void update(IModel model){
        DataProduktDatum newDatum = model.getIDataAnforderungssammlung().getDataProduktDaten().get(dataId);
        this.id.setText(dataId.getId());
        this.name.setText(newDatum.getName());
        this.verweise.setText(newDatum.getVerweise());
        this.attributModel.removeAllElements();
        List<DataAttribut> newAttribute = newDatum.getAttribute();

        for(DataAttribut i: newAttribute){
            attributModel.addElement(i.);
        }
    }

    /**
     * getter-Methode für die ID des Produktdatums
     * @return DataId des Produktdatum
     */
    public DataId getId() {
        return dataId;
    }
}
