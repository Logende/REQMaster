package org.dhbw.stuttgart.ita16.reqmaster;

import org.dhbw.stuttgart.ita16.reqmaster.components.UIButton;
import org.dhbw.stuttgart.ita16.reqmaster.components.UIPanel;
import org.dhbw.stuttgart.ita16.reqmaster.components.UITextField;
import org.dhbw.stuttgart.ita16.reqmaster.model.IExporter;
import org.dhbw.stuttgart.ita16.reqmaster.model.IModel;
import org.dhbw.stuttgart.ita16.reqmaster.model.Model;
import org.dhbw.stuttgart.ita16.reqmaster.view.UIProduktFunktion;
import org.dhbw.stuttgart.ita16.reqmaster.view.View;
import org.dhbw.stuttgart.ita16.reqmaster.view.View.*;
import org.dhbw.stuttgart.ita16.reqmaster.*;

import javax.swing.*;
import java.awt.*;

/**
 * Hier erst einmal ein Testframe und Testpanel zum Testen
 */
public class ReqMaster {

    public static void main(String[] args){

        JFrame testFrame = new JFrame("Test");

        UIButton delete = new UIButton();
        UITextField id = new UITextField();
        UITextField name = new UITextField();
        UITextField quelle = new UITextField();
        UITextField akteur = new UITextField();
        UITextField beschreibung = new UITextField();
        UITextField verweise = new UITextField();

        UIButton delete1 = new UIButton();
        UITextField name1 = new UITextField();
        UITextField id1 = new UITextField();
        UITextField attribute = new UITextField();
        UITextField verweise1 = new UITextField();

        UIPanel testpanel = new UIPanel();
        UIPanel testpanel1 = new UIPanel();

        testFrame.setSize(1200,1200);
        testFrame.setLayout(null);


        testpanel.add(delete);
        testpanel.add(id);
        testpanel.add(name);
        testpanel.add(quelle);
        testpanel.add(akteur);
        testpanel.add(beschreibung);
        testpanel.add(verweise);

        delete.setBounds(10,10,90,20);
        delete.setText("Löschen");
        id.setText("ID");
        id.setBounds(10,35,150,20);
        name.setBounds(10,60, 150,20);
        name.setText("Name");
        quelle.setBounds(10,85,150,20);
        quelle.setText("Quelle");
        akteur.setBounds(10,110, 150,20);
        akteur.setText("Akteur");
        beschreibung.setBounds(10,135,150,50);
        beschreibung.setText("Beschreibung");
        verweise.setBounds(10,190, 150, 20);
        verweise.setText("Verweise");
        testpanel.setLayout(null);

        testpanel.setBounds(10,10,200,500);
        testpanel.setVisible(true);

        testpanel1.add(delete1);
        testpanel1.add(name1);
        testpanel1.add(id1);
        testpanel1.add(attribute);
        testpanel1.add(verweise1);

        delete1.setText("Löschen");
        delete1.setBounds(10,10,90,20);
        name1.setText("Name");
        name1.setBounds(10,35,150,20);
        id1.setText("ID");
        id1.setBounds(10,60,150,20);
        attribute.setText("Attribute");
        attribute.setBounds(10,85,150,20);
        verweise1.setText("Verweise");
        verweise1.setBounds(10,110,150,20);

        testpanel1.setLayout(null);
        testpanel1.setBounds(210,10,200,500);
        testpanel1.setVisible(true);

        testFrame.add(testpanel);
        testFrame.add(testpanel1);
        testFrame.setVisible(true);

    }
}
