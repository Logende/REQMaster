package org.dhbw.stuttgart.ita16.reqmaster.view;

import org.dhbw.stuttgart.ita16.reqmaster.model.IModel;
import org.dhbw.stuttgart.ita16.reqmaster.components.UITextField;
import org.dhbw.stuttgart.ita16.reqmaster.components.UIPanel;

import javax.swing.*;

public class UIProdukteinsatz extends UIPanel implements UIUpdateable {

	private UITextField text;

	public UIProdukteinsatz()
	{
		super();
		this.add(text=new UITextField());
		this.setBorder(BorderFactory.createTitledBorder("Produkteinsatz"));
		this.setVisible(true);
	}

	public void update(IModel model) {

		text.setText(model.getIDataAnforderungssammlung().getDataProdukteinsatz().getText());
	}


}
