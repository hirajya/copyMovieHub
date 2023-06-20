package controller;

import java.io.IOException;

import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Duration;

public class SignupController {
    @FXML
    ImageView imageBlack;

    private static final Duration DURATION = Duration.seconds(2);

    public void initialize() {
        animateImageView(imageBlack, DURATION, 726);
    }

    public void switchToLogin(MouseEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("/view/loginPage.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public static void animateImageView(ImageView imageView, Duration duration, int moveDistance) {
        // Create a TranslateTransition to move the ImageView
        TranslateTransition transition = new TranslateTransition(duration, imageView);
        transition.setByY(moveDistance);
        // transition.setAutoReverse(true);
        // transition.setCycleCount(TranslateTransition.INDEFINITE);

        // Start the animation
        transition.play();
    }
    
}
