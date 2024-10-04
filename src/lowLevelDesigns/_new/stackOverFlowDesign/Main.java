package lowLevelDesigns._new.stackOverFlowDesign;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        run();
    }

    private static void run() {
        StackOverFlow stackOverFlow = new StackOverFlow();

        User alice=stackOverFlow.createUser("Alice", "alice@example.com");
        User bob=stackOverFlow.createUser("Bob", "bob@example.com");
        User charlie=stackOverFlow.createUser("Charlie", "charlie@example.com");

        // Alice asks a question
        Question javaQuestionAlice=stackOverFlow.askQuestion(alice, "What is polymorphism in Java?",
                "I am not able to understand polymorphism in Java. Can someone explain it to me?",
                Arrays.asList("java", "polymorphism"));

        // Bob answers Alice's question
        Answer javaAnswerBob=stackOverFlow.answerQuestion(bob, javaQuestionAlice,
                "Polymorphism is one of the core concepts of OOP. It allows methods to do different things based on the object it is acting upon.");


        // Charlie comments on Alice's question
        stackOverFlow.addComment(charlie, javaQuestionAlice,"Great question! I'm also interested in learning about this." );

        //Alice comments on Bob's answer
        stackOverFlow.addComment(alice, javaAnswerBob, "Thanks for the explanation, Bob!");

        // Charlie votes on Bob's answer and Alice's question
        stackOverFlow.voteQuestion(charlie, javaQuestionAlice, 1);
        stackOverFlow.voteAnswer(charlie, javaAnswerBob, 1);

        stackOverFlow.acceptAnswer(javaAnswerBob);
    }
}
