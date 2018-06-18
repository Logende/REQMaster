package org.dhbw.stuttgart.ita16.reqmaster.events;

import org.dhbw.stuttgart.ita16.reqmaster.model.*;

public class UIModifyKlassifizierungEvent extends UIModifyEvent {

	private int id;
	private FPKlassifizierung proposal;

	public UIModifyKlassifizierungEvent(int id, FPKlassifizierung proposal) {
		this.id=id;
		this.proposal=proposal;
	}

	public int getID() {
		return id;
	}

	public FPKlassifizierung getproposal() {
		return proposal;
	}
}
