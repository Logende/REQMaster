package org.dhbw.stuttgart.ita16.reqmaster.model;


public class DataAttribut {

	private String anzahl;
	private String name;

	public DataAttribut(String name, String anzahl) {
		this.anzahl = anzahl;
		this.name = name;
	}

	@Override
	public boolean equals(Object o){
		if(o instanceof  DataAttribut){
			DataAttribut a = (DataAttribut) o;
			return anzahl.equals(a.anzahl) && name.equals(a.name);
		}
		return false;
	}
}
