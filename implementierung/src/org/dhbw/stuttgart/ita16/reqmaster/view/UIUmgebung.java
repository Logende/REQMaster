package org.dhbw.stuttgart.ita16.reqmaster.view;

import org.dhbw.stuttgart.ita16.reqmaster.components.FocusListenerEventTriggering;
import org.dhbw.stuttgart.ita16.reqmaster.components.UIPanel;
import org.dhbw.stuttgart.ita16.reqmaster.components.UIScrollPane;
import org.dhbw.stuttgart.ita16.reqmaster.components.UITextArea;
import org.dhbw.stuttgart.ita16.reqmaster.events.UIEvent;
import org.dhbw.stuttgart.ita16.reqmaster.events.UIModifyUmgebungEvent;
import org.dhbw.stuttgart.ita16.reqmaster.model.DataUmgebung;
import org.dhbw.stuttgart.ita16.reqmaster.model.DefaultValues;
import org.dhbw.stuttgart.ita16.reqmaster.model.IModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

/**
 * Grafikkomponente: Ermöglicht es dem Anwender, die Umgebung seiner Anforderungssammlung zu definieren.
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
        this.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder(DefaultValues.UMGEBUNG),
                BorderFactory.createEmptyBorder(30,10,20,10)));
        this.setVisible(true);
        text.setLineWrap(true);

        //Definition eines FocusListeners für TextArea
        text.addFocusListener(new FocusListenerEventTriggering(view) {
            @Override
            public UIEvent generateEvent(Component lostFocus, Component gotFocus) {
                return new UIModifyUmgebungEvent(new DataUmgebung(text.getText()));
            }
        });

    }

    /**
     * Aktualisiert die TextArea mit dem Wert im Model
     * @param model Istanz des Model des MVC-Patterns
     */
    public void update(IModel model) {
        text.setText(model.getIDataAnforderungssammlung().getDataUmgebung().getText());
    }
}
