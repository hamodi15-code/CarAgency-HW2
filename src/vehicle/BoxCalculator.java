package vehicle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.ParseException;

import javax.swing.text.*;

public class BoxCalculator extends JFrame implements ActionListener {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private JFormattedTextField lengthField, widthField, heightField, volumeField, surfaceAreaField;

    public BoxCalculator() {
        setTitle("Box Calculator");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel(new GridLayout(3, 2));
        inputPanel.add(new JLabel("Length:"));
        lengthField = new JFormattedTextField(createFormatter("#.##"));
        inputPanel.add(lengthField);
        inputPanel.add(new JLabel("Width:"));
        widthField = new JFormattedTextField(createFormatter("#.##"));
        inputPanel.add(widthField);
        inputPanel.add(new JLabel("Height:"));
        heightField = new JFormattedTextField(createFormatter("#.##"));
        inputPanel.add(heightField);
        add(inputPanel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new GridLayout(2, 2));
        JButton volumeButton = new JButton("Calculate Volume");
        volumeButton.addActionListener(this);
        buttonPanel.add(volumeButton);
        volumeField = new JFormattedTextField(createFormatter("#.##"));
        volumeField.setEditable(false);
        buttonPanel.add(volumeField);
        JButton surfaceAreaButton = new JButton("Calculate Surface Area");
        surfaceAreaButton.addActionListener(this);
        buttonPanel.add(surfaceAreaButton);
        surfaceAreaField = new JFormattedTextField(createFormatter("#.##"));
        surfaceAreaField.setEditable(false);
        buttonPanel.add(surfaceAreaField);
        add(buttonPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        try {
            double length = Double.parseDouble(lengthField.getText());
            double width = Double.parseDouble(widthField.getText());
            double height = Double.parseDouble(heightField.getText());
            if (length <= 0 || width <= 0 || height <= 0) {
                throw new NumberFormatException("All inputs must be positive");
            }
            if (e.getActionCommand().equals("Calculate Volume")) {
                double volume = length * width * height;
                volumeField.setText(Double.toString(volume));
            } else if (e.getActionCommand().equals("Calculate Surface Area")) {
                double surfaceArea = 2 * (length * width + length * height + width * height);
                surfaceAreaField.setText(Double.toString(surfaceArea));
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Invalid Input", JOptionPane.ERROR_MESSAGE);
        }
    }

    private MaskFormatter createFormatter(String format) {
        MaskFormatter formatter = null;
        try {
            formatter = new MaskFormatter(format);
            formatter.setPlaceholderCharacter('0');
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        return formatter;
    }

    public static void main(String[] args) {
        new BoxCalculator();
    }
}