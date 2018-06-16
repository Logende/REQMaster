package org.dhbw.stuttgart.ita16.reqmaster.events;

import java.io.*;
import java.util.*;

public class UIModifyRealerAufwand extends UIModifyEvent {

	private String proposal;

	//Konstruktor
	public UIModifyRealerAufwand(String proposal) {
    this.proposal=proposal;
	}

	//getter
    public String getProposal() {
        return proposal;
    }
}
