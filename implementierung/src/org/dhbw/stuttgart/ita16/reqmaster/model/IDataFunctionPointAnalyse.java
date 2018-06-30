package org.dhbw.stuttgart.ita16.reqmaster.model;

import java.io.*;
import java.util.*;

public interface IDataFunctionPointAnalyse {


	double getRealerAufwand();

	void setRealerAufwand(double d);

	IDataFunctionPointEinstufung getEinstufung(IIdentifiable iIdentifiable);

}
