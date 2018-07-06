package org.dhbw.stuttgart.ita16.reqmaster.view;

import org.dhbw.stuttgart.ita16.reqmaster.components.*;
import org.dhbw.stuttgart.ita16.reqmaster.events.*;
import org.dhbw.stuttgart.ita16.reqmaster.model.FPGewichtsfaktor;
import org.dhbw.stuttgart.ita16.reqmaster.model.IModel;

import javax.swing.*;
import java.awt.*;
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
        aufwandMmLabel.setText("Aufwand in MM");
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
        addGB(realerAufwandLabel,ergebnisPanel,  1,  4,  1, 1, insets, constraints);
        addGB(realerAufwand,ergebnisPanel,  2,  4,  1, 1, fill = GridBagConstraints.BOTH, insets, constraints);
        addGB(vafText,ergebnisPanel,  1,  5,  1, 1, insets, constraints);
        addGB(vaf,ergebnisPanel,  2,  5,  1, 1, insets, constraints);

        aufwandAnzeigen.addActionListener(new ActionListenerEventTriggering(view) {
            @Override
            public UIEvent generateEvent(Object source) {
                try {
                    double vaf = Double.parseDouble(UIFunctionPointErgebnis.this.vaf.getText());
                    return new UIActionFPAufwandAnzeigenEvent(vaf);
                } catch (NumberFormatException exception) {
                    return new UIErrorEvent("Invalider 'VAF' Wert.");
                }
            }
        });

        realerAufwand.addFocusListener(new FocusListenerEventTriggering(view, false) {
            @Override
            public UIEvent generateEvent(Component lostFocus, Component gotFocus) {
                try {
                    double value = Double.parseDouble(realerAufwand.getText());
                    return new UIModifyRealerAufwandEvent(value);
                } catch (NumberFormatException exception) {
                    return new UIErrorEvent("Invalider 'realer Aufwand' Wert.");
                }
            }
        });

        gewichtsfaktorOpt.addActionListener(new ActionListenerEventTriggering(view) {
            @Override
            public UIEvent generateEvent(Object source) {
                try {
                    double vaf = Double.parseDouble(UIFunctionPointErgebnis.this.vaf.getText());
                    return new UIActionFPGewichtsfaktorenOptimierenEvent(choice.getSelectedIndex(), vaf);
                } catch (NumberFormatException exception) {
                    return new UIErrorEvent("Invalider 'VAF' Wert.");
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

