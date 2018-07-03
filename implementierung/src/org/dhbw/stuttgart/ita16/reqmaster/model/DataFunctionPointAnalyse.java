package org.dhbw.stuttgart.ita16.reqmaster.model;


import java.util.Map;

/**
 * Datenstruktur einer FunctionPoint analyse.
 */
public class DataFunctionPointAnalyse implements IDataFunctionPointAnalyse {

    //durch Anwender eingegebene Einstufungen der versch. ProduktDaten/-Funktionen in Funktionstyp, Klassifizierung und Komplexität
	private Map<IIdentifiable, IDataFunctionPointEinstufung> einstufungen;

	//wird durch Anwender eingegeben
	private double realerAufwand;

	//wird durch Programm ermittelt
	private double summeAufwand, summEinflussFaktoren, faktorEinflussBewertung, aufwandFp, aufwandMm;

	public DataFunctionPointAnalyse(Map<IIdentifiable, IDataFunctionPointEinstufung> einstufungen, double realerAufwand) {
		this.einstufungen = einstufungen;
		this.realerAufwand = realerAufwand;
	}


	@Override
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

    @Override
    public double getSummeAufwand() {
        return summeAufwand;
    }

    @Override
    public void setSummeAufwand(double summeAufwand) {
        this.summeAufwand = summeAufwand;
    }

    @Override
    public double getSummEinflussFaktoren() {
        return summEinflussFaktoren;
    }

    @Override
    public void setSummEinflussFaktoren(double summEinflussFaktoren) {
        this.summEinflussFaktoren = summEinflussFaktoren;
    }

    @Override
    public double getFaktorEinflussBewertung() {
        return faktorEinflussBewertung;
    }

    @Override
    public void setFaktorEinflussBewertung(double faktorEinflussBewertung) {
        this.faktorEinflussBewertung = faktorEinflussBewertung;
    }
}
