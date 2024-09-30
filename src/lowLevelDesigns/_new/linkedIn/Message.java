package lowLevelDesigns._new.linkedIn;

import java.sql.Timestamp;

public class Message {
    private String messageId;
    private User sender;
    private User receiver;
    private String message;
    private Timestamp timestamp;

    public Message(String messageId, User sender, User receiver, String message, Timestamp timestamp) {
        this.messageId = messageId;
        this.sender = sender;
        this.receiver = receiver;
        this.message = message;
        this.timestamp = timestamp;
    }
}
