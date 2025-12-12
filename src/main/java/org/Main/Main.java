package org.Main;

import GUI.Hoursheet_GUI;

import java.awt.*;// 2. IMPORTS the GUI class so we can use it
import javax.swing.SwingUtilities;
import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        System.out.println("Program starting...");


        SwingUtilities.invokeLater(() -> {
            new Hoursheet_GUI();
        });

        System.out.println("GUI Launched!");
    }

}