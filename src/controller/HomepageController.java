package controller;

import java.io.IOException;

import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.ParallelTransition;
import javafx.animation.PauseTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.Group;
import javafx.scene.Node;
import model.*;


public class HomepageController {

    static int moneyAmount = 1000;

    @FXML
    Pane optionPane;

    @FXML
    ImageView optionButton, optionButtonOuts;

    @FXML
    Text movieNameText, descriptionText, yearText, ratePercentText, rateVotesText, createdByText;

    @FXML
    ImageView bigscreen, spotscreen, sidescreen1, sidescreen2, sidescreen3, sidescreen4;

    @FXML 
    ImageView toLeft, toRight;

    @FXML
    ImageView blackscreenDescrip, blackScreenEnabler1, blackScreenEnabler2;

    @FXML
    Text moneyAmt;

    @FXML 
    ImageView paneMovie1, paneMovie2, paneMovie3, paneMovie4, paneMovie5, paneMovie6, paneMovie7, paneMovie8, paneMovie9, paneMovie10;

    @FXML
    ImageView moviePaneImage1, moviePaneImage2, moviePaneImage3, moviePaneImage4, moviePaneImage5, moviePaneImage6, moviePaneImage7, moviePaneImage8, moviePaneImage9, moviePaneImage10;

    @FXML 
    Pane movie1InfoPane, movie2InfoPane, movie3InfoPane, movie4InfoPane, movie5InfoPane, movie6InfoPane, movie7InfoPane, movie8InfoPane, movie9InfoPane, movie10InfoPane;

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

        firstScreenBig("M_1", bigscreen);

        firstScreen("M_1", spotscreen);
        firstScreen("M_2", sidescreen1);
        firstScreen("M_3", sidescreen2);
        firstScreen("M_4", sidescreen3);
        firstScreen("M_5", sidescreen4);

        firstTitle("M_1", movieNameText);
        firstDescrip("M_1", descriptionText);
        firstYear("M_1", yearText);
        firstCreatedby("M_1", createdByText);

        scrollButton.setOnMouseClicked(event -> moveImageDown());
        optionButton.setOnMouseClicked(event -> movePaneRight());
        optionPane.getChildren().get(0).setOnMouseClicked(event -> movePaneLeft());

        spotscreen.setEffect(new DropShadow(20, Color.BLACK));
        sidescreen1.setEffect(new DropShadow(20, Color.BLACK));
        sidescreen2.setEffect(new DropShadow(20, Color.BLACK));
        sidescreen3.setEffect(new DropShadow(20, Color.BLACK));
        sidescreen4.setEffect(new DropShadow(20, Color.BLACK));

        moneyAmt.setText(String.valueOf(moneyAmount));

        blackscreenDescrip.setOpacity(0.0);

    }

    static String[] movieNames = {"M_1", "M_2", "M_3", "M_4", "M_5", "M_6", "M_7", "M_8", "M_9", "M_10"}; // movieNames[0] = "M_1" + .getDescription // "M_1" M_1
    static int movieIndex = 0;          // M_1 "M_1"
    static int movieIndexSide1 = 1; // movieNames[movieIndex] = "M_1" "M_1".getDescription
    static int movieIndexSide2 = 2;
    static int movieIndexSide3 = 3;
    static int movieIndexSide4 = 4;

    public static void movieIndexIncrement() {
        if (movieIndex == movieNames.length - 1) {
            movieIndex = 0;
        } else {
            movieIndex++;
        }

        if (movieIndexSide1 == movieNames.length - 1) {
            movieIndexSide1 = 0;
        } else {
            movieIndexSide1++;
        }

        if (movieIndexSide2 == movieNames.length - 1) {
            movieIndexSide2 = 0;
        } else {
            movieIndexSide2++;
        }

        if (movieIndexSide3 == movieNames.length - 1) {
            movieIndexSide3 = 0;
        } else {
            movieIndexSide3++;
        }

        if (movieIndexSide4 == movieNames.length - 1) {
            movieIndexSide4 = 0;
        } else {
            movieIndexSide4++;
        }
    }

    public static void movieIndexDecrement() {
        if (movieIndex == 0) {
            movieIndex = movieNames.length - 1;
        } else {
            movieIndex--;
        }

        if (movieIndexSide1 == 0) {
            movieIndexSide1 = movieNames.length - 1;
        } else {
            movieIndexSide1--;
        }

        if (movieIndexSide2 == 0) {
            movieIndexSide2 = movieNames.length - 1;
        } else {
            movieIndexSide2--;
        }

        if (movieIndexSide3 == 0) {
            movieIndexSide3 = movieNames.length - 1;
        } else {
            movieIndexSide3--;
        }

        if (movieIndexSide4 == 0) {
            movieIndexSide4 = movieNames.length - 1;
        } else {
            movieIndexSide4--;
        }
    } 

    public void leftButtonClicked() {
        System.out.println("Left button clicked");
        movieIndexDecrement();
        changeBigAndSpotScreen();
        changeSideScreen1();
        changeSideScreen2();
        changeSideScreen3();
        changeSideScreen4();
        updateMovieTitle();
        updateMovieDescription();
        updateMovieYear();
        updateMovieCreatedBy();
    }

    public void rightButtonClicked() {
        System.out.println("Right button clicked");
        movieIndexIncrement();
        changeBigAndSpotScreen();
        changeSideScreen1();
        changeSideScreen2();
        changeSideScreen3();
        changeSideScreen4();
        updateMovieTitle();
        updateMovieDescription();
        updateMovieYear();
        updateMovieCreatedBy();
    }

    public void rentButtonClicked() {
        System.out.println("Rent button clicked");
    }

    public void infoButtonClicked() {
        System.out.println("Info button clicked");
        System.out.println(movieNames[movieIndex]);

    }

    public void blackAppearDescrip() {
        fadeEffect(0.75);
    }

    public void blackDontAppearDescrip() {
        fadeEffect(0.0);
        
    }

    private void fadeEffect(double targetOpacity) {
        double currentOpacity = blackscreenDescrip.getOpacity();
        Duration duration = Duration.millis(500); // Duration of the fade effect (in milliseconds)
    
        KeyValue keyValue = new KeyValue(blackscreenDescrip.opacityProperty(), targetOpacity);
        KeyFrame keyFrame = new KeyFrame(duration, keyValue);
    
        Timeline timeline = new Timeline(keyFrame);
        timeline.setCycleCount(1); // Play the animation only once
        timeline.play();
    }

    public void changeBigAndSpotScreen() {
        try {
            String className = "model." + movieNames[movieIndex]; // "model.M_1"
            Class<?> clazz = Class.forName(className); // model.M_1
            Object instance = clazz.getDeclaredConstructor().newInstance(); // instance = M_1

            if (instance instanceof movie) {
                movie movieInstance = (movie) instance; // movieInstance = M_1
                ImageView movieImage = movieInstance.getMainImage(); // movieInstance.getImage() == M_1.getImage()
                ImageView movieImagePoster = movieInstance.getPosterImage();
                
                fadeImageViewBig(bigscreen, movieImage);
                fadeImageView(spotscreen, movieImagePoster);
                // // Check if the image needs to be changed
                // if (!bigscreen.getImage().equals(movieImage.getImage())) {
                //     fadeImageViewBig(bigscreen, movieImage);
                // }
                
  
                // // Check if the image needs to be changed
                // if (!spotscreen.getImage().equals(movieImage.getImage())) {
                //     fadeImageView(spotscreen, movieImage);
                // }
                
                

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void changeSideScreen1() {
        try {
            String className = "model." + movieNames[movieIndexSide1]; // M_1, "M_1"
            Class<?> clazz = Class.forName(className);
            Object instance = clazz.getDeclaredConstructor().newInstance();

            if (instance instanceof movie) {
                movie movieInstance = (movie) instance;
                ImageView movieImage = movieInstance.getPosterImage();
                fadeImageView(sidescreen1, movieImage);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void changeSideScreen2() {
        try {
            String className = "model." + movieNames[movieIndexSide2];
            Class<?> clazz = Class.forName(className);
            Object instance = clazz.getDeclaredConstructor().newInstance();

            if (instance instanceof movie) {
                movie movieInstance = (movie) instance;
                ImageView movieImage = movieInstance.getPosterImage();
                fadeImageView(sidescreen2, movieImage);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void changeSideScreen3() {
        try {
            String className = "model." + movieNames[movieIndexSide3];
            Class<?> clazz = Class.forName(className);
            Object instance = clazz.getDeclaredConstructor().newInstance();

            if (instance instanceof movie) {
                movie movieInstance = (movie) instance;
                ImageView movieImage = movieInstance.getPosterImage();
                fadeImageView(sidescreen3, movieImage);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void changeSideScreen4() {
        try {
            String className = "model." + movieNames[movieIndexSide4];
            Class<?> clazz = Class.forName(className);
            Object instance = clazz.getDeclaredConstructor().newInstance();

            if (instance instanceof movie) {
                movie movieInstance = (movie) instance;
                ImageView movieImage = movieInstance.getPosterImage();
                fadeImageView(sidescreen4, movieImage);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateMovieTitle() {
        //     Text movieNameText, descriptionText, yearText, ratePercentText, rateVotesText, createdByText;
        try {
            String className = "model." + movieNames[movieIndex];
            Class<?> clazz = Class.forName(className);
            Object instance = clazz.getDeclaredConstructor().newInstance();

            if (instance instanceof movie) {
                movie movieInstance = (movie) instance;
                String movieName = movieInstance.getName();
                fadeText(movieNameText, movieName);
                
            }
            } catch (Exception e) {
                e.printStackTrace();
        }
    }

    public void updateMovieDescription() {
        try {
            String className = "model." + movieNames[movieIndex];
            Class<?> clazz = Class.forName(className);
            Object instance = clazz.getDeclaredConstructor().newInstance();

            if (instance instanceof movie) {
                movie movieInstance = (movie) instance;
                String movieDescription = movieInstance.getDescription();
                fadeText(descriptionText, movieDescription);
            }
            } catch (Exception e) {
                e.printStackTrace();
        }
    }

    public void updateMovieYear() {
        try {
            String className = "model." + movieNames[movieIndex];
            Class<?> clazz = Class.forName(className);
            Object instance = clazz.getDeclaredConstructor().newInstance();

            if (instance instanceof movie) {
                movie movieInstance = (movie) instance;
                String movieYear = movieInstance.getYearMade();
                fadeText(yearText, movieYear);
            }
            } catch (Exception e) {
                e.printStackTrace();
        }
    }

    public void updateMovieRatePercent() {
        try {
            String className = "model." + movieNames[movieIndex];
            Class<?> clazz = Class.forName(className);
            Object instance = clazz.getDeclaredConstructor().newInstance();

            if (instance instanceof movie) {
                movie movieInstance = (movie) instance;
                String movieRatePercent = movieInstance.getRatePercent();
                fadeText(ratePercentText, movieRatePercent);
            }
            } catch (Exception e) {
                e.printStackTrace();
        }
    }

    public void updateMovieRateVotes() {
        try {
            String className = "model." + movieNames[movieIndex];
            Class<?> clazz = Class.forName(className);
            Object instance = clazz.getDeclaredConstructor().newInstance();

            if (instance instanceof movie) {
                movie movieInstance = (movie) instance;
                String movieRatePercent = movieInstance.getRateVotes();
                fadeText(rateVotesText, movieRatePercent);
            }
            } catch (Exception e) {
                e.printStackTrace();
        }
    }

    public void updateMovieCreatedBy() {
        try {
            String className = "model." + movieNames[movieIndex];
            Class<?> clazz = Class.forName(className);
            Object instance = clazz.getDeclaredConstructor().newInstance();

            if (instance instanceof movie) {
                movie movieInstance = (movie) instance;
                String movieCreatorDescription = movieInstance.getCreatorDescription();
                fadeText(createdByText, movieCreatorDescription);
            }
            } catch (Exception e) {
                e.printStackTrace();
        }
        
    }   

    private void fadeImageView(ImageView imageView, ImageView newImage) {
        FadeTransition fadeOutTransition = new FadeTransition(Duration.millis(1000), imageView);
        fadeOutTransition.setFromValue(1.0);
        fadeOutTransition.setToValue(0.0);
        
        fadeOutTransition.setOnFinished(event -> {
            imageView.setEffect(new DropShadow(20, Color.BLACK));
            imageView.setImage(newImage.getImage());
            FadeTransition fadeInTransition = new FadeTransition(Duration.millis(1000), imageView);
            fadeInTransition.setFromValue(0.0);
            fadeInTransition.setToValue(1.0);
            fadeInTransition.play();
        });
    
        fadeOutTransition.play();
    }

    private void fadeImageViewBig(ImageView imageView, ImageView newImage) {
        FadeTransition fadeOutTransition = new FadeTransition(Duration.millis(400), imageView);
        fadeOutTransition.setFromValue(1.0);
        fadeOutTransition.setToValue(0.0);
        
        fadeOutTransition.setOnFinished(event -> {
            imageView.setImage(newImage.getImage());
            FadeTransition fadeInTransition = new FadeTransition(Duration.millis(400), imageView);
            fadeInTransition.setFromValue(0.0);
            fadeInTransition.setToValue(1.0);
            fadeInTransition.play();
        });
    
        fadeOutTransition.play();
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

    @FXML
    private ImageView scrollButton;

    private void moveImageDown() {
        TranslateTransition transition = new TranslateTransition(Duration.seconds(1), scrollButton);
        transition.setToY(scrollButton.getTranslateY() + 107); // Adjust the value as needed
        transition.setOnFinished(event -> {
            try {
                switchToScene2();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        transition.play();
    }

    private void movePaneRight() {
        movePaneRight(optionPane, 0.5, 250);
        System.out.println("move pane successfully");

    }

    private void movePaneLeft() {
        movePaneRight(optionPane, 0.5, -250);
        System.out.println("move pane successfully");
    }

    
    public static void movePaneRight(Pane pane, double durationSeconds, int distance) {
        TranslateTransition transition = new TranslateTransition(Duration.seconds(durationSeconds), pane);
        transition.setToX(pane.getTranslateX() + distance); // Adjust the value as needed
        transition.play();
    }
    



    private Stage stage;
    private Scene scene;
    private Parent root;

    public void switchToScene2() throws IOException {
        Stage stage = (Stage) scrollButton.getScene().getWindow();
        Scene scene1 = stage.getScene();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/movieMovieList.fxml"));
        Parent root2 = loader.load();
        Scene scene2 = new Scene(root2, scene1.getWidth(), scene1.getHeight());

        // Set initial position for scene 2 below scene 1
        root2.translateYProperty().set(scene1.getHeight());

        // Set background of scene 2 to transparent
        scene2.setFill(Color.BLACK); // CHANGE IT IF WHAT IS THE MAIN COLOR OF THE FRAMEEEEEEEEEE

        // Create a transition for sliding scene 1
        TranslateTransition slideOutTransition = new TranslateTransition(Duration.seconds(0.5), scene1.getRoot());
        slideOutTransition.setToY(-scene1.getHeight());

        // Create a transition for sliding scene 2
        TranslateTransition slideInTransition = new TranslateTransition(Duration.seconds(0.5), root2);
        slideInTransition.setToY(0);

        // Set up the transitions and show Scene 2
        slideOutTransition.setOnFinished(event -> {
            stage.setScene(scene2);
            slideInTransition.play();
        });

        // Play the sliding transitions
        slideOutTransition.play();
    }

    public void firstScreen(String movieClass, ImageView imagenode) {
        try {
            String className = "model." + movieClass; // M_1, "M_1"
            Class<?> clazz = Class.forName(className);
            Object instance = clazz.getDeclaredConstructor().newInstance();

            if (instance instanceof movie) {
                movie movieInstance = (movie) instance;
                ImageView movieImage = movieInstance.getPosterImage();
                fadeImageView(imagenode, movieImage);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void firstScreenBig(String movieClass, ImageView imagenode) {
        try {
            String className = "model." + movieClass; // M_1, "M_1"
            Class<?> clazz = Class.forName(className);
            Object instance = clazz.getDeclaredConstructor().newInstance();

            if (instance instanceof movie) {
                movie movieInstance = (movie) instance;
                ImageView movieImage = movieInstance.getMainImage();
                fadeImageView(imagenode, movieImage);
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
                fadeText(descriptionText, movieDescription);
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
                fadeText(titleText, movieName);
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
                fadeText(yearText, movieYear);
            }
            } catch (Exception e) {
                e.printStackTrace();
        }
    }

    public void firstCreatedby(String movieClass, Text createdByText) {
        try {
            String className = "model." + movieClass;
            Class<?> clazz = Class.forName(className);
            Object instance = clazz.getDeclaredConstructor().newInstance();

            if (instance instanceof movie) {
                movie movieInstance = (movie) instance;
                String movieCreatedBy = movieInstance.getCreatorDescription();
                fadeText(createdByText, movieCreatedBy);
            }
            } catch (Exception e) {
                e.printStackTrace();
        }
    }

        public void switchToPayment(MouseEvent event) throws IOException {
        MoviePaymentController.movieChoosen = movieNames[movieIndex];
        Parent root = FXMLLoader.load(getClass().getResource("/view/moviePayment.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
