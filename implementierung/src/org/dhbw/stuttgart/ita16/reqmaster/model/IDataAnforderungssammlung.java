package org.dhbw.stuttgart.ita16.reqmaster.model;

import java.util.*;

public interface IDataAnforderungssammlung {

    DataProdukteinsatz getDataProdukteinsatz();

    DataZielbestimmung getDataZielbestimmung();

    List<DataProduktFunktion> getDataProduktFunktionen();

    List<DataProduktDatum> getDataProduktDaten();

    IDataFunctionPointAnalyse getIDataFunctionPointAnalyse();



    void deleteIDataFunctionPointAnalyse();
}
