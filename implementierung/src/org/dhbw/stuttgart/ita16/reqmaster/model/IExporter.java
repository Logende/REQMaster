package org.dhbw.stuttgart.ita16.reqmaster.model;

import java.io.*;
import java.util.*;

/**
 * Interface für Fileexporter, der sowohl die Anforderungssammlung, als auch Schaetzkonfigurationen
 * exportieren und importieren kann.
 */
public interface IExporter {

	IDataAnforderungssammlung loadAnforderungssammlung(File f);

	void saveAnforderungssammlung(IDataAnforderungssammlung anforderungsSammlung, File f);

	IDataSchaetzKonfiguration loadSchaetzkonfiguration(File f);

	void saveSchaetzKonfiguration(IDataSchaetzKonfiguration schaetzKonfiguration, File f);

}
