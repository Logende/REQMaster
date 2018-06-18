package org.dhbw.stuttgart.ita16.reqmaster.model;

import java.util.*;

public class DataFunctionPointAnalyse implements IDataFunctionPointAnalyse {

	private Map<IIdentifiable, IDataFunctionPointEinstufung> map;
	private double realerAufwand;

	public DataFunctionPointAnalyse(Map<IIdentifiable, IDataFunctionPointEinstufung> map, double realerAufwand) {
		this.map = map;
		this.realerAufwand = realerAufwand;
	}

	public void init(List<IIdentifiable> list, IDataSchaetzKonfiguration gewichtsfaktoren) {
		throw new UnsupportedOperationException("The method is not implemented yet.");
	}

	public double getRealerAufwand() {
		return this.realerAufwand;
	}

	public IDataFunctionPointEinstufung getClassification(IIdentifiable iIdentifiable){
		return map.get(iIdentifiable);
	}

}
