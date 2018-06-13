package org.dhbw.stuttgart.ita16.reqmaster.components;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Adaption der Swing JButton-Klasse fuer Projektzwecke
 */

public class UIButton extends JButton {

    JButton uiButton;

    /**
     *
     *
     */
    public UIButton() {

        uiButton = new JButton();

        // Settings fuer spezifische Anpassungen hier

        uiButton.setBounds(20,20,30,30);

        uiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }});
    }
}

