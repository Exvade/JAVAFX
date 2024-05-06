import java.net.URL;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

/**
 *
 * @author kobinath
 */
public class FXMLDocumentController implements Initializable {

  @FXML
  private Label label;

  @FXML
  private TextField txtNama;

  @FXML
  private TextField txtNPM;

  @FXML
  private TextField txtMK;

  @FXML
  private TableView<Student> table;

  @FXML
  private TableColumn<Student, String> IDColmn;

  @FXML
  private TableColumn<Student, String> NameColmn;

  @FXML
  private TableColumn<Student, String> NPMColmn;

  @FXML
  private TableColumn<Student, String> MKColmn;

  @FXML
  private Button btnAdd;

  @FXML
  private Button btnUpdate;

  @FXML
  private Button btnDelete;

  @FXML
  void Add(ActionEvent event) {
    String stnama, stnpm, stmk;
    stnama = txtNama.getText();
    stnpm = txtNPM.getText();
    stmk = txtMK.getText();
    try {
      pst =
        con.prepareStatement(
          "insert into registation(name,mobile,course)values(?,?,?)"
        );
      pst.setString(1, stnama);
      pst.setString(2, stnpm);
      pst.setString(3, stmk);
      pst.executeUpdate();

      Alert alert = new Alert(Alert.AlertType.INFORMATION);
      alert.setTitle("Student Registation");

      alert.setHeaderText("Student Registation");
      alert.setContentText("Record Addedddd!");

      alert.showAndWait();

      table();

      txtNama.setText("");
      txtNPM.setText("");
      txtMK.setText("");
      txtNama.requestFocus();
    } catch (SQLException ex) {
      Logger
        .getLogger(FXMLDocumentController.class.getName())
        .log(Level.SEVERE, null, ex);
    }
  }

  public void table() {
    Connect();
    ObservableList<Student> students = FXCollections.observableArrayList();
    try {
      pst =
        con.prepareStatement("select id,nama,npm,mk from registation");
      ResultSet rs = pst.executeQuery();
      {
        while (rs.next()) {
          Student st = new Student();
          st.setId(rs.getString("id"));
          st.setNama(rs.getString("nama"));
          st.setNPM(rs.getString("npm"));
          st.setMK(rs.getString("mk"));
          students.add(st);
        }
      }
      table.setItems(students);
      IDColmn.setCellValueFactory(f -> f.getValue().idProperty());
      NameColmn.setCellValueFactory(f -> f.getValue().namaProperty());
      NPMColmn.setCellValueFactory(f -> f.getValue().npmProperty());
      MKColmn.setCellValueFactory(f -> f.getValue().mkProperty());
    } catch (SQLException ex) {
      Logger
        .getLogger(FXMLDocumentController.class.getName())
        .log(Level.SEVERE, null, ex);
    }

    table.setRowFactory(tv -> {
      TableRow<Student> myRow = new TableRow<>();
      myRow.setOnMouseClicked(event -> {
        if (event.getClickCount() == 1 && (!myRow.isEmpty())) {
          myIndex = table.getSelectionModel().getSelectedIndex();

          id =
            Integer.parseInt(
              String.valueOf(table.getItems().get(myIndex).getId())
            );
          txtNama.setText(table.getItems().get(myIndex).getNama());
          txtNPM.setText(table.getItems().get(myIndex).getNPM());
          txtMK.setText(table.getItems().get(myIndex).getMK());
        }
      });
      return myRow;
    });
  }

  @FXML
  void Delete(ActionEvent event) {
    myIndex = table.getSelectionModel().getSelectedIndex();

    id =
      Integer.parseInt(String.valueOf(table.getItems().get(myIndex).getId()));

    try {
      pst = con.prepareStatement("delete from registation where id = ? ");
      pst.setInt(1, id);
      pst.executeUpdate();

      Alert alert = new Alert(Alert.AlertType.INFORMATION);
      alert.setTitle("Student Registationn");

      alert.setHeaderText("Student Registation");
      alert.setContentText("Deletedd!");

      alert.showAndWait();
      table();
    } catch (SQLException ex) {
      Logger
        .getLogger(FXMLDocumentController.class.getName())
        .log(Level.SEVERE, null, ex);
    }
  }

  @FXML
  void Update(ActionEvent event) {
    String stnama, stnpm, stmk;

    myIndex = table.getSelectionModel().getSelectedIndex();

    id =
      Integer.parseInt(String.valueOf(table.getItems().get(myIndex).getId()));

    stnama = txtNama.getText();
    stnpm = txtNPM.getText();
    stmk = txtMK.getText();
    try {
      pst =
        con.prepareStatement(
          "update registation set name = ?,mobile = ? ,course = ? where id = ? "
        );
      pst.setString(1, stnama);
      pst.setString(2, stnpm);
      pst.setString(3, stmk);
      pst.setInt(4, id);
      pst.executeUpdate();
      Alert alert = new Alert(Alert.AlertType.INFORMATION);
      alert.setTitle("Student Registationn");

      alert.setHeaderText("Student Registation");
      alert.setContentText("Updateddd!");

      alert.showAndWait();
      table();
    } catch (SQLException ex) {
      Logger
        .getLogger(FXMLDocumentController.class.getName())
        .log(Level.SEVERE, null, ex);
    }
  }

  Connection con;
  PreparedStatement pst;
  int myIndex;
  int id;

  public void Connect() {
    try {
      Class.forName("com.mysql.jdbc.Driver");
      con =
        DriverManager.getConnection(
          "jdbc:mysql://localhost/studcruds",
          "root",
          ""
        );
    } catch (ClassNotFoundException ex) {} catch (SQLException ex) {
      ex.printStackTrace();
    }
  }

  @Override
  public void initialize(URL url, ResourceBundle rb) {
    Connect();
    table();
  }
}
