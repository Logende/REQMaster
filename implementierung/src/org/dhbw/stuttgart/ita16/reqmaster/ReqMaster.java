package org.dhbw.stuttgart.ita16.reqmaster;

import org.dhbw.stuttgart.ita16.reqmaster.controller.*;
import org.dhbw.stuttgart.ita16.reqmaster.model.*;
import org.dhbw.stuttgart.ita16.reqmaster.view.View;
import java.io.File;

/**
 * Diese Klasse ist die Hauptklasse des Programmes
 * Sie initialisiert die Bestandteile des MVC-Patterns
 * sowie weitere Objekte, die für das Programm benoetigt werden
 */
public class ReqMaster {

    /**
     * Definition der main-Methode
     * @param args Standard-Übergabeparameter der main-Methode, wird nicht verwendet
     */
    public static void main(String[] args){
        IExporter exporter = new XMLExporter();
        IValidator validator = new Validator();
        IAufwandRechner aufwandrechner = new AufwandRechner();
        File schaetzKonfigurationsFile = new File(System.getProperty("user.home") + "/reqmaster/schaetzkonfiguration.xml");
        Model model = new Model(exporter, schaetzKonfigurationsFile);
        View view = new View(model);
        Controller controller = new Controller(model, view, validator, aufwandrechner);
        view.setObserverController(controller);
        model.setObserverView(view);
    }
}
