package org.dhbw.stuttgart.ita16.reqmaster;

import org.dhbw.stuttgart.ita16.reqmaster.components.UIButton;
import org.dhbw.stuttgart.ita16.reqmaster.components.UILabel;
import org.dhbw.stuttgart.ita16.reqmaster.components.UIPanel;
import org.dhbw.stuttgart.ita16.reqmaster.components.UITextField;
import org.dhbw.stuttgart.ita16.reqmaster.controller.Controller;
import org.dhbw.stuttgart.ita16.reqmaster.controller.IValidator;
import org.dhbw.stuttgart.ita16.reqmaster.controller.Validator;
import org.dhbw.stuttgart.ita16.reqmaster.model.*;
import org.dhbw.stuttgart.ita16.reqmaster.view.UIProduktFunktion;
import org.dhbw.stuttgart.ita16.reqmaster.view.View;
import org.dhbw.stuttgart.ita16.reqmaster.view.View.*;
import org.dhbw.stuttgart.ita16.reqmaster.*;
import org.dhbw.stuttgart.ita16.reqmaster.components.UILabel.*;

import javax.swing.*;
import java.awt.*;
import java.io.File;

/**
 * Diese Klasse ist die Hauptklasse des Programmes
 * Sie initialisiert die Bestandteile des MVC-Patterns
 */
public class ReqMaster {

    /**
     * Definition der main-Methode
     * @param args Standard-Übergabeparameter der main-Methode
     */
    public static void main(String[] args){
        IExporter exporter = new XMLExporter();
        IValidator validator = new Validator();
        File schaetzKonfigurationsFile = new File(System.getProperty("user.home") + "/reqmaster/schaetzkonfiguration.xml");
        Model model = new Model(exporter, schaetzKonfigurationsFile);
        View view = new View(model);
        Controller controller = new Controller(model, view, validator);
        view.setObserverController(controller);
        model.setObserverView(view);
    }
}
