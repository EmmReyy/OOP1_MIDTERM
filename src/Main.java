import java.util.*;

public class Main {

    static Game game = new Game();
    static Records records = new Records();

    public static void gameLoop(Scanner scanner){

        System.out.println("Your name?: ");
        String name = scanner.nextLine();

        System.out.println("How many questions?: ");
        int num = Integer.parseInt(scanner.nextLine());

        if (num > game.LIMIT){
            System.out.println("Can only do "+ game.LIMIT +" questions. Number of questions set to default amount.");
            num = 10;
        }

        double score = 0;

        Date timeNow = new Date();


        System.out.println("=======================GAME START!=======================");
        for (int i = 0; i < num; i++){
            game.printRandomQuestion();
            System.out.println("Your answer: ");
            String answer = scanner.nextLine();

            System.out.println("------------");

            if (game.checkAnswer(answer)){score += 1;}

            System.out.println("------------\n");
        }
        System.out.println("=======================GAME END!=======================");
        score = score/num * 100;
        score = Math.round(score*100)/100.0;
        records.addRecords(new User(name, score, timeNow));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        //Game loop
        //will keep going until break
        while (true){
            //calls the method responsible for the game loop
            gameLoop(scanner);
            //after gameloop asks user if they want to play again
            System.out.println("Do you want to play again?");
            String keepGoing = scanner.nextLine();

            //if the answer is anything but yes, stop the loop
            if (!keepGoing.equalsIgnoreCase("yes")){
                break;
            }
        }

        //asks the user if they want to see the hall of fame
        System.out.println("Do you want to see the hall of fame?");
        String shouldPrintRecords = scanner.nextLine();

        //if yes, prints the hall of fame.
        if (shouldPrintRecords.equalsIgnoreCase("yes")){
            records.displayRecords();
        }
    }
}
