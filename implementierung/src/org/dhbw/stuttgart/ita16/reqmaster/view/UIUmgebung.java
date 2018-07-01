package org.dhbw.stuttgart.ita16.reqmaster.view;

import org.dhbw.stuttgart.ita16.reqmaster.components.UIPanel;
import org.dhbw.stuttgart.ita16.reqmaster.components.UIScrollPane;
import org.dhbw.stuttgart.ita16.reqmaster.components.UITextArea;
import org.dhbw.stuttgart.ita16.reqmaster.events.UIModifyUmgebungEvent;
import org.dhbw.stuttgart.ita16.reqmaster.model.DataUmgebung;
import org.dhbw.stuttgart.ita16.reqmaster.model.IModel;

import javax.swing.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

/**
 * Grafikkomponente: Ermöglicht es, die Umgebung der Anforderungssammlung zu definieren.
 */
public class UIUmgebung extends UIPanel implements IUIUpdateable {

    //Variablen der Klasse
    private UITextArea text;
    private UIScrollPane scrollPane;

    /**
     * Konstruktor der Klasse
     * @param view Instanz der View des MVC-Patterns
     */
    public UIUmgebung(IView view) {
        super(view);
        //Initialisierung
        text = new UITextArea();
        scrollPane = new UIScrollPane(text, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        //Settings
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(scrollPane);
        this.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder("Umgebung"),
                BorderFactory.createEmptyBorder(30,10,20,10)));
        this.setVisible(true);
        text.setLineWrap(true);

        //Definition eines FocusListeners für TextArea
        text.addFocusListener(new FocusListener() {

            @Override
            public void focusGained(FocusEvent e) { }
            /**
             * Wenn der Fokus verloren wird, werden alle Daten-Änderungen über ein Modify-Event an den Controller gereicht.
             * Der Controller kann bei invaliden Daten das Event ablehnen, woraufhin die Komponente den Fokus erneut anfordert,
             * damit der Anwender valide Daten eingibt.
             * @param e auf zu reagierendes Event
             */
            @Override
            public void focusLost(FocusEvent e) {
               UIModifyUmgebungEvent modifyEvent;
                getView().getObsController().observe(modifyEvent =
                        new UIModifyUmgebungEvent(new DataUmgebung(text.getText())));
               if(!(modifyEvent.isSuccess())){
                   View.forcesFocus = UIUmgebung.this;
                   text.requestFocus();	//Abfrage, ob Änderung valide ist, ansonsten Fokus auf TextArea behalten
               }else{
                   View.forcesFocus = null;
               }
            }
        });

    }

    /**
     * updatet den Inhalt des Textfeldes
     * @param model Model des MVC-Patterns
     */
    public void update(IModel model) {
        text.setText(model.getIDataAnforderungssammlung().getDataUmgebung().getText());
    }

}
