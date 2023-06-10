package controller;

import javafx.util.Duration;

import java.io.IOException;

import javax.swing.Action;

import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.Scene;
import javafx.scene.effect.DropShadow;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.scene.Node;
import javafx.scene.Parent;
import model.*;

public class MovieListController {

    private String choosenMovie;

    @FXML
    Pane movie1InfoPane;

    @FXML
    ImageView scrollButton2;

    @FXML
    Pane movie2InfoPane;

    @FXML
    Pane movie3InfoPane, movie4InfoPane, movie5InfoPane, movie6InfoPane, movie7InfoPane, movie8InfoPane, movie9InfoPane, movie10InfoPane;

    @FXML
    ImageView moviePic1, moviePic2, moviePic3, moviePic4, moviePic5, moviePic6, moviePic7, moviePic8, moviePic9, moviePic10;

    @FXML
    Text movieTitle1, movieTitle2, movieTitle3, movieTitle4, movieTitle5, movieTitle6, movieTitle7, movieTitle8, movieTitle9, movieTitle10;

    @FXML
    Text yearMovie1, yearMovie2, yearMovie3, yearMovie4, yearMovie5, yearMovie6, yearMovie7, yearMovie8, yearMovie9, yearMovie10;

    @FXML
    ImageView optionButton;

    @FXML
    Pane optionPane;

    @FXML
    Text moneyAmt;
    
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

        firstScreen("M_1", moviePic1);
        firstScreen("M_2", moviePic2);
        firstScreen("M_3", moviePic3);
        firstScreen("M_4", moviePic4);
        firstScreen("M_5", moviePic5);
        firstScreen("M_6", moviePic6);
        firstScreen("M_7", moviePic7);
        firstScreen("M_8", moviePic8);
        firstScreen("M_9", moviePic9);
        firstScreen("M_10", moviePic10);

        firstTitle("M_1", movieTitle1);
        firstTitle("M_2", movieTitle2);
        firstTitle("M_3", movieTitle3);
        firstTitle("M_4", movieTitle4);
        firstTitle("M_5", movieTitle5);
        firstTitle("M_6", movieTitle6);
        firstTitle("M_7", movieTitle7);
        firstTitle("M_8", movieTitle8);
        firstTitle("M_9", movieTitle9);
        firstTitle("M_10", movieTitle10);

        firstYear("M_1", yearMovie1);
        firstYear("M_2", yearMovie2);
        firstYear("M_3", yearMovie3);
        firstYear("M_4", yearMovie4);
        firstYear("M_5", yearMovie5);
        firstYear("M_6", yearMovie6);
        firstYear("M_7", yearMovie7);
        firstYear("M_8", yearMovie8);
        firstYear("M_9", yearMovie9);
        firstYear("M_10", yearMovie10);

        ((ImageView) movie1InfoPane.getChildren().get(0)).setImage(m1.getPosterImage().getImage());
        ((ImageView) movie2InfoPane.getChildren().get(0)).setImage(m2.getPosterImage().getImage());
        ((ImageView) movie3InfoPane.getChildren().get(0)).setImage(m3.getPosterImage().getImage());
        ((ImageView) movie4InfoPane.getChildren().get(0)).setImage(m4.getPosterImage().getImage());
        ((ImageView) movie5InfoPane.getChildren().get(0)).setImage(m5.getPosterImage().getImage());
        ((ImageView) movie6InfoPane.getChildren().get(0)).setImage(m6.getPosterImage().getImage());
        ((ImageView) movie7InfoPane.getChildren().get(0)).setImage(m7.getPosterImage().getImage());
        ((ImageView) movie8InfoPane.getChildren().get(0)).setImage(m8.getPosterImage().getImage());
        ((ImageView) movie9InfoPane.getChildren().get(0)).setImage(m9.getPosterImage().getImage());
        ((ImageView) movie10InfoPane.getChildren().get(0)).setImage(m10.getPosterImage().getImage());



        scrollButton2.setOnMouseClicked(event -> moveScrollUp());
        optionButton.setOnMouseClicked(event -> movePaneRight());
        optionPane.getChildren().get(0).setOnMouseClicked(event -> movePaneLeft());

        DropShadow dropShadow = new DropShadow();
        moviePic1.setEffect(new DropShadow(20, Color.BLACK));
        moviePic2.setEffect(new DropShadow(20, Color.BLACK));
        moviePic3.setEffect(new DropShadow(20, Color.BLACK));
        moviePic4.setEffect(new DropShadow(20, Color.BLACK));
        moviePic5.setEffect(new DropShadow(20, Color.BLACK));
        moviePic6.setEffect(new DropShadow(20, Color.BLACK));
        moviePic7.setEffect(new DropShadow(20, Color.BLACK));
        moviePic8.setEffect(new DropShadow(20, Color.BLACK));
        moviePic9.setEffect(new DropShadow(20, Color.BLACK));
        moviePic10.setEffect(new DropShadow(20, Color.BLACK));

        moneyAmt.setText(String.valueOf(HomepageController.moneyAmount));

        

    }

    public void pickMovie1() {
        System.out.println("clicked movie1");
        choosenMovie = "M_1";
        MovieInfoPageController.setChoosenMovie(choosenMovie);
        // set other controller variables to this movie
        // switch to info scene

    }

    public void pickMovie2() {
        System.out.println("clicked movie2");
        choosenMovie = "M_2";
        MovieInfoPageController.setChoosenMovie(choosenMovie);
        // set other controller variables to this movie
        // switch to info scene
    }

    public void pickMovie3() {
        System.out.println("clicked movie3");
        choosenMovie = "M_3";
        MovieInfoPageController.setChoosenMovie(choosenMovie);
        // set other controller variables to this movie
        // switch to info scene
    }

    public void pickMovie4() {
        System.out.println("clicked movie4");
        choosenMovie = "M_4";
        MovieInfoPageController.setChoosenMovie(choosenMovie);
        // set other controller variables to this movie
        // switch to info scene
    }

    public void pickMovie5() {
        System.out.println("clicked movie5");
        choosenMovie = "M_5";
        MovieInfoPageController.setChoosenMovie(choosenMovie);
        // set other controller variables to this movie
        // switch to info scene
    }

    public void pickMovie6() {
        System.out.println("clicked movie6");
        choosenMovie = "M_6";
        MovieInfoPageController.setChoosenMovie(choosenMovie);
        // set other controller variables to this movie
        // switch to info scene
    }

    public void pickMovie7() {
        System.out.println("clicked movie7");
        choosenMovie = "M_7";
        MovieInfoPageController.setChoosenMovie(choosenMovie);
        // set other controller variables to this movie
        // switch to info scene
    }

    public void pickMovie8() {
        System.out.println("clicked movie8");
        choosenMovie = "M_8";
        MovieInfoPageController.setChoosenMovie(choosenMovie);
        // set other controller variables to this movie
        // switch to info scene
    }

    public void pickMovie9() {
        System.out.println("clicked movie9");
        choosenMovie = "M_9";
        MovieInfoPageController.setChoosenMovie(choosenMovie);
        // set other controller variables to this movie
        // switch to info scene
    }

    public void pickMovie10() {
        System.out.println("clicked movie10");
        choosenMovie = "M_10";
        MovieInfoPageController.setChoosenMovie(choosenMovie);
        // set other controller variables to this movie
        // switch to info scene
    }

    

    public void showInfoMovie1() {
        fadePane(movie1InfoPane, true);
        pickMovie1();
    }

    public void hideInfoMovie1() {
        fadePane(movie1InfoPane, false);
    }

    public void showInfoMovie2() {
        fadePane(movie2InfoPane, true);
        pickMovie2();
    }

    public void hideInfoMovie2() {
        fadePane(movie2InfoPane, false);
    }

    public void showInfoMovie3() {
        fadePane(movie3InfoPane, true);
        pickMovie3();
    }

    public void hideInfoMovie3() {
        fadePane(movie3InfoPane, false);
    }

    public void showInfoMovie4() {
        fadePane(movie4InfoPane, true);
        pickMovie4();
    }

    public void hideInfoMovie4() {
        fadePane(movie4InfoPane, false);
    }

    public void showInfoMovie5() {
        fadePane(movie5InfoPane, true);
        pickMovie5();
    }

    public void hideInfoMovie5() {
        fadePane(movie5InfoPane, false);
    }

    public void showInfoMovie6() {
        fadePane(movie6InfoPane, true);
        pickMovie6();
    }

    public void hideInfoMovie6() {
        fadePane(movie6InfoPane, false);
    }

    public void showInfoMovie7() {
        fadePane(movie7InfoPane, true);
        pickMovie7();
    }

    public void hideInfoMovie7() {
        fadePane(movie7InfoPane, false);
    }

    public void showInfoMovie8() {
        fadePane(movie8InfoPane, true);
        pickMovie8();
    }

    public void hideInfoMovie8() {
        fadePane(movie8InfoPane, false);
    }

    public void showInfoMovie9() {
        fadePane(movie9InfoPane, true);
        pickMovie9();
    }

    public void hideInfoMovie9() {
        fadePane(movie9InfoPane, false);
    }

    public void showInfoMovie10() {
        fadePane(movie10InfoPane, true);
        pickMovie10();
    }

    public void hideInfoMovie10() {
        fadePane(movie10InfoPane, false);
    }



    private static final Duration FADE_DURATION = Duration.seconds(0.5); // Fade duration in milliseconds

    private void fadePane(Pane pane, boolean show) {
        if (show) {
            // Set the pane to visible and fade it in
            pane.setVisible(true);
            FadeTransition fadeIn = new FadeTransition(FADE_DURATION, pane);
            fadeIn.setFromValue(0.0);
            fadeIn.setToValue(1.0);
            fadeIn.play();
        } else {
            // Fade out the pane
            FadeTransition fadeOut = new FadeTransition(FADE_DURATION, pane);
            fadeOut.setFromValue(1.0);
            fadeOut.setToValue(0.0);
            fadeOut.setOnFinished(e -> pane.setVisible(false));
            fadeOut.play();
        }
    }

    private Stage stage;
    private Scene scene;
    private Parent root;


    public void switchToInfo(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/view/movieInfoPage.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    

    public void moveScrollUp() {
        TranslateTransition transition = new TranslateTransition(Duration.seconds(1), scrollButton2);
        transition.setToY(scrollButton2.getTranslateY() - 107);
        transition.setOnFinished(event -> {
            try {
                switchToHomepage();
            } catch (IOException e) {
                e.printStackTrace();
            }
            
        });
        transition.play();
    }

    public void switchToHomepage() throws IOException {
        Stage stage = (Stage) scrollButton2.getScene().getWindow();
        Scene scene1 = stage.getScene();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/movieHomepage.fxml"));
        Parent root2 = loader.load();
        Scene scene2 = new Scene(root2, scene1.getWidth(), scene1.getHeight());

        // Set initial position for scene 2 below scene 1
        root2.translateYProperty().set(-scene1.getHeight());

        // Set background of scene 2 to transparent
        scene2.setFill(Color.BLACK); // CHANGE IT IF WHAT IS THE MAIN COLOR OF THE FRAMEEEEEEEEEE

        // Create a transition for sliding scene 1
        TranslateTransition slideOutTransition = new TranslateTransition(Duration.seconds(0.5), scene1.getRoot());
        slideOutTransition.setToY(scene1.getHeight());

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

    private void fadeText(Text textNode, String newText) {
        FadeTransition fadeOutTransition = new FadeTransition(Duration.millis(1500), textNode);
        fadeOutTransition.setFromValue(1.0);
        fadeOutTransition.setToValue(0.0);
        
        fadeOutTransition.setOnFinished(event -> {
            textNode.setText(newText);
            FadeTransition fadeInTransition = new FadeTransition(Duration.millis(1500), textNode);
            fadeInTransition.setFromValue(0.0);
            fadeInTransition.setToValue(1.0);
            fadeInTransition.play();
        });
    
        fadeOutTransition.play();
    }

    private void fadeImageView(ImageView imageView, ImageView newImage) {
        FadeTransition fadeOutTransition = new FadeTransition(Duration.millis(1500), imageView);
        fadeOutTransition.setFromValue(1.0);
        fadeOutTransition.setToValue(0.0);
        
        fadeOutTransition.setOnFinished(event -> {
            imageView.setEffect(new DropShadow(20, Color.BLACK));
            imageView.setImage(newImage.getImage());
            FadeTransition fadeInTransition = new FadeTransition(Duration.millis(1500), imageView);
            fadeInTransition.setFromValue(0.0);
            fadeInTransition.setToValue(1.0);
            fadeInTransition.play();
        });
    
        fadeOutTransition.play();
    }
    
}
