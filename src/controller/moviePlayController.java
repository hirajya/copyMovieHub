package controller;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import model.movie;

public class moviePlayController implements Initializable{

    File directory = new File("");
    String loc = (directory.getAbsolutePath() + "\\src\\movieTrailer\\sample_video.mp4");

    private File file;
    private Media media;
    private MediaPlayer mediaPlayer;
    
    @FXML 
    MediaView mediaView;

    public void initialize(URL arg0, ResourceBundle arg1) {
        System.out.println("Initializing moviePlayController");
        videoTrailer();
    }

    public void videoTrailer() {

        file = new File(loc);
        media = new Media(file.toURI().toString());
        mediaPlayer = new MediaPlayer(media);
        mediaView.setMediaPlayer(mediaPlayer);
        mediaView.setFitHeight(580);
        mediaView.setFitWidth(1160);
        mediaPlayer.setAutoPlay(false);
    }

    public void pauseVideo() {
        mediaPlayer.pause();
    }

    public void playVideo() {
        mediaPlayer.play();
    }

}
