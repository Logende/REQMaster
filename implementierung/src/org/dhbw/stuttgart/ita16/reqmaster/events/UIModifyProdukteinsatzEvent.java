package org.dhbw.stuttgart.ita16.reqmaster.events;

import org.dhbw.stuttgart.ita16.reqmaster.model.DataProdukteinsatz;

public class UIModifyProdukteinsatzEvent extends UIModifyEvent {

	private final DataProdukteinsatz proposal;

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
