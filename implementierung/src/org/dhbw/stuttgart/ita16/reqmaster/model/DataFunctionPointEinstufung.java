package org.dhbw.stuttgart.ita16.reqmaster.model;

public class DataFunctionPointEinstufung implements IDataFunctionPointEinstufung {

	private FPFunktionsTyp funktionstyp;
	private FPKlassifizierung klassifizierung;
	private FPKomplexitaet komplexitaet;

	public DataFunctionPointEinstufung(FPFunktionsTyp funktionstyp, FPKlassifizierung klassifizierung, FPKomplexitaet komplexitaet) {
		this.funktionstyp = funktionstyp;
		this.klassifizierung = klassifizierung;
		this.komplexitaet = komplexitaet;
	}

	@Override
	public FPFunktionsTyp getFunktionstyp() {
		return funktionstyp;
	}

	@Override
	public void setFunktionstyp(FPFunktionsTyp funktionstyp) {
		this.funktionstyp = funktionstyp;
	}

	@Override
	public FPKlassifizierung getKlassifizierung() {
		return klassifizierung;
	}

	@Override
	public void setKlassifizierung(FPKlassifizierung klassifizierung) {
		this.klassifizierung = klassifizierung;
	}

	@Override
	public FPKomplexitaet getKomplexitaet() {
		return komplexitaet;
	}

	@Override
	public void setKomplexitaet(FPKomplexitaet komplexitaet) {
		this.komplexitaet = komplexitaet;
	}

	@Override
	public void modify(IDataFunctionPointEinstufung goal) {
		this.funktionstyp = goal.getFunktionstyp();
		this.klassifizierung = goal.getKlassifizierung();
		this.komplexitaet = goal.getKomplexitaet();
	}
}
