package org.dhbw.stuttgart.ita16.reqmaster.view;

import org.dhbw.stuttgart.ita16.reqmaster.controller.IObserverController;
import org.dhbw.stuttgart.ita16.reqmaster.model.IModel;

public interface IView {

    public IModel getModel();

    public IObserverController getObsController();
}
