package org.dhbw.stuttgart.ita16.reqmaster.controller;

import java.io.*;
import java.util.*;
import org.dhbw.stuttgart.ita16.reqmaster.model.*;

public interface IValidator {

	boolean isValid(IModel model, IIdentifiable currentId, DataProduktDatum proposal);

	boolean isValid(IModel model, DataZielbestimmung proposal);

	boolean isValid(IModel model, DataProdukteinsatz proposal);

	boolean isValid(IModel model, IIdentifiable currentId, DataProduktFunktion proposal);

}
