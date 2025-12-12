package GUI;


import java.awt.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.awt.Taskbar; // Standard Java API for Mac Dock
import java.awt.Toolkit; // Standard Java API for loading AWT images
import java.net.URL;
public class Hoursheet_GUI extends Application {

    @Override
    public void start(Stage stage) {
        // 1. Set the Title
        stage.setTitle("TSV Neuburg 1862");

        // 2. Load the Icon
        // JavaFX uses "/" to look in src/main/resources
        String iconPath = "/tsv-logo.jpg";
        URL iconURL = getClass().getResource(iconPath);

        if (iconURL != null) {
            // A. Set icon for Windows Taskbar & Linux (Native JavaFX way)
            // Note: JavaFX needs the stream string, not the URL object usually
            Image fxImage = new Image(iconURL.toExternalForm());
            stage.getIcons().add(fxImage);

            // B. Set icon for Mac Dock (Specific fix using AWT)
            // JavaFX icons often don't update the Mac Dock automatically when running from IDE
            if (Taskbar.isTaskbarSupported()) {
                Taskbar taskbar = Taskbar.getTaskbar();
                if (taskbar.isSupported(Taskbar.Feature.ICON_IMAGE)) {
                    // We need to load it as an AWT image for the Taskbar API
                    java.awt.Image awtImage = Toolkit.getDefaultToolkit().getImage(iconURL);
                    taskbar.setIconImage(awtImage);
                }
            }
        } else {
            System.out.println("Error: Image not found at " + iconPath);
        }

        // 3. Create a Scene (Content inside the window)
        // We add a simple layout (StackPane) so the window isn't empty
        StackPane root = new StackPane();
        root.getChildren().add(new Label("Welcome to Hoursheet")); // Optional placeholder text
        Scene scene = new Scene(root, 400, 300);

        // 4. Set Scene and Show
        stage.setScene(scene);
        stage.centerOnScreen(); // Equivalent to setLocationRelativeTo(null)
        stage.show();
    }

}