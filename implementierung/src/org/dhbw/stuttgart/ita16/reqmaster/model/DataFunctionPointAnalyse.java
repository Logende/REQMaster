package org.dhbw.stuttgart.ita16.reqmaster.model;

import java.io.File;
import java.util.*;

public class DataFunctionPointAnalyse implements IDataFunctionPointAnalyse {

	private Map<IIdentifiable, IDataFunctionPointEinstufung> einstufungen;
	private double realerAufwand;

	public DataFunctionPointAnalyse(Map<IIdentifiable, IDataFunctionPointEinstufung> einstufungen, double realerAufwand) {
		this.einstufungen = einstufungen;
		this.realerAufwand = realerAufwand;
	}



	public double getRealerAufwand() {
		return this.realerAufwand;
	}

    @Override
    public void setRealerAufwand(double d) {
	    this.realerAufwand = d;
    }

    @Override
    public IDataFunctionPointEinstufung getEinstufung(IIdentifiable iIdentifiable) {
        if(einstufungen.containsKey(iIdentifiable)) {
			return einstufungen.get(iIdentifiable);
		}else{
        	IDataFunctionPointEinstufung einstufung = DefaultValues.getDefaultEinstufung(iIdentifiable);
        	einstufungen.put(iIdentifiable, einstufung);
        	return einstufung;
		}
    }
}
