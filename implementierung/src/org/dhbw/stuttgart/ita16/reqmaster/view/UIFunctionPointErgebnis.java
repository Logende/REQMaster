package org.dhbw.stuttgart.ita16.reqmaster.view;

import org.dhbw.stuttgart.ita16.reqmaster.components.*;
import org.dhbw.stuttgart.ita16.reqmaster.controller.IObserverController;
import org.dhbw.stuttgart.ita16.reqmaster.events.*;
import org.dhbw.stuttgart.ita16.reqmaster.model.FPGewichtsfaktor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

/**
 * Die Klasse enthält alle Eingabefelder der Function-Ponit analyse, welche nicht zur Klasse UIFunktionenDaten oder UIGewichtsfaktoren gehören.
 */
public class UIFunctionPointErgebnis extends UIPanel {

    //Variablen der Klasse
    private UIButton aufwandAnzeigen;
    private UIButton gewichtsfaktorOpt;
    private UILabel aufwandFP;
    private UILabel aufwandMM;
    private UILabel aufwandMMLabel;
    private UITextField realerAufwand;
    private UIChoice<FPGewichtsfaktor> choice;

    public UIFunctionPointErgebnis(IView view) {

		super(view);

		//Die Klassenvariablen instanzieren
        aufwandAnzeigen=new UIButton();
        gewichtsfaktorOpt=new UIButton();
        aufwandMM=new UILabel();
        aufwandFP= new UILabel();
        aufwandMMLabel = new UILabel();
        realerAufwand=new UITextField();
        choice = new UIChoice<>(FPGewichtsfaktor.values());
        insets = new Insets(10,10,10,10);

        //Hinzufügen der Komponenten sowie Settings
        this.setLayout(new GridBagLayout());
        this.setBorder(BorderFactory.createTitledBorder("Ergebnis"));
        aufwandAnzeigen.setText("Aufwand in FP anzeigen");
        aufwandMM.setText("Aufwand in MM");
        gewichtsfaktorOpt.setText("Optimieren");
        realerAufwand.setPreferredSize(new Dimension(100,20));
        realerAufwand.setMinimumSize(new Dimension(50,20));

        //Definieren des Layout wegen GridBagLayout
        addGB(aufwandAnzeigen,this, gridx = 1, gridy = 1, gridwidth = 1, gridheight = 1, fill = GridBagConstraints.HORIZONTAL, insets);
        addGB(aufwandMMLabel,this, gridx = 1, gridy = 2, gridwidth = 1, gridheight = 1, insets);
        addGB(aufwandFP,this, gridx = 2, gridy = 1, gridwidth = 1, gridheight = 1, insets);
        addGB(aufwandMM,this, gridx = 2, gridy = 2, gridwidth = 1, gridheight = 1, insets);
        addGB(gewichtsfaktorOpt,this,gridx = 1, gridy = 3, gridwidth = 1, gridheight = 1, fill = GridBagConstraints.HORIZONTAL, insets);
        addGB(realerAufwand,this, gridx = 2, gridy = 3, gridwidth = 1, gridheight = 1, fill = GridBagConstraints.BOTH, insets);
        addGB(choice, this, 3,3,2,1,fill = GridBagConstraints.BOTH, insets);

        aufwandAnzeigen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    double vaf = Double.parseDouble(realerAufwand.getText());
                    getView().getObsController().observe(new UIActionFPAufwandAnzeigenEvent(vaf));
                }catch(NumberFormatException exception){
                    //TODO: show error message/dialog
                }
            }
        });

        gewichtsfaktorOpt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (realerAufwand.getText() != null) {
                    try {
                        double value = Double.parseDouble(realerAufwand.getText());
                        realerAufwand.setForeground(Color.BLACK);
                        getView().getObsController().observe(new UIActionFPGewichtsfaktorenOptimierenEvent((FPGewichtsfaktor) choice.getSelectedItem(), value));
                    } catch (Exception exception) {
                        realerAufwand.setForeground(Color.RED);
                    }
                }
            }
        });
    }

    public void addGB(Component component, UIPanel parent, int gridx, int gridy, int gridwidth, int gridheight, Insets insets) {
        addGB(component, parent, gridx, gridy, gridwidth, gridheight, GridBagConstraints.NONE, 0.0, 0.0,
                GridBagConstraints.CENTER, insets, 0, 0);
    }

    public void addGB(Component component, UIPanel parent, int gridx, int gridy, int gridwidth, int gridheight, int fill, Insets insets) {
        addGB(component, parent, gridx, gridy, gridwidth, gridheight, fill, 0.0, 0.0, GridBagConstraints.CENTER,
                insets, 0, 0);
    }
    private void addGB(Component component, UIPanel parent, int gridx, int gridy, int gridwidth, int gridheight,
                       int fill, double weightx, double weighty, int anchor, Insets insets, int ipadx, int ipady) {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = gridx;
        constraints.gridy = gridy;
        constraints.gridwidth = gridwidth;
        constraints.gridheight = gridheight;
        constraints.fill = fill;
        constraints.weightx = weightx;
        constraints.weighty = weighty;
        constraints.anchor = anchor;
        constraints.insets = insets;
        constraints.ipadx = ipadx;
        constraints.ipady = ipady;
        parent.add(component, constraints);
    }
}

