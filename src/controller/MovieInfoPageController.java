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
    ImageView backButtonClicked;

    @FXML
    Text movieNameText, movieReleaseDate, firstGenre, secondGenre, thirdGenre;

    @FXML
    ImageView starringActorUno, starringActorSecond, starringActorThird;

    @FXML
    Text actorName1, actorName2, actorName3;

    @FXML
    MediaView movieTrailer;

    private File file;

    private Media media;

    private MediaPlayer mediaPlayer;



    static private String choosenMovie; // nakastored na agad; M_2

    public static void setChoosenMovie(String movie) {
        choosenMovie = movie;
    }

    static boolean fromHomePage = false; 


    public void initialize() {

         M_1 m1 = new M_1();
        M_2 m2 = new M_2();
        M_3 m3 = new M_3();
        M_4 m4 = new M_4();
        M_5 m5 = new M_5();
        M_6 m6 = new M_6();
        M_7 m7 = new M_7();
        M_8 m8 = new M_8();
        M_9 m9 = new M_9();
        M_10 m10 = new M_10();

        moviePickedText.setText(choosenMovie);
        bigScreenMoviePic(choosenMovie);

        backButton.setOnMouseClicked(event -> backButtonClicked());

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

    }

            static String[] movieNames = {"M_1", "M_2", "M_3", "M_4", "M_5", "M_6", "M_7", "M_8", "M_9", "M_10"};
            static String[] starringActors = {"//src/castImage/BillSkarsgard.png","//src/castImage/ChrisPratt.png","//src/castImage/DanielPadilla.png","//src/castImage/DarrenEspanto.png"
            ,"//src/castImage/DaveBautista.png","//src/castImage/DonnieYen.png","//src/castImage/EmilyMortimer.png","//src/castImage/EnriqueGil.png","//src/castImage/EvangelineLilly.png"
            ,"//src/castImage/JonathanMajors.png","//src/castImage/KathrynBernardo.png","//src/castImage/KeanuReaves.png","//src/castImage/LizaSoberano.png","//src/castImage/MariNatsuki.png"
            ,"//src/castImage/MichaelDouglas.png","//src/castImage/MikeBJordan.png","//src/castImage/MiyuIrino.png","//src/castImage/NikitaEfremov.png","//src/castImage/PaulRudd.png"
            ,"//src/castImage/RumiHiiragi.png","//src/castImage/SamWorthington.png","//src/castImage/Sigourney Weaver.png","//src/castImage/SofyaLebedava.png","src/castImage/SylviaSanchez.png"
            ,"//src/castImage/TakuyaKimura.png","//src/castImage/TaronEgorton.png","//src/castImage/TatsuyaGashuin.png","//src/castImage/TessaThompson.png","//src/castImage/ZoeZaldana.png"           
        };

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

        private void switch2movielist() throws IOException {
            
        //  mediaPlayer.stop();
         Stage stage = (Stage) backButton.getScene().getWindow();
            Scene scene1 = stage.getScene();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/movieMovieList.fxml"));
            Parent root2 = loader.load();
                Scene scene2 = new Scene(root2, scene1.getWidth(), scene1.getHeight());

             stage.setScene(scene2); // Set the new scene in the stage
        }

            private void switch2Homepage() throws IOException {
        // Stop the media player if necessary
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
            String videoPath = movieInstance.getTrailer();

            Media media = new Media(new File(videoPath).toURI().toString());

            MediaPlayer mediaPlayer = new MediaPlayer(media);

            movieTrailer.setMediaPlayer(mediaPlayer);

            movieTrailer.setFitWidth(700); // Set the desired width
            movieTrailer.setFitHeight(360);
            // Set the desired height
            // Add the mediaView to your layout

            // Play the video
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
}
