package org.dhbw.stuttgart.ita16.reqmaster.model;


public class DataProduktFunktion implements IIdentifiable {

	private String name;
	private String beschreibung;
	private String akteur;
	private String quelle;
	private String verweise;
	private DataId id;

	public DataProduktFunktion(String name, String beschreibung,
							   String akteur, String quelle, String verweise, DataId id) {
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

	public String getName(){
		return name;
	}

	public String getBeschreibung() {
		return beschreibung;
	}

	public String getAkteur(){
		return akteur;
	}

	public String getQuelle(){
		return quelle;
	}

	public String getVerweise() {
		return verweise;
	}

	public boolean modify(DataProduktFunktion goal){
		boolean wasModified = !this.name.equals(goal.name) |! this.id.equals(goal.id) |! this.verweise.equals(goal.verweise)
				|! this.beschreibung.equals(goal.beschreibung) |! this.quelle.equals(goal.quelle) |! this.akteur.equals(goal.akteur);

		this.name = goal.name;
		this.beschreibung = goal.beschreibung;
		this.akteur = goal.akteur;
		this.quelle = goal.quelle;
		this.verweise = goal.verweise;
		this.id.modify(goal.id);

		return wasModified;
	}

}
