import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCombination;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class App extends Application {

  private Stage primaryStage;
  private Scene scene;

  @Override
  public void start(Stage primaryStage) {
    try {
      this.primaryStage = primaryStage;
      Object root = FXMLLoader.load(getClass().getResource("LoginScene.fxml"));
      scene = new Scene((Parent) root);
      
      // Set style menjadi UNDECORATED untuk menghilangkan bingkai jendela
      primaryStage.initStyle(StageStyle.UNDECORATED);
      primaryStage.setFullScreenExitHint("");
      primaryStage.setFullScreenExitKeyCombination(KeyCombination.valueOf("none"));

      // Tambahkan event handler untuk menangani tombol escape
      scene.setOnKeyPressed(event -> {
        if (event.getCode() == KeyCode.ESCAPE) {
          toggleFullScreen();
        }
      });

      primaryStage.setScene(scene);
      primaryStage.setFullScreen(true);
      primaryStage.show();
    } catch (Exception e) {
      System.out.println(e);
    }
  }

  // Method untuk mengubah mode fullscreen
  private void toggleFullScreen() {
    primaryStage.setFullScreen(!primaryStage.isFullScreen());
  }

  public static void main(String[] args) {
    launch(args);
  }
}
