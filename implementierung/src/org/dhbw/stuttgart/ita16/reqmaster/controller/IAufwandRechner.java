package org.dhbw.stuttgart.ita16.reqmaster.controller;

import org.dhbw.stuttgart.ita16.reqmaster.model.IModel;

/**
 * AufwandRechner Interface.
 * Methoden um Aufwand in FP/MM zu berechnen und Gewichtsfaktoren zu optimieren.
 */
public interface IAufwandRechner {

    /**
     * Berechnet den Aufwand in FP und MM auf Basis der Einstufungen der Produktfunktionen und Produktdaten, sowie
     * der Einflussfaktoren, welche im Model zwischengespeichert sind. Die Ergebnisse werden in das Model geschrieben.
     * @param model Model, welches relevante Daten für Aufwandsberechnung beinhaltet und in welches Ergebnisse geschrieben werden sollen
     * @param vaf Value adjustment factor, welcher Teil der FP Berechnungs-Formel ist
     * @return null bei Erfolg, Fehlermeldung sondt
     */
    String calculateAufwand(IModel model, double vaf);

    /**
     * Optimiert den ausgewählten Einflussfaktor (index) und setzt ihn auf den Wert, der benötigt wird, damit bei einer
     * MM Berechnung der eingegebene reale Aufwand erreicht wird.
     * @param model Model, welches relevante Daten für Aufwandsberechnung beinhaltet und in welches Ergebnisse geschrieben werden sollen
     * @param vaf Value adjustment factor, welcher Teil der FP Berechnungs-Formel ist
     * @param index Index welcher auf zu verändernden Gewichtsfaktor zeigt
     * @return
     */
    String optimiereFaktor(IModel model, double vaf, int index);
}
