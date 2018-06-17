package org.dhbw.stuttgart.ita16.reqmaster.events;


public class UIModifyZielbestimmungEvent extends UIModifyEvent {

	/**
	 * legt den typ eines Events des User Interface fest
	 * und speichert dessen relavente Werte
	 */
	private String proposal;
	/**
	 * Konstruktor für die Klasse schreibt Eingansvariablen auf Klassenvariablen um
	 * @param proposal
	 */
	public UIModifyZielbestimmungEvent(String proposal)
	{
		this.proposal=proposal;
	}

	/**
	 * getter für proposal
	 * @return proposal
	 */
	public String getProposal() {
		return proposal;
	}
}
