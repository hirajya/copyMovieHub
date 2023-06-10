package controller;



import javafx.animation.FadeTransition;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.util.Duration;
import model.movie;

public class MovieInfoPageController {

    @FXML
    Text moviePickedText;

    @FXML 
    ImageView bigScreenMovie;


    static private String choosenMovie; // nakastored na agad; M_2

    public static void setChoosenMovie(String movie) {
        choosenMovie = movie;
    }

    public void initialize() {
        moviePickedText.setText(choosenMovie);
        bigScreenMoviePic(choosenMovie);
    }


    public void bigScreenMoviePic(String movie) { // "M_2"
        try {
            String className = "model." + movie; // "model.M_1"
            Class<?> clazz = Class.forName(className); // model.M_1
            Object instance = clazz.getDeclaredConstructor().newInstance(); // instance = M_1

            if (instance instanceof movie) {
                movie movieInstance = (movie) instance; // movieInstance = M_1
                ImageView movieImage = movieInstance.getMainImage(); // movieInstance.getImage() == M_1.getImage()
                ImageView movieImagePoster = movieInstance.getPosterImage();
                
                fadeImageViewBig(bigScreenMovie, movieImage);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void fadeImageViewBig(ImageView imageView, ImageView newImage) {
        FadeTransition fadeOutTransition = new FadeTransition(Duration.millis(500), imageView);
        fadeOutTransition.setFromValue(1.0);
        fadeOutTransition.setToValue(0.0);
        
        fadeOutTransition.setOnFinished(event -> {
            imageView.setImage(newImage.getImage());
            FadeTransition fadeInTransition = new FadeTransition(Duration.millis(500), imageView);
            fadeInTransition.setFromValue(0.0);
            fadeInTransition.setToValue(1.0);
            fadeInTransition.play();
        });
    
        fadeOutTransition.play();
    }
}
