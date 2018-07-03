package org.dhbw.stuttgart.ita16.reqmaster.model;


/**
 * Klasse für die Attribute eines DataProduktDatums.
 */
public class DataAttribut {


	private String name;

	public DataAttribut(String name) {
		this.name = name;
	}

	@Override
	public boolean equals(Object o){
		if(o instanceof  DataAttribut){
			DataAttribut a = (DataAttribut) o;
			return name.equals(a.name);
		}
		return false;
	}

	/**
	 * getter für den Name des Attributs
	 * @return name: Inhalt des Attributs
	 */
	public String getName() {
		return name;
	}
}
