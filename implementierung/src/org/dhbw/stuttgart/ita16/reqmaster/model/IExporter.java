package org.dhbw.stuttgart.ita16.reqmaster.model;

import java.io.*;
import java.util.*;

public interface IExporter {

	IDataAnforderungssammlung loadAnforderungssammlung(File f);

	void saveAnforderungssammlung(IDataAnforderungssammlung anforderungsSammlung, File f);

	IDataFunctionPointAnalyse loadFunctionPointAnalyse(File f);

	void saveFunctionPointAnalyse(IDataFunctionPointAnalyse analyse, File f);

}
