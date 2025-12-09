package hust.soict.dsai.aims.screen.customer.controller;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.exception.PlayerException;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class ItemController {
    private Cart cart;
    public ItemController(Cart cart) {
        this.cart = cart;
    }

    @FXML
    private Button btnAddToCart;

    @FXML
    private Button btnPlay;

    @FXML
    private Label lblCost;

    @FXML
    private Label lblTitle;

    @FXML
    void btnAddToCartClicked(ActionEvent event) {
        if (this.media != null && this.cart != null) {
            // TODO: Bắt LimitReachedException nếu có trong addMedia()
            cart.addMedia(this.media);
            System.out.println("Added " + this.media.getTitle() + " to cart from ItemController.");
            
            // Có thể thêm thông báo xác nhận thành công
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Thành công");
            alert.setHeaderText(null);
            alert.setContentText("Đã thêm '" + this.media.getTitle() + "' vào giỏ hàng!");
            alert.showAndWait();

        } else {
            System.err.println("Cart or Media is null in ItemController.");
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Lỗi");
            alert.setHeaderText(null);
            alert.setContentText("Không thể thêm sản phẩm vào giỏ hàng.");
            alert.showAndWait();
        }
    }

    @FXML
    void btnPlayClicked(ActionEvent event) {
        if (this.media instanceof Playable) {
            try {
                ((Playable) this.media).play(); // Gọi phương thức play(), có thể ném Exception
                // Nếu play thành công, có thể hiển thị thông báo
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Đang phát Media");
                alert.setHeaderText(null);
                alert.setContentText("Đang phát: " + this.media.getTitle());
                alert.showAndWait();
            } catch (Exception e) {
                // Bắt PlayerException và hiển thị thông tin lỗi
                System.err.println("PlayerException caught in ItemController: " + e.getMessage());
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
    private Media media;
    public void setData(Media media) {
        this.media = media;
        lblTitle.setText(media.getTitle());
        lblCost.setText(String.valueOf(media.getCost()) + " $");

        if (media instanceof Playable) {
            btnPlay.setVisible(true);
        } else {
            btnPlay.setVisible(false);
                HBox.setMargin(btnAddToCart, new Insets(0, 0, 0, 60));
        }
    }
}