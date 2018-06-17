package org.dhbw.stuttgart.ita16.reqmaster.controller;

import org.dhbw.stuttgart.ita16.reqmaster.events.UIEvent;
import org.dhbw.stuttgart.ita16.reqmaster.model.IModel;
import org.dhbw.stuttgart.ita16.reqmaster.view.IView;

@FunctionalInterface
public interface EventReaction<T extends UIEvent> {

    /**
     * Reacts to the given event.
     * @param model Model.
     * @param view View.
     * @param event Event to react to.
     * @return true if event reaction has modified data in model
     */
    boolean react(IModel model, IView view, T event);
}
