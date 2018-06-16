package org.dhbw.stuttgart.ita16.reqmaster.events;

import java.io.*;
import java.util.*;
import org.dhbw.stuttgart.ita16.reqmaster.model.*;

public class UImodyfiKlassifizierungEvent extends UIModifyEvent {

	private int id;
	private FPKlassifzierung proposal;

	public UImodyfiKlassifizierungEvent(int id, FPKlassifzierung proposal) {
		this.id=id;
		this.proposal=proposal;
	}

	public int getID() {
		return id;
	}

	public FPKlassifzierung getproposal() {
		return proposal;
	}
}
