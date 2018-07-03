package org.dhbw.stuttgart.ita16.reqmaster.controller;

import org.dhbw.stuttgart.ita16.reqmaster.model.*;


/**
 * Interface für Validator, der User Input bzw. Vorschläge des User für neue Model-Werte validiert.
 * Verwendet vom Controller um User Input zu prüfen und zu akzeptieren/ablehnen.
 */
public interface IValidator {

	/**
	 * Prüft ob Eingabewerte valide sind.
	 * @param model
	 * @param current
	 * @param proposal
	 * @return null falls valide; Fehlermeldung (String), falls invalide
	 */
	String isValid(IModel model, DataProduktDatum current, DataProduktDatum proposal);

	/**
	 * Prüft ob Eingabewerte valide sind.
	 * @param model
	 * @param proposal
	 * @return null falls valide; Fehlermeldung (String), falls invalide
	 */
	String isValid(IModel model, DataZielbestimmung proposal);

	/**
	 * Prüft ob Eingabewerte valide sind.
	 * @param model
	 * @param proposal
	 * @return null falls valide; Fehlermeldung (String), falls invalide
	 */
	String isValid(IModel model, DataProdukteinsatz proposal);

	/**
	 * Prüft ob Eingabewerte valide sind.
	 * @param model
	 * @param proposal
	 * @return null falls valide; Fehlermeldung (String), falls invalide
	 */
	String isValid(IModel model, DataUmgebung proposal);

	/**
	 * Prüft ob Eingabewerte valide sind.
	 * @param model
	 * @param current
	 * @param proposal
	 * @return null falls valide; Fehlermeldung (String), falls invalide
	 */
	String isValid(IModel model, DataProduktFunktion current, DataProduktFunktion proposal);

	/**
	 * Prüft ob Eingabewerte valide sind.
	 * @param model
	 * @param current
	 * @param proposal
	 * @param iIdentifiable
	 * @return null falls valide; Fehlermeldung (String), falls invalide
	 */
	String isValid(IModel model, IDataFunctionPointEinstufung current, IDataFunctionPointEinstufung proposal, IIdentifiable iIdentifiable);

	/**
	 * Prüft ob Eingabewerte valide sind.
	 * @param model
	 * @param realerAufwand
	 * @return null falls valide; Fehlermeldung (String), falls invalide
	 */
	String isValid(IModel model, double realerAufwand);

	/**
	 * Prüft ob Eingabewerte valide sind.
	 * @param model
	 * @param schaetzKonfiguration
	 * @return null falls valide; Fehlermeldung (String), falls invalide
	 */
	String isValid(IModel model, IDataSchaetzKonfiguration schaetzKonfiguration);

}
