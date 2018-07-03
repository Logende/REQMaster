package org.dhbw.stuttgart.ita16.reqmaster.components;

import javax.swing.*;

/**
 * Adaption der Swing JButton-Klasse fuer individuelle Anpassungen an das Projekt
 * @param <T> generischer Parameter: Combobox kann verschiedene Objekte aufnehmen
 */
public class UIChoice<T> extends JComboBox{

    /**
     * Konstruktor der Klasse
     * @param choices Array mit den Auswahlmöglichkeiten in der Combobox
     */
    public UIChoice(T[] choices){
        this(choices, null);
    }

    /**
     * Konstruktor der Klasse
     * @param choices Array mit den Auswahlmöglichkeiten in der Combobox
     * @param listener ein Listener für d
     */
    public UIChoice(T[] choices, UIListenerChoiceSelected<T> listener){
        super(choices);
        this.addItemListener(event -> {
            if(this.getSelectedItem() != null && listener != null) {
                listener.selectedChoice(UIChoice.this, (T) UIChoice.this.getSelectedItem());
            }
        });
    }

    /**
     * Setter Methode fuer das selektierte Item in der ComboBox
     * @param item ausgewähltes Element in der Combobox
     */
    public void setChoice(T item){
        if(getSelectedItem() != item) {
            setSelectedItem(item);
        }
    }
}
