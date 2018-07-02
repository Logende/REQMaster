package org.dhbw.stuttgart.ita16.reqmaster.controller;

import org.dhbw.stuttgart.ita16.reqmaster.model.DataProduktDatum;
import org.dhbw.stuttgart.ita16.reqmaster.model.DataProduktFunktion;
import org.dhbw.stuttgart.ita16.reqmaster.model.IDataFunctionPointEinstufung;
import org.dhbw.stuttgart.ita16.reqmaster.model.IModel;

public class AufwandRechner implements IAufwandRechner {

    @Override
    public double calculateAufwandInFP(IModel model) {
        double summeAufwand = 0;
        for(DataProduktFunktion dataProduktFunktion : model.getIDataAnforderungssammlung().getDataProduktFunktionen().values()){
            IDataFunctionPointEinstufung einstufung = model.getIDataAnforderungssammlung().getIDataFunctionPointAnalyse().getEinstufung(dataProduktFunktion);
            summeAufwand += model.getSchaetzKonfiguration().getGewicht1(einstufung.getKlassifizierung(), einstufung.getKomplexitaet());
        }
        for(DataProduktDatum dataProduktDatum : model.getIDataAnforderungssammlung().getDataProduktDaten().values()){
            IDataFunctionPointEinstufung einstufung = model.getIDataAnforderungssammlung().getIDataFunctionPointAnalyse().getEinstufung(dataProduktDatum);
            summeAufwand += model.getSchaetzKonfiguration().getGewicht1(einstufung.getKlassifizierung(), einstufung.getKomplexitaet());
        }

        double summeEinflussFaktoren = 0;
        for(double einflussFaktor : model.getSchaetzKonfiguration().getGewichte2()){
            summeEinflussFaktoren += einflussFaktor;
        }

        double faktorEinflussbewertung = summeEinflussFaktoren / 100.0 + 0.7;
        double aufwandInFp = summeAufwand * faktorEinflussbewertung;
        return aufwandInFp;
    }

    @Override
    public double calculateAufwandInMM(IModel model) {
        double vaf = 1.0; //todo
        double afp = this.calculateAufwandInFP(model) * vaf;
        double aufwandInMm = Math.pow(afp, 0.4f);
        return aufwandInMm;
    }
}

