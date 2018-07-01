package org.dhbw.stuttgart.ita16.reqmaster.view;

import org.dhbw.stuttgart.ita16.reqmaster.components.UILabel;
import org.dhbw.stuttgart.ita16.reqmaster.components.UIPanel;
import org.dhbw.stuttgart.ita16.reqmaster.components.UITextField;

import javax.swing.*;
import java.awt.*;

public class UIEinflussfaktoren extends UIPanel {

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

    public UIEinflussfaktoren() {
        super();
        setLayout(new GridLayout(14,2));
        setBorder(BorderFactory.createTitledBorder("Einflussfaktoren"));
        addComponents();
        setComponents();
    }

    private void addComponents(){
        this.add(faktorEinsText = new UILabel());
        this.add(faktorEins = new UITextField());
        this.add(faktorZweiText = new UILabel());
        this.add(faktorZwei = new UITextField());
        this.add(faktorDreiText = new UILabel());
        this.add(faktorDrei = new UITextField());
        this.add(faktorVierText = new UILabel());
        this.add(new UILabel());
        this.add(faktorVierAText = new UILabel());
        this.add(faktorAVier = new UITextField());
        this.add(faktorVierBText = new UILabel());
        this.add(faktorBVier = new UITextField());
        this.add(faktorVierCText = new UILabel());
        this.add(faktorCVier = new UITextField());
        this.add(faktorVierDText = new UILabel());
        this.add(faktorDVier = new UITextField());
        this.add(faktorFuenfText = new UILabel());
        this.add(faktorFuenf = new UITextField());
        this.add(faktorSechsText = new UILabel());
        this.add(faktorSechs = new UITextField());
        this.add(faktorSiebenText = new UILabel());
        this.add(faktorSieben = new UITextField());
        this.add(new UILabel());
        this.add(new UILabel());
        this.add(sumEinflussText = new UILabel());
        this.add(sumEinflussZahl = new UILabel());
        this.add(faktorEinflussText = new UILabel());
        this.add(faktorEinflussZahl = new UILabel());
    }

    private void setComponents() {
        faktorEinsText.setText("1. Verflechtung mit anderen Programmen (0-5)");
        faktorZweiText.setText("2. Dezentrale Daten, dezentrale Verarbeitung (0-5)");
        faktorDreiText.setText("3. Transaktionsrate (0-5)");
        faktorVierText.setText("4. Verarbeitungslogik");
        faktorVierAText.setText("   a Rechenoperationen (0-10)");
        faktorVierBText.setText("   b Kontrollverfahren (0-5)");
        faktorVierCText.setText("   c Ausnahmeregelungen (0-10)");
        faktorVierDText.setText("   d Logik (0-5)");
        faktorFuenfText.setText("5. Wiederverwendbarkeit (0-5)");
        faktorSechsText.setText("6. Datenbestandskonvertierung (0-5)");
        faktorSiebenText.setText("7. Anpassbarkeit (0-5)");
        sumEinflussText.setText("Summe der 7 Einflüsse (E2)");
        faktorEinflussText.setText("Faktor Einflussbewertung (E2/100 + 0.7)");
    }
}
