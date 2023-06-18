package controller;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

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
import javafx.stage.Stage;
import model.movie;

public class moviePlayController implements Initializable{

    @FXML
    ImageView backButton;

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
        mediaPlayer.setAutoPlay(true);
    }

    public void pauseVideo() {
        mediaPlayer.pause();
    }

    public void playVideo() {
        mediaPlayer.play();
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
