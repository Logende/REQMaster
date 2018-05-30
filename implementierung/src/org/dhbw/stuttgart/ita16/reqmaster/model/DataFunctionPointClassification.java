package org.dhbw.stuttgart.ita16.reqmaster.model;

import java.io.*;
import java.util.*;

public class DataFunctionPointClassification implements IDataFunctionPointClassification {

	private FPFunktionsTyp funktionstyp;
	private FPKlassifzierung klassifizierung;
	private FPKomplexitaet komplexitaet;

	public FPFunktionsTyp getFunktionsTyp() {
		return funktionstyp;

	}

	public FPKlassifzierung getKlassifizierung() {
		return klassifizierung;

	}

	public FPKomplexitaet getKomplexitaet() {
		return komplexitaet;

	}

	public void setFunktionsTyp(FPFunktionsTyp typ) {

	}

	public boolean setKlassifizierung(FPKlassifzierung klassifizierung) {
		return true;
	}

	public void setKomplexitaet(FPKomplexitaet komplexitaet) {

	}

}
