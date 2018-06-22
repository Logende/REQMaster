package org.dhbw.stuttgart.ita16.reqmaster.model;

import java.util.HashMap;
import java.util.Map;

public class DefaultValues {

    public static final String PRODUKTDATUM_NAME = "produktdatumname";
    public static final String PRODUKTFUNKTION_NAME = "produktfunktionname";
    public static final String PRODUKTFUNKTION_BESCHREIBUNG = "beschreibung";
    public static final String PRODUKTFUNKTION_QUELLE = "quelle";
    public static final String PRODUKTFUNKTION_AKTEUR = "akteur";



    public static IDataAnforderungssammlung createAnforderungsSammlung(){
        DataZielbestimmung zielbestimmung = new DataZielbestimmung("Zielbestimmung und so");
        DataProdukteinsatz produkteinsatz = new DataProdukteinsatz("Produkteinsatz");
        DataUmgebung umgebung = new DataUmgebung("Umgebung");
        Map<DataId, DataProduktFunktion> produktFunktionen = new HashMap<>();
        Map<DataId, DataProduktDatum> produktDaten = new HashMap<>();
        return new DataAnforderungssammlung(zielbestimmung, produkteinsatz, umgebung, produktFunktionen, produktDaten, null);
    }

    public static IDataSchaetzKonfiguration createSchaetzKonfiguration(){
        double defaultGewichte[] = null;
        return new DataSchaetzKonfiguration(defaultGewichte);
    }
}
