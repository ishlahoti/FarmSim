import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import java.io.IOException;


/**
 * Controller class for Configuration Screen
 * TODO: handle implementation of layout nodes. initialize them similarly to how nextScreen button was initialized
 * below. variable names should match fxid. variables such as season/etc may need to be imported by ifarmui fxml-
 * will be used in next screen, should be accessible
 */
public class ConfigController {
    @FXML
    private Button nextScreen;

    /**
     * Handles action event of clicking button
     * changes screen to ifarmui
     * does not need to be changed
     */
    @FXML
    private void changeScreen(ActionEvent event) throws IOException {
        Parent root3 = FXMLLoader.load(getClass().getResource("Ifarmui.fxml"));
        Stage primaryStage = new Stage();
        primaryStage.setScene(new Scene(root3, 800, 800));
        primaryStage.show();
        WelcomeController.primaryStage.close();
    }
}
