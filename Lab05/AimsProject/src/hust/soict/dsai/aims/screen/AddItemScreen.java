package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.store.Store;
import java.awt.*;
import javax.swing.*;

public abstract class AddItemScreen extends JFrame {
    protected Store store;
    protected final Dimension inputFieldSize = new Dimension(200, 20);

    public AddItemScreen(Store store) {
        this.store = store;
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    protected JTextField createInputField() {
        JTextField field = new JTextField();
        field.setPreferredSize(inputFieldSize);
        return field;
    }

    protected abstract void addItem();
}