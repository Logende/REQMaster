package org.dhbw.stuttgart.ita16.reqmaster.model;

import java.io.*;
import java.util.*;

public interface IDataAnforderungssammlung {

    DataProdukteinsatz getDataProdukteinsatz();

    DataZielbestimmung getdataZielbestimmung();

    List<DataProduktFunktion> getDataProkuktFunktion();

    List<DataProduktDatum> getDataProduktDatum();

    IDataFunctionPointAnalyse getIDataFunctionPointAnalyse();
}
