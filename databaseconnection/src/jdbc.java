import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement; // Perbaikan di sini

public class jdbc {
  public static void main(String[] args) {
    try {
      Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/login_schema", "root", "kepolunajis12");
      Statement statement = connection.createStatement(); // Perbaikan di sini
      ResultSet resultSet = statement.executeQuery("SELECT * FROM USERS"); // Perbaikan di sini
      while (resultSet.next()) {
        System.out.println(resultSet.getString("username"));
        System.out.println(resultSet.getString("password"));
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}
