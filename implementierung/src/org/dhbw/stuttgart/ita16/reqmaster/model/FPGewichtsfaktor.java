package org.dhbw.stuttgart.ita16.reqmaster.model;

public enum FPGewichtsfaktor {

    G1("1. Verflechtung mit anderen Programmen"),
    G2("2. Dezentrale Daten, dezentrale Verarbeitung"),
    G3("3. Transaktionsrate"),
    G4("4. Verarbeitungslogik"),
    G4a("   a Rechenoperationen"),
    G4b("   b Kontrollverfahren"),
    G4c("   c Ausnahmeregelungen"),
    G4d("d Logik"),
    G5("5. Wiederverwendbarkeit"),
    G6("Datenbestandskonvertierung"),
    G7("Anpassbarkeit"),
    SUMME_FAKTOREN("Summe der 7 Einflüsse E2"),
    FAKTOR_EINFLUSS("Faktor Einflussbewertung E2/100 + 0.7");



    private String displayname;

    FPGewichtsfaktor(String displayname){
        this.displayname = displayname;
    }

    public String getDisplayname() {
        return displayname;
    }
}
