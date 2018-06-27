package org.dhbw.stuttgart.ita16.reqmaster.events;

import org.dhbw.stuttgart.ita16.reqmaster.model.DataUmgebung;

public class UIModifyUmgebungEvent extends UIModifyEvent {

	private DataUmgebung proposal;

	/**
	 * Konstruktor für die Klasse schreibt Eingansvariablen auf Klassenvariablen um
	 * @param proposal
	 */
	public UIModifyUmgebungEvent(DataUmgebung proposal) {
		this.proposal = proposal;

	}

	/**
	 * setter für proposal
	 * @return proposal
	 */
	public DataUmgebung getProposal() {
		return proposal;
	}
}
