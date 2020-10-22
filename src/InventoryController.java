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
        boolean empty = false;
        switch (((Button) event.getSource()).getId()) {
            case "raspberryPlant" :
                if (game.getRaspberrySeedQuantity() > 0) {
                    for (int i = 0; i < plots.length; i++) {
                        String text = plots[i];;
                        if (text.compareTo("Empty") == 0) {
                            label.setText("You planted a Raspberry Seed!");
                            farm.editPlot(i, "Raspberry Seed");
                            empty = true;
                            game.addRaspberrySeed(-1); //reduce quantity
                            raspberrySeedQuantity.setText("" + game.getRaspberrySeedQuantity());
                            break;
                        }
                    }
                }
                else {
                    empty = true;
                    label.setText("Oops! You don't have any raspberry seeds to plant. Visit the market!");
            }
                break;
            case "strawberryPlant" :
                if (game.getStrawberrySeedQuantity() > 0) {
                    for (int i = 0; i < plots.length; i++) {
                        String text = plots[i];;
                        if (text.compareTo("Empty") == 0) {
                            label.setText("You planted a Strawberry Seed!");
                            farm.editPlot(i, "Strawberry Seed");
                            empty = true;
                            game.addStrawberrySeed(-1); //reduce quantity
                            strawberrySeedQuantity.setText("" + game.getStrawberrySeedQuantity());
                            break;
                        }
                    }
                }
                else {
                    empty = true;
                    label.setText("Oops! You don't have any strawberry seeds to plant. Visit the market!");
                }
                break;
            case "passionPlant" :
                if (game.getPassionFruitSeedQuantity() > 0) {
                    for (int i = 0; i < plots.length; i++) {
                        String text = plots[i];;
                        if (text.compareTo("Empty") == 0) {
                            label.setText("You planted a Passion Fruit Seed!");
                            farm.editPlot(i, "Passion Fruit Seed");
                            empty = true;
                            game.addPassionFruitSeed(-1); //reduce quantity
                            passionFruitSeedQuantity.setText("" + game.getPassionFruitSeedQuantity());
                            break;
                        }
                    }
                }
                else {
                    empty = true;
                    label.setText("Oops! You don't have any passion fruit seeds to plant. Visit the market!");
                }
                break;
            case "grapePlant" :
                if (game.getGrapeSeedQuantity() > 0) {
                    for (int i = 0; i < plots.length; i++) {
                        String text = plots[i];;
                        if (text.compareTo("Empty") == 0) {
                            label.setText("You planted a Grape Seed!");
                            farm.editPlot(i, "Grape Seed");
                            empty = true;
                            game.addGrapeSeed(-1); //reduce quantity
                            grapeSeedQuantity.setText("" + game.getGrapeSeedQuantity());
                            break;
                        }
                    }
                }
                else {
                    empty = true;
                    label.setText("Oops! You don't have any grape seeds to plant. Visit the market!");
                }
                break;
            case "watermelonPlant" :
                if (game.getWatSeedQ() > 0) {
                    for (int i = 0; i < plots.length; i++) {
                        String text = plots[i];;
                        if (text.compareTo("Empty") == 0) {
                            label.setText("You planted a Watermelon Seed!");
                            farm.editPlot(i, "Watermelon Seed");
                            empty = true;
                            game.addWatSeed(-1); //reduce quantity
                            watSeedQ.setText("" + game.getWatSeedQ());
                            break;
                        }
                    }
                }
                else {
                    empty = true;
                    label.setText("Oops! You don't have any watermelon seeds to plant. Visit the market!");
                }
                break;
            case "pineapplePlant" :
                if (game.getPinSeedQ() > 0) {
                    for (int i = 0; i < plots.length; i++) {
                        String text = plots[i];;
                        if (text.compareTo("Empty") == 0) {
                            label.setText("You planted a Pineapple Seed!");
                            farm.editPlot(i, "Pineapple Seed");
                            empty = true;
                            game.addPinSeed(-1); //reduce quantity
                            pinSeedQ.setText("" + game.getPinSeedQ());
                            break;
                        }
                    }
                }
                else {
                    empty = true;
                    label.setText("Oops! You don't have any pineapple seeds to plant. Visit the market!");
                }
                break;
            case "dragonPlant" :
                if (game.getDragSeedQ() > 0) {
                    for (int i = 0; i < plots.length; i++) {
                        String text = plots[i];;
                        if (text.compareTo("Empty") == 0) {
                            label.setText("You planted a Dragon Fruit Seed!");
                            farm.editPlot(i, "Dragon Fruit Seed");
                            empty = true;
                            game.addDragSeed(-1); //reduce quantity
                            dragSeedQ.setText("" + game.getDragSeedQ());
                            break;
                        }
                    }
                }
                else {
                    empty = true;
                    label.setText("Oops! You don't have any dragon fruit seeds to plant. Visit the market!");
                }
                break;
            case "beanPlant" :
                if (game.getBeanSeedQ() > 0) {
                    for (int i = 0; i < plots.length; i++) {
                        String text = plots[i];;
                        if (text.compareTo("Empty") == 0) {
                            label.setText("You planted a Bean Stalk Seed!");
                            farm.editPlot(i, "Bean Stalk Seed");
                            empty = true;
                            game.addBeanSeed(-1); //reduce quantity
                            beanSeedQ.setText("" + game.getBeanSeedQ());
                            break;
                        }
                    }
                }
                else {
                    empty = true;
                    label.setText("Oops! You don't have any bean stalk seeds to plant. Visit the market!");
                }
                break;
        }
        inventoryCapacity.setText("Inventory Capacity: "
                + game.getTotalInventoryQuantity() + "/"
                + game.getInventoryCapacity());
        if (!empty) {
            label.setText("Oops! You don't have any empty plot spaces. Harvest some crops!");
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
