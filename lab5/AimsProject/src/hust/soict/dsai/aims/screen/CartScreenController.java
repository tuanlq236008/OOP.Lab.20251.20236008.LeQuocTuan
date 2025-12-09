package hust.soict.dsai.aims.screen;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class CartScreenController {

    @FXML
    private Button btnPlay;

    @FXML
    private Button btnRemove;

    @FXML
    private TableColumn<?, ?> colMediaCategory;

    @FXML
    private TableColumn<?, ?> colMediaCost;

    @FXML
    private TableColumn<?, ?> colMediaTitle;

    @FXML
    private ToggleGroup filterCategory;

    @FXML
    private Label lbTotalCost;

    @FXML
    private Button placeOrderButton;

    @FXML
    private RadioButton radioBtnFilterId;

    @FXML
    private RadioButton radioBtnFilterTitle;

    @FXML
    private TableView<?> tblMedia;

    @FXML
    private TextField tfFilter;

    @FXML
    void btnPlaceOrderPressed(ActionEvent event) {

    }

    @FXML
    void btnPlayPressed(ActionEvent event) {

    }

    @FXML
    void btnRemovePressed(ActionEvent event) {

    }

    @FXML
    void handleAddBook(ActionEvent event) {

    }

    @FXML
    void handleAddCD(ActionEvent event) {

    }

    @FXML
    void handleAddDVD(ActionEvent event) {

    }

    @FXML
    void handleViewCart(ActionEvent event) {

    }

    @FXML
    void handleViewStore(ActionEvent event) {

    }

}
