package org.dhbw.stuttgart.ita16.reqmaster.model;

public enum FPGewichtsfaktor {

    G1("todo"),
    G2("name2"),
    G3("todo"),
    G4("todo"),
    G5("todo"),
    G6("todo"),
    G7("todo");

    private String displayname;

    FPGewichtsfaktor(String displayname){
        this.displayname = displayname;
    }

    public String getDisplayname() {
        return displayname;
    }
}
