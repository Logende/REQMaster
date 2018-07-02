package org.dhbw.stuttgart.ita16.reqmaster.model;

import java.util.Map;

public interface IDataSchaetzKonfiguration {

	double getGewicht1(FPKlassifizierung klassifizierung, FPKomplexitaet komplexitaet);
	void setGewichte1(Map<FPKlassifizierung, Map<FPKomplexitaet, Double>> gewichte);

	double getGewicht2(int i);
	double[] getGewichte2();
	void setGewichte2(double[] gewichte);
	Map<FPKlassifizierung, Map<FPKomplexitaet, Double>> getGewichte1();

}
