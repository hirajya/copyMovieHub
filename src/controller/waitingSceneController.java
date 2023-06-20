
package controller;
import javafx.animation.TranslateTransition;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class waitingSceneController {

    private static final int DELAY_SECONDS = 5;

    @FXML
    private Parent waitingPane;

    @FXML
    private ImageView pic1, pic2, pic3, pic4, pic5, pic6, pic7, pic8, pic9, pic10, pic11, pic12, pic13, pic14, logo1, logo2, logo3, logo4;

    public void initialize() {
        animateImageViewLogo(logo1, logo2, logo3, logo4, -536, -1030, 564, 651);
        animateImageView(pic1, Duration.seconds(8), 100);
        animateImageView(pic2, Duration.seconds(8), 100);
        animateImageView(pic3, Duration.seconds(8), 100);
        animateImageView(pic4, Duration.seconds(8), 100);
        animateImageView(pic5, Duration.seconds(8), 100);
        animateImageView(pic6, Duration.seconds(8), 100);
        animateImageView(pic7, Duration.seconds(8), 100);
        animateImageView(pic8, Duration.seconds(8), 100);
        animateImageView(pic9, Duration.seconds(8), 100);
        animateImageView(pic10, Duration.seconds(8), 100);
        animateImageView(pic11, Duration.seconds(8), 100);
        animateImageView(pic12, Duration.seconds(8), 100);
        animateImageView(pic13, Duration.seconds(8), 100);
        animateImageView(pic14, Duration.seconds(8), 100);
        DelayedNavigationService service = new DelayedNavigationService();
        service.setOnSucceeded(event -> navigateToProfileScene()); // Switch to profile scene after navigation
        service.start();
    }

    private void navigateToProfileScene() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/view/movieHomepage.fxml"));
            Scene scene = waitingPane.getScene();
            scene.setRoot(root);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private class DelayedNavigationService extends Service<Void> {
        @Override
        protected Task<Void> createTask() {
            return new Task<Void>() {
                @Override
                protected Void call() throws Exception {
                    Thread.sleep(DELAY_SECONDS * 1000);
                    return null;
                }
            };
        }
    }

    public static void animateImageView(ImageView imageView, Duration duration, int moveDistance1) {
        // Create a TranslateTransition to move the ImageView
        TranslateTransition transition = new TranslateTransition(duration, imageView);
        transition.setByY(moveDistance1);
        
        // Start the animation
        transition.play();
    }

    public static void animateImageViewLogo(ImageView imageView1, ImageView imageView2, ImageView imageView3, ImageView imageView4, int moveDistance1, int moveDistance2, int moveDistance3, int moveDistance4) {
        Duration duration = Duration.seconds(1);
        
        // Create a TranslateTransition to move the ImageView
        TranslateTransition transition = new TranslateTransition(duration, imageView1);
        transition.setByY(moveDistance1);

        TranslateTransition transition2 = new TranslateTransition(duration, imageView2);
        transition2.setByX(moveDistance2);

        TranslateTransition transition3 = new TranslateTransition(duration, imageView3);
        transition3.setByY(moveDistance3);

        TranslateTransition transition4 = new TranslateTransition(duration, imageView4);
        transition4.setByX(moveDistance4);

        // Set up the event handler for transition1
        transition.setOnFinished(event -> {
            // Start transition2 when transition1 finishes
            transition2.play();
        });

        // Set up the event handler for transition2
        transition2.setOnFinished(event -> {
            // Stop the animation when transition2 finishes
            transition2.stop();
            transition3.play();
        });

        // Set up the event handler for transition1
        transition3.setOnFinished(event -> {
            // Start transition2 when transition1 finishes
            transition3.stop();
            transition4.play();
        });

        // Set up the event handler for transition2
        transition4.setOnFinished(event -> {
            // Stop the animation when transition2 finishes
            transition4.stop();
        });

        

        // Start the animation
        transition.play();
    }


}

