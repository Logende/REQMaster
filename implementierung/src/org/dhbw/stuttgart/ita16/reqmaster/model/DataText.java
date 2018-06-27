package org.dhbw.stuttgart.ita16.reqmaster.model;

import java.io.*;
import java.util.*;

public abstract class DataText {

	private String text;

	public DataText(String text) {
		this.text = text;
	}

	public boolean writeText(String neuerText) {
		this.text = neuerText;
		return true;
	}

	public String getText() {
		return text;
	}

	public void modify(DataText goal){
		this.text = goal.text;
	}

}
