import java.util.*;

class Question {
    String questionText;
    String[] options;
    int correctOption; // 1-based index

    public Question(String questionText, String[] options, int correctOption) {
        this.questionText = questionText;
        this.options = options;
        this.correctOption = correctOption;
    }

    public void displayQuestion(int qNo) {
        System.out.println("\nQuestion " + qNo + ": " + questionText);
        for (int i = 0; i < options.length; i++) {
            System.out.println((i + 1) + ") " + options[i]);
        }
    }

    public boolean isCorrect(int userAnswer) {
        return userAnswer == correctOption;
    }
}

public class QuizGame {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        List<Question> questions = loadQuestions();
        int score = 0;

        System.out.println("🎯 Welcome to the Java Quiz Game!");
        System.out.println("You will be asked " + questions.size() + " questions.\n");

        for (int i = 0; i < questions.size(); i++) {
            Question q = questions.get(i);
            q.displayQuestion(i + 1);

            int answer = getUserAnswer();
            if (q.isCorrect(answer)) {
                System.out.println("✅ Correct!");
                score++;
            } else {
                System.out.println("❌ Incorrect! The correct answer was: " +
                        q.options[q.correctOption - 1]);
            }
        }

        // Final Score
        System.out.println("\n🎉 Quiz Completed!");
        System.out.println("Your Score: " + score + " / " + questions.size());

        if (score == questions.size()) {
            System.out.println("🌟 Excellent! Perfect Score!");
        } else if (score >= questions.size() * 0.7) {
            System.out.println("👍 Good job!");
        } else {
            System.out.println("📚 Keep learning and try again!");
        }
    }

    private static int getUserAnswer() {
        int answer = 0;
        while (true) {
            System.out.print("Your answer (1-4): ");
            try {
                answer = Integer.parseInt(scanner.nextLine());
                if (answer >= 1 && answer <= 4)
                    break;
                else
                    System.out.println("Please enter a number between 1 and 4.");
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Enter a number.");
            }
        }
        return answer;
    }

    private static List<Question> loadQuestions() {
        List<Question> questions = new ArrayList<>();

        questions.add(new Question(
                "What is the size of int in Java?",
                new String[]{"4 bytes", "2 bytes", "8 bytes", "Depends on OS"},
                1
        ));
        questions.add(new Question(
                "Which keyword is used to inherit a class in Java?",
                new String[]{"this", "import", "extends", "implements"},
                3
        ));
        questions.add(new Question(
                "Which method is the entry point of a Java program?",
                new String[]{"main()", "start()", "run()", "init()"},
                1
        ));
        questions.add(new Question(
                "Which one is not a Java feature?",
                new String[]{"Object-Oriented", "Portable", "Use of pointers", "Secure"},
                3
        ));
        questions.add(new Question(
                "Which package contains Scanner class?",
                new String[]{"java.io", "java.lang", "java.util", "java.net"},
                3
        ));

        return questions;
    }
}
