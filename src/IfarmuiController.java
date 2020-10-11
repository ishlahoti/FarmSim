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
    private static boolean alreadyExecuted;

    @FXML
    private void difficultyLabel() {
            String difficulty = this.game.getDifficulty();
            int mon = 0;
            switch (difficulty) {
                case "Easy":
                    mon = 60;
                    break;
                case "Medium":
                    mon = 40;
                    break;
                case "Hard":
                    mon = 20;
                    break;
                default:
                    break;
            }
            this.game.setMoney(mon);
    }

    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.day.setText("Day " + this.game.getDay());
        this.name.setText(this.game.getName() + "'s Farm");
        if (!alreadyExecuted) {
            difficultyLabel();
            alreadyExecuted = true;
        }
        this.money.setText("Money $" + this.game.getMoney());
    }

    @FXML
    private void changeScreen(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("Inventory.fxml"));
        Parent root3 = (Parent) loader.load();
        Main.getPrimaryStage().setScene(new Scene(root3, 800, 800));
        Main.getPrimaryStage().show();
    }

    @FXML
    private void changeScreentoMarket(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("Market.fxml"));
        Parent root3 = (Parent) loader.load();
        Main.getPrimaryStage().setScene(new Scene(root3, 800, 800));
        Main.getPrimaryStage().show();
    }
}


