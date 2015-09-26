package myapp;

import java.util.Map;

/**
 * @author Artem Grebenkin <ag@nemeses.de>
 */
public class ButtonizerPair {
    private String buttonId;
    private String eventId;
    private Map<String, String> eventCtx;

    public ButtonizerPair() {}

    public ButtonizerPair(final String buttonId, final String eventId, Map<String, String> eventCtx) {
        this.buttonId = buttonId;
        this.eventId = eventId;
        this.eventCtx = eventCtx;
    }

    public void setButtonId(final String buttonId) {
        this.buttonId = buttonId;
    }

    public void setEventId(final String eventId) {
        this.eventId = eventId;
    }

    public void setEventCtx(final Map<String, String> eventCtx) {
        this.eventCtx = eventCtx;
    }

    public String getButtonId() {
        return buttonId;
    }

    public String getEventId() {
        return eventId;
    }

    public Map<String, String> getEventCtx() {
        return eventCtx;
    }

    @Override public String toString() {
        return "ButtonizerPair{" +
                "buttonId='" + buttonId + '\'' +
                ", eventId='" + eventId + '\'' +
                '}';
    }
}
