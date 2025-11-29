package hust.soict.dsai.aims.screen;

import javax.swing.JFrame;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.store.Store;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class CartScreen extends JFrame {
    private Cart cart;
    private Store store;

    public CartScreen(Cart cart, Store store) {
        super();
        JFXPanel fxPanel = new JFXPanel();
        this.add(fxPanel);

        this.setTitle("Cart");
        this.setVisible(true);
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("Cart.fxml"));
                    loader.setController(new CartScreenController(cart, store));
                    Parent root = loader.load();
                    fxPanel.setScene(new Scene(root));

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        });
    }

    public static void main(String[] args) {
        Cart cart = new Cart();
        Store store = new Store();
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        cart.addMedia(dvd1);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star War", "Science Fiction", "George Lucas", 87, 24.95f);
        cart.addMedia(dvd2);

        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
        cart.addMedia(dvd3);

        // Khởi chạy CartScreen
        new CartScreen(cart, store);

    }

}
