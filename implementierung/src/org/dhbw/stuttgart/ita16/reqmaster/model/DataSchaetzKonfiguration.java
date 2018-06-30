package org.dhbw.stuttgart.ita16.reqmaster.model;

import java.util.Map;

public class DataSchaetzKonfiguration implements IDataSchaetzKonfiguration {


	private Map<FPKlassifizierung, Map<FPKomplexitaet, Double>> gewichte;

	public DataSchaetzKonfiguration(Map<FPKlassifizierung, Map<FPKomplexitaet, Double>> gewichte){
		this.gewichte = gewichte;
	}

	@Override
	public double getGewicht(FPKlassifizierung klassifizierung, FPKomplexitaet komplexitaet) {
		return gewichte.get(klassifizierung).get(komplexitaet);
	}

	@Override
	public void setGewicht(FPKlassifizierung klassifizierung, FPKomplexitaet komplexitaet, double d){
		gewichte.get(klassifizierung).put(komplexitaet, d);
	}
}
