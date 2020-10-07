import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.IOException;
import java.net.URL;

import java.util.Random;
import java.util.ResourceBundle;

public class Marketcontroller implements Initializable {

    @FXML
    Label error;
    @FXML
    Label PineappleSeed;
    @FXML
    Label WatermelonSeed;
    @FXML
    Label DragonFruitSeed;
    // TO get money and other valuable information from other screens.
    @FXML
    private Game game = Game.factory();


    //The amount of seeds and capacity the market can hold
    final int marketCapacity = 100;
    final int size = 4;
    final double BasePrice = 3.50;
    Random rand;
    int randomValue = rand.nextInt(4 ) + 1;

    public double difficultyPrice() {
        if (game.getDifficulty().equals("Easy")) {
            return 2.0;
        } else if (game.getDifficulty().equals("Medium")) {
            return 1.5;
        } else {
            return 1.0;
        }
    }

    // the @param should be the action in which someone clicks a particular seed
    // or crop to buy
    public double sellingPriceCalculator() {
        double sellPrice = BasePrice * difficultyPrice() + randomValue;
    }

    public double buyingPriceCalculator() {
        double buyPrice = BasePrice * difficultyPrice() + (randomValue -1);
    }


    public void buy() {
        if (()game.getMoney());
    }

    public void sell() {

    }



    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    // So that the player can return to the Farm
    @FXML
    private void changeScreen(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("Ifarmui.fxml"));
        Parent root3 = (Parent) loader.load();
        Main.getPrimaryStage().setScene(new Scene(root3, 800, 800));
        Main.getPrimaryStage().show();
    }
}


