package org.dhbw.stuttgart.ita16.reqmaster.model;

import java.util.*;

/**
 * Enthält alle Daten einer Anforderungssammlung
 */
public class DataAnforderungssammlung implements IDataAnforderungssammlung {

	private DataZielbestimmung zielbestimmung;
	private DataProdukteinsatz produkteinsatz;
	private DataUmgebung umgebung;
	private Map<DataId, DataProduktFunktion> produktFunktionen;
	private Map<DataId, DataProduktDatum> produktDaten;

	private IDataFunctionPointAnalyse functionPointAnalyse;


	public DataAnforderungssammlung(DataZielbestimmung zielbestimmung, DataProdukteinsatz produkteinsatz, DataUmgebung umgebung,
									Map<DataId, DataProduktFunktion> produktFunktionen, Map<DataId, DataProduktDatum> produktDaten,
									IDataFunctionPointAnalyse functionPointAnalyse) {
		this.zielbestimmung = zielbestimmung;
		this.produkteinsatz = produkteinsatz;
		this.umgebung = umgebung;
		this.produktFunktionen = produktFunktionen;
		this.produktDaten = produktDaten;
		this.functionPointAnalyse = functionPointAnalyse;
	}



	@Override
	public DataProdukteinsatz getDataProdukteinsatz() {
		return produkteinsatz;
	}

	@Override
	public DataUmgebung getDataUmgebung() {
		return umgebung;
	}

	@Override
	public DataZielbestimmung getDataZielbestimmung() {
		return zielbestimmung;
	}

	@Override
	public Map<DataId, DataProduktFunktion> getDataProduktFunktionen() {
		return produktFunktionen;
	}

	@Override
	public Map<DataId, DataProduktDatum> getDataProduktDaten() {
		return produktDaten;
	}

	@Override
	public IDataFunctionPointAnalyse getIDataFunctionPointAnalyse() {
		return functionPointAnalyse;
	}

	@Override
	public void deleteIDataFunctionPointAnalyse() {
		this.functionPointAnalyse = null;
	}

	@Override
	public IIdentifiable getObject(DataId id) {
		if(produktFunktionen.containsKey(id)){
			return produktFunktionen.get(id);
		}
		if(produktDaten.containsKey(id)){
			return produktDaten.get(id);
		}
		for(IIdentifiable iIdentifiable : produktDaten.values()){
			if(iIdentifiable.getId().equals(id)){
				return iIdentifiable;
			}
		}
		for(IIdentifiable iIdentifiable : produktFunktionen.values()){
			if(iIdentifiable.getId().equals(id)){
				return iIdentifiable;
			}
		}
		return null;
	}
}
