package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.store.Store;
import java.awt.*;
import javax.swing.*;

public class AddBookScreen extends AddItemScreen {
    private JTextField titleField, categoryField, costField, authorField;

    public AddBookScreen(Store store) {
        super(store);
        setTitle("Add Book");

        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));

        titleField = createInputField();
        categoryField = createInputField();
        costField = createInputField();
        authorField = createInputField();

        inputPanel.add(createLabeledField("Title:", titleField));
        inputPanel.add(createLabeledField("Category:", categoryField));
        inputPanel.add(createLabeledField("Cost:", costField));
        inputPanel.add(createLabeledField("Author:", authorField));

        cp.add(inputPanel, BorderLayout.CENTER);

        JButton addButton = new JButton("Add Book");
        addButton.addActionListener(e -> {
            try {
                String title = titleField.getText();
                String category = categoryField.getText();
                String author = authorField.getText();
                float cost = Float.parseFloat(costField.getText());

                Book book = new Book(title, category, cost);
                book.addAuthor(author);
                store.addMedia(book);

                JOptionPane.showMessageDialog(this, "Book added to store!");
                new StoreScreen(store);
                dispose();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Invalid cost value.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        cp.add(addButton, BorderLayout.SOUTH);
        setVisible(true);
    }

    private JPanel createLabeledField(String labelText, JTextField textField) {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 5));
        JLabel label = new JLabel(labelText);
        label.setPreferredSize(new Dimension(70, 25));
        panel.add(label);
        panel.add(textField);
        return panel;
    }

    @Override
    protected void addItem() {
    }
}