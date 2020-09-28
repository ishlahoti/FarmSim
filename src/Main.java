import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

//don't edit this file unless you're changing title/dimensions of scene please
/**
 * This is the Main class where the applications is launched from
 */
public class Main extends Application {
    private static Stage primaryStage;

    /**
     * Loads the Main.fxml file and launches the application
     *
     * @param primaryStage the main stage
     * @throws IOException fxml file not found
     */
    @Override
    public void start(Stage primaryStage) throws IOException {
        this.primaryStage = primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("WelcomeScreen.fxml"));
        primaryStage.setTitle("Farm Simulation"); //feel free to replace w/ something more creative
        Scene scene = new Scene(root, 800, 800);
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }

    /**
     * Accessor for primaryStage
     * @return the primaryStage
    */
    public static Stage getPrimaryStage() {
        return primaryStage;
    }
}
