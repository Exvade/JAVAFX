import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCombination;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application{
  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) throws Exception {
    Stage stage = new Stage();
    Group root = new Group();
    Scene scene = new Scene(root, Color.BLACK);
    Image icon = new Image("./img/flowbite.png");

    stage.setWidth(420);
    stage.setHeight(420);
    stage.setResizable(false);
    // stage.setX(50);
    // stage.setY(50);
    stage.getIcons().add(icon);
    stage.setTitle("Belajar JAVAFX Cuyy");
    stage.setFullScreen(true);
    stage.setFullScreenExitHint("GABISA KELUAR GOBLOK KALO GA PENCET Q");
    stage.setFullScreenExitKeyCombination(KeyCombination.valueOf("q"));


    stage.setScene(scene);
    stage.show();
  }
}
