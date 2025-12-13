package GUI;

import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;

public class TravelFX {
    private final BorderPane rootPane;
    private final Button test;
    public TravelFX(Button back) {
        rootPane = new BorderPane();
        test = back;
        rootPane.setTop(test);
    }

    public BorderPane getRootPane(){
        return rootPane;
    }
}
