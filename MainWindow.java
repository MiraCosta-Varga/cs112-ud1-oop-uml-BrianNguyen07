import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class MainWindow extends JFrame {
    private JTextField inputField;
    private JButton submitButton, saveButton;
    private JLabel feedbackLabel;

    public MainWindow() {
        setTitle("Enhanced GUI Application");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create tabs
        JTabbedPane tabbedPane = new JTabbedPane();

        // Input Tab with form
        JPanel inputTab = createInputTab();
        tabbedPane.addTab("Input", inputTab);

        // Save Data Tab with file chooser
        JPanel saveTab = createSaveTab();
        tabbedPane.addTab("Save Data", saveTab);

        // Settings Tab with customization options
        JPanel settingsTab = createSettingsTab();
        tabbedPane.addTab("Settings", settingsTab);

        // Add tabs to frame
        add(tabbedPane);
        setVisible(true);
    }

    private JPanel createInputTab() {
        JPanel panel = new JPanel(new GridLayout(3, 2));
        panel.add(new JLabel("Enter text:"));
        inputField = new JTextField(20);
        panel.add(inputField);

        submitButton = new JButton("Submit");
        submitButton.addActionListener(new SubmitActionListener());
        panel.add(submitButton);

        feedbackLabel = new JLabel("Enter text above and click submit.");
        panel.add(feedbackLabel);
        return panel;
    }

    private JPanel createSaveTab() {
        JPanel panel = new JPanel(new BorderLayout());
        saveButton = new JButton("Save Data");
        saveButton.addActionListener(new SaveActionListener());
        panel.add(saveButton, BorderLayout.CENTER);
        return panel;
    }

    private JPanel createSettingsTab() {
        JPanel panel = new JPanel(new GridLayout(2, 1));
        JLabel colorLabel = new JLabel("Choose a theme color:");
        panel.add(colorLabel);

        JButton colorButton = new JButton("Pick Color");
        colorButton.addActionListener(new ColorChooserActionListener());
        panel.add(colorButton);

        return panel;
    }

    private class SubmitActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String userInput = inputField.getText();
            if (userInput == null || userInput.trim().isEmpty()) {
                feedbackLabel.setText("Please enter valid text.");
                feedbackLabel.setForeground(Color.RED);
            } else {
                feedbackLabel.setText("Submitted: " + userInput);
                feedbackLabel.setForeground(Color.GREEN);
            }
        }
    }

    private class SaveActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JFileChooser fileChooser = new JFileChooser();
            int option = fileChooser.showSaveDialog(MainWindow.this);

            if (option == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                try (FileWriter writer = new FileWriter(file)) {
                    writer.write("User Input: " + inputField.getText());
                    JOptionPane.showMessageDialog(MainWindow.this, "Data saved successfully!",
                            "Save Success", JOptionPane.INFORMATION_MESSAGE);
                } catch (IOException ioException) {
                    JOptionPane.showMessageDialog(MainWindow.this, "Error saving file.",
                            "Save Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }

    private class ColorChooserActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Color newColor = JColorChooser.showDialog(MainWindow.this, "Choose Background Color", getBackground());
            if (newColor != null) {
                getContentPane().setBackground(newColor);
            }
        }
    }
}