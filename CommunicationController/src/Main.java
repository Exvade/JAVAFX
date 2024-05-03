import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
  @Override
  public void start(Stage primaryStage) {
  try {
   Object root = FXMLLoader.load(getClass().getResource("Scene1.fxml"));
   Scene scene = new Scene((Parent) root);
   primaryStage.setTitle("Controller");
   primaryStage.setScene(scene);
   primaryStage.show();
  } catch (Exception e) {
    // TODO: handle exception
  }
}

public static void main(String[] args) {
 launch(args);
}
}