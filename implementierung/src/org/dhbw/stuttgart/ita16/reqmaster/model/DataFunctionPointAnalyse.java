package org.dhbw.stuttgart.ita16.reqmaster.model;


import java.util.Map;

public class DataFunctionPointAnalyse implements IDataFunctionPointAnalyse {

	private Map<IIdentifiable, IDataFunctionPointEinstufung> einstufungen;
	private double realerAufwand, aufwandFp, aufwandMm;

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


    @Override
	public double getAufwandInFP() {
		return aufwandFp;
	}

	@Override
	public void setAufwandInFP(double aufwandFp) {
		this.aufwandFp = aufwandFp;
	}

	@Override
	public double getAufwandInMM() {
		return aufwandMm;
	}

	@Override
	public void setAufwandInMM(double aufwandMm) {
		this.aufwandMm = aufwandMm;
	}
}
