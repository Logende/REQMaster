package org.dhbw.stuttgart.ita16.reqmaster.events;


public class UIActionFPGewichtsfaktorenOptimierenEvent extends UIActionFPEvent {

	private final int index;
	private final double vaf;

	public UIActionFPGewichtsfaktorenOptimierenEvent(int index, double vaf) {
		this.index = index;
		this.vaf = vaf;
	}


	public int getIndex() {
		return index;
	}

	public double getVaf() {
		return vaf;
	}
}
