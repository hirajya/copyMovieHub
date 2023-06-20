package controller;

import java.io.IOException;
import java.util.function.UnaryOperator;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;



public class LoginController {

    @FXML
    TextField usernameTextField, passwordField;

    @FXML
    Text wrongpass;

    public void initialize() {
        
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
            Parent root = FXMLLoader.load(getClass().getResource("/view/movieHomepage.fxml"));
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
    
}
