package org.dhbw.stuttgart.ita16.reqmaster.events;

import java.io.*;
import java.util.*;

public class UIModifyRealerAufwand extends UIModifyEvent {

	private double proposal;

	//Konstruktor
	public UIModifyRealerAufwand(double proposal) {
    this.proposal=proposal;
	}

	//getter
    public double getProposal() {
        return proposal;
    }
}
