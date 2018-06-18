package org.dhbw.stuttgart.ita16.reqmaster.model;

import java.io.*;
import java.util.*;

public interface IDataFunctionPointAnalyse {

	void init(List<IIdentifiable> list, IDataSchaetzKonfiguration gewichtsfaktoren);

	void setSchaetzKonfiguration(IDataSchaetzKonfiguration gewichtsfaktoren);

	double getRealerAufwand();

	void setRealerAufwand(double d);

	IDataFunctionPointEinstufung getEinstufung(IIdentifiable id);

}
