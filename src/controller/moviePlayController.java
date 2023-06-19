package controller;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import model.movie;

public class moviePlayController implements Initializable{

    @FXML
    ImageView backButton;

    @FXML
    private ImageView playButton, restartButton;

    @FXML
    private ImageView moviePoster;

    @FXML
    private Text titleText, yearText, descripText;

    File directory = new File("");
    String loc = (directory.getAbsolutePath() + "\\src\\movieTrailer\\sample_video.mp4");

    private File file;
    private Media media;
    private MediaPlayer mediaPlayer;

    private boolean isVidPlaying = false;

    @FXML
    private ImageView vidIconOpen, vidIconClose, peekIcon;

    @FXML
    private Pane infoPane;
    
    @FXML 
    MediaView mediaView;

    public void initialize(URL arg0, ResourceBundle arg1) {
        vidIconOpen.setMouseTransparent(true);
        vidIconClose.setMouseTransparent(true);
        System.out.println("Initializing moviePlayController");
        videoTrailer();
        firstPoster(movieChoosen, moviePoster);
        firstDescrip(movieChoosen, descripText);
        firstTitle(movieChoosen, titleText);
        firstYear(movieChoosen, yearText);
        vidIconClose.setVisible(true);
        vidIconOpen.setVisible(false);
        infoPane.setOnMouseClicked(event -> hideInfo());

    }

    static String movieChoosen = "";

    public void videoTrailer() {

        file = new File(loc);
        media = new Media(file.toURI().toString());
        mediaPlayer = new MediaPlayer(media);
        mediaView.setMediaPlayer(mediaPlayer);
        mediaView.setFitHeight(580);
        mediaView.setFitWidth(1160);
        mediaPlayer.setAutoPlay(true);
    }

    public void pauseVideo() {
        mediaPlayer.pause();
    }

    public void playVideo() {
        mediaPlayer.play();
    }

    public void restartVideo() {
        mediaPlayer.seek(mediaPlayer.getStartTime());
    }

    public void playButtonClicked() {
        if (isVidPlaying) {
            pauseVideo();
            isVidPlaying = false;
        } else {
            playVideo();
            isVidPlaying = true;
        }
    }

    public void switchToHomepage(MouseEvent event) throws IOException {
        mediaPlayer.stop();
        Parent root = FXMLLoader.load(getClass().getResource("/view/movieHomepage.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);  
        stage.setScene(scene);
        stage.show();
    }

    public void firstPoster(String movieClass, ImageView imagenode) {
        try {
            String className = "model." + movieClass; // M_1, "M_1"
            Class<?> clazz = Class.forName(className);
            Object instance = clazz.getDeclaredConstructor().newInstance();

            if (instance instanceof movie) {
                movie movieInstance = (movie) instance;
                ImageView movieImage = movieInstance.getPosterImage();
                imagenode.setFitHeight(250);
                imagenode.setFitWidth(150);
                imagenode.setImage(movieImage.getImage());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void firstDescrip(String movieClass, Text descriptionText) {
        try {
            String className = "model." + movieClass;
            Class<?> clazz = Class.forName(className);
            Object instance = clazz.getDeclaredConstructor().newInstance();

            if (instance instanceof movie) {
                movie movieInstance = (movie) instance;
                String movieDescription = movieInstance.getDescription();
                descriptionText.setText(movieDescription);
            }
            } catch (Exception e) {
                e.printStackTrace();
        }
    }

    public void firstTitle(String movieClass, Text titleText) {
        try {
            String className = "model." + movieClass;
            Class<?> clazz = Class.forName(className);
            Object instance = clazz.getDeclaredConstructor().newInstance();

            if (instance instanceof movie) {
                movie movieInstance = (movie) instance;
                String movieName = movieInstance.getName();
                titleText.setText(movieName);
            }
            } catch (Exception e) {
                e.printStackTrace();
        }
    }


    public void firstYear(String movieClass, Text yearText) {
        try {
            String className = "model." + movieClass;
            Class<?> clazz = Class.forName(className);
            Object instance = clazz.getDeclaredConstructor().newInstance();

            if (instance instanceof movie) {
                movie movieInstance = (movie) instance;
                String movieYear = movieInstance.getYearMade();
                yearText.setText(movieYear);
            }
            } catch (Exception e) {
                e.printStackTrace();
        }
    }

    public void showInfo() {
        movePaneTo(infoPane, -224);
    }

    public void hideInfo() {
        movePaneTo(infoPane, 224);
    }

    public void slightReveal() {
        moveImageViewTo(peekIcon, 20);
        changePicVidIconOpen();
        hidePicVidIconClose();
    }

    public void slightHide() {
        moveImageViewTo(peekIcon, -20);
        changePicVidIconClose();
        hidePicVidIconOpen();
    }

    public void changePicVidIconOpen() {
        vidIconOpen.setVisible(true);
    }

    public void hidePicVidIconOpen() {
        vidIconOpen.setVisible(false);
    }

    public void changePicVidIconClose() {
        vidIconClose.setVisible(true);
    }

    public void hidePicVidIconClose() {
        vidIconClose.setVisible(false);
    }

    public static void moveImageViewTo(ImageView imageView, double distance) {
        // Create a TranslateTransition for gradual movement
        Duration duration = Duration.millis(500);
        TranslateTransition translateTransition = new TranslateTransition(duration, imageView);
        translateTransition.setByX(-distance); // Move to the left by the specified distance
        translateTransition.setAutoReverse(false);
        translateTransition.setCycleCount(1);
        // Start the animation
        translateTransition.play();
    }

    public static void movePaneTo(Pane pane, double distance) {
        // Create a TranslateTransition for gradual movement
        Duration duration = Duration.millis(500);
        TranslateTransition translateTransition = new TranslateTransition(duration, pane);
        translateTransition.setByX(distance); // Move to the right by the specified distance
        translateTransition.setAutoReverse(false);
        translateTransition.setCycleCount(1);

        // Start the animation
        translateTransition.play();
    }

}
