package org.dhbw.stuttgart.ita16.reqmaster.model;

public class DataSchaetzKonfiguration implements IDataSchaetzKonfiguration {


	private  double[] gewichte;

	public DataSchaetzKonfiguration(double[] gewichte){
		this.gewichte = gewichte;
	}

	@Override
	public double getGewicht(int index) {
		if(index>= gewichte.length || index<0){
			throw new ArrayIndexOutOfBoundsException("Out of bounds: Gewicht requested was " + index + " but needs to be between 0 and " + (gewichte.length-1) + ".");
		}
		return gewichte[index];
	}
}
