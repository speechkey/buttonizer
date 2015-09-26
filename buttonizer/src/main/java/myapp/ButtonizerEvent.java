package myapp;

/**
 * Represents a buttonizer event sent to the server
 */
public class ButtonizerEvent {
    private String buttonId;

    // just for the example
    public ButtonizerEvent() {
    }

    // just for the example
    public ButtonizerEvent(String buttonId) {
        this.buttonId = buttonId;
    }

    public String getButtonId() {
        return buttonId;
    }

    public void setButtonId(final String buttonId) {
        this.buttonId = buttonId;
    }

    @Override
    public String toString() {
        return "ButtonizerEvent{" +
                "buttonId=" + buttonId + '}';
    }
}
