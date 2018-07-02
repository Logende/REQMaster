package org.dhbw.stuttgart.ita16.reqmaster.view;

import org.dhbw.stuttgart.ita16.reqmaster.components.*;
import org.dhbw.stuttgart.ita16.reqmaster.events.UIActionFPGewichtsfaktorenOptimierenEvent;
import org.dhbw.stuttgart.ita16.reqmaster.events.UIModifyGewichtsfaktorenEvent;
import org.dhbw.stuttgart.ita16.reqmaster.events.UIModifyProduktDatumEvent;
import org.dhbw.stuttgart.ita16.reqmaster.model.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class UIGewichtsfaktoren extends UIPanel implements  IUIUpdateable{

    //Variablen der Klasse
    private UILabel faktorEinsText;
    private UILabel faktorZweiText;
    private UILabel faktorDreiText;
    private UILabel faktorVierText;
    private UILabel faktorVierAText;
    private UILabel faktorVierBText;
    private UILabel faktorVierCText;
    private UILabel faktorVierDText;
    private UILabel faktorFuenfText;
    private UILabel faktorSechsText;
    private UILabel faktorSiebenText;
    private UILabel sumEinflussText;
    private UILabel sumEinflussZahl;
    private UILabel faktorEinflussText;
    private UILabel faktorEinflussZahl;
    private UITextField faktorEins;
    private UITextField faktorZwei;
    private UITextField faktorDrei;
    private UITextField faktorAVier;
    private UITextField faktorBVier;
    private UITextField faktorCVier;
    private UITextField faktorDVier;
    private UITextField faktorFuenf;
    private UITextField faktorSechs;
    private UITextField faktorSieben;
    private UIPanel gewichtsPanel;
    private UIScrollPane scrollPane;

    public UIGewichtsfaktoren(IView view) {
        super(view);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(BorderFactory.createTitledBorder("Einflussfaktoren"));
        addComponents();
        setComponents();
        this.update(view.getModel());
    }

    private void addComponents(){
        // Für jedes UITextField in ProduktDatum wird einmalig ein
        // FocusListener definiert, den die Textfelder im Konstruktor übergeben bekommen
        UIListenerComponentLostFocus listener = (focusLost, focusGained) -> {
            if(focusGained != null) {
                if (focusLost.getParent() == focusGained.getParent()) {
                    if(focusGained instanceof  UITextField) {
                        return; //do nothing if new component has same parent
                    }
                }
            }
            wasModified(focusLost);
        };


        gewichtsPanel = new UIPanel();
        scrollPane = new UIScrollPane(gewichtsPanel, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        this.add(scrollPane);
        gewichtsPanel.add(faktorEinsText = new UILabel());
        gewichtsPanel.add(faktorEins = new UITextField(listener));
        gewichtsPanel.add(faktorZweiText = new UILabel());
        gewichtsPanel.add(faktorZwei = new UITextField(listener));
        gewichtsPanel.add(faktorDreiText = new UILabel());
        gewichtsPanel.add(faktorDrei = new UITextField(listener));
        gewichtsPanel.add(faktorVierText = new UILabel());
        gewichtsPanel.add(new UILabel());
        gewichtsPanel.add(faktorVierAText = new UILabel());
        gewichtsPanel.add(faktorAVier = new UITextField(listener));
        gewichtsPanel.add(faktorVierBText = new UILabel());
        gewichtsPanel.add(faktorBVier = new UITextField(listener));
        gewichtsPanel.add(faktorVierCText = new UILabel());
        gewichtsPanel.add(faktorCVier = new UITextField(listener));
        gewichtsPanel.add(faktorVierDText = new UILabel());
        gewichtsPanel.add(faktorDVier = new UITextField(listener));
        gewichtsPanel.add(faktorFuenfText = new UILabel());
        gewichtsPanel.add(faktorFuenf = new UITextField(listener));
        gewichtsPanel.add(faktorSechsText = new UILabel());
        gewichtsPanel.add(faktorSechs = new UITextField(listener));
        gewichtsPanel.add(faktorSiebenText = new UILabel());
        gewichtsPanel.add(faktorSieben = new UITextField(listener));
        gewichtsPanel.add(new UILabel());
        gewichtsPanel.add(new UILabel());
        gewichtsPanel.add(sumEinflussText = new UILabel());
        gewichtsPanel.add(sumEinflussZahl = new UILabel());
        gewichtsPanel.add(faktorEinflussText = new UILabel());
        gewichtsPanel.add(faktorEinflussZahl = new UILabel());
    }

    private void setComponents() {
        gewichtsPanel.setLayout(new GridLayout(15,2));
        scrollPane.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        faktorEins.setMaximumSize(new Dimension(100,40));
        faktorEinsText.setText(FPGewichtsfaktor.G1.getDisplayname());
        faktorZweiText.setText(FPGewichtsfaktor.G2.getDisplayname());
        faktorDreiText.setText(FPGewichtsfaktor.G3.getDisplayname());
        faktorVierText.setText("4. Verarbeitungslogik");
        faktorVierAText.setText(FPGewichtsfaktor.G4a.getDisplayname());
        faktorVierBText.setText(FPGewichtsfaktor.G4b.getDisplayname());
        faktorVierCText.setText(FPGewichtsfaktor.G4c.getDisplayname());
        faktorVierDText.setText(FPGewichtsfaktor.G4d.getDisplayname());
        faktorFuenfText.setText(FPGewichtsfaktor.G5.getDisplayname());
        faktorSechsText.setText(FPGewichtsfaktor.G6.getDisplayname());
        faktorSiebenText.setText(FPGewichtsfaktor.G7.getDisplayname());
        sumEinflussText.setText("Summe der 7 Einflüsse (E2)");
        faktorEinflussText.setText("Faktor Einflussbewertung (E2/100 + 0.7)");
    }

    @Override
    public void update(IModel model) {
       double[] gewichte = model.getSchaetzKonfiguration().getGewichte2();
        faktorEins.setText(String.valueOf(gewichte[0]));
        faktorZwei.setText(String.valueOf(gewichte[1]));
        faktorDrei.setText(String.valueOf(gewichte[2]));
        faktorAVier.setText(String.valueOf(gewichte[3]));
        faktorBVier.setText(String.valueOf(gewichte[4]));
        faktorCVier.setText(String.valueOf(gewichte[5]));
        faktorDVier.setText(String.valueOf(gewichte[6]));
        faktorFuenf.setText(String.valueOf(gewichte[7]));
        faktorSechs.setText(String.valueOf(gewichte[8]));
        faktorSieben.setText(String.valueOf(gewichte[9]));
    //    sumEinflussZahl.setText(String.valueOf(model.getIDataAnforderungssammlung().getIDataFunctionPointAnalyse().getSummEinflussFaktoren()));
    //    faktorEinflussZahl.setText(String.valueOf(model.getIDataAnforderungssammlung().getIDataFunctionPointAnalyse().getFaktorEinflussBewertung()));
    }


    private void wasModified(Component focusLost) {
        // Erstellen einer Liste mit den aktuellen Attributen
        double[] gewichte = createGewichte();
        DataSchaetzKonfiguration proposal = new DataSchaetzKonfiguration(getView().getModel().getSchaetzKonfiguration().getGewichte1(), gewichte);
        UIModifyGewichtsfaktorenEvent optimierenEvent = new UIModifyGewichtsfaktorenEvent(proposal);
        if (gewichte != null) {
            getView().getObsController().observe(optimierenEvent);
            if (focusLost != null) {
                if (!optimierenEvent.isSuccess()) {
                    JOptionPane.showMessageDialog(focusLost.getParent(), optimierenEvent.getErrorMessage(),
                            "Änderung nicht valide", JOptionPane.WARNING_MESSAGE);
                    View.forcesFocus = UIGewichtsfaktoren.this; // Wenn Änderung nicht richtig, Fokus wieder auf die Komponente setzen
                    focusLost.requestFocus();
                } else {
                    View.forcesFocus = null;
                }
            }
        }
    }

    private double[] createGewichte(){
        try {
            double[] gewichte = new double[11];
            gewichte[0] = Double.parseDouble(faktorEins.getText());
            gewichte[1] = Double.parseDouble(faktorZwei.getText());
            gewichte[2] = Double.parseDouble(faktorDrei.getText());
            gewichte[3] = Double.parseDouble(faktorAVier.getText());
            gewichte[4] = Double.parseDouble(faktorBVier.getText());
            gewichte[5] = Double.parseDouble(faktorCVier.getText());
            gewichte[6] = Double.parseDouble(faktorDVier.getText());
            gewichte[7] = Double.parseDouble(faktorFuenf.getText());
            gewichte[8] = Double.parseDouble(faktorSechs.getText());
            gewichte[9] = Double.parseDouble(faktorSieben.getText());
            return gewichte;
        } catch (NumberFormatException exception) {
            JOptionPane.showMessageDialog(this, "Einer der Gewichtsfaktoren ist keine Zahl!",
                    "Fehler in Gewichtsfaktoren", JOptionPane.WARNING_MESSAGE);
            return null;
        }
    }
}