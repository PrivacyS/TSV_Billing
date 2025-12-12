package GUI;

import java.net.URL;
import java.awt.*;
import javax.swing.JFrame;
import java.awt.Taskbar;
public class Hoursheet_GUI {

    public void Hoursheet_GUI() {
        // 1. Create the frame (the window)
        JFrame frame = new JFrame("My Empty Window");

        // 2. Define what happens when you click the 'X' (Exit the program)
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        try {
            // 1. Load the image from resources
            // Note: The path must start with "/" and match your filename exactly
            URL imageURL = getClass().getResource("/tsv-logo.jpg");


            if (imageURL != null) {
                // Load the image
                Image image = Toolkit.getDefaultToolkit().getImage(imageURL);

                // 2. Set the Dock Icon (Mac specific)
                // This checks if the system supports changing the Taskbar/Dock icon

                if (Taskbar.isTaskbarSupported()) {
                    Taskbar taskbar = Taskbar.getTaskbar();
                    if (taskbar.isSupported(Taskbar.Feature.ICON_IMAGE)) {
                        taskbar.setIconImage(image);
                    }
                }

                // 3. Set the Window Icon (for Windows/Linux support later)
                frame.setIconImage(image);
            }else {
                System.out.println("Error: Image not found!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 3. Set the size (Width: 400px, Height: 300px)
        frame.setSize(400, 300);

        // 4. Center the window on the screen (Optional, but looks nice)
        frame.setLocationRelativeTo(null);

        // 5. Make the window visible
        frame.setVisible(true);
    }


}