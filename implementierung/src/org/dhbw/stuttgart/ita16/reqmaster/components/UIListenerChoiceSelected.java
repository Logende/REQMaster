package org.dhbw.stuttgart.ita16.reqmaster.components;

@FunctionalInterface
/**
 * Choice Listener, der #selectedChoice aufruft, sobald eine neue "Choice" (Auswahl) bei einer UIChoice Komponente
 * (modifizierte Kombobox) ausgewählt wurde.
 */
public interface UIListenerChoiceSelected<T> {

    /**
     * Wird aufgerufen, wenn neue Choice ausgewählt wurde
     * @param component Betroffene UIChoice
     * @param choice Auswahl des Anwenders
     */
    void selectedChoice(UIChoice component, T choice);

}
