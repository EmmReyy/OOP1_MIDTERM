import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseTest {

    public static void main(String[] args) {

        String url = "jdbc:mysql://127.0.0.1:3306/trivia_quiz_db";
        String username = "root";
        String password = "";

        try (Connection connection =
                     DriverManager.getConnection(url, username, password)) {

            System.out.println("Successfully connected to MySQL!");

        } catch (SQLException e) {

            System.out.println("Connection failed!");
            e.printStackTrace();
        }
    }
}