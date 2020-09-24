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

    /**
     * Handles action event of clicking button
     * changes screen to ifarmui
     * does not need to be changed
     */
    @FXML
    private void changeScreen(ActionEvent event) throws IOException {
        Parent root3 = FXMLLoader.load(getClass().getResource("Ifarmui.fxml"));
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

    /**
     * Outputs the selected difficulty
     * @return the String representing difficulty
     */
    public String getDifficulty() {
        return difficulty.getValue();
    }

    /**
     * Outputs the selected starting seed
     * @return the String representing starting seed
     */
    public String getStartingSeed() {
        return startingSeed.getValue();
    }

    /**
     * Outputs the selected starting season
     * @return the String representing starting season
     */
    public String getStartingSeason() {
        return startingSeason.getValue();
    }
}
