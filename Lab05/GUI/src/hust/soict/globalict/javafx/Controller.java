package hust.soict.globalict.javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Controller {

    @FXML
    private TextField name;

    @FXML
    void enter(ActionEvent event) {
        System.out.println("Hello " + name.getText());
    }
}
