package hust.soict.dsai.aims.screen.customer.controller;

import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.beans.value.ChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

import java.io.IOException;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.exception.PlayerException;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;
import hust.soict.dsai.aims.store.Store;
import hust.soict.dsai.aims.exception.PlayerException;

public class CartScreenController<tblMedia> {
    private Store store;
    private Cart cart;
    private FilteredList<Media> filteredList;

    public CartScreenController(Store store, Cart cart) {
        this.cart = cart;
        this.store = store;
    }

    @FXML
    private Button btnPlay;
    @FXML
    private Button btnRemove;
    @FXML
    private TableColumn<Media, String> colMediaCategory;
    @FXML
    private TableColumn<Media, Float> colMediaCost;
    @FXML
    private TableColumn<Media, String> colMediaTitle;
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
    private TableView<Media> tblMedia;
    @FXML
    private TextField tfFilter;

    @FXML
    void btnPlaceOrderPressed(ActionEvent event) {
        if (cart.getItemsOrdered().isEmpty()) {
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Giỏ hàng trống");
            alert.setHeaderText(null);
            alert.setContentText("Không có sản phẩm nào trong giỏ hàng để đặt.");
            alert.showAndWait();
            return;
        }

        // Thực hiện đặt hàng: xóa tất cả các mục trong giỏ hàng
        cart.clear();
        updateTotalCost(); // Cập nhật lại tổng chi phí (về 0)

        // Hiển thị thông báo đặt hàng thành công
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Đặt hàng thành công");
        alert.setHeaderText(null);
        alert.setContentText("Đơn hàng của bạn đã được đặt thành công!");
        alert.showAndWait();
    }

    @FXML
    void btnPlayPressed(ActionEvent event) {
        Media selectedMedia = tblMedia.getSelectionModel().getSelectedItem();
        if (selectedMedia instanceof Playable) {
            try {
                ((Playable) selectedMedia).play(); // Gọi phương thức play(), có thể ném Exception
                // Nếu play thành công, có thể hiển thị thông báo
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Đang phát Media");
                alert.setHeaderText(null);
                alert.setContentText("Đang phát: " + selectedMedia.getTitle());
                alert.showAndWait();
            } catch (Exception e) {
                // Bắt PlayerException và hiển thị thông tin lỗi
                System.err.println("PlayerException caught in CartController: " + e.getMessage());
                System.err.println("Exception toString(): " + e.toString());
                e.printStackTrace(); // In dấu vết ngăn xếp ra console

                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Lỗi Phát Media");
                alert.setHeaderText("Không thể phát Media!");
                alert.setContentText(e.getMessage() + "\n\nChi tiết lỗi: " + e.toString());
                alert.showAndWait();
            }
        } else {
            System.out.println("Selected item is not playable.");
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Không thể phát");
            alert.setHeaderText(null);
            alert.setContentText("Mục đã chọn không thể phát.");
            alert.showAndWait();
        }
    }

    @FXML
    void btnRemovePressed(ActionEvent event) {
        Media selectedMedia = tblMedia.getSelectionModel().getSelectedItem();
        if (selectedMedia != null) {
            cart.removeMedia(selectedMedia);
            System.out.println("Removed: " + selectedMedia.getTitle() + " from cart.");
            updateTotalCost();
        } else {
            System.out.println("No item selected to remove.");
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Cảnh báo");
            alert.setHeaderText(null);
            alert.setContentText("Vui lòng chọn một mục để xóa.");
            alert.showAndWait();
        }
    }
    private void updateTotalCost() {
        lbTotalCost.setText(String.format("%.2f $", cart.totalCost()));
    }

    @FXML
    void btnViewStorePressed(ActionEvent event) {
        try {
            final String CART_FXML_FILE_PATH = "/hust/soict/dsai/aims/screen/customer/view/Store.fxml";
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(CART_FXML_FILE_PATH));
            
            
            ViewStoreController StoreController = new ViewStoreController(store, cart);
            
            
            fxmlLoader.setController(StoreController);
            
           
            Parent root = fxmlLoader.load();
            
            Stage stage = (Stage)((javafx.scene.Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("AIMS - Store Screen");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Failed to load Store.fxml: " + e.getMessage());
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Lỗi Chuyển Màn Hình");
            alert.setHeaderText("Không thể tải màn hình cửa hàng.");
            alert.setContentText("Chi tiết lỗi: " + e.getMessage());
            alert.showAndWait();
        }
    }

    @FXML
    public void initialize() {
        colMediaTitle.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<>("title"));
        colMediaCategory.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<>("category"));
        colMediaCost.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<>("cost"));
        if(cart.getItemsOrdered() != null) {
            tblMedia.setItems((ObservableList<Media>) cart.getItemsOrdered());
        }
        btnPlay.setVisible(false);
        btnRemove.setVisible(false);

        tblMedia.getSelectionModel().selectedItemProperty().addListener(
            
            new ChangeListener<Media>() {
                @Override
                public void changed(javafx.beans.value.ObservableValue<? extends Media> observable,
                        Media oldValue, Media newValue) {
                    if (newValue != null) {
                        updateButtonBar(newValue);
                    }
                }
            }
        );
        tfFilter.textProperty().addListener((observable, oldValue, newValue) -> {
            showFilteredMedia();
        });

        radioBtnFilterId.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                showFilteredMedia();
            }
        });

        radioBtnFilterTitle.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                showFilteredMedia();
            }
        });
    }
    void showFilteredMedia() {
        String filterText = tfFilter.getText().toLowerCase();

        filteredList.setPredicate(media -> {
            if (filterText == null || filterText.isEmpty()) {
                return true;
            }

            if (radioBtnFilterId.isSelected()) {
                try {
                    int filterId = Integer.parseInt(filterText);
                    return media.getId() == filterId;
                } catch (NumberFormatException e) {
                    return false;
                }
            } else {
                return media.getTitle().toLowerCase().contains(filterText);
            }
        });
    }
    void updateButtonBar(Media media) {
        btnRemove.setVisible(true);
        if (media instanceof hust.soict.dsai.aims.media.Playable) {
            btnPlay.setVisible(true);
        } else {
            btnPlay.setVisible(false);
        }
    }

}
