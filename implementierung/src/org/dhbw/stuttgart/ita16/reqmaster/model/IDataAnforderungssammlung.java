package org.dhbw.stuttgart.ita16.reqmaster.model;

import java.util.*;

public interface IDataAnforderungssammlung {

    DataProdukteinsatz getDataProdukteinsatz();

    DataUmgebung getDataUmgebung();

    DataZielbestimmung getDataZielbestimmung();

    Map<DataId, DataProduktFunktion> getDataProduktFunktionen();

    Map<DataId, DataProduktDatum> getDataProduktDaten();

    IDataFunctionPointAnalyse getIDataFunctionPointAnalyse();

    void deleteIDataFunctionPointAnalyse();
    IIdentifiable getObject(DataId id);



}
