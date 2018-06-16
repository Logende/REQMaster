package org.dhbw.stuttgart.ita16.reqmaster.events;

import java.io.*;
import java.util.*;
import org.dhbw.stuttgart.ita16.reqmaster.*;
import org.dhbw.stuttgart.ita16.reqmaster.model.*;
public class UIModifyFunktionstypEvent extends UIModifyEvent {

	private int id;
	private FPFunktionsTyp proposal;

	//Konstruktor der Klasse
	//Zuordnung der Variablen
	public UIModifyFunktionstypEvent(int id, FPFunktionsTyp proposal) {
		this.id=id;
	}

	//getter
	public FPFunktionsTyp getProposal() {
		return proposal;
	}

	//getter
	public int getID() {
		return id;
	}
}
