package lowLevelDesigns._new.stackOverFlowDesign;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class StackOverFlow {
    private Map<Integer, User> usersMap;
    private Map<Integer, Question> questionsMap;
    private Map<Integer, Answer> answersMap;
    private Map<String, Tag> tagsMap;

    public StackOverFlow() {
        this.usersMap=new ConcurrentHashMap<>();
        this.questionsMap=new ConcurrentHashMap<>();
        this.answersMap=new ConcurrentHashMap<>();
        this.tagsMap=new ConcurrentHashMap<>();
    }

    public User createUser(String username, String email){
        int id=usersMap.size()+1;
        User user=new User(id, username, email);
        usersMap.put(id, user);
        return user;
    }

    public Question askQuestion(User user, String title, String content, List<String> tags){
        Question question= user.askQuestion(title, content, tags); // user will ask question
        questionsMap.put(question.getQuestionId(), question);
        for(Tag tag:question.getTags()){
            this.tagsMap.putIfAbsent(tag.getTagName(), tag);
        }
        return question;
    }

    public Answer answerQuestion(User user, Question question, String content){
        Answer answer= user.answerQuestion(question, content);
        answersMap.put(answer.getAnswerId(), answer);
        return answer;
    }

    public Comment addComment(User user, Commentable commentable, String content){
        return user.addComment(commentable, content);
    }

    public void voteQuestion(User user, Question question, int value){
        question.vote(user, value);
    }

    public void voteAnswer(User user, Answer answer, int value){
        answer.vote(user, value);
    }

    public void acceptAnswer(Answer answer){
        answer.markAsAccepted();
    }

    public List<Question> searchQuestions(String query){
        return questionsMap.values().stream()
                .filter(q -> q.getTitle().toLowerCase().contains(query.toLowerCase()) ||
                        q.getContent().toLowerCase().contains(query.toLowerCase()) ||
                        q.getTags().stream().anyMatch(t->t.getTagName().equalsIgnoreCase(query)))
                .collect(Collectors.toList());
    }

    public List<Question> getQuestionsByUser(User user){
        return user.getQuestions();
    }

    public Map<Integer, User> getUsersMap() {
        return usersMap;
    }

    public Map<Integer, Question> getQuestionsMap() {
        return questionsMap;
    }

    public Map<Integer, Answer> getAnswersMap() {
        return answersMap;
    }

    public Map<String, Tag> getTagsMap() {
        return tagsMap;
    }
}
