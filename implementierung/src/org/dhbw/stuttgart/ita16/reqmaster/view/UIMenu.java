package org.dhbw.stuttgart.ita16.reqmaster.view;

import org.dhbw.stuttgart.ita16.reqmaster.components.UIButton;
import org.dhbw.stuttgart.ita16.reqmaster.components.UIMenuBar;
import org.dhbw.stuttgart.ita16.reqmaster.components.UIMenuItem;
import org.dhbw.stuttgart.ita16.reqmaster.events.UIActionMenuLoadEvent;
import org.dhbw.stuttgart.ita16.reqmaster.events.UIActionMenuSaveEvent;
import org.dhbw.stuttgart.ita16.reqmaster.events.UIEvent;
import org.dhbw.stuttgart.ita16.reqmaster.model.IModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Grafikkomponente: enthält die Menüeinträge der GUI
 */
public class UIMenu extends UIMenuBar {

    /***Variablen der Klasse*******/
    private IView view;
    private UIMenuItem docExportXml;
    private UIMenuItem fpNeu;
    private UIFunctionPointPanel functionPointPanel;
    /******************************/

    /**
     * Konstruktor der Klasse
     * @param view Instanz der View des MVC-Patterns
     */
    public UIMenu(IView view, UIFunctionPointPanel functionPointPanel) {

        super(view);
        this.view = view;
        this.functionPointPanel = functionPointPanel;

        /********************Instanzierung***************/
        docExportXml = new UIMenuItem("Dokument in XML exportieren");
        fpNeu = new UIMenuItem("Aufwandsabschätzung");
        /************************************************/

        /******************Settings*********************/
        this.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        this.setLayout(new FlowLayout());
        this.add(docExportXml, FlowLayout.LEFT);
        this.add(fpNeu, FlowLayout.LEFT);
        /***********************************************/

        /******Actionlistener definieren****************/
        docExportXml.addActionListener(new ActionListener() {
            /**
             * definiert, dass ein UIActionSaveEvent an den Controller gesendet wird,
             * wenn auf den Button geklickt wird
             * @param e ActionEvent
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                UIActionMenuSaveEvent safeEvent = new UIActionMenuSaveEvent();
                getView().getObsController().observe(safeEvent);
                //TODO success fehlt  if(safeEvent.isSuccess){
                //}
            }
        });

        fpNeu.addActionListener(new ActionListener() {
            /**
             * definiert, dass ein ActionMenuNewEvent an den Controller gesendet wird,
             * wenn auf den Button geklickt wird
             * @param e ActionEvent
             */
            @Override
            public void actionPerformed(ActionEvent e) {
             //TODO welches Event   getView().getObsController().observe(new UI);
                functionPointPanel.setVisible(true);
            }
        });

    }
}
