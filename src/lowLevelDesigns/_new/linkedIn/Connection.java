package lowLevelDesigns._new.linkedIn;

import java.sql.Timestamp;

public class Connection {
    private User user;
    private Timestamp connectedOn;

    public Connection(User user, Timestamp connectedOn) {
        this.user = user;
        this.connectedOn = connectedOn;
    }

    public User getUser() {
        return user;
    }

    public Timestamp getConnectedOn() {
        return connectedOn;
    }
}
