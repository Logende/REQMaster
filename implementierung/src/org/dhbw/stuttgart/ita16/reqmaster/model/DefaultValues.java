package org.dhbw.stuttgart.ita16.reqmaster.model;


import java.util.LinkedHashMap;
import java.util.Map;

public class DefaultValues {

    public static final String PRODUKTDATUM_NAME = "Produktdatumname";
    public static final String PRODUKTDATUM_ATTRIBUTE = "Attribute";
    public static final String PRODUKTDATUM_VERWEISE = "Verweise";
    public static final String PRODUKTFUNKTION_NAME = "Produktfunktionname";
    public static final String PRODUKTFUNKTION_BESCHREIBUNG = "Beschreibung";
    public static final String PRODUKTFUNKTION_QUELLE = "Quelle";
    public static final String PRODUKTFUNKTION_AKTEUR = "Akteur";
    public static final String PRODUKTFUNKTION_VERWEISE = "Verweise";
    public static final String ID = "ID";
    public static final String ZIELBESTIMMUNG = "Zielbestimmung";
    public static final String PRODUKTEINSATZ = "Produkteinsatz";
    public static final String UMGEBUNG = "Umgebung";
    public static final String PRODUKTDATEN = "Produktdaten";
    public static final String PRODUKTFUNKTIONEN = "Produktfunktionen";
    public static final String DEFAULT_PATH = "C:\\Users\\%name%\\Documents";


    public static IDataAnforderungssammlung createAnforderungsSammlung(){
        DataZielbestimmung zielbestimmung = new DataZielbestimmung(ZIELBESTIMMUNG);
        DataProdukteinsatz produkteinsatz = new DataProdukteinsatz(PRODUKTEINSATZ);
        DataUmgebung umgebung = new DataUmgebung(UMGEBUNG);
        Map<DataId, DataProduktFunktion> produktFunktionen = new LinkedHashMap<>();
        Map<DataId, DataProduktDatum> produktDaten = new LinkedHashMap<>();
        return new DataAnforderungssammlung(zielbestimmung, produkteinsatz, umgebung, produktFunktionen, produktDaten, DefaultValues.createFunctionPointAnalyse());
    }

    public static IDataSchaetzKonfiguration createSchaetzKonfiguration(){
        Map<FPKlassifizierung, Map<FPKomplexitaet, Double>> defaultGewichte1 = new LinkedHashMap<>();
        Map<FPKomplexitaet, Double> gewichteDatenILF = new LinkedHashMap<>();
        gewichteDatenILF.put(FPKomplexitaet.EINFACH, 3.0);
        gewichteDatenILF.put(FPKomplexitaet.MITTEL, 4.0);
        gewichteDatenILF.put(FPKomplexitaet.KOMPLEX, 6.0);
        defaultGewichte1.put(FPKlassifizierung.DATEN_ILF, gewichteDatenILF);

        Map<FPKomplexitaet, Double> gewichteDatenELF = new LinkedHashMap<>();
        gewichteDatenELF.put(FPKomplexitaet.EINFACH, 3.0);
        gewichteDatenELF.put(FPKomplexitaet.MITTEL, 4.0);
        gewichteDatenELF.put(FPKomplexitaet.KOMPLEX, 6.0);
        defaultGewichte1.put(FPKlassifizierung.DATEN_ELF, gewichteDatenELF);

        Map<FPKomplexitaet, Double> gewichteTransaktionEO = new LinkedHashMap<>();
        gewichteTransaktionEO.put(FPKomplexitaet.EINFACH, 3.0);
        gewichteTransaktionEO.put(FPKomplexitaet.MITTEL, 4.0);
        gewichteTransaktionEO.put(FPKomplexitaet.KOMPLEX, 6.0);
        defaultGewichte1.put(FPKlassifizierung.TRANSAKTION_EO, gewichteTransaktionEO);

        Map<FPKomplexitaet, Double> gewichteTransaktionEI = new LinkedHashMap<>();
        gewichteTransaktionEI.put(FPKomplexitaet.EINFACH, 3.0);
        gewichteTransaktionEI.put(FPKomplexitaet.MITTEL, 4.0);
        gewichteTransaktionEI.put(FPKomplexitaet.KOMPLEX, 6.0);
        defaultGewichte1.put(FPKlassifizierung.TRANSAKTION_EI, gewichteTransaktionEI);

        Map<FPKomplexitaet, Double> gewichteTransaktionEQ = new LinkedHashMap<>();
        gewichteTransaktionEQ.put(FPKomplexitaet.EINFACH, 3.0);
        gewichteTransaktionEQ.put(FPKomplexitaet.MITTEL, 4.0);
        gewichteTransaktionEQ.put(FPKomplexitaet.KOMPLEX, 6.0);
        defaultGewichte1.put(FPKlassifizierung.TRANSAKTION_EQ, gewichteTransaktionEQ);

        double[] defaultGewichte2 = {1,1,1,1,1,1,1,1,1,1,1};
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
