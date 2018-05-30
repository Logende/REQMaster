package org.dhbw.stuttgart.ita16.reqmaster.model;

import org.dhbw.stuttgart.ita16.reqmaster.view.IObserverView;

import java.io.*;
import java.util.*;

public class Model implements IModel {

	IObserverView obsView;
	private IExporter exporter;
	private IDataSchaetzKonfiguration schaetzKonfiguration;
	private IDataAnforderungssammlung anforderungssammlung;
	private File anforderungsSammlungFile;

	public void loadAnforderungssammlung(File f) {
		throw new UnsupportedOperationException("The method is not implemented yet.");
	}

	public void saveAnforderungssammlung() {
		throw new UnsupportedOperationException("The method is not implemented yet.");
	}

	public void saveKonfiguration() {
		throw new UnsupportedOperationException("The method is not implemented yet.");
	}

	public Model(IExporter exporter, File schaetzKonfigurationsFile) {
		throw new UnsupportedOperationException("The method is not implemented yet.");
	}

}
