package org.dhbw.stuttgart.ita16.reqmaster.events;


import org.dhbw.stuttgart.ita16.reqmaster.model.DataZielbestimmung;

public class UIModifyZielbestimmungEvent extends UIModifyEvent {

	private DataZielbestimmung proposal;
	/**
	 * Konstruktor für die Klasse schreibt Eingansvariablen auf Klassenvariablen um
	 * @param proposal
	 */
	public UIModifyZielbestimmungEvent(DataZielbestimmung proposal)
	{
		this.proposal=proposal;
	}

	/**
	 * getter für proposal
	 * @return proposal
	 */
	public DataZielbestimmung getProposal() {
		return proposal;
	}
}
