import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {
  @Override
  public void start(Stage primaryStage) {
  try {
   Object root = FXMLLoader.load(getClass().getResource("MainScene.fxml"));
   Scene scene = new Scene((Parent)root);
   primaryStage.setTitle("Hellyeahh");
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