package org.dhbw.stuttgart.ita16.reqmaster.controller;

import org.dhbw.stuttgart.ita16.reqmaster.events.UIEvent;

@FunctionalInterface
public interface EventReaction<T extends UIEvent> {

    void react(IModel model, IView view, T event);
}
