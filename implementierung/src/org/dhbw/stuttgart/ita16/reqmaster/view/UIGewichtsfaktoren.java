package org.dhbw.stuttgart.ita16.reqmaster.view;

import org.dhbw.stuttgart.ita16.reqmaster.components.UILabel;
import org.dhbw.stuttgart.ita16.reqmaster.components.UIPanel;
import org.dhbw.stuttgart.ita16.reqmaster.components.UIScrollPane;
import org.dhbw.stuttgart.ita16.reqmaster.components.UITextField;
import org.dhbw.stuttgart.ita16.reqmaster.model.FPGewichtsfaktor;

import javax.swing.*;
import java.awt.*;

public class UIGewichtsfaktoren extends UIPanel {

    //Variablen der Klasse
    private UIScrollPane scrollPane;
    private UIPanel gewichtPanel;
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

    public UIGewichtsfaktoren(IView view) {
        super(view);
        this.setLayout(new BorderLayout());
        setBorder(BorderFactory.createTitledBorder("Gewichtsfaktoren"));
        addComponents();
        setComponents();
    }

    private void addComponents(){
        gewichtPanel = new UIPanel();
        this.add(scrollPane = new UIScrollPane(gewichtPanel, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED), BorderLayout.CENTER);
        gewichtPanel.add(faktorEinsText = new UILabel());
        gewichtPanel.add(faktorEins = new UITextField());
        gewichtPanel.add(faktorZweiText = new UILabel());
        gewichtPanel.add(faktorZwei = new UITextField());
        gewichtPanel.add(faktorDreiText = new UILabel());
        gewichtPanel.add(faktorDrei = new UITextField());
        gewichtPanel.add(faktorVierText = new UILabel());
        gewichtPanel.add(new UILabel());
        gewichtPanel.add(faktorVierAText = new UILabel());
        gewichtPanel.add(faktorAVier = new UITextField());
        gewichtPanel.add(faktorVierBText = new UILabel());
        gewichtPanel.add(faktorBVier = new UITextField());
        gewichtPanel.add(faktorVierCText = new UILabel());
        gewichtPanel.add(faktorCVier = new UITextField());
        gewichtPanel.add(faktorVierDText = new UILabel());
        gewichtPanel.add(faktorDVier = new UITextField());
        gewichtPanel.add(faktorFuenfText = new UILabel());
        gewichtPanel.add(faktorFuenf = new UITextField());
        gewichtPanel.add(faktorSechsText = new UILabel());
        gewichtPanel.add(faktorSechs = new UITextField());
        gewichtPanel.add(faktorSiebenText = new UILabel());
        gewichtPanel.add(faktorSieben = new UITextField());
        gewichtPanel.add(sumEinflussText = new UILabel());
        gewichtPanel.add(sumEinflussZahl = new UILabel());
        gewichtPanel.add(faktorEinflussText = new UILabel());
        gewichtPanel.add(faktorEinflussZahl = new UILabel());
    }

    private void setComponents() {
        scrollPane.setBorder(BorderFactory.createEmptyBorder(5,0,0,0));
        gewichtPanel.setLayout(new GridLayout(14,2));
        faktorEinsText.setText(FPGewichtsfaktor.G1.getDisplayname());
        faktorZweiText.setText(FPGewichtsfaktor.G2.getDisplayname());
        faktorDreiText.setText(FPGewichtsfaktor.G3.getDisplayname());
        faktorVierText.setText(FPGewichtsfaktor.G4.getDisplayname());
        faktorVierAText.setText(FPGewichtsfaktor.G4a.getDisplayname());
        faktorVierBText.setText(FPGewichtsfaktor.G4b.getDisplayname());
        faktorVierCText.setText(FPGewichtsfaktor.G4c.getDisplayname());
        faktorVierDText.setText(FPGewichtsfaktor.G4d.getDisplayname());
        faktorFuenfText.setText(FPGewichtsfaktor.G5.getDisplayname());
        faktorSechsText.setText(FPGewichtsfaktor.G6.getDisplayname());
        faktorSiebenText.setText(FPGewichtsfaktor.G7.getDisplayname());
        sumEinflussText.setText(FPGewichtsfaktor.SUMME_FAKTOREN.getDisplayname());
        faktorEinflussText.setText(FPGewichtsfaktor.FAKTOR_EINFLUSS.getDisplayname());
    }
}
