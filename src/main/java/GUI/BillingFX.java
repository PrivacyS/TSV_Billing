package GUI;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.DatePicker;

import java.time.LocalDate;
import java.util.Date;

public class BillingFX  {
    private final BorderPane rootPane;
    private final Button test;
    private final DatePicker datePicker;
    public BillingFX(Button back) {
        rootPane = new BorderPane();
        test = back;
        rootPane.setTop(test);
        datePicker = new DatePicker();
        datePicker.setOnAction(event -> {
            LocalDate date = datePicker.getValue();
            System.out.println(date);
        });
        rootPane.setCenter(datePicker);
    }

    public BorderPane getRootPane(){
        return rootPane;
    }



}
