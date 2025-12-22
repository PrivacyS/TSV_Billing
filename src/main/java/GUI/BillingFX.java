package GUI;

import hoursheet.ExcelExport;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.collections.FXCollections;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class BillingFX extends ExcelExport {
    private final GridPane gridPane;
    private final Button test;
    private final DatePicker datePicker;
    public BillingFX(Button back) {
        Text sceneTitle = new Text("Übungsleiterstunden Abrechnung");
        Map<String, Label> formFields = new HashMap<>();
        Button createExcel = new Button("Excel erstellen");
        gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(25, 25, 25, 25));
        Label startTimeLabel = new Label("von");
        TextField startTime = new TextField("Start des Trainings");
        startTimeLabel.setLabelFor(startTime);
        Label endTimeLabel = new Label("bis");
        String[] lables = {"Einheit des Trainings", "von", "bis", "Trainingsort", "Gruppenname"};
        TextField endTime = new TextField("Ende des Trainings");
        endTimeLabel.setLabelFor(endTime);
        ComboBox trainingUnit = new ComboBox();
        Label lengthOfUnit = new Label("Laenge der Einheit");
        lengthOfUnit.setLabelFor(trainingUnit);
        ObservableList<String> options = FXCollections.observableArrayList("45min.", "60min");
        trainingUnit.setItems(options);
        Label placeLabel = new Label("Trainingsort");
        TextField place = new TextField("Trainingsort"); // which gym
        placeLabel.setLabelFor(place);
        Label teamnameLabel = new Label("Teamname");

        TextField teamname = new TextField("Gruppenname");// Herren, Damen, U16 etc.
        teamnameLabel.setLabelFor(teamname);
        formFields.put("startTime", startTimeLabel);
        formFields.put("endTime", endTimeLabel);
        formFields.put("place", placeLabel);
        formFields.put("teamname", teamnameLabel);
        formFields.put("place", placeLabel);
        formFields.put("einheit", lengthOfUnit);

        test = back;
        datePicker = new DatePicker();
        TextField[] fields = {startTime, endTime, place};
        gridPane.add(sceneTitle, 0, 0, 2, 1);
        gridPane.add(trainingUnit, 0, 1, 3,2);
        createExcel.setOnAction(event -> {createExcel();});
        for(int i = 0; i < fields.length; i++) {
            gridPane.add(fields[i], 0, i+4, 1, 1);

        }
        gridPane.add(test, 0, fields.length+7,1,1);
        gridPane.add(createExcel, 0, fields.length+6,1,1);

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
