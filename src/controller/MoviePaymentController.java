package controller;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.text.Text;
import model.movie;

public class MoviePaymentController implements Initializable{

    @FXML
    Text movieee;

    static String movieChoosen = "M_5"; // Default movie

    @FXML 
    private MediaView mediaView;

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

}
