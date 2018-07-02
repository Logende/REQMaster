package org.dhbw.stuttgart.ita16.reqmaster.controller;

import org.dhbw.stuttgart.ita16.reqmaster.model.IModel;

public interface IAufwandRechner {

    double calculateAufwandInFP(IModel model);
    double calculateAufwandInMM(IModel model);
}
