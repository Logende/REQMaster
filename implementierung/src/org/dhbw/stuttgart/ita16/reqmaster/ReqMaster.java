package org.dhbw.stuttgart.ita16.reqmaster;

import org.dhbw.stuttgart.ita16.reqmaster.components.UIButton;
import org.dhbw.stuttgart.ita16.reqmaster.components.UILabel;
import org.dhbw.stuttgart.ita16.reqmaster.components.UIPanel;
import org.dhbw.stuttgart.ita16.reqmaster.components.UITextField;
import org.dhbw.stuttgart.ita16.reqmaster.controller.Controller;
import org.dhbw.stuttgart.ita16.reqmaster.controller.IValidator;
import org.dhbw.stuttgart.ita16.reqmaster.controller.Validator;
import org.dhbw.stuttgart.ita16.reqmaster.model.IExporter;
import org.dhbw.stuttgart.ita16.reqmaster.model.IModel;
import org.dhbw.stuttgart.ita16.reqmaster.model.Model;
import org.dhbw.stuttgart.ita16.reqmaster.view.UIProduktFunktion;
import org.dhbw.stuttgart.ita16.reqmaster.view.View;
import org.dhbw.stuttgart.ita16.reqmaster.view.View.*;
import org.dhbw.stuttgart.ita16.reqmaster.*;
import org.dhbw.stuttgart.ita16.reqmaster.components.UILabel.*;

import javax.swing.*;
import java.awt.*;
import java.io.File;

/**
 * Hier erst einmal ein Testframe und Testpanel zum Testen
 */
public class ReqMaster {

    public static void main(String[] args){
        IExporter exporter = null;
        IValidator validator = new Validator();
        File schaetzKonfigurationsFile = null;
        Model model = new Model(exporter, schaetzKonfigurationsFile);
        View view = new View(model);
        Controller controller = new Controller(model, view, validator);
        view.setObsController(controller);
    }
}
