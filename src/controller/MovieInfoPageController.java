package controller;



import java.io.File;
import java.io.IOException;
import javafx.animation.FadeTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import model.*;

public class MovieInfoPageController {

    @FXML
    Text moviePickedText;

    @FXML 
    ImageView bigScreenMovie;

    @FXML
    ImageView backButtonClicked, buyButton, playWhiteButton, playGreenButton;

    @FXML
    Text movieNameText, movieReleaseDate, firstGenre, secondGenre, thirdGenre;

    @FXML
    ImageView starringActorUno, starringActorSecond, starringActorThird;

    @FXML
    Text actorName1, actorName2, actorName3;

    @FXML
    Text creatorDescripText, descripText;

    @FXML
    MediaView mediaView;

    @FXML
    Text buyText;


    static private String choosenMovie; // nakastored na agad; M_2

    public static void setChoosenMovie(String movie) {
        choosenMovie = movie;
    }

    static boolean fromHomePage = false; 


    public void initialize() {

        bigScreenMoviePic(choosenMovie);
        changeCreator();
        changeDescrip();
        playGreenButton.setVisible(false);

        backButton.setOnMouseClicked(event -> backButtonClicked());
        ifBoughtAlready();
        changeTitle(choosenMovie);
        yearMade(choosenMovie); 
        genreUno(choosenMovie);
        genreDos(choosenMovie); 
        genreTres(choosenMovie);
        starringUno(choosenMovie);
        starringDos(choosenMovie);
        starringTres(choosenMovie);
        starringActor1(choosenMovie);
        starringActor2(choosenMovie);
        starringActor3(choosenMovie);
        videoTrailer();
        System.out.println(fromHomePage);
        playWhiteButton.setOpacity(0.6);


    }

    static String[] movieNames = {"M_1", "M_2", "M_3", "M_4", "M_5", "M_6", "M_7", "M_8", "M_9", "M_10"};
            

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
            // BACK BUTTON
        @FXML
        private ImageView backButton;

        private void backButtonClicked(){

         System.out.println("Backbutton clicked!");
         try {
            if (fromHomePage) {
            switch2Homepage();
        }   else {
            switch2movielist();
             }
         } catch (IOException e) {
          e.printStackTrace(); 
        }
         }
    private File file;

    private Media media;

    private MediaPlayer mediaPlayer;

    private void switch2movielist() throws IOException {
        mediaPlayer.stop();
        Stage stage = (Stage) backButton.getScene().getWindow();
        Scene scene1 = stage.getScene();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/movieMovieList.fxml"));
        Parent root2 = loader.load();
        Scene scene2 = new Scene(root2, scene1.getWidth(), scene1.getHeight());
        stage.setScene(scene2); // Set the new scene in the stage
    }

    private void switch2Homepage() throws IOException {
        // Stop the media player if necessary
        mediaPlayer.stop();
        Parent root = FXMLLoader.load(getClass().getResource("/view/movieHomepage.fxml"));
        Stage stage = (Stage) backButton.getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }



        private void changeTitle(String movieClass){
             try {
                 String movieNames = "model." + movieClass;
                 Class<?> clazz = Class.forName(movieNames);
                 Object instance = clazz.getDeclaredConstructor().newInstance();

                    if (instance instanceof movie) {
                     movie movieInstance = (movie) instance;
                     String movieName = movieInstance.getName();
                     movieNameText.setText(movieName); // Set the movie name in the label
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    }  
            
        private void yearMade(String movieClass){

             try {
                 String movieNames = "model." + movieClass;
                 Class<?> clazz = Class.forName(movieNames);
                 Object instance = clazz.getDeclaredConstructor().newInstance();

                    if (instance instanceof movie) {
                     movie movieInstance = (movie) instance;
                     String movieName = movieInstance.getYearMade();
                     movieReleaseDate.setText(movieName); // Set the movie name in the label
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
        }

            // genres
         private void genreUno(String movieClass){
            try {
                 String movieNames = "model." + movieClass;
                 Class<?> clazz = Class.forName(movieNames);
                 Object instance = clazz.getDeclaredConstructor().newInstance();

                    if (instance instanceof movie) {
                     movie movieInstance = (movie) instance;
                     String movieName = movieInstance.getGenre1();
                     firstGenre.setText(movieName); // Set the movie name in the label
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
        }


         private void genreDos(String movieClass){
            try {
                 String movieNames = "model." + movieClass;
                 Class<?> clazz = Class.forName(movieNames);
                 Object instance = clazz.getDeclaredConstructor().newInstance();

                    if (instance instanceof movie) {
                     movie movieInstance = (movie) instance;
                     String movieName = movieInstance.getGenre2();
                     secondGenre.setText(movieName); // Set the movie name in the label
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
        }
      

        private void genreTres(String movieClass){
            try {
                 String movieNames = "model." + movieClass;
                 Class<?> clazz = Class.forName(movieNames);
                 Object instance = clazz.getDeclaredConstructor().newInstance();

                    if (instance instanceof movie) {
                     movie movieInstance = (movie) instance;
                     String movieName = movieInstance.getGenre3();
                     thirdGenre.setText(movieName); // Set the movie name in the label
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
        }

        // starring pics
        private void starringUno(String starActor) {
    try {
        String className = "model." + starActor;
        Class<?> clazz = Class.forName(className);
        Object instance = clazz.getDeclaredConstructor().newInstance();

        if (instance instanceof movie) {
            movie starringInstance = (movie) instance;
            ImageView starringActor1 = starringInstance.getStarring1();
            starringActorUno.setImage(starringActor1.getImage());
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
}

    private void starringDos(String starActor) {
    try {
        String className = "model." + starActor;
        Class<?> clazz = Class.forName(className);
        Object instance = clazz.getDeclaredConstructor().newInstance();

        if (instance instanceof movie) {
            movie starringInstance = (movie) instance;
            ImageView starringActor2 = starringInstance.getStarring2();
            starringActorSecond.setImage(starringActor2.getImage());
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
}

    private void starringTres(String starActor) {
    try {
        String className = "model." + starActor;
        Class<?> clazz = Class.forName(className);
        Object instance = clazz.getDeclaredConstructor().newInstance();

        if (instance instanceof movie) {
            movie starringInstance = (movie) instance;
            ImageView starringActor3 = starringInstance.getStarring3();
            starringActorThird.setImage(starringActor3.getImage());

        }
    } catch (Exception e) {
        e.printStackTrace();
    }
}

        //starring names



     private void starringActor1(String movieClass){
            try {
                 String movieNames = "model." + movieClass;
                 Class<?> clazz = Class.forName(movieNames);
                 Object instance = clazz.getDeclaredConstructor().newInstance();

                    if (instance instanceof movie) {
                     movie movieInstance = (movie) instance;
                     String movieName = movieInstance.getActor1();
                     actorName1.setText(movieName); // Set the movie name in the label
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
        }

         private void starringActor2(String movieClass){
            try {
                 String movieNames = "model." + movieClass;
                 Class<?> clazz = Class.forName(movieNames);
                 Object instance = clazz.getDeclaredConstructor().newInstance();

                    if (instance instanceof movie) {
                     movie movieInstance = (movie) instance;
                     String movieName = movieInstance.getActor2();
                     actorName2.setText(movieName); // Set the movie name in the label
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
        }

         private void starringActor3(String movieClass){
            try {
                 String movieNames = "model." + movieClass;
                 Class<?> clazz = Class.forName(movieNames);
                 Object instance = clazz.getDeclaredConstructor().newInstance();

                    if (instance instanceof movie) {
                     movie movieInstance = (movie) instance;
                     String movieName = movieInstance.getActor3();
                     actorName3.setText(movieName); // Set the movie name in the label
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
        }

           

    public void videoTrailer() {
         try {
            String className = "model." + choosenMovie;
            Class<?> clazz = Class.forName(className);
            Object instance = clazz.getDeclaredConstructor().newInstance();

            if (instance instanceof movie) {
                movie movieInstance = (movie) instance;
                String movieTrailer = movieInstance.getTrailer();
                file = new File(movieTrailer);
                media = new Media(file.toURI().toString());
                mediaPlayer = new MediaPlayer(media);
                mediaView.setMediaPlayer(mediaPlayer);
                mediaView.setFitHeight(360);
                mediaView.setFitWidth(500);
                mediaPlayer.setAutoPlay(true);
                
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

    public void changeCreator() {
        try {
            String movieNames = "model." + choosenMovie;
            Class<?> clazz = Class.forName(movieNames);
            Object instance = clazz.getDeclaredConstructor().newInstance();

            if (instance instanceof movie) {
                movie movieInstance = (movie) instance;
                String movieName = movieInstance.getCreatorDescription();
                creatorDescripText.setText(movieName); // Set the movie name in the label
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void changeDescrip() {
        try {
            String movieNames = "model." + choosenMovie;
            Class<?> clazz = Class.forName(movieNames);
            Object instance = clazz.getDeclaredConstructor().newInstance();

            if (instance instanceof movie) {
                movie movieInstance = (movie) instance;
                String movieDescription = movieInstance.getDescription();
                descripText.setText(movieDescription); // Set the movie name in the label
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void ifBoughtAlready() {
        String input = choosenMovie;
        int result = Integer.parseInt(extractNumbersAfterUnderscore(input));
        if (MoviePaymentController.movieBought[result-1] == true) {
            buyText.setText("Purchased");
            buyText.setDisable(true);
            buyButton.setDisable(true);
            playWhiteButton.setDisable(false);
            playGreenButton.setDisable(false);
            // play button fade will do & not disable method
        } else {
            buyText.setText("Buy");
            buyText.setDisable(false);
            buyButton.setDisable(false);
            playWhiteButton.setDisable(true);
            playGreenButton.setDisable(true);
        }
    }

    public static String extractNumbersAfterUnderscore(String input) {
        int lastIndex = input.lastIndexOf('_');
        if (lastIndex != -1 && lastIndex < input.length() - 1) {
            return input.substring(lastIndex + 1);
        } else {
            // Return an empty string or throw an exception if no numbers found after underscore.
            return "";
        }
    }

     public void switchToPayment(MouseEvent event) throws IOException {
        MoviePaymentController.setMovieChoosen(choosenMovie);
        Parent root = FXMLLoader.load(getClass().getResource("/view/moviePayment.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);  
        stage.setScene(scene);
        stage.show();
    }

    public void showInWhite() {
        playWhiteButton.setOpacity(1);
        playGreenButton.setVisible(true);
    }

    public void showOutWhite() {
        playWhiteButton.setOpacity(0.6);
        playGreenButton.setVisible(false);
    }

    public void switchToMoviePlay(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/view/moviePlay.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);  
        stage.setScene(scene);
        stage.show();
    }

}
