package org.dhbw.stuttgart.ita16.reqmaster.model;


import java.util.HashMap;
import java.util.LinkedHashMap;
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
        Map<DataId, DataProduktFunktion> produktFunktionen = new LinkedHashMap<>();
        Map<DataId, DataProduktDatum> produktDaten = new LinkedHashMap<>();
        return new DataAnforderungssammlung(zielbestimmung, produkteinsatz, umgebung, produktFunktionen, produktDaten, DefaultValues.createFunctionPointAnalyse());
    }

    public static IDataSchaetzKonfiguration createSchaetzKonfiguration(){
        Map<FPKlassifizierung, Map<FPKomplexitaet, Double>> defaultGewichte1 = new LinkedHashMap<>();
        for(FPKlassifizierung klassifizierung : FPKlassifizierung.values()){
            Map<FPKomplexitaet, Double> submap = new LinkedHashMap<>();
            for(FPKomplexitaet komplexitaet : FPKomplexitaet.values()){
                submap.put(komplexitaet, 1.0);
            }
            defaultGewichte1.put(klassifizierung, submap);
        }
        double[] defaultGewichte2 = {1,1,1,1,1,1,1};
        return new DataSchaetzKonfiguration(defaultGewichte1, defaultGewichte2);
    }

    public static IDataFunctionPointAnalyse createFunctionPointAnalyse(){
        return new DataFunctionPointAnalyse(new LinkedHashMap<>(), 0);
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
