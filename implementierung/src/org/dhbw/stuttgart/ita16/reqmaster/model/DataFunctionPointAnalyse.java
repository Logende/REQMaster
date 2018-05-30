package org.dhbw.stuttgart.ita16.reqmaster.model;

import java.io.*;
import java.util.*;

public class DataFunctionPointAnalyse implements IDataFunctionPointAnalyse {

	private Map<IIdentifiable, IDataFunctionPointClassification> map;
	private double realerAufwand;

	public DataFunctionPointAnalyse(Map<IIdentifiable, IDataFunctionPointClassification> map, double realerAufwand) {
		this.map = map;
		this.realerAufwand = realerAufwand;
	}

	public void init(List<IIdentifiable> list, IDataSchaetzKonfiguration gewichtsfaktoren) {
		throw new UnsupportedOperationException("The method is not implemented yet.");
	}

	public double getRealerAufwand() {
		return this.realerAufwand;
	}

}
