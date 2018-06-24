package org.dhbw.stuttgart.ita16.reqmaster.components;

import javax.swing.*;
import java.awt.*;

/**
 *  Adaption der Swing JScrollPane Klasse für Projektzwecke
 */
public class UIScrollPane extends JScrollPane {

    /**
     * Konstruktor der Klasse
     * @param comp Komponente die in ScrollPane enthalten sein soll
     * @param vsbPolicy Setting für die vertikale Scrollbar
     * @param hsbPolicy Setting für die horizontale Scrollbar
     */
    public UIScrollPane(Component comp, int vsbPolicy, int hsbPolicy) {
        super(comp, vsbPolicy, hsbPolicy);
    }
}
