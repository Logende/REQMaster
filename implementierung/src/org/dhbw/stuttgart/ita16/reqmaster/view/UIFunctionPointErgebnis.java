package org.dhbw.stuttgart.ita16.reqmaster.view;

import org.dhbw.stuttgart.ita16.reqmaster.components.*;
import org.dhbw.stuttgart.ita16.reqmaster.controller.IObserverController;
import org.dhbw.stuttgart.ita16.reqmaster.events.*;
import org.dhbw.stuttgart.ita16.reqmaster.model.FPGewichtsfaktor;
import org.dhbw.stuttgart.ita16.reqmaster.model.IModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

/**
 * Die Klasse enthält alle Eingabefelder der Function-Ponit analyse, welche nicht zur Klasse UIFunktionenDaten oder UIGewichtsfaktoren gehören.
 */
public class UIFunctionPointErgebnis extends UIPanel implements  IUIUpdateable{

    //Variablen der Klasse
    private UIButton aufwandAnzeigen;
    private UIButton gewichtsfaktorOpt;
    private UILabel aufwandFP;
    private UILabel aufwandMM;
    private UILabel aufwandMMLabel;
    private UITextField realerAufwand;
    private UILabel vafText;
    private UITextField vaf;
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
        vaf = new UITextField();
        vafText = new UILabel();
        choice = new UIChoice<>(FPGewichtsfaktor.values());
        insets = new Insets(10,10,10,10);

        //Hinzufügen der Komponenten sowie Settings
        this.setLayout(new GridBagLayout());
        this.setBorder(BorderFactory.createTitledBorder("Ergebnis"));
        aufwandAnzeigen.setText("Aufwand in FP anzeigen");
        aufwandMM.setText("Aufwand in MM");
        gewichtsfaktorOpt.setText("Optimieren");
        vafText.setText("VAF-Faktor");
        vaf.setText("1.0");
        realerAufwand.setPreferredSize(new Dimension(100,20));
        realerAufwand.setMinimumSize(new Dimension(50,20));
        vaf.setPreferredSize(new Dimension(100,20));
        vaf.setMinimumSize(new Dimension(50,20));

        //Definieren des Layout wegen GridBagLayout
        GridBagConstraints constraints = new GridBagConstraints();
        addGB(aufwandAnzeigen,this, 1, 1, 1,  1, GridBagConstraints.HORIZONTAL, insets, constraints);
        addGB(aufwandFP,this,  2,  1, 1, 1, insets, constraints);
        addGB(aufwandMMLabel,this,  1,  2,  1, 1, insets, constraints);
        addGB(aufwandMM,this,  2,  2,  1, 1, insets, constraints);
        addGB(gewichtsfaktorOpt,this, 1,  3,  1, 1, fill = GridBagConstraints.HORIZONTAL, insets, constraints);
        addGB(realerAufwand,this,  2,  3,  1, 1, fill = GridBagConstraints.BOTH, insets, constraints);
        addGB(choice, this, 3,3,2,1,fill = GridBagConstraints.BOTH, insets, constraints);
        addGB(vafText,this,  1,  4,  1, 1, insets, constraints);
        addGB(vaf,this,  2,  4,  1, 1, insets, constraints);

        aufwandAnzeigen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (View.forcesFocus == null) {
                    try {
                        double vaf = Double.parseDouble(realerAufwand.getText());
                        getView().getObsController().observe(new UIActionFPAufwandAnzeigenEvent(vaf));
                    } catch (NumberFormatException exception) {
                        JOptionPane.showMessageDialog(UIFunctionPointErgebnis.this, "VAF-Faktor ist kein zulässiger Wert",
                                "Fehler", JOptionPane.WARNING_MESSAGE);
                    }
                }
            }
        });

        gewichtsfaktorOpt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (View.forcesFocus == null) {
                    if (realerAufwand.getText() != null) {
                        try {
                            double value = Double.parseDouble(realerAufwand.getText());
                            realerAufwand.setForeground(Color.BLACK);
                            getView().getObsController().observe(new UIActionFPGewichtsfaktorenOptimierenEvent(choice.getSelectedIndex(), value));
                        } catch (Exception exception) {
                            realerAufwand.setForeground(Color.RED);
                        }
                    }
                }
            }
        });
    }

    public void addGB(Component component, UIPanel parent, int gridx, int gridy, int gridwidth, int gridheight, Insets insets, GridBagConstraints constraints) {
        addGB(component, parent, gridx, gridy, gridwidth, gridheight, GridBagConstraints.NONE, 0.0, 0.0,
                GridBagConstraints.CENTER, insets, 0, 0, constraints);
    }

    public void addGB(Component component, UIPanel parent, int gridx, int gridy, int gridwidth, int gridheight, int fill, Insets insets, GridBagConstraints constraints) {
        addGB(component, parent, gridx, gridy, gridwidth, gridheight, fill, 0.0, 0.0, GridBagConstraints.CENTER,
                insets, 0, 0, constraints);
    }
    private void addGB(Component component, UIPanel parent, int gridx, int gridy, int gridwidth, int gridheight,
                       int fill, double weightx, double weighty, int anchor, Insets insets, int ipadx, int ipady, GridBagConstraints constraints) {
        constraints. gridx = gridx;
        constraints. gridy = gridy;
        constraints. gridwidth = gridwidth;
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

    @Override
    public void update(IModel model) {
        aufwandFP.setText(String.valueOf(model.getIDataAnforderungssammlung().getIDataFunctionPointAnalyse().getAufwandInFP()));
        aufwandMM.setText(String.valueOf(model.getIDataAnforderungssammlung().getIDataFunctionPointAnalyse().getAufwandInMM()));
        realerAufwand.setText(String.valueOf(model.getIDataAnforderungssammlung().getIDataFunctionPointAnalyse().getRealerAufwand()));
    }
}

