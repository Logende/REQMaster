package org.dhbw.stuttgart.ita16.reqmaster.model;

import java.io.File;
import java.util.*;

public class DataFunctionPointAnalyse implements IDataFunctionPointAnalyse {

	private Map<IIdentifiable, IDataFunctionPointEinstufung> einstufungen;
	private double realerAufwand;
	private IModel model;

	public DataFunctionPointAnalyse(IModel model, Map<IIdentifiable, IDataFunctionPointEinstufung> einstufungen, double realerAufwand) {
		this.einstufungen = einstufungen;
		this.realerAufwand = realerAufwand;
		this.model = model;
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
        	return DefaultValues.getDefaultEinstufung(iIdentifiable);
		}
    }
}
