import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.Slider;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class Controller implements Initializable {

  @FXML
  private Button nextButton;

  @FXML
  private AnchorPane pane;

  @FXML
  private Button pauseButton;

  @FXML
  private Button playButton;

  @FXML
  private Button previousButton;

  @FXML
  private Button resetButton;

  @FXML
  private Label songLabel;

  @FXML
  private ProgressBar songProgressBar;

  private Media media;
  private MediaPlayer mediaPlayer;

  @FXML
  private ComboBox<String> speedBox;

  @FXML
  private Slider volumeSlider;

  private File directory;
  private File[] files;

  private ArrayList<File> songs;
  private int songNumber;
  private int[] speeds = {25, 50, 75, 100, 125, 150, 175, 200};

  private Timer timer;
  private TimerTask task;
  private boolean running;

  @Override
  public void initialize(URL arg0, ResourceBundle arg1) {
    songs = new ArrayList<File>();

    directory = new File("music");
    files = directory.listFiles();
    if (files != null) {
      for (File file : files) {
        songs.add(file);
      }
    }
    media = new Media(songs.get(songNumber).toURI().toString());
    mediaPlayer = new MediaPlayer(media);
    songLabel.setText(songs.get(songNumber).getName());
  }

  @FXML
  public void playMedia(ActionEvent event) {
    mediaPlayer.play();
  }

  @FXML
  void changeSpeed(ActionEvent event) {}

  @FXML
  void nextMedia(ActionEvent event) {}

  @FXML
  void pauseMedia(ActionEvent event) {}

  @FXML
  void previousMedia(ActionEvent event) {}

  @FXML
  void resetMedia(ActionEvent event) {}
}
