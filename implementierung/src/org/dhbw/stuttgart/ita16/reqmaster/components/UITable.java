package org.dhbw.stuttgart.ita16.reqmaster.components;

import java.io.*;
import java.util.*;
import javax.swing.*;
//TODO überhaupt benötigt?
/**
 * Adaption der Swing JTable-Klasse fuer individuelle Anpassungen an das Projekt
 */
public class UITable extends JTable {

    /**
     * Standardkonstruktor der Klasse
     */
	public UITable() {
	    super();
	}

    /**
     * Konstruktor der Klasse, zum...
     * @param i
     * @param j
     */
    public UITable(int i, int j) {

	    super(i, j);
    }
}
