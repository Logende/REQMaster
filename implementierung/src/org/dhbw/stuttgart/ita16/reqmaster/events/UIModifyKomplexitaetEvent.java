package org.dhbw.stuttgart.ita16.reqmaster.events;

import org.dhbw.stuttgart.ita16.reqmaster.model.*;

public class UIModifyKomplexitaetEvent extends UIModifyEvent {

	private DataId id;
	private FPKomplexitaet proposal;

	public DataId getID() {
		return id;
	}

	public UIModifyKomplexitaetEvent(DataId id, FPKomplexitaet proposal) {
		this.id=id;
		this.proposal=proposal;
	}

	public FPKomplexitaet getProposal() {
		return proposal;
	}

}
