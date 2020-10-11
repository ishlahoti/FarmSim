import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;

import java.util.Random;
import java.util.ResourceBundle;

public class MarketController implements Initializable {

    private Market market; //determining the price of the goods.
    private Game game;
    private Items item;

    @FXML
    private static int capacity = 25;

    @FXML
    private Label dragonBuyPrice;

    @FXML
    private Label watermelonBuyPrice;

    @FXML
    private Label pineappleBuyPrice;

    @FXML
    private Label beanBuyPrice;

    @FXML
    private Label dragonSellPrice;

    @FXML
    private Label watermelonSellPrice;

    @FXML
    private Label pineappleSellPrice;

    @FXML
    private Label beanSellPrice;

    @FXML
    private Label dragonQMarket;

    @FXML
    private Label watermelonQMarket;

    @FXML
    private Label pineappleQMarket;

    @FXML
    private Label beanQMarket;

    // inventory seeds and crops
    @FXML
    private Label raspberryCrop, raspberrySeed;

    @FXML
    private Label strawberryCrop, strawberrySeed;

    @FXML
    private Label grapeCrop, grapeSeed;

    @FXML
    private Label passionFruitCrop, passionFruitSeed;

    // inventory crops/seeds sell
    @FXML
    private Label raspberryCSellPrice, raspberrySSellPrice;

    @FXML
    private Label strawberryCSellPrice, strawberrySSellPrice;

    @FXML
    private Label grapeCSellPrice, grapeSSellPrice;

    @FXML
    private Label passionCSellPrice, passionSSellPrice;

    //Inventory crops/seeds to buy from market;
    @FXML
    private Label raspberryCBuyPrice, raspberrySBuyPrice;

    @FXML
    private Label strawberryCBuyPrice, strawberrySBuyPrice;

    @FXML
    private Label grapeCBuyPrice, grapeSBuyPrice;

    @FXML
    private Label passionCBuyPrice, passionSBuyPrice;

    @FXML
    private Label money;

    @FXML
    private Label raspberryCQ, raspberrySQ;

    @FXML
    private Label strawberryCQ, strawberrySQ;

    @FXML
    private Label grapeFruitCQ, grapeFruitSQ;

    @FXML
    private Label passionFruitCQ, passionFruitSQ;

    @FXML
    private Button leave;

    // I havent out crops for the new seeds!!

    @FXML
    private void sell(ActionEvent event) {
        switch (((Button) event.getSource()).getId()) {
            case "dragonSell":
                if (item.getQuantity("DragonFruit Seed") > 0 && game.getDragSeedQ() > 0) {
                    game.setMoney((int) (game.getMoney() + market.getPSell("DragonFruit Seed")));
                    //item.setQuantity("DragonFruit Seed", (item.getQuantity("DragonFruit Seed") - 1));
                    game.addDragSeed(-1);
                }
                break;
            case "watermelonSell":
                if (item.getQuantity("Watermelon Seed") > 0 && game.getWatSeedQ() > 0) {
                    game.setMoney((int) (game.getMoney() + market.getPSell("Watermelon Seed")));
                    //item.setQuantity("Watermelon Seed", (item.getQuantity("Watermelon Seed") - 1));
                    game.addWatSeed(-1);
                }
                break;
            case "pineappleSell":
                if (item.getQuantity("Pineapple Seed") > 0 && game.getPinSeedQ() > 0) {
                    game.setMoney((int) game.getMoney() + market.getPSell("Pineapple Seed"));
                    //item.setQuantity("Pineapple Seed", (item.getQuantity("Pineapple Seed") - 1));
                    game.addPinSeed(-1);
                }
                break;
            case "beanSell":
                if (item.getQuantity("Bean Seed") > 0 && game.getBeanSeedQ() > 0) {
                    game.setMoney((int) game.getMoney() + market.getPSell("Bean Seed"));
                    //item.setQuantity("Bean Seed", (item.getQuantity("Bean Seed") - 1));
                    game.addBeanSeed(-1);
                }
                break;
            case "raspberryCSell":
                if (item.getQuantity("Raspberry Crop") > 0 && game.getRaspberryCropQ() > 0) {
                    game.setMoney((int) game.getMoney() + market.getPSell("Raspberry Crop"));
                    //item.setQuantity("Raspberry Crop", (item.getQuantity("Raspberry Crop") - 1));
                    game.addRaspberryCrop(-1);
                }
                break;
            case "strawberryCSell":
                if (item.getQuantity("Strawberry Crop") > 0 && game.getStrawberryCropQ() > 0) {
                    game.setMoney((int) game.getMoney() + market.getPSell("Strawberry Crop"));
                    game.addStrawberryCrop(-1);
                }
                break;
            case "grapeCSell":
                if (item.getQuantity("GrapeFruit Crop") > 0 && game.getGrapeFruitCropQ() > 0) {
                    game.setMoney((int) game.getMoney() + market.getPSell("GrapeFruit Crop"));
                    game.addGrapeCrop(-1);
                }
                break;
            case "passionCSell":
                if (item.getQuantity("PassionFruit Crop") > 0 && game.getGrapeFruitCropQ() > 0) {
                    game.setMoney((int) game.getMoney() + market.getPSell("PassionFruit Crop"));
                    game.addPassionFruitCrop(-1);

                }
            case "raspberrySSell":
                if (item.getQuantity("Raspberry Seed") > 0 && game.getRaspberrySeedQuantity() > 0) {
                    game.setMoney((int) game.getMoney() + market.getPSell("Raspberry Seed"));
                    game.addRaspberrySeed(-1);
                }
            case "strawberrySSell":
                if (item.getQuantity("Strawberry Seed") > 0 && game.getStrawberrySeedQuantity() > 0) {
                    game.setMoney((int) game.getMoney() + market.getPSell("Strawberry Seed"));
                    game.addStrawberrySeed(-1);
                }
            case "grapeSSell" :
                if (item.getQuantity("GrapeFruit Seed") > 0 && game.getGrapeSeedQuantity() > 0) {
                    game.setMoney((int) game.getMoney() + market.getPSell("GrapeFruit Seed"));
                    game.addGrapeSeed(-1);
                }
            case "passionSSell" :
                if (item.getQuantity("PassionFruit Seed") > 0 && game.getPassionFruitSeedQuantity() > 0) {
                    game.setMoney((int) game.getMoney() + market.getPSell("PassionFruit Seed"));
                    game.addPassionFruitSeed(-1);
                }
            default:
                break;

        }
        render();
    }

    @FXML
    private void buy(ActionEvent event) {
        switch (((Button) event.getSource()).getId()) {
            case "dragonBuy":
                if ((game.getMoney() - market.getPBuy("DragonFruit Seed") > 0)
                        && game.getTotalQuantity() <= capacity) {
                    game.setMoney((int) game.getMoney() - market.getPBuy("DragonFruit Seed"));
                    game.addDragSeed(1);
                }
                break;
            case "watermelonBuy":
                if ((game.getMoney() - market.getPBuy("Watermelon Seed") > 0)
                        && game.getTotalQuantity() <= capacity) {
                    game.setMoney((int) game.getMoney() - market.getPBuy("Watermelon Seed"));
                    game.addWatSeed(1);
                }
                break;
            case "pineappleBuy":
                if ((game.getMoney() - market.getPBuy("Pineapple Seed") > 0)
                        && game.getTotalQuantity() <= capacity) {
                    game.setMoney((int) game.getMoney() - market.getPBuy("Pineapple Seed"));
                    game.addPinSeed(1);
                }
                break;
            case "beanBuy":
                if ((game.getMoney() - market.getPBuy("Bean Seed") > 0)
                        && game.getTotalQuantity() <= capacity) {
                    game.setMoney((int) game.getMoney() - market.getPBuy("Bean Seed"));
                    game.addBeanSeed(1);
                }
                break;
            case "raspberryCBuy":
                if ((game.getMoney() - market.getPBuy("Raspberry Crop") > 0)
                        && game.getTotalQuantity() <= capacity) {
                    game.setMoney((int) game.getMoney() - market.getPBuy("Raspberry Crop"));
                    game.addRaspberryCrop(1);
                }
                break;
            case "strawberryCBuy":
                if ((game.getMoney() - market.getPBuy("Strawberry Crop") > 0)
                        && game.getTotalQuantity() <= capacity) {
                    game.setMoney((int) game.getMoney() - market.getPBuy("Strawberry Crop"));
                    game.addStrawberryCrop(1);
                }
                break;
            case "grapeCBuy":
                if ((game.getMoney() - market.getPBuy("GrapeFruit Crop") > 0)
                        && game.getTotalQuantity() <= capacity) {
                    game.setMoney((int) game.getMoney() - market.getPBuy("GrapeFruit Crop"));
                    game.addGrapeCrop(1);
                }
                break;
            case "passionCBuy" :
                if ((game.getMoney() - market.getPBuy("PassionFruit Crop") > 0)
                        && game.getTotalQuantity() <= capacity) {
                    game.setMoney((int) game.getMoney() - market.getPBuy("PassionFruit Crop"));
                    game.addPassionFruitCrop(1);
                }
            case "raspberrySBuy" :
                if ((game.getMoney() - market.getPBuy("Raspberry Seed") > 0)
                        && game.getTotalQuantity() <= capacity) {
                    game.setMoney((int) game.getMoney() - market.getPBuy("Raspberry Seed"));
                    game.addRaspberrySeed(1);
                }
            case "strawberrySBuy" :
                if ((game.getMoney() - market.getPBuy("Strawberry Seed") > 0)
                        && game.getTotalQuantity() <= capacity) {
                game.setMoney((int) game.getMoney() - market.getPBuy("Strawberry Seed"));
                game.addStrawberrySeed(1);
            }
            case "grapeSBuy" :
                if ((game.getMoney() - market.getPBuy("GrapeFruit Seed") > 0)
                        && game.getTotalQuantity() <= capacity) {
                game.setMoney((int) game.getMoney() - market.getPBuy("GrapeFruit Seed"));
                game.addGrapeSeed(1);
            }
            case "passionSBuy":
                if ((game.getMoney() - market.getPBuy("PassionFruit Seed") > 0)
                        && game.getTotalQuantity() <= capacity) {
                    game.setMoney((int) game.getMoney() - market.getPBuy("PassionFruit Seed"));
                    game.addPassionFruitSeed(1);
                }
            default:
                break;
        }

        render();
    }


    public void render(){
        dragonBuyPrice.setText(Integer.toString(market.getPBuy("DragonFruit Seed")));
        watermelonBuyPrice.setText(Integer.toString(market.getPBuy("Watermelon Seed")));
        pineappleBuyPrice.setText(Integer.toString(market.getPBuy("Pineapple Seed")));
        beanBuyPrice.setText(Integer.toString(market.getPBuy("Bean Seed")));

        dragonSellPrice.setText(Integer.toString(market.getPSell("DragonFruit Seed")));
        watermelonSellPrice.setText(Integer.toString(market.getPSell("Watermelon Seed")));
        pineappleSellPrice.setText(Integer.toString(market.getPSell("Pineapple Seed")));
        beanSellPrice.setText(Integer.toString(market.getPSell("Bean Seed")));

        // Quantities for the new seeds in the market.
        dragonQMarket.setText(Integer.toString(item.getQuantity("DragonFruit Seed")));
        watermelonQMarket.setText(Integer.toString(item.getQuantity("Watermelon Seed")));
        pineappleQMarket.setText(Integer.toString(item.getQuantity("Pineapple Seed")));
        beanQMarket.setText(Integer.toString(item.getQuantity("Bean Seed")));

        //crop and seed quantities for the market
        raspberryCrop.setText(Integer.toString(market.getQuantity("Raspberry Crop")));
        strawberryCrop.setText(Integer.toString(market.getQuantity("Strawberry Crop")));
        grapeCrop.setText(Integer.toString(market.getQuantity("GrapeFruit Crop")));
        passionFruitCrop.setText(Integer.toString(market.getQuantity("PassionFruit Crop")));
        raspberrySeed.setText(Integer.toString(market.getQuantity("Raspberry Seed")));
        strawberrySeed.setText(Integer.toString(market.getQuantity("Strawberry Seed")));
        grapeSeed.setText(Integer.toString(market.getQuantity("GrapeFruit Seed")));
        passionFruitSeed.setText(Integer.toString(market.getQuantity("PassionFruit Seed")));

        // The farmer can sell crops and seeds from his inventory;
        raspberryCSellPrice.setText(Integer.toString(market.getPSell("Raspberry Crop")));
        strawberryCSellPrice.setText(Integer.toString(market.getPSell("Strawberry Crop")));
        grapeCSellPrice.setText(Integer.toString(market.getPSell("GrapeFruit Crop")));
        passionCSellPrice.setText(Integer.toString(market.getPSell("PassionFruit Crop")));

        raspberrySSellPrice.setText(Integer.toString(market.getPSell("Raspberry Seed")));
        strawberrySSellPrice.setText(Integer.toString(market.getPSell("Strawberry Seed")));
        grapeSSellPrice.setText(Integer.toString(market.getPSell("GrapeFruit Seed")));
        passionSSellPrice.setText(Integer.toString(market.getPSell("PassionFruit Seed")));

        // The farmer can buy crops and seeds from the market;
        raspberryCBuyPrice.setText(Integer.toString(market.getPBuy("Raspberry Crop")));
        strawberryCBuyPrice.setText(Integer.toString(market.getPBuy("Strawberry Crop")));
        grapeCBuyPrice.setText(Integer.toString(market.getPBuy("GrapeFruit Crop")));
        passionCBuyPrice.setText(Integer.toString(market.getPBuy("PassionFruit Crop")));

        raspberrySBuyPrice.setText(Integer.toString(market.getPBuy("Raspberry Seed")));
        strawberrySBuyPrice.setText(Integer.toString(market.getPBuy("Strawberry Seed")));
        grapeSBuyPrice.setText(Integer.toString(market.getPBuy("GrapeFruit Seed")));
        passionSBuyPrice.setText(Integer.toString(market.getPBuy("PassionFruit Seed")));

        // Inventory quantities
        money.setText(Integer.toString((int) game.getMoney()));
        raspberryCQ.setText(Integer.toString(game.getRaspberryCropQ()));
        strawberryCQ.setText(Integer.toString(game.getStrawberryCropQ()));
        grapeFruitCQ.setText(Integer.toString(game.getGrapeFruitCropQ()));
        passionFruitCQ.setText(Integer.toString(game.getPassionFruitCropQ()));
        raspberrySQ.setText(Integer.toString(game.getRaspberrySeedQuantity()));
        strawberrySQ.setText(Integer.toString(game.getStrawberrySeedQuantity()));
        grapeFruitSQ.setText(Integer.toString(game.getGrapeSeedQuantity()));
        passionFruitSQ.setText(Integer.toString(game.getPassionFruitSeedQuantity()));



    }

    /**
     * Called to initialize a controller after its root element has been
     * completely processed.
     *
     * @param location  The location used to resolve relative paths for the root object, or
     *                  <tt>null</tt> if the location is not known.
     * @param resources The resources used to localize the root object, or <tt>null</tt> if
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) { }

    @FXML
    private void leave(ActionEvent event) {
        Stage stage = (Stage) leave.getScene().getWindow();
        stage.close();
    }

    @FXML
    void initData(Market market, Game game) {
        this.market = market;
        this.game = game;
        render();
    }

    @FXML
    private void changeScreen(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("Ifarmui.fxml"));
        Parent root3 = (Parent) loader.load();
        Main.getPrimaryStage().setScene(new Scene(root3, 800, 800));
        Main.getPrimaryStage().show();
    }
}


