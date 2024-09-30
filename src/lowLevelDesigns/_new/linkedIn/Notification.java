package lowLevelDesigns._new.linkedIn;

import java.sql.Timestamp;

public class Notification {
    private String notificationId;
    private User user;
    private NotificationType notificationType;
    private String content;
    private Timestamp timestamp;

    public Notification(String notificationId, User user, NotificationType notificationType, String content, Timestamp timestamp) {
        this.notificationId = notificationId;
        this.user = user;
        this.notificationType = notificationType;
        this.content = content;
        this.timestamp = timestamp;
    }

    public String getNotificationId() {
        return notificationId;
    }

    public void setNotificationId(String notificationId) {
        this.notificationId = notificationId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public NotificationType getNotificationType() {
        return notificationType;
    }

    public void setNotificationType(NotificationType notificationType) {
        this.notificationType = notificationType;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }
}
