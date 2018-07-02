package org.dhbw.stuttgart.ita16.reqmaster.events;


public class UIModifyRealerAufwandEvent extends UIModifyEvent {

	private final double proposal;

	//Konstruktor
	public UIModifyRealerAufwandEvent(double proposal) {
    this.proposal=proposal;
	}

	//getter
    public double getProposal() {
        return proposal;
    }
}
