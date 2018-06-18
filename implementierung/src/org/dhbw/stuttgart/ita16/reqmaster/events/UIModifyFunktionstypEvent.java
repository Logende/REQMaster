package org.dhbw.stuttgart.ita16.reqmaster.events;

import org.dhbw.stuttgart.ita16.reqmaster.model.*;
public class UIModifyFunktionstypEvent extends UIModifyEvent {

	private DataId id;
	private FPFunktionsTyp proposal;

	//Konstruktor der Klasse
	//Zuordnung der Variablen
	public UIModifyFunktionstypEvent(DataId id, FPFunktionsTyp proposal) {
		this.id=id;
	}

	//getter
	public FPFunktionsTyp getProposal() {
		return proposal;
	}

	//getter
	public DataId getID() {
		return id;
	}
}
