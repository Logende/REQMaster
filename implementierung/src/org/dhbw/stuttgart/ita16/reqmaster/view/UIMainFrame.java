package org.dhbw.stuttgart.ita16.reqmaster.view;

import java.io.*;
import java.util.*;
import org.dhbw.stuttgart.ita16.reqmaster.model.IModel;
import org.dhbw.stuttgart.ita16.reqmaster.components.UIFrame;

public class UIMainFrame extends UIFrame implements UIUpdateable {

	private UIMainPanel mainPanel;

	public UIMainFrame()
	{
		super();
		mainPanel=new UIMainPanel();
        this.add(mainPanel);
        this.setVisible(true);
	}

	public void update(IModel model) {

		mainPanel.update(model);
        this.validate();
	}
    public UIMainPanel getMainPanel() {
        return mainPanel;
    }
}
