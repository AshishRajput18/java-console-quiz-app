import java.util.*;

public class QuizApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Question> quiz = new ArrayList<>();

        quiz.add(new Question("What is the size of int in Java?",
                new String[]{"2 bytes", "4 bytes", "8 bytes", "Depends on system"}, 2));
        quiz.add(new Question("Who developed Java?",
                new String[]{"Oracle", "Microsoft", "James Gosling", "Guido van Rossum"}, 3));

        int score = 0;

        System.out.println("Welcome to the Java Quiz!\n");

        int questionNumber = 1;
        for (Question q : quiz) {
            System.out.println("Q" + questionNumber + ": " + q.questionText);
            for (int i = 0; i < q.options.length; i++) {
                System.out.println((i + 1) + ". " + q.options[i]);
            }
            System.out.print("Your answer: ");
            int userAnswer = sc.nextInt();

            if (q.isCorrect(userAnswer)) {
                System.out.println("Correct!\n");
                score++;
            } else {
                System.out.println("Wrong! Correct answer is: " + q.options[q.correctAnswer - 1] + "\n");
            }

            questionNumber++;
        }

        System.out.println("Your final score is: " + score + " out of " + quiz.size());
        sc.close();
    }
}
