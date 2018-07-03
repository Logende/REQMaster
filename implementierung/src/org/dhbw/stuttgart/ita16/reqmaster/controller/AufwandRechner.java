package org.dhbw.stuttgart.ita16.reqmaster.controller;

import org.dhbw.stuttgart.ita16.reqmaster.model.*;

/**
 * AufwandRechner Implementierung.
 * In der Lage, Aufwand in FP/MM zu berechnen und Gewichtsfaktoren zu optimieren.
 */
public class AufwandRechner implements IAufwandRechner {

    @Override
    public String calculateAufwand(IModel model, double vaf) {
        if(vaf < 0.65 || vaf > 1.35){
            return "Value Adjustment Factor ist invalide. Muss zwischen 0.65 und 1.35 liegen.";
        }
        IDataAnforderungssammlung anforderungssammlung = model.getIDataAnforderungssammlung();
        IDataFunctionPointAnalyse functionPointAnalyse = anforderungssammlung.getIDataFunctionPointAnalyse();
        double summeAufwand = this.calculateSummeAufwand(model);
        double summeEinflussFaktoren = this.calculateSummeEinflussfaktoren(model);

        double faktorEinflussbewertung = summeEinflussFaktoren / 100.0 + 0.7;
        double aufwandInFp = summeAufwand * faktorEinflussbewertung;

        double afp = aufwandInFp * vaf;
        double aufwandInMm = Math.pow(afp, 0.4f);

        functionPointAnalyse.setFaktorEinflussBewertung(faktorEinflussbewertung);
        functionPointAnalyse.setSummeAufwand(summeAufwand);
        functionPointAnalyse.setSummEinflussFaktoren(summeEinflussFaktoren);
        functionPointAnalyse.setAufwandInFP(aufwandInFp);
        functionPointAnalyse.setAufwandInMM(aufwandInMm);
        return null;
    }


    private double calculateSummeAufwand(IModel model){
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
        return summeAufwand;
    }

    private double calculateSummeEinflussfaktoren(IModel model){
        double summeEinflussFaktoren = 0;
        for(double einflussFaktor : model.getSchaetzKonfiguration().getGewichte2()){
            summeEinflussFaktoren += einflussFaktor;
        }
        return summeEinflussFaktoren;
    }

    @Override
    public String optimiereFaktor(IModel model, double vaf, int index) {
        if(vaf < 0.65 || vaf > 1.35){
            return "Value Adjustment Factor ist invalide. Muss zwischen 0.65 und 1.35 liegen.";
        }
        IDataAnforderungssammlung anforderungssammlung = model.getIDataAnforderungssammlung();
        double summeAufwand = this.calculateSummeAufwand(model);

        double goalAufwandInMm = model.getIDataAnforderungssammlung().getIDataFunctionPointAnalyse().getRealerAufwand();
        double afp = Math.pow(goalAufwandInMm, 1.0/0.4);
        double aufwandInFp = afp / vaf;
        double faktorEinflussbewertung = aufwandInFp / summeAufwand;
        double summeEinflussfaktoren = (faktorEinflussbewertung - 0.7)*100;

        double oldSummeEinflussfaktoren = this.calculateSummeEinflussfaktoren(model);
        double summeEinflussfaktorenWithoutSelectedFaktor = oldSummeEinflussfaktoren - model.getSchaetzKonfiguration().getGewicht2(index);

        double einflussFaktor = summeEinflussfaktoren - summeEinflussfaktorenWithoutSelectedFaktor;
        double[] einflussFaktoren = model.getSchaetzKonfiguration().getGewichte2();
        einflussFaktoren[index] = einflussFaktor;
        model.getSchaetzKonfiguration().setGewichte2(einflussFaktoren);
        return null;
    }
}

