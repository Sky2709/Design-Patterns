package lowLevelDesigns._new.linkedIn;

import java.util.List;

public class User {
    private String userId;
    private String userName;
    private String eMail;
    private String password;
    private Profile profile;
    private List<Connection> connections;
    private List<Message> inbox;
    private List<Message> sentMessages;

    public User(String userId, String userName, String eMail, String password, Profile profile, List<Connection> connections, List<Message> inbox, List<Message> sentMessages) {
        this.userId = userId;
        this.userName = userName;
        this.eMail = eMail;
        this.password = password;
        this.profile = profile;
        this.connections = connections;
        this.inbox = inbox;
        this.sentMessages = sentMessages;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public List<Connection> getConnections() {
        return connections;
    }

    public void setConnections(List<Connection> connections) {
        this.connections = connections;
    }

    public List<Message> getInbox() {
        return inbox;
    }

    public void setInbox(List<Message> inbox) {
        this.inbox = inbox;
    }

    public List<Message> getSentMessages() {
        return sentMessages;
    }

    public void setSentMessages(List<Message> sentMessages) {
        this.sentMessages = sentMessages;
    }
}
