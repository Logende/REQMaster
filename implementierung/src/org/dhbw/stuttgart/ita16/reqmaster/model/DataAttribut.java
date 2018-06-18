package org.dhbw.stuttgart.ita16.reqmaster.model;


public class DataAttribut {

	private Class type;
	private int limit;
	private String name;

	public DataAttribut(String name, Class type, int limit) {
		this.type = type;
		this.name = name;
		this.limit = limit;
	}
}
