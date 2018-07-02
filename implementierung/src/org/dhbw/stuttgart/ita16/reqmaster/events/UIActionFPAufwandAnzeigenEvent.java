package org.dhbw.stuttgart.ita16.reqmaster.events;


public class UIActionFPAufwandAnzeigenEvent extends UIActionFPEvent {


	private double vaf;



	public UIActionFPAufwandAnzeigenEvent(double vaf) {
		this.vaf = vaf;
	}

	public double getVaf() {
		return vaf;
	}
}
