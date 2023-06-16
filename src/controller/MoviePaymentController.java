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


    @FXML
    ImageView homeButton, mainScreen, cashinImage;

    static String movieChoosen = "M_5"; // Default movie

    @FXML 
    private MediaView mediaView;

    @FXML
    private Text titleText, lengthText, cashinText, moneyWarning;

    @FXML
    private Text moneyUserText, movieCostText, balanceText;

    private File file;
    private Media media;
    private MediaPlayer mediaPlayer;

    static boolean[] movieBought = {false, false, false, false, false, false, false, false, false, false}; 


    public static void setMovieChoosen(String movie) {
        movieChoosen = movie;
    }

    public void initialize(URL arg0, ResourceBundle arg1) {
        System.out.println("Initializing MoviePaymentController");
        moneyWarning.setVisible(false);
        setBalanceMoney();
        CashInProceedure();
        videoTrailer();
        setMovieTitle();
        setLengthMovie();
        setMainScreen();
        setMoneyUser();
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

    public void setMainScreen() {
        try {
            String className = "model." + movieChoosen; // "model.M_1"
            Class<?> clazz = Class.forName(className); // model.M_1
            Object instance = clazz.getDeclaredConstructor().newInstance(); // instance = M_1

            if (instance instanceof movie) {
                movie movieInstance = (movie) instance; // movieInstance = M_1
                ImageView movieImage = movieInstance.getMainImage(); // movieInstance.getImage() == M_1.getImage()
                mainScreen.setImage(movieImage.getImage());
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
                String movieYear = movieInstance.getYearMade();
                String inputText = movieTitle + " (" + movieYear + ")";
                fadeText(titleText, inputText);
            }
            } catch (Exception e) {
                e.printStackTrace();
        }
    }

    public void setLengthMovie() {
        fadeText(lengthText, "163 mins");
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

    public void setMoneyUser() {
        String moneyUser = HomepageController.moneyAmount + ".00 Php";
        moneyUserText.setText(moneyUser);
    }

    public void CashInProceedure() {
        if (checkIfBought()) {
            cashinText.setText("Purchased");
            cashinText.setOpacity(0.8);
            cashinImage.setOpacity(0.5);
            cashinImage.setDisable(true);
            cashinText.setDisable(true);
            balanceText.setText("Purchased Already.");
        } else {
            cashinText.setText("Cash In");
            cashinText.setOpacity(1);
            cashinImage.setOpacity(1);
            cashinImage.setDisable(false);
            cashinText.setDisable(false);
        }
    }

    public void setBalanceMoney() {
        if (checkIfPurchased()) {
            balanceText.setText("Purchased Already.");
        } else {
            int balanceMoney = HomepageController.moneyAmount - 400;
            String balanceMoneyString = balanceMoney + ".00 Php";
            balanceText.setText(balanceMoneyString);
        }
    }

    public boolean checkMoney() {
        if (HomepageController.moneyAmount >= 400) {
            return true;
        } else {
            return false;
        }
    }

    public void buyMovie() {
        if (checkMoney()) {
            HomepageController.moneyAmount -= 400;
            setMoneyUser();
            balanceText.setText("Purchased Already.");
            cashinText.setText("Purchased");
            cashinText.setDisable(true);
            cashinImage.setDisable(true);
            // add purchase history
            WalletProfileController.purchaseList.add(movieChoosen);
            // make isPurchased true
            setIsPurchased();
            setBought();


        } else {
            moneyWarning.setVisible(true);
        }
    }

    public boolean checkIfPurchased() {
        try {
            String className = "model." + movieChoosen; // "model.M_9"
            Class<?> clazz = Class.forName(className);
            Object instance = clazz.getDeclaredConstructor().newInstance();

            if (instance instanceof movie) {
                movie movieInstance = (movie) instance;
                Boolean movieIsPurchased = movieInstance.getIsPurchased();
                return movieIsPurchased;
            }
            } catch (Exception e) {
                e.printStackTrace();
        }
        return false;
    }

    public void setIsPurchased() {
        try {
            String className = "model." + movieChoosen; // "model.M_9"
            Class<?> clazz = Class.forName(className);
            Object instance = clazz.getDeclaredConstructor().newInstance();

            if (instance instanceof movie) {
                movie movieInstance = (movie) instance;
                movieInstance.setIsPurchased(true);
    
            }
            } catch (Exception e) {
                e.printStackTrace();
        }
    }

    public boolean checkIfBought() {
        String text = movieChoosen;
        int underscoreIndex = text.indexOf('_');

        String extractedString = text.substring(underscoreIndex + 1);
        int intValue = Integer.valueOf(extractedString);
        return (movieBought[intValue-1] == true);
    }

    public void setBought() {
        String text = movieChoosen;
        int underscoreIndex = text.indexOf('_');

        String extractedString = text.substring(underscoreIndex + 1);
        int intValue = Integer.valueOf(extractedString);
        movieBought[intValue-1] = true;
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
