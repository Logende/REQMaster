package org.dhbw.stuttgart.ita16.reqmaster;

import org.dhbw.stuttgart.ita16.reqmaster.components.UIButton;

import javax.swing.*;
import java.awt.*;

/**
 * Hier erst einmal ein Testframe und Testpanel zum Testen
 */
public class ReqMaster {

    public static void main(String[] args){

        JFrame testFrame = new JFrame("Test");
        JPanel testPanel = new JPanel();
        UIButton testButton = new UIButton();

        testButton.setText("add");
        testButton.setBounds(20,20,60,30);
        testPanel.setLayout(null);
        testPanel.add(testButton);
        testFrame.setSize(600,600);
        testFrame.add(testPanel);
        testFrame.setVisible(true);

    }
}
