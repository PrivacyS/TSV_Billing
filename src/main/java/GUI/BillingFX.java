package GUI;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.control.DatePicker;
import javafx.collections.FXCollections;

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
        TextField startTime = new TextField("Start des Trainings");
        TextField endTime = new TextField("Ende des Trainings");
        ComboBox trainingUnit = new ComboBox();
        ObservableList<String> options = FXCollections.observableArrayList("45min.", "60min");
        trainingUnit.setItems(options);
        TextField place = new TextField("Trainingsort"); // which gym
        TextField teamname = new TextField("Gruppenname"); // Herren, Damen, U16 etc.
        test = back;
        datePicker = new DatePicker();
        TextField[] fields = {startTime, endTime, place};
        gridPane.add(sceneTitle, 0, 0, 2, 1);
        gridPane.add(trainingUnit, 0, 1, 3,2);
        for(int i = 0; i < fields.length; i++) {
            gridPane.add(fields[i], 0, i+4, 1, 1);
        }
        gridPane.add(test, 0, fields.length+6,1,1);

        datePicker.setOnAction(event -> {
            LocalDate date = datePicker.getValue();
            System.out.println(date);
        });
        gridPane.add(datePicker, 0, fields.length + 5,1 ,1);
        gridPane.add(teamname,  0, fields.length + 4,1 ,1);

    }

    public GridPane getRootPane(){
        return gridPane;
    }



}
