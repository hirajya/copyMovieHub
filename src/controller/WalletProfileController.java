package controller;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class WalletProfileController {

    @FXML
    Pane optionPane;

    @FXML
    Text moneyAmt;

    public void initialize() {
        moneyAmt.setText(String.valueOf(HomepageController.moneyAmount) + ".00 PHP");
        optionPane.getChildren().get(1).setOnMouseClicked(event -> {
            try {
                switchToHomepage(event);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        });
    }

    public void switchToHomepage(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/view/movieHomepage.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
