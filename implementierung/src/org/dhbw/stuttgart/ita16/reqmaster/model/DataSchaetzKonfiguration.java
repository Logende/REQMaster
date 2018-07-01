package org.dhbw.stuttgart.ita16.reqmaster.model;

import java.util.Map;

public class DataSchaetzKonfiguration implements IDataSchaetzKonfiguration {


	private Map<FPKlassifizierung, Map<FPKomplexitaet, Double>> gewichte1;
	private double[] gewichte2;

	public DataSchaetzKonfiguration(Map<FPKlassifizierung, Map<FPKomplexitaet, Double>> gewichte1, double gewichte2[]){
		this.gewichte1 = gewichte1;
		this.gewichte2 = gewichte2;
	}


	@Override
	public double getGewicht1(FPKlassifizierung klassifizierung, FPKomplexitaet komplexitaet) {
		return gewichte1.get(klassifizierung).get(komplexitaet);
	}

	@Override
	public void setGewichte1(Map<FPKlassifizierung, Map<FPKomplexitaet, Double>> gewichte) {
		this.gewichte1 = gewichte;
	}

	@Override
	public double getGewicht2(int i) {
		return gewichte2[i];
	}

	@Override
	public void setGewichte2(double[] gewichte) {
		this.gewichte2 = gewichte;
	}
}
