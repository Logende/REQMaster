package org.dhbw.stuttgart.ita16.reqmaster.model;

public class DataFunctionPointClassification implements IDataFunctionPointClassification {

	private FPFunktionsTyp funktionstyp;
	private FPKlassifizierung klassifizierung;
	private FPKomplexitaet komplexitaet;

	public FPFunktionsTyp getFunktionsTyp() {
		return funktionstyp;

	}

	public FPKlassifizierung getKlassifizierung() {
		return klassifizierung;

	}

	public FPKomplexitaet getKomplexitaet() {
		return komplexitaet;

	}

	public void setFunktionsTyp(FPFunktionsTyp typ) {

	}

	public boolean setKlassifizierung(FPKlassifizierung klassifizierung) {
		return true;
	}

	public void setKomplexitaet(FPKomplexitaet komplexitaet) {

	}

}
