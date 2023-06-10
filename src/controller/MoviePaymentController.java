package controller;

import javafx.fxml.FXML;
import javafx.scene.text.Text;

public class MoviePaymentController {

    @FXML
    Text movieee;

    static String movieChoosen = "M_5"; // Default movie

    public static void setMovieChoosen(String movie) {
        movieChoosen = movie;
    }

    public void initialize() {
        System.out.println("Initializing MoviePaymentController");
        movieee.setText(movieChoosen);
    }

}
