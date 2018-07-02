package org.dhbw.stuttgart.ita16.reqmaster.model;


public interface IDataFunctionPointAnalyse {


	double getAufwandInFP();
	double getAufwandInMM();
	double getRealerAufwand();

	void setRealerAufwand(double d);
	void setAufwandInFP(double d);
	void setAufwandInMM(double d);

	double getSummeAufwand();
	void setSummeAufwand(double summeAufwand);

	double getSummEinflussFaktoren();
	void setSummEinflussFaktoren(double summEinflussFaktoren);

	double getFaktorEinflussBewertung() ;
	void setFaktorEinflussBewertung(double faktorEinflussBewertung);

	IDataFunctionPointEinstufung getEinstufung(IIdentifiable iIdentifiable);

}
