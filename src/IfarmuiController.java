import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;


public class IfarmuiController implements Initializable {
    @FXML
    private Label day;
    @FXML
    private Label money;
    @FXML
    private Label name;
    @FXML
    private GridPane grid;
    @FXML
    private StackPane plot1;
    @FXML
    private Button inventory;

    private Game game = Game.factory();

    public IfarmuiController() {
    }

    @FXML
    private void difficultyLabel() {
        String difficulty = this.game.getDifficulty();
        int mon = 0;
        switch(difficulty) {
            case "Easy":
                    mon = 60;
                break;
            case "Medium":
                mon = 40;
                break;
            case "Hard":
                mon = 20;
        }
        this.game.setMoney(mon);
        this.money.setText("Money: $" + mon);


    }

    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.day.setText("Day " + this.game.getDay());
        this.name.setText(this.game.getName() + "'s Farm");
        this.difficultyLabel();

    }

    @FXML
    private void changeScreen(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("Inventory.fxml"));
        Parent root3 = (Parent) loader.load();
        Main.primaryStage.setScene(new Scene(root3, 800, 800));
        Main.primaryStage.show();
    }
}


