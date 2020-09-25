import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import java.io.IOException;


/**
 * Controller class for Configuration Screen
 * TODO: handle implementation of layout nodes. initialize them similarly to how nextScreen button was initialized
 * below. variable names should match fxid. variables such as season/etc may need to be imported by ifarmui fxml-
 * will be used in next screen, should be accessible
 */
public class ConfigController {
    @FXML
    private Button submit;
    @FXML
    private TextField name;
    @FXML
    private ChoiceBox<String> difficulty = new ChoiceBox<>();
    @FXML
    private ChoiceBox<String> startingSeed = new ChoiceBox<>();
    @FXML
    private ChoiceBox<String> startingSeason = new ChoiceBox<>();
    private Game game = Game.factory();

    /**
     * Handles action event of clicking button
     * changes screen to ifarmui
     * does not need to be changed
     */
    @FXML
    private void changeScreen(ActionEvent event) throws IOException {
        this.game.setDifficulty((String) this.difficulty.getValue());
        this.game.setSeed((String) this.startingSeed.getValue());
        this.game.setSeason((String) this.startingSeason.getValue());
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Ifarmui.fxml"));
        Parent root3 = loader.load();
        Main.primaryStage.setScene(new Scene(root3, 800, 800));
        Main.primaryStage.show();
    }

    /**
     * Initializes the drop-down menus
     */
    @FXML
    private void initialize() {
        difficulty.getItems().addAll("Easy", "Medium", "Hard");
        difficulty.setValue("Easy");
        startingSeed.getItems().addAll("Strawberry", "Raspberry", "Passion Fruit", "Grape");
        startingSeed.setValue("Strawberry");

        startingSeason.getItems().addAll("Spring", "Summer", "Fall", "Winter");
        startingSeason.setValue("Spring");
    }
}