import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class IfarmuiController implements Initializable {
    @FXML
    private Label day;
    @FXML
    private Label money;
    @FXML
    private Label name;
    @FXML
    private GridPane grid;
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
}


