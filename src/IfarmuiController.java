import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import java.io.IOException;

/**
 * Controller class for Initial Farm User Interface
 * TODO: display starting money/farm plots/day based on what user selects in previous screen
 */
public class IfarmuiController {

    final int[] moneyval = {0};
    final int[] dayval = {0};

    @FXML
    private Label day;

    @FXML
    private Label money;

    @FXML
    private GridPane grid;

    @FXML
    public void getDifficulty(String difficulty) {
        int mon = 0;
        switch (difficulty) {
            case "Easy":
                mon = 20;
                break;
            case "Medium":
                mon = 40;
                break;
            case "Hard":
                mon = 60;
        }
        moneyval[0] = moneyval[0] + mon;
        money.setText("Money: $" + moneyval[0]);
        updateDay();
        plots();
    }


        @FXML
        private void updateDay() {
            day.setText("Day " + (dayval[0] + 1));
        }


        @FXML
        private void plots() {
            grid.setGridLinesVisible(true);
        }





    }


