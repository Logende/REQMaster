package org.dhbw.stuttgart.ita16.reqmaster.model;


public interface IDataFunctionPointAnalyse {


	double getAufwandInFP();
	double getAufwandInMM();
	double getRealerAufwand();

	void setRealerAufwand(double d);
	void setAufwandInFP(double d);
	void setAufwandInMM(double d);

	IDataFunctionPointEinstufung getEinstufung(IIdentifiable iIdentifiable);

}
