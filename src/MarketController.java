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

public class MarketController implements Initializable {

    @FXML
    Label error;
    @FXML
    Label watermelonSeedP, pineappleSeedP, dragonFruitSeedP, beanStalkSeedP;

    // These are buttons that will be clicked and the trolley will be filled.
    @FXML
    Label Buy;
    @FXML
    Label Sell;
    @FXML
    private Game game = Game.factory();

    //Listing of inventory and continual updating of the inventory.
    // Listing of seeds to sell.
    // Listing of seed to buy

    //The amount of seeds and capacity the market can hold
    final int marketCapacity = 100;
    final int size = 4;
    @FXML
    final double watermelonPrice = sellingPriceCalculator();
    @FXML
    final double pineapplePrice = sellingPriceCalculator();
    @FXML
    final double dragonFruitPrice = sellingPriceCalculator();
    @FXML
    final double beanStalkPrice = sellingPriceCalculator();
    final double BasePrice = 3.50;
    Random rand;
    int randomValue = rand.nextInt(4 ) + 1;

    private double difficultyPrice() {
        if (game.getDifficulty().equals("Easy")) {
            return 2.0;
        } else if (game.getDifficulty().equals("Medium")) {
            return 1.5;
        } else {
            return 1.0;
        }
    }

    // you need to display the money next to the labels.
    private double sellingPriceCalculator() {
        // the price should be adjusted based on the seed.
        double sellPrice = BasePrice * difficultyPrice() + randomValue;
        return sellPrice;
    }

    private double buyingPriceCalculator() {
        double buyPrice = BasePrice * difficultyPrice() + (randomValue -1);
        return buyPrice;
    }

    // the @param should be the action when someone wants to buy a crop or a seed.
    @FXML
    public void buy(ActionEvent event) throws IOException {
        // Player's money - crop's selling price > 0
       //if (game.getMoney() - );
       //  update the player's inventory
        // Update the player's money
    }

    // the @param should be the action in which someone clicks a particular seed
    // or crop to sell
    public void sell() {
        // update the player's inventory
        // update the player's money
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


