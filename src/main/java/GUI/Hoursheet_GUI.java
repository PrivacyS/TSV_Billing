package GUI;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.DatePicker;

import java.time.LocalDate;

public class Hoursheet_GUI extends Application {

    @Override
    public void start(Stage primaryStage) {
        VBox menuBox = new VBox();
        menuBox.setSpacing(10);
        Button uelBtn = new Button("Übungsleiterstunden abrechnen");
        Button back = new Button("back");
        Button trvlCostsBtn = new Button("Fahrtkosten abrechnen");
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

        Scene scene = new Scene(menuBox, 1000, 1000);

        primaryStage.setTitle("TSV Neuburg 1862");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}