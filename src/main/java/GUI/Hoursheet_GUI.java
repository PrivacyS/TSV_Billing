package GUI;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.DatePicker;
import java.awt.Taskbar;
import java.awt.Toolkit;
import java.net.URL;
import java.time.LocalDate;

public class Hoursheet_GUI extends Application {

    @Override
    public void start(Stage primaryStage) {
        VBox menuBox = new VBox();
        menuBox.setSpacing(10);
        Button uelBtn = new Button("Übungsleiterstunden abrechnen");
        uelBtn.setMinSize(200, 5);
        Button back = new Button("back");
        Button trvlCostsBtn = new Button("Fahrtkosten abrechnen");
        trvlCostsBtn.setMinSize(200,5);

        if (Taskbar.isTaskbarSupported()) {
            var taskbar = Taskbar.getTaskbar();

            if (taskbar.isSupported(Taskbar.Feature.ICON_IMAGE)) {
                // You generally need to load this via AWT Toolkit for the Mac Dock
                final Toolkit defaultToolkit = Toolkit.getDefaultToolkit();
                URL imageResource = getClass().getResource("/tsv-logo.jpg");

                if (imageResource != null) {
                    java.awt.Image image = defaultToolkit.getImage(imageResource);
                    taskbar.setIconImage(image);
                }
            }
        }

        back.setOnAction(a -> {
            primaryStage.getScene().setRoot(menuBox);
        });

        uelBtn .setOnAction(e -> {
            BillingFX billing = new BillingFX(back);
            primaryStage.getScene().setRoot(billing.getRootPane());
        });

        trvlCostsBtn.setOnAction(e -> {
            TravelFX travel = new TravelFX(back);
            primaryStage.getScene().setRoot(travel.getRootPane());
        });

        menuBox.getChildren().addAll(uelBtn, trvlCostsBtn);
        menuBox.setAlignment(Pos.CENTER);
        Scene scene = new Scene(menuBox, 1000, 1000);

        primaryStage.setTitle("TSV Neuburg 1862");
        primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("/tsv-logo.jpg")));
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}