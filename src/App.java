import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


public class App extends Application{

    public static void main(String[] args) {
        launch(args);
    }

    
    public void start(Stage stage) throws Exception {
        
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/view/movieHomepage.fxml"));
            Scene scene = new Scene(root);

            Image icon = new Image("vectorImages/movieHubLogo.png");
            stage.getIcons().add(icon);
            stage.setTitle("MovieHub");
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
