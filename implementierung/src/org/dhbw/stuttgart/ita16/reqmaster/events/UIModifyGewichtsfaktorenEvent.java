package org.dhbw.stuttgart.ita16.reqmaster.events;

import org.dhbw.stuttgart.ita16.reqmaster.model.IDataSchaetzKonfiguration;

import java.io.*;
import java.util.*;

public class UIModifyGewichtsfaktorenEvent extends UIModifyEvent {

	private final IDataSchaetzKonfiguration proposal;


	//Konstruktor
	public UIModifyGewichtsfaktorenEvent(IDataSchaetzKonfiguration proposal) {
		this.proposal=proposal;
	}


	//getter
	public IDataSchaetzKonfiguration getProposal() {
		return proposal;
	}

}
