public class ButtonTester {
    public static void main(String[] args) {
        // Create a button instance
        Button myButton = new Button("Submit");

        // Test rendering the button
        myButton.render();

        // Test clicking the button
        try {
            myButton.click();
        } catch (InvalidUserInputException e) {
            System.out.println(e.getMessage());
        }

        // Test setting an invalid label and triggering the exception
        myButton.setLabel("");
        try {
            myButton.click();
        } catch (InvalidUserInputException e) {
            System.out.println(e.getMessage());
        }

        // Test the toString method
        System.out.println(myButton.toString());
    }
}