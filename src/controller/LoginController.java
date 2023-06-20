package controller;

import java.io.IOException;
import java.util.function.UnaryOperator;

import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;



public class LoginController {

    @FXML
    TextField usernameTextField, passwordField;

    @FXML
    Text wrongpass;

    @FXML
    ImageView pic1, pic2, pic3;

    
    private static final Duration DURATION = Duration.seconds(2);
    private static final Duration DURATION2 = Duration.seconds(5); // 126

    public void initialize() {
        animateImageView(pic1, DURATION, DURATION2, -600, -126);
        animateImageView(pic2, DURATION, DURATION2, 600, 126);
        animateImageView(pic3, DURATION, DURATION2, 600, 126);
    }

    public void switchToSignup(MouseEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("/view/signupPage.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToHomepage(MouseEvent event) throws IOException{
        if (checkUsernamePass()) {
            Parent root = FXMLLoader.load(getClass().getResource("/view/waitingScene.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } else {
            wrongpass.setVisible(true);
        }
        
    }

    public boolean checkUsernamePass() {
        String username = usernameTextField.getText();
        String password = passwordField.getText();
        if (username.equals("admin") && password.equals("admin")) {
            return true;
        }
        return false;
    }

    // public static void animateImageView(ImageView imageView, Duration duration, Duration duration2, int moveDistance1, int moveDistance2) {
    //     // Create a TranslateTransition to move the ImageView
    //     TranslateTransition transition = new TranslateTransition(duration, imageView);
    //     transition.setByY(moveDistance1);
    //     TranslateTransition transition2 = new TranslateTransition(duration2, imageView);
    //     transition2.setByY(moveDistance2);
    //     // transition.setAutoReverse(true);
    //     // transition.setCycleCount(TranslateTransition.INDEFINITE);

    //     // Start the animation
    //     transition.play();
    //     transition2.play();
    // }

    public static void animateImageView(ImageView imageView, Duration duration, Duration duration2, int moveDistance1, int moveDistance2) {
        // Create a TranslateTransition to move the ImageView
        TranslateTransition transition = new TranslateTransition(duration, imageView);
        transition.setByY(moveDistance1);

        TranslateTransition transition2 = new TranslateTransition(duration2, imageView);
        transition2.setByY(moveDistance2);

        // Set up the event handler for transition1
        transition.setOnFinished(event -> {
            // Start transition2 when transition1 finishes
            transition2.play();
        });

        // Set up the event handler for transition2
        transition2.setOnFinished(event -> {
            // Stop the animation when transition2 finishes
            transition2.stop();
        });

        // Start the animation
        transition.play();
    }


    
}
