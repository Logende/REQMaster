package org.dhbw.stuttgart.ita16.reqmaster.model;

import java.io.*;
import java.util.*;

public class DataProduktFunktion implements IIdentifiable {

	private String name;
	private String beschreibung;
	private String akteur;
	private String quelle;
	private List<DataId> verweise;
	private DataId id;

	public DataProduktFunktion(String name, String beschreibung,
							   String akteur, String quelle, List<DataId> verweise, DataId id) {
		this.name = name;
		this.beschreibung = beschreibung;
		this.akteur = akteur;
		this.quelle = quelle;
		this.verweise = verweise;
		this.id = id;
	}

	@Override
	public DataId getId() {
		return id;
	}


	public void modify(DataProduktFunktion goal){
		this.name = goal.name;
		this.beschreibung = goal.beschreibung;
		this.akteur = goal.akteur;
		this.quelle = goal.quelle;
		this.verweise = goal.verweise;
		this.id.modify(goal.id);
	}

}
