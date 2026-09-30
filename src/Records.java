import java.util.*;

class User{
    public User(String n, double s, Date d){
        this.NAME = n;
        this.SCORE = s;
        this.DATE = d;
    }

    private final String NAME;
    private final double SCORE;
    private final Date DATE;

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

        if (records.isEmpty()) {
            System.out.println("No records found.");
            return;
        }

        System.out.println("\n========== HALL OF FAME ==========");

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
