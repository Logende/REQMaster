package org.dhbw.stuttgart.ita16.reqmaster.model;

import java.util.*;

public class DataProduktDatum implements IIdentifiable {

	private String name;
	private DataId id;
	private List<DataAttribut> attribute;
	private String verweise;

	public DataProduktDatum(String name, DataId id, List<DataAttribut> attribute, String verweise) {
		this.name = name;
		this.id = id;
		this.attribute = attribute;
		this.verweise = verweise;
	}

	@Override
	public DataId getId() {
		return id;
	}

	public boolean modify(DataProduktDatum goal){
		boolean wasModified = !this.name.equals(goal.name) |! this.id.equals(goal.id) |! this.verweise.equals(goal.verweise)
				|! this.attribute.equals(goal.attribute);

		this.name = goal.name;
		this.id.modify(goal.id);
		this.attribute = goal.attribute;
		this.verweise = goal.verweise;
		return wasModified;
	}

	public String getName(){
		return name;
	}

	public List<DataAttribut> getAttribute() {
		return attribute;
	}

	public String getVerweise() {
		return verweise;
	}
}
