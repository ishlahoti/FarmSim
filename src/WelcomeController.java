import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import java.io.IOException;

/**
 * Controller class for Welcome Screen
 * TODO: can customize/initialize button here
 */
public class WelcomeController {
    @FXML
    private Button start;

    /**
     * Handles action event of clicking button
     * changes screen to initial configuration
     * does not need to be changed
     */
    @FXML
    private void changeScreen(ActionEvent event) throws IOException {
        Parent root2 = FXMLLoader.load(getClass().getResource("Config.fxml"));
        Main.primaryStage.setScene(new Scene(root2, 800, 800));
        Main.primaryStage.show();
    }
}