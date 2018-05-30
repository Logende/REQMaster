package org.dhbw.stuttgart.ita16.reqmaster.model;

import java.io.*;
import java.util.*;

public class DataProduktDatum implements IIdentifiable {

	private String name;
	private DataId id;
	private List<DataAttribut> attribute;
	private List<DataId> verweise;

	public DataProduktDatum(String name, DataId id, List<DataAttribut> attribute, List<DataId> verweise) {
		this.name = name;
		this.id = id;
		this.attribute = attribute;
		this.verweise = verweise;
	}

	@Override
	public DataId getId() {
		return id;
	}
}
