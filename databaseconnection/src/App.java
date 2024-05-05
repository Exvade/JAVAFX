import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("welcome eksped");

        Statement sqlSt;
        String useSQL = new String("use kuliah");
        String output;
        ResultSet result;
            String SQL = "select * from mahasiswa";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String dbURL = "jdbc:mysql://localhost:3306/kuliah";
            Connection dbConnect = DriverManager.getConnection(dbURL, "root", "");
            sqlSt = dbConnect.createStatement();
            result = sqlSt.executeQuery(SQL);
            while (result.next() != false) {
                output = result.getString("nama") + " " + result.getString("jurusan");
                System.out.println(output);
            }

            sqlSt.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Class not found, check the jar");
        } catch(SQLException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("SQL is BAD!" + ex.getMessage());
        }
    }
}
