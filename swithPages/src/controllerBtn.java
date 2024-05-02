import java.io.IOException;
import javafx.scene.Node;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class controllerBtn {

    @FXML
    void switchToPage2(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Page2.fxml"));
            Parent root = loader.load();
            // Set scene baru
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            // Handle the exception
        }
    }

    @FXML
    void switchToPage1(ActionEvent event) {
      try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Page1.fxml"));
        Parent root = loader.load();
        // Set scene baru
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    } catch (IOException e) {
        e.printStackTrace();
        // Handle the exception
    }
    }
}
