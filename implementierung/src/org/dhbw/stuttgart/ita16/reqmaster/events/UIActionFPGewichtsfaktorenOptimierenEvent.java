package org.dhbw.stuttgart.ita16.reqmaster.events;

import org.dhbw.stuttgart.ita16.reqmaster.model.FPGewichtsfaktor;

import java.io.*;
import java.util.*;

public class UIActionFPGewichtsfaktorenOptimierenEvent extends UIActionFPEvent {

	private final FPGewichtsfaktor gewichtsfaktor;
	private final double realerAufwand;

	public UIActionFPGewichtsfaktorenOptimierenEvent(FPGewichtsfaktor gewichtsfaktor, double realerAufwand) {
		this.gewichtsfaktor = gewichtsfaktor;
		this.realerAufwand = realerAufwand;
	}

	public FPGewichtsfaktor getGewichtsfaktor() {
		return gewichtsfaktor;
	}

	public double getRealerAufwand() {
		return realerAufwand;
	}
}
