
package controller;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class waitingSceneController {

    private static final int DELAY_SECONDS = 5;

    @FXML
    private Parent waitingPane;

    public void initialize() {
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
}

