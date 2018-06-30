package org.dhbw.stuttgart.ita16.reqmaster.events;

import org.dhbw.stuttgart.ita16.reqmaster.model.DataId;
import org.dhbw.stuttgart.ita16.reqmaster.model.IDataFunctionPointEinstufung;

public class UIModifyFunctionPointEinstufungEvent extends UIModifyEvent {

	IDataFunctionPointEinstufung proposal;
	private DataId id;


	//Konstruktor
	public UIModifyFunctionPointEinstufungEvent(DataId id, IDataFunctionPointEinstufung proposal) {
		this.id = id;
		this.proposal=proposal;
	}


	//getter
	public IDataFunctionPointEinstufung getProposal() {
		return proposal;
	}

	public DataId getID() {
		return id;
	}
}
