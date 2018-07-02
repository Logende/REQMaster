package org.dhbw.stuttgart.ita16.reqmaster.components;

import javax.swing.*;

public class UIChoice<T> extends JComboBox{

    public UIChoice(T[] choices){
        this(choices, null);
    }


    public UIChoice(T[] choices, UIListenerChoiceSelected<T> listener){
        super(choices);
        this.addItemListener(event -> {
            if(this.getSelectedItem() != null && listener != null) {
                listener.selectedChoice(UIChoice.this, (T) UIChoice.this.getSelectedItem());
            }
        });
    }

    public void setChoice(T item){
        if(getSelectedItem() != item) {
            setSelectedItem(item);
        }
    }

}
