import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import java.io.IOException;

/**
 * Controller class for Welcome Screen
 */
public class WelcomeController {
    @FXML
    private Button start;

    /**
     * Handles action event of clicking button
     * changes screen to initial configuration
     * does not need to be changed
     * @param event the action taken by the user
     * @throws IOException if Config.fxml is not found
     */
    @FXML
    private void changeScreen(ActionEvent event) throws IOException {
        Parent root2 = FXMLLoader.load(getClass().getResource("Config.fxml"));
        Main.getPrimaryStage().setScene(new Scene(root2, 800, 800));
        Main.getPrimaryStage().show();
    }
}
