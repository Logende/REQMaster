package org.dhbw.stuttgart.ita16.reqmaster.model;

import org.dhbw.stuttgart.ita16.reqmaster.view.IObserverView;

import java.io.*;

/**
 * Implementierung des IModels.
 */
public class Model implements IModel {

	private IObserverView obsView;
	private IExporter exporter;
	private IDataSchaetzKonfiguration schaetzKonfiguration;
	private IDataAnforderungssammlung anforderungsSammlung;
	private File schaetzKonfigurationFile;

	private File anforderungsSammlungFile;
    public Model(IExporter exporter, File schaetzKonfigurationsFile) {
    	this.exporter = exporter;
    	this.schaetzKonfigurationFile = schaetzKonfigurationsFile;
    	boolean b = true;
    	if(!schaetzKonfigurationsFile.exists() || b){
    		this.schaetzKonfiguration = DefaultValues.createSchaetzKonfiguration();
		}else {
			this.schaetzKonfiguration = exporter.loadSchaetzkonfiguration(schaetzKonfigurationsFile);
		}
    }

    public void setObserverView(IObserverView obsView){
    	this.obsView = obsView;
	}

	@Override
    public void createAnforderungssammlung(File f){
    	this.anforderungsSammlungFile = f;
    	this.anforderungsSammlung = DefaultValues.createAnforderungsSammlung();
    	this.wasModified();
	}

	@Override
	public void loadAnforderungssammlung(File f) {
    	this.anforderungsSammlungFile = f;
		this.anforderungsSammlung = this.exporter.loadAnforderungssammlung(f);
		this.wasModified();
	}

	@Override
	public void saveAnforderungssammlung() {
		this.exporter.saveAnforderungssammlung(anforderungsSammlung, anforderungsSammlungFile);
	}

	@Override
	public void saveSchaetzkonfiguration(){
    	this.exporter.saveSchaetzKonfiguration(schaetzKonfiguration, schaetzKonfigurationFile);
	}



	@Override
    public void wasModified() {
    	this.obsView.update();
    }

    @Override
    public IDataAnforderungssammlung getIDataAnforderungssammlung(){
    	return anforderungsSammlung;
    }

	@Override
	public IDataSchaetzKonfiguration getSchaetzKonfiguration() {
		return schaetzKonfiguration;
	}

	@Override
	public void setSchaetzKonfiguration(IDataSchaetzKonfiguration schaetzKonfiguration) {
		this.schaetzKonfiguration = schaetzKonfiguration;
	}
}
