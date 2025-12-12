package org.Main;
import java.GUI;
import java.awt.*;// 2. IMPORTS the GUI class so we can use it
import javax.swing.SwingUtilities;
import javax.swing.*;

public class Main {

    public class main {
        public static void main(String[] args) {

            System.out.println("Program starting...");


            SwingUtilities.invokeLater(() -> {
                new GUI();
            });

            System.out.println("GUI Launched!");
        }
    }
}