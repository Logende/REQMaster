package org.dhbw.stuttgart.ita16.reqmaster.controller;

import org.dhbw.stuttgart.ita16.reqmaster.model.*;


/**
 * Interface for validators, which validate user input for the model.
 * Used by the controller to validate user input and deny invalid input.
 */
public interface IValidator {

	/**
	 * Checks whether proposal is valid.
	 * @param model
	 * @param current
	 * @param proposal
	 * @return null if valid, error message if invalid.
	 */
	String isValid(IModel model, DataProduktDatum current, DataProduktDatum proposal);

	/**
	 * Checks whether proposal is valid.
	 * @param model
	 * @param proposal
	 * @return
	 */
	String isValid(IModel model, DataZielbestimmung proposal);

	/**
	 * Checks whether proposal is valid.
	 * @param model
	 * @param proposal
	 * @return null if valid, error message if invalid.
	 */
	String isValid(IModel model, DataProdukteinsatz proposal);

	/**
	 * Checks whether proposal is valid.
	 * @param model
	 * @param proposal
	 * @return null if valid, error message if invalid.
	 */
	String isValid(IModel model, DataUmgebung proposal);

	/**
	 * Checks whether proposal is valid.
	 * @param model
	 * @param current
	 * @param proposal
	 * @return null if valid, error message if invalid.
	 */
	String isValid(IModel model, DataProduktFunktion current, DataProduktFunktion proposal);

	/**
	 * Checks whether proposal is valid.
	 * @param model
	 * @param current
	 * @param proposal
	 * @param iIdentifiable
	 * @return null if valid, error message if invalid.
	 */
	String isValid(IModel model, IDataFunctionPointEinstufung current, IDataFunctionPointEinstufung proposal, IIdentifiable iIdentifiable);

	/**
	 * Checks whether proposal is valid.
	 * @param model
	 * @param realerAufwand
	 * @return null if valid, error message if invalid.
	 */
	String isValid(IModel model, double realerAufwand);

	/**
	 * Checks whether proposal is valid.
	 * @param model
	 * @param schaetzKonfiguration
	 * @return null if valid, error message if invalid.
	 */
	String isValid(IModel model, IDataSchaetzKonfiguration schaetzKonfiguration);

}
