package org.dhbw.stuttgart.ita16.reqmaster.model;

import java.io.*;
import java.util.*;

public class DataAnforderungssammlung implements IDataAnforderungssammlung {

	private DataZielbestimmung zielbestimmung;
	private DataProdukteinsatz produkteinsatz;
	private List<DataProduktFunktion> produktFunktionen;
	private List<DataProduktDatum> produktDaten;
	private IDataFunctionPointAnalyse aufwandsabschaetzung;

	public DataAnforderungssammlung(DataZielbestimmung zielbestimmung, DataProdukteinsatz produkteinsatz,
									List<DataProduktFunktion> produktFunktionen, List<DataProduktDatum> produktDaten,
									IDataFunctionPointAnalyse aufwandsabschaetzung) {
		this.zielbestimmung = zielbestimmung;
		this.produkteinsatz = produkteinsatz;
		this.produktFunktionen = produktFunktionen;
		this.produktDaten = produktDaten;
		this.aufwandsabschaetzung = aufwandsabschaetzung;
	}
}
