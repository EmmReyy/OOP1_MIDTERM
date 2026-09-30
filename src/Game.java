import java.util.*;

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

    Question currentQuestion;

    //fill list with random trivia questions
    public void generateQuestions() {

        questions.clear();
        pickedQuestions.clear();

        questions.add(new Question("What is the capital of France?", "Paris"));
        questions.add(new Question("What is the largest planet in our solar system?", "Jupiter"));
        questions.add(new Question("Who painted the Mona Lisa?", "Leonardo da Vinci"));
        questions.add(new Question("What is the chemical symbol for gold?", "Au"));
        questions.add(new Question("How many continents are there?", "7"));
        questions.add(new Question("What is the fastest land animal?", "Cheetah"));
        questions.add(new Question("What is the smallest prime number?", "2"));
        questions.add(new Question("Who wrote Romeo and Juliet?", "William Shakespeare"));
        questions.add(new Question("What is the largest ocean on Earth?", "Pacific Ocean"));
        questions.add(new Question("How many sides does a hexagon have?", "6"));

        questions.add(new Question("What is the capital of Japan?", "Tokyo"));
        questions.add(new Question("Which planet is known as the Red Planet?", "Mars"));
        questions.add(new Question("What is the boiling point of water in Celsius?", "100"));
        questions.add(new Question("Who developed the theory of relativity?", "Albert Einstein"));
        questions.add(new Question("What is the hardest natural substance?", "Diamond"));
        questions.add(new Question("Which country is famous for the pyramids of Giza?", "Egypt"));
        questions.add(new Question("What is the largest mammal?", "Blue Whale"));
        questions.add(new Question("How many bones are in the adult human body?", "206"));
        questions.add(new Question("What is the currency of Japan?", "Yen"));
        questions.add(new Question("Which gas do humans need to breathe?", "Oxygen"));

        questions.add(new Question("Who was the first person to walk on the Moon?", "Neil Armstrong"));
        questions.add(new Question("What is the capital of Italy?", "Rome"));
        questions.add(new Question("Which planet is closest to the Sun?", "Mercury"));
        questions.add(new Question("What is 12 multiplied by 12?", "144"));
        questions.add(new Question("Who wrote The Odyssey?", "Homer"));
        questions.add(new Question("What is the longest river in South America?", "Amazon River"));
        questions.add(new Question("Which element has the chemical symbol O?", "Oxygen"));
        questions.add(new Question("How many players are on a soccer team on the field?", "11"));
        questions.add(new Question("What is the capital of Canada?", "Ottawa"));
        questions.add(new Question("Which animal is known as the King of the Jungle?", "Lion"));

        questions.add(new Question("What is the largest desert in the world?", "Antarctic Desert"));
        questions.add(new Question("What is the square root of 64?", "8"));
        questions.add(new Question("Which country invented paper?", "China"));
        questions.add(new Question("What is the capital of Australia?", "Canberra"));
        questions.add(new Question("How many planets are in the solar system?", "8"));
        questions.add(new Question("Which organ pumps blood through the human body?", "Heart"));
        questions.add(new Question("What is the chemical symbol for sodium?", "Na"));
        questions.add(new Question("Who wrote Pride and Prejudice?", "Jane Austen"));
        questions.add(new Question("What is the tallest mountain above sea level?", "Mount Everest"));
        questions.add(new Question("Which planet has the most prominent ring system?", "Saturn"));

        questions.add(new Question("How many letters are in the English alphabet?", "26"));
        questions.add(new Question("What is the capital of Germany?", "Berlin"));
        questions.add(new Question("Which instrument has 88 keys?", "Piano"));
        questions.add(new Question("What is the freezing point of water in Celsius?", "0"));
        questions.add(new Question("Who was known as the Maid of Orléans?", "Joan of Arc"));
        questions.add(new Question("What is the largest country by land area?", "Russia"));
        questions.add(new Question("What is the capital of Brazil?", "Brasília"));
        questions.add(new Question("Which metal is liquid at room temperature?", "Mercury"));
        questions.add(new Question("How many degrees are in a right angle?", "90"));
        questions.add(new Question("Which planet is famous for its Great Red Spot?", "Jupiter"));

        questions.add(new Question("Who invented the telephone?", "Alexander Graham Bell"));
        questions.add(new Question("What is the main language spoken in Brazil?", "Portuguese"));
        questions.add(new Question("How many legs does a spider have?", "8"));
        questions.add(new Question("What is the capital of Spain?", "Madrid"));
        questions.add(new Question("Which ocean lies between Africa and Australia?", "Indian Ocean"));
        questions.add(new Question("What is the chemical symbol for iron?", "Fe"));
        questions.add(new Question("Who wrote Harry Potter?", "J.K. Rowling"));
        questions.add(new Question("What is the largest internal organ in the human body?", "Liver"));
        questions.add(new Question("Which country is shaped like a boot?", "Italy"));
        questions.add(new Question("What is 15 multiplied by 5?", "75"));

        questions.add(new Question("Which planet is farthest from the Sun?", "Neptune"));
        questions.add(new Question("Who composed the Ninth Symphony?", "Ludwig van Beethoven"));
        questions.add(new Question("What is the capital of South Korea?", "Seoul"));
        questions.add(new Question("How many teeth does a typical adult human have?", "32"));
        questions.add(new Question("Which bird is often associated with peace?", "Dove"));
        questions.add(new Question("What is the chemical symbol for silver?", "Ag"));
        questions.add(new Question("Who was the first President of the United States?", "George Washington"));
        questions.add(new Question("What is the largest island in the world?", "Greenland"));
        questions.add(new Question("Which country is home to the Great Barrier Reef?", "Australia"));
        questions.add(new Question("What is 100 divided by 4?", "25"));

        questions.add(new Question("What is the capital of Mexico?", "Mexico City"));
        questions.add(new Question("Which planet is known for having the strongest winds?", "Neptune"));
        questions.add(new Question("Who wrote The Great Gatsby?", "F. Scott Fitzgerald"));
        questions.add(new Question("What is the chemical symbol for carbon?", "C"));
        questions.add(new Question("How many minutes are in one hour?", "60"));
        questions.add(new Question("Which animal is the largest living land animal?", "African Elephant"));
        questions.add(new Question("What is the capital of India?", "New Delhi"));
        questions.add(new Question("Which scientist studied evolution by natural selection?", "Charles Darwin"));
        questions.add(new Question("What is the square root of 81?", "9"));
        questions.add(new Question("Which country gifted the Statue of Liberty to the United States?", "France"));

        questions.add(new Question("What is the largest organ of the human body?", "Skin"));
        questions.add(new Question("How many sides does an octagon have?", "8"));
        questions.add(new Question("What is the capital of China?", "Beijing"));
        questions.add(new Question("Which gas makes up most of Earth's atmosphere?", "Nitrogen"));
        questions.add(new Question("Who painted The Starry Night?", "Vincent van Gogh"));
        questions.add(new Question("What is the chemical symbol for potassium?", "K"));
        questions.add(new Question("Which sport uses a shuttlecock?", "Badminton"));
        questions.add(new Question("What is 9 multiplied by 9?", "81"));
        questions.add(new Question("What is the capital of Russia?", "Moscow"));
        questions.add(new Question("Which planet is Earth's twin in size?", "Venus"));

        questions.add(new Question("Who wrote 1984?", "George Orwell"));
        questions.add(new Question("What is the largest species of shark?", "Whale Shark"));
        questions.add(new Question("How many colors are traditionally listed in a rainbow?", "7"));
        questions.add(new Question("What is the capital of the Philippines?", "Manila"));
        questions.add(new Question("Which element has the chemical symbol H?", "Hydrogen"));
        questions.add(new Question("Who formulated the laws of motion?", "Isaac Newton"));
        questions.add(new Question("What is the largest continent?", "Asia"));
        questions.add(new Question("How many sides does a triangle have?", "3"));
        questions.add(new Question("Which country is home to the Eiffel Tower?", "France"));
        questions.add(new Question("What is the capital of Greece?", "Athens"));

        questions.add(new Question("Which mammal is capable of true flight?", "Bat"));
        questions.add(new Question("What is 25 multiplied by 4?", "100"));
        questions.add(new Question("What is the chemical symbol for helium?", "He"));
        questions.add(new Question("Who wrote The Hobbit?", "J.R.R. Tolkien"));
        questions.add(new Question("Which planet rotates on its side?", "Uranus"));
        questions.add(new Question("What is the capital of Egypt?", "Cairo"));
        questions.add(new Question("How many hours are in a day?", "24"));
        questions.add(new Question("Which ocean is the largest?", "Pacific Ocean"));
        questions.add(new Question("Who was the Roman god of war?", "Mars"));
        questions.add(new Question("What is the chemical symbol for calcium?", "Ca"));

        // Randomize the order of the questions
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
