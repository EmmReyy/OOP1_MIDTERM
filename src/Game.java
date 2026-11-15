import java.util.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

//class uses to represent a Question
//works like a struct
class Question{
    //constructor for the class, assigns values to variables
    //constructors are methods called upon instantiation
    public Question(String q, String a){
        this.answer = a;
        this.question = q;
    }

    //pirvate class variables
    private final String answer;
    private final String question;

    //getter methods for variables
    public String getAnswer() {
        return answer;
    }

    public String getQuestion() {
        return question;
    }
}

public class Game {

    //constructor for game
    //gives values to the questions list upon instantiation
    public Game(){
        generateQuestions();
    }

    public final int LIMIT = 100;
    //the arrays
    private final ArrayList<Question> questions = new ArrayList<>();
    private ArrayList<Integer> pickedQuestions = new ArrayList<>();

    //database creds
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/trivia_quiz_db";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";

    Question currentQuestion;

    //fill list with random trivia questions
    public void generateQuestions() {

        //empty lists, prevents future errors
        questions.clear();
        pickedQuestions.clear();

        //database query to get our qustions
        String sql = "SELECT question_text, correct_answer FROM questions";

        //attempt a connection
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

             //create a statement. statement is the command we will send to mysql.
             Statement statement = connection.createStatement();
             //take results. results are what the sql sends back
             ResultSet result = statement.executeQuery(sql)) {

            //get teh questions
            while (result.next()) {

                String questionText = result.getString("question_text");
                String correctAnswer = result.getString("correct_answer");

                questions.add(new Question(questionText, correctAnswer));
            }

        } catch (SQLException e) {
            //if error, print error trace
            throw new IllegalStateException(
                    "Could not load questions from MySQL. " +
                            "Make sure Laragon is running.",
                    e
            );
        }

        if (questions.isEmpty()) {
            throw new IllegalStateException(
                    "No questions found in the database."
            );
        }

        //randomize the questions
        Collections.shuffle(questions);
    }

    //pick a random question and print
    public void printRandomQuestion(){

        if (questions.isEmpty()) {
            System.out.println("There are no questions yet.");
            return;
        }

        // keep picking until we get an index that wasn't used yet
        Random rand = new Random();
        int index;
        do {
            index = rand.nextInt(questions.size());
        } while (pickedQuestions.contains(index));

        pickedQuestions.add(index);
        currentQuestion = questions.get(index);
        System.out.println(currentQuestion.getQuestion());

    }


    //take an input answer and compare it to the random answer
    public boolean checkAnswer(String answer){
        if (answer.equalsIgnoreCase(currentQuestion.getAnswer())) {
            System.out.println("Correct");
            return true;
        } else {
            System.out.println("Wrong");
            return false;
        }
    }
}
