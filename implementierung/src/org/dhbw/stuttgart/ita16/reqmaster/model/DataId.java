package org.dhbw.stuttgart.ita16.reqmaster.model;


/**
 * Id von z.B. einer ProduktFunktion/eines ProduktDatums.
 */
public class DataId {

	private String id;

	public DataId(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	@Override
	public boolean equals(Object o){
		if(o instanceof DataId){
			return this.id.equalsIgnoreCase(((DataId) o).id);
		}
		return false;
	}

	protected void modify(DataId id){
		this.id = id.id;
	}

}
