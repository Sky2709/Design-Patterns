package lowLevelDesigns._new.stackOverFlowDesign;

import java.util.Date;

public class Comment {
    private int commentId;
    private User user;
    private String content;
    private Date creationTime;
    public Comment(User user, String content) {
        this.commentId=generateId();
        this.user = user;
        this.content = content;
        this.creationTime = new Date();
    }

    private int generateId() {
        return (int) (System.currentTimeMillis() % Integer.MAX_VALUE);
    }

    public int getCommentId() {
        return commentId;
    }

    public User getUser() {
        return user;
    }

    public String getContent() {
        return content;
    }

    public Date getCreationTime() {
        return creationTime;
    }
}
