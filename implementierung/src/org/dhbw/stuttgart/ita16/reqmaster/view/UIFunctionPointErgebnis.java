package org.dhbw.stuttgart.ita16.reqmaster.view;

import org.dhbw.stuttgart.ita16.reqmaster.components.*;
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
 * Grafikkomponente: Die Klasse enthält Eingabe- und Anzeigeelemente
 * für die Ergebniskalkulation der Function-Point-Analyse
 */
public class UIFunctionPointErgebnis extends UIPanel implements  IUIUpdateable{

    //Variablen der Klasse
    private UIButton aufwandAnzeigen;
    private UIButton gewichtsfaktorOpt;
    private UILabel aufwandFp;
    private UILabel aufwandMm;
    private UILabel aufwandMmLabel;
    private UILabel realerAufwandLabel;
    private UITextField realerAufwand;
    private UILabel vafText;
    private UITextField vaf;
    private UIChoice<FPGewichtsfaktor> choice;
    private UIScrollPane scrollPane;
    private UIPanel ergebnisPanel;

    /**
     * Konstruktor der Klasse
     * @param view Instanz der View des MVC-Patterns
     */
    public UIFunctionPointErgebnis(IView view) {
        super(view);
        //Die Klassenvariablen instanzieren
        ergebnisPanel = new UIPanel();
        scrollPane = new UIScrollPane(ergebnisPanel, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        aufwandAnzeigen = new UIButton();
        gewichtsfaktorOpt = new UIButton();
        aufwandMm = new UILabel();
        aufwandFp = new UILabel();
        aufwandMmLabel = new UILabel();
        realerAufwand = new UITextField();
        realerAufwandLabel = new UILabel();
        vaf = new UITextField();
        vafText = new UILabel();
        choice = new UIChoice<>(FPGewichtsfaktor.values());
        insets = new Insets(10,10,10,10);

        //Hinzufügen der Komponenten sowie Settings
        this.setLayout(new FlowLayout());
        this.setBorder(BorderFactory.createTitledBorder("Ergebnis"));
        this.add(scrollPane);
        scrollPane.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        ergebnisPanel.setLayout(new GridBagLayout());
        aufwandAnzeigen.setText("Aufwand in FP anzeigen");
        aufwandMm.setText("Aufwand in MM");
        gewichtsfaktorOpt.setText("Optimieren");
        realerAufwandLabel.setText("Realer Aufwand");
        vafText.setText("VAF-Faktor");
        vaf.setText("1.0");
        realerAufwand.setPreferredSize(new Dimension(100,20));
        realerAufwand.setMinimumSize(new Dimension(50,20));
        vaf.setPreferredSize(new Dimension(100,20));
        vaf.setMinimumSize(new Dimension(50,20));

        //Definieren des Layout wegen GridBagLayout
        GridBagConstraints constraints = new GridBagConstraints();
        addGB(aufwandAnzeigen,ergebnisPanel, 1, 1, 1,  1, GridBagConstraints.HORIZONTAL, insets, constraints);
        addGB(aufwandFp,ergebnisPanel,  2,  1, 1, 1, insets, constraints);
        addGB(aufwandMmLabel,ergebnisPanel,  1,  2,  1, 1, insets, constraints);
        addGB(aufwandMm,ergebnisPanel,  2,  2,  1, 1, insets, constraints);
        addGB(gewichtsfaktorOpt,ergebnisPanel, 1,  3,  1, 1, fill = GridBagConstraints.HORIZONTAL, insets, constraints);
        addGB(choice, ergebnisPanel, 2,3,2,1,fill = GridBagConstraints.BOTH, insets, constraints);
        addGB(realerAufwandLabel,ergebnisPanel,  1,  4,  1, 1, fill = GridBagConstraints.BOTH, insets, constraints);
        addGB(realerAufwand,ergebnisPanel,  2,  4,  1, 1, fill = GridBagConstraints.BOTH, insets, constraints);
        addGB(vafText,ergebnisPanel,  1,  5,  1, 1, insets, constraints);
        addGB(vaf,ergebnisPanel,  2,  5,  1, 1, insets, constraints);

        aufwandAnzeigen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (View.forcesFocus == null) {
                    try {
                        double vaf = Double.parseDouble(UIFunctionPointErgebnis.this.vaf.getText());
                        UIActionFPAufwandAnzeigenEvent event = new UIActionFPAufwandAnzeigenEvent(vaf);
                        getView().getObsController().observe(event);
                        if(!event.isSuccess()){
                            JOptionPane.showMessageDialog(UIFunctionPointErgebnis.this, event.getErrorMessage(),
                                    "Fehler", JOptionPane.WARNING_MESSAGE);
                        }
                    } catch (NumberFormatException exception) {
                        JOptionPane.showMessageDialog(UIFunctionPointErgebnis.this, "VAF-Faktor ist kein zulässiger Wert",
                                "Fehler", JOptionPane.WARNING_MESSAGE);
                    }
                }
            }
        });

        realerAufwand.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
            }

            @Override
            public void focusLost(FocusEvent e) {
                try {
                    double value = Double.parseDouble(realerAufwand.getText());
                    UIModifyRealerAufwandEvent modifyEvent = new UIModifyRealerAufwandEvent(value);
                    getView().getObsController().observe(modifyEvent);

                    if (!modifyEvent.isSuccess()) {
                        JOptionPane.showMessageDialog(e.getComponent().getParent(), modifyEvent.getErrorMessage(),
                                "Änderung nicht valide", JOptionPane.WARNING_MESSAGE);
                        View.forcesFocus = e.getComponent(); // Wenn Änderung nicht richtig, Fokus wieder auf die Komponente setzen
                        e.getComponent().requestFocus();
                    } else {
                        View.forcesFocus = null;
                    }
                } catch (NumberFormatException exception) {
                    JOptionPane.showMessageDialog(e.getComponent().getParent(), "Realer Aufwand: Keine valide Zahl.",
                            "Änderung nicht valide", JOptionPane.WARNING_MESSAGE);
                    View.forcesFocus = e.getComponent(); // Wenn Änderung nicht richtig, Fokus wieder auf die Komponente setzen
                    e.getComponent().requestFocus();
                }
            }
        });

        gewichtsfaktorOpt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (View.forcesFocus == null) {
                        try {
                            double vaf = Double.parseDouble(UIFunctionPointErgebnis.this.vaf.getText());
                            realerAufwand.setForeground(Color.BLACK);
                            UIActionFPGewichtsfaktorenOptimierenEvent event = new UIActionFPGewichtsfaktorenOptimierenEvent(choice.getSelectedIndex(), vaf);
                            getView().getObsController().observe(event);
                            if(!event.isSuccess()){
                                JOptionPane.showMessageDialog(UIFunctionPointErgebnis.this, event.getErrorMessage(),
                                        "Änderung nicht valide", JOptionPane.WARNING_MESSAGE);
                            }
                        } catch (NumberFormatException exception) {
                            realerAufwand.setForeground(Color.RED);
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

    @Override
    public void update(IModel model) {
        aufwandFp.setText(String.valueOf(model.getIDataAnforderungssammlung().getIDataFunctionPointAnalyse().getAufwandInFP()));
        aufwandMm.setText(String.valueOf(model.getIDataAnforderungssammlung().getIDataFunctionPointAnalyse().getAufwandInMM()));
        realerAufwand.setText(String.valueOf(model.getIDataAnforderungssammlung().getIDataFunctionPointAnalyse().getRealerAufwand()));
    }
}

