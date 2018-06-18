package org.dhbw.stuttgart.ita16.reqmaster.model;

public interface IDataFunctionPointClassification {

	FPFunktionsTyp getFunktionsTyp();

	FPKlassifizierung getKlassifizierung();

	FPKomplexitaet getKomplexitaet();

	void setFunktionsTyp(FPFunktionsTyp typ);

	boolean setKlassifizierung(FPKlassifizierung klassifizierung);

	void setKomplexitaet(FPKomplexitaet komplexitaet);

}
