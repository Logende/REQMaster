package org.dhbw.stuttgart.ita16.reqmaster.controller;

import java.io.*;
import java.util.*;
import org.dhbw.stuttgart.ita16.reqmaster.model.*;

public interface IValidator {

	boolean isValid(IModel model, DataProduktDatum current, DataProduktDatum proposal);

	boolean isValid(IModel model, DataZielbestimmung proposal);

	boolean isValid(IModel model, DataProdukteinsatz proposal);

	boolean isValid(IModel model, DataProduktFunktion current, DataProduktFunktion proposal);

}
