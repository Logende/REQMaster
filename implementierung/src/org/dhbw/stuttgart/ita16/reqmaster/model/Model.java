package org.dhbw.stuttgart.ita16.reqmaster.model;

import org.dhbw.stuttgart.ita16.reqmaster.view.IObserverView;

import java.io.*;

public class Model implements IModel {

	IObserverView obsView;
	private IExporter exporter;
	private IDataSchaetzKonfiguration schaetzKonfiguration;
	private IDataAnforderungssammlung anforderungssammlung;
	private File anforderungsSammlungFile;

    public Model(IExporter exporter, File schaetzKonfigurationsFile) {
        throw new UnsupportedOperationException("The method is not implemented yet.");
    }


	public void loadAnforderungssammlung(File f) {
		throw new UnsupportedOperationException("The method is not implemented yet.");
	}

	public void saveAnforderungssammlung() {
		throw new UnsupportedOperationException("The method is not implemented yet.");
	}

	public void saveKonfiguration() {
		throw new UnsupportedOperationException("The method is not implemented yet.");
	}


	@Override
    public void wasModified() {

    }

    @Override
    public IDataAnforderungssammlung getIDataAnforderungssammlung(){
	    throw new UnsupportedOperationException("Not implemented yet");
    }
}
