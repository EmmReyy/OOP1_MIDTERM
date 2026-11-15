import java.sql.*;
import java.util.Date;
import java.util.ArrayList;

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
    //since variables are private, other classes cant access these variables
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
    //record
    private ArrayList<User> records = new ArrayList<User>();
    //db url
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/trivia_quiz_db";
    //db username
    private static final String USERNAME = "root";
    //db pass
    private static final String PASSWORD = "";

    //attempt connection to databasw
    private Connection connect() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }

    //print every element in the list
    public void displayRecords(){

        //query
        String sql = "SELECT player_name, score, played_at " + "FROM game_records ORDER BY played_at DESC";

        //attempt connection, send a statement, get a result
        try (Connection connection = connect();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet result = statement.executeQuery()
        ){
            //assume not found by default
            boolean found = false;

            //read every result
            while (result.next()) {

                //if found
                if (!found) {
                    System.out.println(
                            "\n========== HALL OF FAME =========="
                    );
                }

                //found
                found = true;

                //create new user object based on results
                User user = new User(
                        result.getString("player_name"),
                        result.getDouble("score"),
                        result.getTimestamp("played_at")
                );

                //print the user
                System.out.println(user);
            }

            //state if not found
            if (!found) {
                System.out.println("No records found.");
            } else {
                System.out.println(
                        "==================================="
                );
            }
        } catch (SQLException e) {
            //print error if error
            System.out.println("Failed to retrieve records.");
            e.printStackTrace();
        }
    }

    //add a new User to the records list
    public void addRecords(User user){
        String sql = "INSERT INTO game_records " +
                "(player_name, score, played_at) VALUES (?, ?, ?)";

        try (Connection connection = connect();
             PreparedStatement statement =
                     connection.prepareStatement(sql)) {

            statement.setString(1, user.getNAME());
            statement.setDouble(2, user.getSCORE());

            statement.setTimestamp(
                    3,
                    new Timestamp(user.getDATE().getTime())
            );

            statement.executeUpdate();

            System.out.println("Record added successfully!");

        } catch (SQLException e) {
            System.out.println("Failed to save record.");
            e.printStackTrace();
        }
    }

}
