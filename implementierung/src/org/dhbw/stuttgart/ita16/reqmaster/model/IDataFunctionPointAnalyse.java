package org.dhbw.stuttgart.ita16.reqmaster.model;

import java.io.*;
import java.util.*;

public interface IDataFunctionPointAnalyse {

	void init(List<IIdentifiable> list, IDataSchaetzKonfiguration gewichtsfaktoren);

	double getRealerAufwand();

}
