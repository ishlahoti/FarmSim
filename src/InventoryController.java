import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import java.net.URL;
import java.util.ResourceBundle;

public class InventoryController implements Initializable {

    @FXML
    Label error;
    @FXML
    Label raspberrySeedQuantity;
    @FXML
    Label strawberrySeedQuantity;
    @FXML
    Label passionFruitSeedQuantity;
    @FXML
    Label grapeSeedQuantity;

    final int capacity = 20;
    int size = 4;

    //made add & remove for each item
    public void addRaspberrySeed(int x) {
        if (size == capacity) {
            //for market, should have error message pop up when trying to buy
        }
        int curr = Integer.parseInt(raspberrySeedQuantity.getText());
        int val = curr + x;
        raspberrySeedQuantity.setText("" + val);
        size+=x;
    }
    public void removeRaspberrySeed() {
        int curr = Integer.parseInt(raspberrySeedQuantity.getText());
        int val = curr - 1;
        raspberrySeedQuantity.setText("" + val);
        size--;
    }
    public void addStrawberrySeed(int x) {
        if (size == capacity) {
            //for market, should have error message pop up when trying to buy
        }
        int curr = Integer.parseInt(strawberrySeedQuantity.getText());
        int val = curr + x;
        strawberrySeedQuantity.setText("" + val);
        size+=x;
    }
    public void removeStrawberrySeed() {
        int curr = Integer.parseInt(strawberrySeedQuantity.getText());
        int val = curr - 1;
        strawberrySeedQuantity.setText("" + val);
        size--;
    }
    public void addPassionFruitSeed(int x) {
        if (size == capacity) {
            //for market, should have error message pop up when trying to buy
        }
        int curr = Integer.parseInt(passionFruitSeedQuantity.getText());
        int val = curr + x;
        passionFruitSeedQuantity.setText("" + val);
        size+=x;
    }
    public void removePassionFruitSeed() {
        int curr = Integer.parseInt(passionFruitSeedQuantity.getText());
        int val = curr - 1;
        passionFruitSeedQuantity.setText("" + val);
        size--;
    }
    public void addGrapeSeed(int x) {
        if (size == capacity) {
            //for market, should have error message pop up when trying to buy
        }
        int curr = Integer.parseInt(grapeSeedQuantity.getText());
        int val = curr + x;
       grapeSeedQuantity.setText("" + val);
        size+=x;
    }
    public void removeGrapeSeed() {
        int curr = Integer.parseInt(grapeSeedQuantity.getText());
        int val = curr - 1;
        grapeSeedQuantity.setText("" + val);
        size--;
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }
}
