package org.dhbw.stuttgart.ita16.reqmaster.events;
/**
 * legt den typ eines Events des User Interface fest
 * und speichert dessen relavente Werte
 */
public class UIModifyProdukteinsatzEvent extends UIModifyEvent {

	private String proposal;

	/**
	 * Konstruktor für die Klasse schreibt Eingansvariablen auf Klassenvariablen um
	 * @param proposal
	 */
	public UIModifyProdukteinsatzEvent(String proposal) {
		this.proposal = proposal;

	}

	/**
	 * setter für proposal
	 * @return proposal
	 */
	public String getProposal() {
		return proposal;
	}
}
