import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow extends JFrame {
    private JLabel label;
    private JTextField inputField;
    private JButton button;

    // Constructor to set up the GUI
    public MainWindow() {
        setTitle("GUI Application");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Initialize components
        label = new JLabel("Enter text:");
        inputField = new JTextField(20);
        button = new JButton("Submit");

        // Add components to the frame
        JPanel panel = new JPanel();
        panel.add(label);
        panel.add(inputField);
        panel.add(button);
        add(panel, BorderLayout.CENTER);

        // Set button click action
        button.addActionListener(new ButtonClickListener());

        setVisible(true);  // Display the GUI
    }

    // Starts the main window
    public void start() {
        this.setVisible(true);
    }

    // Inner class to handle button click event
    private class ButtonClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String userInput = inputField.getText();
            try {
                if (userInput == null || userInput.isEmpty()) {
                    throw new InvalidUserInputException("Input cannot be empty!");
                }
                JOptionPane.showMessageDialog(MainWindow.this, "You entered: " + userInput, 
                                              "Success", JOptionPane.INFORMATION_MESSAGE);
            } catch (InvalidUserInputException ex) {
                JOptionPane.showMessageDialog(MainWindow.this, ex.getMessage(), 
                                              "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}