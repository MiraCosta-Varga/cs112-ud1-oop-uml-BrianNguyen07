public class Button extends BaseComponent {
    private String label;
    
    // Constructor
    public Button(String label) {
        this.label = label;
    }
    
    // Overriding the abstract method render from BaseComponent
    @Override
    public void render() {
        System.out.println("Rendering Button: " + label);
    }
    
    // Method to simulate clicking the button
    public void click() throws InvalidUserInputException {
        if (label == null || label.isEmpty()) {
            throw new InvalidUserInputException("Button label is invalid.");
        }
        System.out.println("Button " + label + " clicked!");
    }
    
    // Getter and setter for label
    public String getLabel() {
        return label;
    }
    
    public void setLabel(String label) {
        this.label = label;
    }
    
    @Override
    public String toString() {
        return "Button[label=" + label + "]";
    }
}