import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

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

    /**
     * Handles action event of clicking button. Checks if name
     * is blank, if not then changes screen to ifarmui.
     * @param event the action taken by the user
     * @throws IOException if Ifarmui.fxml not found in call to changeScreen()
     */
    @FXML
    private void checkBlankName(ActionEvent event) throws IOException {
        // don't allow a blank name
        if (name == null || name.getText() == null || name.getText().trim().equals("")) {
            this.error.setText("Please enter a name");
            this.error.setTextFill(Color.web("#FF0000"));
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


    /**
     * @param event the action taken by the user
     * @throws IOException if Ifarmui.fxml is not found
     */
    @FXML
    private void changeScreen(ActionEvent event) throws IOException {
        this.game.setDifficulty((String) this.difficulty.getValue());
        this.game.setSeed((String) this.startingSeed.getValue());
        if (this.startingSeed.getValue().equals("Strawberry")) {
            this.game.addStrawberrySeed(1);
        } else if (this.startingSeed.getValue().equals("Raspberry")) {
            this.game.addRaspberrySeed(1);
        } else if (this.startingSeed.getValue().equals("Passion Fruit")) {
            this.game.addPassionFruitSeed(1);
        } else {
            this.game.addGrapeSeed(1);
        }
        this.game.setSeason((String) this.startingSeason.getValue());
        this.game.setName((String) this.name.getText());
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("Ifarmui.fxml"));
        Parent root3 = (Parent) loader.load();
        //Main.primaryStage.setScene(new Scene(root3, 800, 800));
        //Main.primaryStage.show();
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(new Scene(root3, 800, 800));
        window.show();
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
