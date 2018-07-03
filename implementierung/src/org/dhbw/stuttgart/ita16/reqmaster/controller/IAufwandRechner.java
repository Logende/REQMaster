package org.dhbw.stuttgart.ita16.reqmaster.controller;

import org.dhbw.stuttgart.ita16.reqmaster.model.IModel;

/**
 * AufwandRechner Interface.
 * Methoden um Aufwand in FP/MM zu berechnen und Gewichtsfaktoren zu optimieren.
 */
public interface IAufwandRechner {

    String calculateAufwand(IModel model, double vaf);

    String optimiereFaktor(IModel model, double vaf, int index);
}
