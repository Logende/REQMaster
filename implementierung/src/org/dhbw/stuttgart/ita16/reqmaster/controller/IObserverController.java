package org.dhbw.stuttgart.ita16.reqmaster.controller;

import org.dhbw.stuttgart.ita16.reqmaster.events.*;

/**
 * Interface für den Controller als Observer von Events.
 * Die View besitzt im Rahmen des MVC pattern eine Referenz eines solchen ObserverControllers,
 * damit sie Events an den Controller reichen kann.
 */
public interface IObserverController {

	/**
	 * Sendet Event an ObserverController.
	 * @param event Event, dass ObserverController vearbeiten soll
	 */
	void observe(UIEvent event);

}
