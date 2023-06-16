package controller;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.Node;

public class profileController {

    @FXML
    Pane optionPane;


    public void initialize() {
        optionPane.getChildren().get(0).setOnMouseClicked(event -> {
            try {
                switchToHomepage(event);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        });
        optionPane.getChildren().get(3).setOnMouseClicked(event -> {
            try {
                switchToWallet(event);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        });

    }

    public void switchToHomepage(MouseEvent event) throws IOException {
        Parent homepageParent = FXMLLoader.load(getClass().getResource("/view/movieHomepage.fxml"));
        Scene homepageScene = new Scene(homepageParent);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(homepageScene);
        window.show();
    }

    public void switchToWallet(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/view/walletProfile.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}