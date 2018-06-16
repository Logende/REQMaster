package org.dhbw.stuttgart.ita16.reqmaster.events;

import java.io.*;
import java.util.*;

public class UIModifyGewichtsfaktorenEvent extends UIModifyEvent {

	int[] proposal;

	//getter
	public int[] getproposal() {
		return proposal;
	}

	//Konstruktor
	public UIModifyGewichtsfaktorenEvent(int[] proposal) {
		this.proposal=proposal;
	}

}
