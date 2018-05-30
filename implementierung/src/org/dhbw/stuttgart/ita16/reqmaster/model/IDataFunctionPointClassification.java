package org.dhbw.stuttgart.ita16.reqmaster.model;

import java.io.*;
import java.util.*;

public interface IDataFunctionPointClassification {

	FPFunktionsTyp getFunktionsTyp();

	FPKlassifzierung getKlassifizierung();

	FPKomplexitaet getKomplexitaet();

	void setFunktionsTyp(FPFunktionsTyp typ);

	boolean setKlassifizierung(FPKlassifzierung klassifizierung);

	void setKomplexitaet(FPKomplexitaet komplexitaet);

}
