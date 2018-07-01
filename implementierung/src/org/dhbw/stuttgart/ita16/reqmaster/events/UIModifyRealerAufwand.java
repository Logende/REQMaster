package org.dhbw.stuttgart.ita16.reqmaster.events;


public class UIModifyRealerAufwand extends UIModifyEvent {

	private final double proposal;

	//Konstruktor
	public UIModifyRealerAufwand(double proposal) {
    this.proposal=proposal;
	}

	//getter
    public double getProposal() {
        return proposal;
    }
}
