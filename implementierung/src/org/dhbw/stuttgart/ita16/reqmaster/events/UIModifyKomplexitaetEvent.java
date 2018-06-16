package org.dhbw.stuttgart.ita16.reqmaster.events;

import java.io.*;
import java.util.*;
import org.dhbw.stuttgart.ita16.reqmaster.model.*;

public class UIModifyKomplexitaetEvent extends UIModifyEvent {

	private int id;
	private FPKomplexitaet proposal;

	public int getID() {
		return id;
	}

	public UIModifyKomplexitaetEvent(int id, FPKomplexitaet proposal) {
		this.id=id;
		this.proposal=proposal;
	}

	public FPKomplexitaet getproposal() {
		return proposal;
	}

}
