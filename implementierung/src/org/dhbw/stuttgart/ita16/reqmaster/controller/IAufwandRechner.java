package org.dhbw.stuttgart.ita16.reqmaster.controller;

import org.dhbw.stuttgart.ita16.reqmaster.model.IModel;

public interface IAufwandRechner {

    String calculateAufwand(IModel model, double vaf);

    String optimiereFaktor(IModel model, double vaf, int index);
}
