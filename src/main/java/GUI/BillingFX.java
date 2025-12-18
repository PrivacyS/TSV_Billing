package GUI;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.control.DatePicker;

import java.time.LocalDate;
import java.util.Date;

public class BillingFX  {
    private final GridPane gridPane;
    private final Button test;
    private final DatePicker datePicker;
    public BillingFX(Button back) {
        Text sceneTitle = new Text("Übungsleiterstunden Abrechnung");
        gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(25, 25, 25, 25));
        TextField startTime = new TextField();
        TextField endTime = new TextField();
        TextField amount = new TextField(); // 45 or 60 minutes
        TextField place = new TextField(); // which gym
        TextField teamname = new TextField(); // Herren, Damen, U16 etc.
        test = back;
        datePicker = new DatePicker();
        TextField[] fields = {startTime, endTime, amount, place};
        gridPane.add(sceneTitle, 0, 0, 2, 1);
        for(int i = 1; i < fields.length; i++) {
            gridPane.add(fields[i], 0, i, 1, 1);
        }
        gridPane.add(test, 0, fields.length+2,1,1);

        datePicker.setOnAction(event -> {
            LocalDate date = datePicker.getValue();
            System.out.println(date);
        });
        gridPane.add(datePicker, 0, fields.length + 1 ,1 ,1);
    }

    public GridPane getRootPane(){
        return gridPane;
    }



}
