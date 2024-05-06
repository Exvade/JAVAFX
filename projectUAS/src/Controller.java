import java.io.IOException;
import javafx.scene.Node;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class Controller {

    @FXML
    void Register(MouseEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("RegisterScene.fxml"));
            Parent root = loader.load();
            // Set scene baru
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.setFullScreen(true);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            // Handle the exception
        }
    }

    @FXML
    void Login(MouseEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("LoginScene.fxml"));
            Parent root = loader.load();
            // Set scene baru
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.setFullScreen(true);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            // Handle the exception
        }
    }

}