package org.dhbw.stuttgart.ita16.reqmaster.controller;

import org.dhbw.stuttgart.ita16.reqmaster.model.*;

public class AufwandRechner implements IAufwandRechner {

    @Override
    public void calculateAufwand(IModel model, double vaf) {
        IDataAnforderungssammlung anforderungssammlung = model.getIDataAnforderungssammlung();
        IDataFunctionPointAnalyse functionPointAnalyse = anforderungssammlung.getIDataFunctionPointAnalyse();
        double summeAufwand = 0;
        for(DataProduktFunktion dataProduktFunktion : anforderungssammlung.getDataProduktFunktionen().values()){
            IDataFunctionPointEinstufung einstufung = functionPointAnalyse.getEinstufung(dataProduktFunktion);
            summeAufwand += model.getSchaetzKonfiguration().getGewicht1(einstufung.getKlassifizierung(), einstufung.getKomplexitaet());
        }
        for(DataProduktDatum dataProduktDatum : anforderungssammlung.getDataProduktDaten().values()){
            IDataFunctionPointEinstufung einstufung = functionPointAnalyse.getEinstufung(dataProduktDatum);
            summeAufwand += model.getSchaetzKonfiguration().getGewicht1(einstufung.getKlassifizierung(), einstufung.getKomplexitaet());
        }

        double summeEinflussFaktoren = 0;
        for(double einflussFaktor : model.getSchaetzKonfiguration().getGewichte2()){
            summeEinflussFaktoren += einflussFaktor;
        }

        double faktorEinflussbewertung = summeEinflussFaktoren / 100.0 + 0.7;
        double aufwandInFp = summeAufwand * faktorEinflussbewertung;

        double afp = aufwandInFp * vaf;
        double aufwandInMm = Math.pow(afp, 0.4f);

        functionPointAnalyse.setFaktorEinflussBewertung(faktorEinflussbewertung);
        functionPointAnalyse.setSummeAufwand(summeAufwand);
        functionPointAnalyse.setSummEinflussFaktoren(summeEinflussFaktoren);
        functionPointAnalyse.setAufwandInFP(aufwandInFp);
        functionPointAnalyse.setAufwandInMM(aufwandInMm);
        System.out.println("fp: " + aufwandInMm);
    }

}

