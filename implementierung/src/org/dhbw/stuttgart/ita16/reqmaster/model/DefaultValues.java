package org.dhbw.stuttgart.ita16.reqmaster.model;

import com.sun.javaws.exceptions.InvalidArgumentException;

import java.util.HashMap;
import java.util.Map;

public class DefaultValues {

    public static final String PRODUKTDATUM_NAME = "produktdatumname";
    public static final String PRODUKTDATUM_VERWEISE = "verweise";
    public static final String PRODUKTFUNKTION_NAME = "produktfunktionname";
    public static final String PRODUKTFUNKTION_BESCHREIBUNG = "beschreibung";
    public static final String PRODUKTFUNKTION_QUELLE = "quelle";
    public static final String PRODUKTFUNKTION_AKTEUR = "akteur";
    public static final String PRODUKTFUNKTION_VERWEISE = "verweise";



    public static IDataAnforderungssammlung createAnforderungsSammlung(){
        DataZielbestimmung zielbestimmung = new DataZielbestimmung("Zielbestimmung");
        DataProdukteinsatz produkteinsatz = new DataProdukteinsatz("Produkteinsatz");
        DataUmgebung umgebung = new DataUmgebung("Umgebung");
        Map<DataId, DataProduktFunktion> produktFunktionen = new HashMap<>();
        Map<DataId, DataProduktDatum> produktDaten = new HashMap<>();
        return new DataAnforderungssammlung(zielbestimmung, produkteinsatz, umgebung, produktFunktionen, produktDaten, DefaultValues.createFunctionPointAnalyse());
    }

    public static IDataSchaetzKonfiguration createSchaetzKonfiguration(){
        Map<FPKlassifizierung, Map<FPKomplexitaet, Double>> defaultGewichte = new HashMap<>();
        for(FPKlassifizierung klassifizierung : FPKlassifizierung.values()){
            Map<FPKomplexitaet, Double> submap = new HashMap<>();
            for(FPKomplexitaet komplexitaet : FPKomplexitaet.values()){
                submap.put(komplexitaet, 1.0);
            }
            defaultGewichte.put(klassifizierung, submap);
        }
        return new DataSchaetzKonfiguration(defaultGewichte);
    }

    public static IDataFunctionPointAnalyse createFunctionPointAnalyse(){
        return new DataFunctionPointAnalyse(new HashMap<>(), 0);
    }

    public static IDataFunctionPointEinstufung getDefaultEinstufung(IIdentifiable i){
        if(i instanceof DataProduktFunktion){
            return new DataFunctionPointEinstufung(FPFunktionsTyp.TRANSAKTION, FPKlassifizierung.TRANSAKTION_EI, FPKomplexitaet.MITTEL);
        }else if(i instanceof DataProduktDatum){
            return new DataFunctionPointEinstufung(FPFunktionsTyp.DATEN, FPKlassifizierung.DATEN_ELF, FPKomplexitaet.MITTEL);
        }else{
            throw new IllegalArgumentException("No default IDataFunctionPointEinstufung defined for iidentifiable of type " + i.getClass().getName());
        }
    }
}
