import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

import java.io.IOException;


/**
 * Controller class for Configuration Screen
 */
public class ConfigController {
    @FXML
    private TextField name;
    @FXML
    private ChoiceBox<String> difficulty = new ChoiceBox<>();
    @FXML
    private ChoiceBox<String> startingSeed = new ChoiceBox<>();
    @FXML
    private ChoiceBox<String> startingSeason = new ChoiceBox<>();

    @FXML
    private Label error;
    private Game game = Game.factory();

    @FXML
    /**
     * Handles action event of clicking button. Checks if name
     * is blank, if not then changes screen to ifarmui.
     */
    private void checkBlankName(ActionEvent event) throws IOException {
        // don't allow a blank name
        if (name == null || name.getText() == null || name.getText().trim().equals("")) {
            this.error.setText("Please enter a name");
            this.error.setTextFill(Color.web("#FF0000"));
            System.out.println("here");
        } else {
            name.setText(name.getText().trim());
            changeScreen(event);
        }
    }
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
        this.game.setName((String) this.name.getText());
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Ifarmui.fxml"));
        Parent root3 = (Parent) loader.load();
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
