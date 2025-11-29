package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.store.Store;
import java.awt.*;
import javax.swing.*;

public class AddDVDScreen extends AddItemScreen {
    private JTextField titleField, categoryField, costField, directorField, lengthField;

    public AddDVDScreen(Store store) {
        super(store);
        setTitle("Add Digital Video Disc");

        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));

        titleField = createInputField();
        categoryField = createInputField();
        costField = createInputField();
        directorField = createInputField();
        lengthField = createInputField();

        inputPanel.add(createLabeledField("Title:", titleField));
        inputPanel.add(createLabeledField("Category:", categoryField));
        inputPanel.add(createLabeledField("Cost:", costField));
        inputPanel.add(createLabeledField("Director:", directorField));
        inputPanel.add(createLabeledField("Length:", lengthField));

        cp.add(inputPanel, BorderLayout.CENTER);

        JButton addButton = new JButton("Add DVD");
        addButton.addActionListener(e -> {
            try {
                String title = titleField.getText();
                String category = categoryField.getText();
                String director = directorField.getText();
                int length = Integer.parseInt(lengthField.getText());
                float cost = Float.parseFloat(costField.getText());

                DigitalVideoDisc dvd = new DigitalVideoDisc(title, category, director, length, cost);
                store.addMedia(dvd);

                JOptionPane.showMessageDialog(this, "DVD added to store!");
                new StoreScreen(store);
                dispose();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Invalid length or cost value.", "Error",
                        JOptionPane.ERROR_MESSAGE);
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
