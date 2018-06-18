package org.dhbw.stuttgart.ita16.reqmaster.model;

public interface IDataFunctionPointEinstufung {

	FPFunktionsTyp getFunktionstyp();

	FPKlassifizierung getKlassifizierung();

	FPKomplexitaet getKomplexitaet();

	void setFunktionstyp(FPFunktionsTyp typ);

	void setKlassifizierung(FPKlassifizierung klassifizierung);

	void setKomplexitaet(FPKomplexitaet komplexitaet);

	void modify(IDataFunctionPointEinstufung goal);

}
