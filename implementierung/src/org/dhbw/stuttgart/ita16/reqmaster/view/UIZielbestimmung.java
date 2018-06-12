package org.dhbw.stuttgart.ita16.reqmaster.view;

import org.dhbw.stuttgart.ita16.reqmaster.components.UIPanel;
import org.dhbw.stuttgart.ita16.reqmaster.model.IModel;
import org.dhbw.stuttgart.ita16.reqmaster.components.UITextField;

import javax.swing.*;

public class UIZielbestimmung extends UIPanel implements UIUpdateable {

	private UITextField text;

	public UIZielbestimmung() {


		super();
		this.add(text=new UITextField());
		this.add(text=new UITextField());
		this.setBorder(BorderFactory.createTitledBorder("Zielbestimmung"));
		this.setVisible(true);

	}

	public void update(IModel model) {

		text.setText(model.getIDataAnforderungssammlung().getdataZielbestimmung().getText());

	}

}
