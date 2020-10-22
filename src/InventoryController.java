import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.TextAlignment;
import javafx.stage.Popup;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class InventoryController implements Initializable {

    @FXML
    private Label error;
    @FXML
    private Label inventoryCapacity;
    @FXML
    private Label raspberrySeedQuantity;
    @FXML
    private Label strawberrySeedQuantity;
    @FXML
    private Label passionFruitSeedQuantity;
    @FXML
    private Label grapeSeedQuantity;
    @FXML
    private Label strawberryCropQ;
    @FXML
    private Label raspberryCropQ;
    @FXML
    private Label passionFruitCropQ;
    @FXML
    private Label grapeCropQ;
    @FXML
    private Label pinCropQ;
    @FXML
    private Label pinSeedQ;
    @FXML
    private Label beanCropQ;
    @FXML
    private Label beanSeedQ;
    @FXML
    private Label dragCropQ;
    @FXML
    private Label dragSeedQ;
    @FXML
    private Label watCropQ;
    @FXML
    private Label watSeedQ;
    @FXML
    private Button market;
    Game game = Game.factory();
    Farm farm = Farm.factory();



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Game game = Game.factory();
        inventoryCapacity.setText("Inventory Capacity: "
                + game.getTotalInventoryQuantity() + "/"
                + game.getInventoryCapacity());
        raspberrySeedQuantity.setText("" + game.getRaspberrySeedQuantity());
        strawberrySeedQuantity.setText("" + game.getStrawberrySeedQuantity());
        passionFruitSeedQuantity.setText("" + game.getPassionFruitSeedQuantity());
        grapeSeedQuantity.setText("" + game.getGrapeSeedQuantity());
        strawberryCropQ.setText("" + game.getStrawberryCropQ());
        raspberryCropQ.setText("" + game.getRaspberryCropQ());
        passionFruitCropQ.setText("" + game.getPassionFruitCropQ());
        grapeCropQ.setText("" + game.getGrapeFruitCropQ());
        watCropQ.setText("" + game.getWatCropQ());
        watSeedQ.setText("" + game.getWatSeedQ());
        dragCropQ.setText("" + game.getDragCropQ());
        dragSeedQ.setText("" + game.getDragSeedQ());
        beanCropQ.setText("" + game.getBeanCropQ());
        beanSeedQ.setText("" + game.getBeanSeedQ());
        pinCropQ.setText("" + game.getPinCropQ());
        pinSeedQ.setText("" + game.getPinSeedQ());
    }
    @FXML
    private void changeScreen(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("Ifarmui.fxml"));
        Parent root3 = (Parent) loader.load();
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(new Scene(root3, 800, 800));
        window.show();
    }
    @FXML
    private void plant(ActionEvent event) {
        Label label = new Label();
        Popup popup = new Popup();
        String[] plots = farm.getPlots();
        switch (((Button) event.getSource()).getId()) {
            case "raspberryPlant" :
                if (game.getRaspberrySeedQuantity() > 0) {
                    game.addRaspberrySeed(-1); //reduce quantity
                    raspberrySeedQuantity.setText("" + game.getRaspberrySeedQuantity());
                    inventoryCapacity.setText("Inventory Capacity: "
                            + game.getTotalInventoryQuantity() + "/"
                            + game.getInventoryCapacity());
                    label.setText("You planted one Raspberry Seed!");
                    for (int i = 0; i < plots.length; i++) {
                        String text = plots[i];;
                        if (text.compareTo("Empty") == 0) {
                            farm.editPlot(i, "Raspberry seed");
                            break;
                        }
                    }
                }
                else {
                    label.setText("Oops! You don't have enough raspberry seeds to plant. Visit the market!");
            }
                break;
            case "strawberryPlant" :

        }

        label.setText(label.getText() + "\nClick out of this box to exit");
        label.setStyle(" -fx-background-color: lightgray;");
        popup.getContent().add(label);
        label.setMinWidth(250);
        label.setMinHeight(50);
        label.setAlignment(Pos.CENTER);
        label.setTextAlignment(TextAlignment.CENTER);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        popup.show(window);
        popup.setAutoHide(true);
    }

    @FXML
    private void changeScreenToMarket(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("Market.fxml"));
        Parent root3 = (Parent) loader.load();
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(new Scene(root3, 800, 800));
        window.show();
    }
}
