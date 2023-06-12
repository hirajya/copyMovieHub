package controller;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.FadeTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import model.movie;

public class MoviePaymentController implements Initializable{

    private int money = HomepageController.moneyAmount;

    @FXML
    ImageView homeButton;

    @FXML
    Text movieee;

    static String movieChoosen = "M_5"; // Default movie

    @FXML 
    private MediaView mediaView;

    @FXML
    private Text titleText;

    private File file;
    private Media media;
    private MediaPlayer mediaPlayer;

    public static void setMovieChoosen(String movie) {
        movieChoosen = movie;
    }

    public void initialize(URL arg0, ResourceBundle arg1) {
        System.out.println("Initializing MoviePaymentController");
        movieee.setText(movieChoosen);
        videoTrailer();
        setMovieTitle();
    }

    public void playMedia() {
        mediaPlayer.play();
    }

    public void pauseMedia() {
        mediaPlayer.pause();
    }

    public void videoTrailer() {

        try {
            String className = "model." + movieChoosen;
            Class<?> clazz = Class.forName(className);
            Object instance = clazz.getDeclaredConstructor().newInstance();

            if (instance instanceof movie) {
                movie movieInstance = (movie) instance;
                String movieTrailer = movieInstance.getTrailer();
                file = new File(movieTrailer);
                media = new Media(file.toURI().toString());
                mediaPlayer = new MediaPlayer(media);
                mediaView.setMediaPlayer(mediaPlayer);
                mediaPlayer.setAutoPlay(true);
            }
            } catch (Exception e) {
                e.printStackTrace();
        }
    }

    public void setMovieTitle() {
        try {
            String className = "model." + movieChoosen; // "model.M_9"
            Class<?> clazz = Class.forName(className);
            Object instance = clazz.getDeclaredConstructor().newInstance();

            if (instance instanceof movie) {
                movie movieInstance = (movie) instance;
                String movieTitle = movieInstance.getName();
                fadeText(titleText, movieTitle);
            }
            } catch (Exception e) {
                e.printStackTrace();
        }
    }

    private void fadeText(Text textNode, String newText) {
        FadeTransition fadeOutTransition = new FadeTransition(Duration.millis(1000), textNode);
        fadeOutTransition.setFromValue(1.0);
        fadeOutTransition.setToValue(0.0);
        
        fadeOutTransition.setOnFinished(event -> {
            textNode.setText(newText);
            FadeTransition fadeInTransition = new FadeTransition(Duration.millis(1000), textNode);
            fadeInTransition.setFromValue(0.0);
            fadeInTransition.setToValue(1.0);
            fadeInTransition.play();
        });
    
        fadeOutTransition.play();
    }

    public void switchToHomepage(MouseEvent event) throws IOException {
        mediaPlayer.stop();
        Parent root = FXMLLoader.load(getClass().getResource("/view/movieHomepage.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    
}
