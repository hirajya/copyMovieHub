package controller;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.movie;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class WalletProfileController {

    @FXML
    Pane optionPane;

    @FXML
    Text moneyAmt;

    @FXML
    VBox purchasesBox;

    static ArrayList<String> purchaseList = new ArrayList<>();

    

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
        optionPane.getChildren().get(2).setOnMouseClicked(event -> {
            try {
                switchToProfile(event);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        });
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setContent(purchasesBox);
        scrollPane.setFitToWidth(true);
        scrollPane.setFitToHeight(true);
        displayPurchaseHistory();
    }

    public void addPurchaseHistory(String movieClass) {
        try {
            String className = "model." + movieClass; // "model.M_1"
            Class<?> clazz = Class.forName(className); // model.M_1
            Object instance = clazz.getDeclaredConstructor().newInstance(); // instance = M_1

            if (instance instanceof movie) {
                movie movieInstance = (movie) instance; // movieInstance = M_1
                String movieTitle = movieInstance.getName(); // movieInstance.getImage() == M_1.getImage()
                String moviePrice = "400.00";
                String movieYear = movieInstance.getYearMade();
                String date = giveDateNTime();
                String inputData = movieTitle + "(" + movieYear +")  -  Php " + moviePrice + "  -  " + date;
                Text text = new Text(inputData);
                text.setFill(Color.WHITE);
                purchasesBox.getChildren().add(text);


            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void displayPurchaseHistory() {
        for (String movieClass : purchaseList) {
            addPurchaseHistory(movieClass);
        }
    }

    public void switchToHomepage(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/view/movieHomepage.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public String giveDateNTime() {
        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = currentDateTime.format(formatter);

        return formattedDateTime;
    }

    public void switchToProfile(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/view/profile.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    
}
