package org.dhbw.stuttgart.ita16.reqmaster.model;

/**
 * Auflistung der Gewichtsfaktoren, welche im Rahmen der FP-Analyse verwendet werden und durch den Nutzer angepasst werden können.
 */
public enum FPGewichtsfaktor {

    G1("1. Verflechtung mit anderen Programmen"),
    G2("2. Dezentrale Daten, dezentrale Verarbeitung"),
    G3("3. Transaktionsrate"),
    G4a("4. a Rechenoperationen"),
    G4b("4. b Kontrollverfahren"),
    G4c("4. c Ausnahmeregelungen"),
    G4d("4. d Logik"),
    G5("5. Wiederverwendbarkeit"),
    G6("6. Datenbestandskonvertierung"),
    G7("7. Anpassbarkeit");

    private String displayname;

    FPGewichtsfaktor(String displayname){
        this.displayname = displayname;
    }

    public String getDisplayname() {
        return displayname;
    }

    @Override
    public String toString(){
        return getDisplayname();
    }
}