package org.dhbw.stuttgart.ita16.reqmaster.components;


@FunctionalInterface
public interface UIListenerChoiceSelected<T> {

    void selectedChoice(UIChoice component, T choice);

}
