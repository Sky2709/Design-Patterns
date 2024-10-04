package lowLevelDesigns._new.stackOverFlowDesign;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Answer implements Commentable, Votable {
    private int answerId;
    private String content;
    private User user;
    private Question question;
    private boolean isAccepted;
    private Date creationDate;
    private List<Comment> comments;
    private List<Vote> votes;

    public Answer(User user, Question question, String content) {
        this.answerId= generateId();
        this.user= user;
        this.question= question;
        this.content= content;
        this.isAccepted=false;
        this.creationDate= new Date();
        this.comments= new ArrayList<>();
        this.votes= new ArrayList<>();
    }

    @Override
    public void addComment(Comment comment) {
        comments.add(comment);
    }

    @Override
    public List<Comment> getComments() {
        return new ArrayList<>(comments);
    }

    @Override
    public void vote(User user, int value) {
        if (value != 1 && value != -1) {
            throw new IllegalArgumentException("Vote value can be either 1 or -1");
        }
        votes.removeIf(v -> v.getUser().equals(user)); // remove the previous vote of the user
        votes.add(new Vote(user, value));
        user.updateReputation(value * 10);
    }

    @Override
    public int getVoteCount() {
        return votes.stream().mapToInt(Vote::getValue).sum();
    }

    public void markAsAccepted(){
        if (isAccepted){
            throw new IllegalArgumentException("Answer is already accepted");
        }
        isAccepted= true;
        user.updateReputation(15);
    }

    private int generateId() {
        return (int) (System.currentTimeMillis() % Integer.MAX_VALUE);
    }

    public int getAnswerId() {
        return answerId;
    }

    public String getContent() {
        return content;
    }

    public User getUser() {
        return user;
    }

    public Question getQuestion() {
        return question;
    }

    public boolean isAccepted() {
        return isAccepted;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public List<Vote> getVotes() {
        return votes;
    }
}
