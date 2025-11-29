package hust.soict.dsai.aims.screen;

import javafx.collections.ListChangeListener;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;
import hust.soict.dsai.aims.store.Store;

public class CartScreenController {

    private Store store;
    private Cart cart;
    private FilteredList<Media> filteredList;

    public CartScreenController(Cart cart, Store store) {
        this.cart = cart;
        this.store = store;
    }

    @FXML
    private Button btnPlay;
    @FXML
    private Button btnRemove;

    @FXML
    private TableView<Media> tblMedia;
    @FXML
    private Label lbTotalCost;
    @FXML
    private Button placeOrderButton;

    @FXML
    private TableColumn<Media, String> colMediaCategory;
    @FXML
    private TableColumn<Media, Float> colMediaCost;
    @FXML
    private TableColumn<Media, String> colMediaTitle;

    @FXML
    private RadioButton radioBtnFilterTitle;
    @FXML
    private RadioButton radioBtnFilterId;
    @FXML
    private TextField tfFilter;
    @FXML
    private ToggleGroup filterCategory;

    @FXML
    private void initialize() {

        colMediaTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        colMediaCategory.setCellValueFactory(new PropertyValueFactory<>("category"));
        colMediaCost.setCellValueFactory(new PropertyValueFactory<>("cost"));

        filteredList = new FilteredList<>(cart.getItemsOrdered(), p -> true);
        tblMedia.setItems(filteredList);

        btnPlay.setVisible(false);
        btnRemove.setVisible(false);

        tblMedia.getSelectionModel().selectedItemProperty().addListener(
                (obs, oldValue, newValue) -> {
                    if (newValue != null)
                        updateButtonBar(newValue);
                });

        tfFilter.textProperty().addListener((obs, oldValue, newValue) -> {
            showFilteredMedia(newValue);
        });

        cart.getItemsOrdered().addListener((ListChangeListener<Media>) c -> updateTotalCost());

        updateTotalCost();
    }

    private void updateTotalCost() {
        lbTotalCost.setText(cart.totalCost() + " $");
    }

    private void updateButtonBar(Media media) {
        btnRemove.setVisible(true);
        btnPlay.setVisible(media instanceof Playable);
    }

    private void showFilteredMedia(String filterText) {
        if (filterText == null || filterText.isBlank()) {
            filteredList.setPredicate(media -> true);
            return;
        }
        String lower = filterText.toLowerCase();

        filteredList.setPredicate(media -> {
            if (radioBtnFilterId.isSelected()) {
                return String.valueOf(media.getId()).contains(lower);
            }
            if (radioBtnFilterTitle.isSelected()) {
                return media.getTitle().toLowerCase().contains(lower);
            }
            return true;
        });
    }

    @FXML
    void btnRemovePressed(ActionEvent event) {
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        if (media != null)
            cart.removeMedia(media);
    }

    @FXML
    void btnPlayPressed(ActionEvent event) {
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        if (media instanceof Playable)
            ((Playable) media).play();
    }

    @FXML
    void handleViewStore(ActionEvent event) {
        new StoreScreen(store);
    }

    @FXML
    void handleViewCart(ActionEvent event) {
        new CartScreen(cart, store);
    }

    @FXML
    void handleAddBook(ActionEvent event) {
        new AddBookScreen(store);
    }

    @FXML
    void handleAddCD(ActionEvent event) {
        new AddCDScreen(store);
    }

    @FXML
    void handleAddDVD(ActionEvent event) {
        new AddDVDScreen(store);
    }
}
