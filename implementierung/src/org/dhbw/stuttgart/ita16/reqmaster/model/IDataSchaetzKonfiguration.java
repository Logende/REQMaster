package org.dhbw.stuttgart.ita16.reqmaster.model;

public interface IDataSchaetzKonfiguration {

	public double getGewicht(FPKlassifizierung klassifizierung, FPKomplexitaet komplexitaet);
	public void setGewicht(FPKlassifizierung klassifizierung, FPKomplexitaet komplexitaet, double d);

}
