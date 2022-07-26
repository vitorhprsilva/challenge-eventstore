package net.intelie.challenges;

/**
 * This is just an event stub, feel free to expand it if needed.
 */
public class Event {
    private final String type;
    private final long timestamp;

    private final String content;

    public Event(String type, long timestamp, String content) {
        this.type = type;
        this.timestamp = timestamp;
        this.content = content;
    }

    public String type() {
        return type;
    }

    public long timestamp() {
        return timestamp;
    }

    public String content() {
        return content;
    }
}
