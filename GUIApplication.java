import javax.swing.*;

public class GUIApplication {
    public static void main(String[] args) {
        // Create and run the main window on the Event Dispatch Thread
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainWindow().start();
            }
        });
    }
}