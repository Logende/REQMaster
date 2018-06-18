package org.dhbw.stuttgart.ita16.reqmaster.events;

import org.dhbw.stuttgart.ita16.reqmaster.model.*;

public class UIModifyKlassifizierungEvent extends UIModifyEvent {

	private DataId id;
	private FPKlassifizierung proposal;

	public UIModifyKlassifizierungEvent(DataId id, FPKlassifizierung proposal) {
		this.id=id;
		this.proposal=proposal;
	}

	public DataId getID() {
		return id;
	}

	public FPKlassifizierung getProposal() {
		return proposal;
	}
}
