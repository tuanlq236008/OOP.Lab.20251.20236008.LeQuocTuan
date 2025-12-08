package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.store.Store;
import java.awt.*;
import javax.swing.*;

public class AddCDScreen extends AddItemScreen {
    private JTextField titleField, categoryField, costField, artistField, directorField;

    public AddCDScreen(Store store) {
        super(store);
        setTitle("Add Compact Disc");

        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));

        titleField = createInputField();
        categoryField = createInputField();
        costField = createInputField();
        artistField = createInputField();
        directorField = createInputField();

        inputPanel.add(createLabeledField("Title:", titleField));
        inputPanel.add(createLabeledField("Category:", categoryField));
        inputPanel.add(createLabeledField("Cost:", costField));
        inputPanel.add(createLabeledField("Artist:", artistField));
        inputPanel.add(createLabeledField("Director:", directorField));

        cp.add(inputPanel, BorderLayout.CENTER);

        JButton addButton = new JButton("Add CD");
        addButton.addActionListener(e -> {
            try {
                String title = titleField.getText();
                String category = categoryField.getText();
                String artist = artistField.getText();
                String director = directorField.getText();
                float cost = Float.parseFloat(costField.getText());

                CompactDisc cd = new CompactDisc(title, category, director, artist, cost);
                store.addMedia(cd);

                JOptionPane.showMessageDialog(this, "CD added to store!");
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
