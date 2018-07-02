package org.dhbw.stuttgart.ita16.reqmaster.controller;

import org.dhbw.stuttgart.ita16.reqmaster.model.IModel;

public interface IAufwandRechner {

    void calculateAufwand(IModel model, double vaf);

    void optimiereFaktor(IModel model, double vaf, int index);
}
