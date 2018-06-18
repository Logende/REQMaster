package org.dhbw.stuttgart.ita16.reqmaster.events;

import org.dhbw.stuttgart.ita16.reqmaster.model.DataProdukteinsatz;

/**
 * legt den typ eines Events des User Interface fest
 * und speichert dessen relavente Werte
 */
public class UIModifyProdukteinsatzEvent extends UIModifyEvent {

	private DataProdukteinsatz proposal;

	/**
	 * Konstruktor für die Klasse schreibt Eingansvariablen auf Klassenvariablen um
	 * @param proposal
	 */
	public UIModifyProdukteinsatzEvent(DataProdukteinsatz proposal) {
		this.proposal = proposal;

	}

	/**
	 * setter für proposal
	 * @return proposal
	 */
	public DataProdukteinsatz getProposal() {
		return proposal;
	}
}
