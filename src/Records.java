import java.util.*;

//class that represents the user
//user is for saving attempts in the records
class User{
    public User(String n, double s, Date d){
        //sets the values of the variables in user class
        //GOOGLE: this keyword
        this.NAME = n;
        this.SCORE = s;
        this.DATE = d;
    }

    //private variables for User class.
    //since variables are private, other classes cant acces these variables
    private final String NAME;
    private final double SCORE;
    private final Date DATE;

    //since variables are private, these have to be accessed by these methods
    //getter methods return the values of the private variable
    public String getNAME() {
        return NAME;
    }

    public double getSCORE() {
        return SCORE;
    }

    public Date getDATE() {
        return DATE;
    }


    // Display user information
    //Override means the default functionality of this method has been changed
    @Override
    public String toString() {
        return "Name: " + NAME +
                " | Score: " + SCORE +
                " | Date: " + DATE;
    }
}

public class Records {

    private ArrayList<User> records = new ArrayList<User>();

    //print every element in the list
    public void displayRecords(){

        //if list is empyt print error
        if (records.isEmpty()) {
            System.out.println("No records found.");
            return;
        }

        //for readability, prints a header
        System.out.println("\n========== HALL OF FAME ==========");

        //enhanced for loop prints every element in the list
        for (User user : records) {
            System.out.println(user);
        }

        System.out.println("===================================");
    }

    //add a new User to the records list
    public void addRecords(User user){
        records.add(user);

        System.out.println("Record added successfully!");
    }

}
