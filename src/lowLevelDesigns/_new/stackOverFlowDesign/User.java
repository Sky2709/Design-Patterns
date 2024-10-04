package lowLevelDesigns._new.stackOverFlowDesign;

import java.util.ArrayList;
import java.util.List;

public class User {
    private int userId;
    private String userName;
    private String email;
    private int reputation;
    private List<Question> questions;
    private List<Answer> answers;
    private List<Comment> comments;


    private static int QUESTION_REPUTATION = 5; // static because it is same for all users and initialized only once
    private static int ANSWER_REPUTATION = 10;
    private static int COMMENT_REPUTATION = 2;


    public User(int userId, String userName, String email) {
        this.userId = userId;
        this.userName = userName;
        this.email = email;
        this.reputation = 0;
        this.questions= new ArrayList<>();
        this.answers = new ArrayList<>();
        this.comments = new ArrayList<>();
    }

    public Question askQuestion(String title, String content, List<String> tags){
        Question question= new Question(this, title, content, tags); // this is the user who is asking the question
        questions.add(question);
        updateReputation(QUESTION_REPUTATION);
        return question;
    }

    public Answer answerQuestion(Question question, String content){
        Answer answer= new Answer(this, question, content);
        answers.add(answer);
        question.addAnswer(answer);
        updateReputation(ANSWER_REPUTATION);
        return answer;
    }

    public Comment addComment(Commentable commentable, String content){
        Comment comment= new Comment(this, content);
        comments.add(comment);
        commentable.addComment(comment);
        updateReputation(COMMENT_REPUTATION);
        return comment;
    }

    synchronized void updateReputation(int value) {
        this.reputation += value;
        if (this.reputation < 0) {
            this.reputation = 0;
        }
    }

    public int getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getEmail() {
        return email;
    }

    public int getReputation() {
        return reputation;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public static int getQuestionReputation() {
        return QUESTION_REPUTATION;
    }

    public static int getAnswerReputation() {
        return ANSWER_REPUTATION;
    }

    public static int getCommentReputation() {
        return COMMENT_REPUTATION;
    }
}
