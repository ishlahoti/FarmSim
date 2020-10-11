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
    private static final int capacity = 20;

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
                if (game.getDragSeedQ() > 0) {
                    game.setMoney((int) (game.getMoney() + market.getPSell(Items.DRAGONS)));
                    game.addDragSeed(-1);
                }
                break;
            case "watermelonSell":
                if (game.getWatSeedQ() > 0) {
                    game.setMoney((int) (game.getMoney() + market.getPSell(Items.WATERMELONS)));
                    game.addWatSeed(-1);
                }
                break;
            case "pineappleSell":
                if (game.getPinSeedQ() > 0) {
                    game.setMoney((int) game.getMoney() + market.getPSell(Items.PINEAPPLES));
                    game.addPinSeed(-1);
                }
                break;
            case "beanSell":
                if (game.getBeanSeedQ() > 0) {
                    game.setMoney((int) game.getMoney() + market.getPSell(Items.BEANS));
                    game.addBeanSeed(-1);
                }
                break;
            case "raspberryCSell":
                if (game.getRaspberryCropQ() > 0) {
                    game.setMoney((int) game.getMoney() + market.getPSell(Items.RASPBERRYC));
                    game.addRaspberryCrop(-1);
                }
                break;
            case "strawberryCSell":
                if (game.getStrawberryCropQ() > 0) {
                    game.setMoney((int) game.getMoney() + market.getPSell(Items.STRAWBERRYC));
                    game.addStrawberryCrop(-1);
                }
                break;
            case "grapeCSell":
                if (game.getGrapeFruitCropQ() > 0) {
                    game.setMoney((int) game.getMoney() + market.getPSell(Items.GRAPEC));
                    game.addGrapeCrop(-1);
                }
                break;
            case "passionCSell":
                if (game.getGrapeFruitCropQ() > 0) {
                    game.setMoney((int) game.getMoney() + market.getPSell(Items.PASSIONC));
                    game.addPassionFruitCrop(-1);

                }
            case "raspberrySSell":
                if (game.getRaspberrySeedQuantity() > 0) {
                    game.setMoney((int) game.getMoney() + market.getPSell(Items.RASPBERRYS));
                    game.addRaspberrySeed(-1);
                }
            case "strawberrySSell":
                if (game.getStrawberrySeedQuantity() > 0) {
                    game.setMoney((int) game.getMoney() + market.getPSell(Items.STRAWBERRYS));
                    game.addStrawberrySeed(-1);
                }
            case "grapeSSell" :
                if ( game.getGrapeSeedQuantity() > 0) {
                    game.setMoney((int) game.getMoney() + market.getPSell(Items.GRAPES));
                    game.addGrapeSeed(-1);
                }
            case "passionSSell" :
                if (game.getPassionFruitSeedQuantity() > 0) {
                    game.setMoney((int) game.getMoney() + market.getPSell(Items.PASSIONS));
                    game.addPassionFruitSeed(-1);
                }
            default:
                break;

        }
        //render();
    }

    @FXML
    private void buy(ActionEvent event) {
        switch (((Button) event.getSource()).getId()) {
            case "dragonBuy":
                if ((game.getMoney() - market.getPBuy(Items.DRAGONS) > 0)
                        && game.getTotalQuantity() <= capacity) {
                    game.setMoney((int) game.getMoney() - market.getPBuy(Items.DRAGONS));
                    game.addDragSeed(1);
                }
                break;
            case "watermelonBuy":
                if ((game.getMoney() - market.getPBuy(Items.WATERMELONS) > 0)
                        && game.getTotalQuantity() <= capacity) {
                    game.setMoney((int) game.getMoney() - market.getPBuy(Items.WATERMELONS));
                    game.addWatSeed(1);
                }
                break;
            case "pineappleBuy":
                if ((game.getMoney() - market.getPBuy(Items.PINEAPPLES) > 0)
                        && game.getTotalQuantity() <= capacity) {
                    game.setMoney((int) game.getMoney() - market.getPBuy(Items.PINEAPPLES));
                    game.addPinSeed(1);
                }
                break;
            case "beanBuy":
                if ((game.getMoney() - market.getPBuy(Items.BEANS) > 0)
                        && game.getTotalQuantity() <= capacity) {
                    game.setMoney((int) game.getMoney() - market.getPBuy(Items.BEANS));
                    game.addBeanSeed(1);
                }
                break;
            case "raspberryCBuy":
                if ((game.getMoney() - market.getPBuy(Items.RASPBERRYC) > 0)
                        && game.getTotalQuantity() <= capacity) {
                    game.setMoney((int) game.getMoney() - market.getPBuy(Items.RASPBERRYC));
                    game.addRaspberryCrop(1);
                }
                break;
            case "strawberryCBuy":
                if ((game.getMoney() - market.getPBuy(Items.STRAWBERRYC) > 0)
                        && game.getTotalQuantity() <= capacity) {
                    game.setMoney((int) game.getMoney() - market.getPBuy(Items.STRAWBERRYC));
                    game.addStrawberryCrop(1);
                }
                break;
            case "grapeCBuy":
                if ((game.getMoney() - market.getPBuy(Items.GRAPEC) > 0)
                        && game.getTotalQuantity() <= capacity) {
                    game.setMoney((int) game.getMoney() - market.getPBuy(Items.GRAPEC));
                    game.addGrapeCrop(1);
                }
                break;
            case "passionCBuy" :
                if ((game.getMoney() - market.getPBuy(Items.PASSIONC) > 0)
                        && game.getTotalQuantity() <= capacity) {
                    game.setMoney((int) game.getMoney() - market.getPBuy(Items.PASSIONC));
                    game.addPassionFruitCrop(1);
                }
            case "raspberrySBuy" :
                if ((game.getMoney() - market.getPBuy(Items.RASPBERRYS) > 0)
                        && game.getTotalQuantity() <= capacity) {
                    game.setMoney((int) game.getMoney() - market.getPBuy(Items.RASPBERRYS));
                    game.addRaspberrySeed(1);
                }
            case "strawberrySBuy" :
                if ((game.getMoney() - market.getPBuy(Items.STRAWBERRYS) > 0)
                        && game.getTotalQuantity() <= capacity) {
                game.setMoney((int) game.getMoney() - market.getPBuy(Items.STRAWBERRYS));
                game.addStrawberrySeed(1);
            }
            case "grapeSBuy" :
                if ((game.getMoney() - market.getPBuy(Items.GRAPES) > 0)
                        && game.getTotalQuantity() <= capacity) {
                game.setMoney((int) game.getMoney() - market.getPBuy(Items.GRAPES));
                game.addGrapeSeed(1);
            }
            case "passionSBuy":
                if ((game.getMoney() - market.getPBuy(Items.PASSIONS) > 0)
                        && game.getTotalQuantity() <= capacity) {
                    game.setMoney((int) game.getMoney() - market.getPBuy(Items.PASSIONS));
                    game.addPassionFruitSeed(1);
                }
            default:
                break;
        }
        //render();
    }

    /*
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
        dragonQMarket.setText(Integer.toString(game.getDragSeedQ()));
        watermelonQMarket.setText(Integer.toString(game.getWatSeedQ()));
        pineappleQMarket.setText(Integer.toString(game.getPinSeedQ()));
        beanQMarket.setText(Integer.toString(game.getBeanSeedQ()));

        //crop and seed quantities for the market
        raspberryCrop.setText(Integer.toString(game.getRaspberryCropQ()));
        strawberryCrop.setText(Integer.toString(game.getStrawberryCropQ()));
        grapeCrop.setText(Integer.toString(game.getGrapeFruitCropQ()));
        passionFruitCrop.setText(Integer.toString(game.getPassionFruitCropQ()));
        raspberrySeed.setText(Integer.toString(game.getRaspberrySeedQuantity()));
        strawberrySeed.setText(Integer.toString(game.getStrawberrySeedQuantity()));
        grapeSeed.setText(Integer.toString(game.getGrapeSeedQuantity()));
        passionFruitSeed.setText(Integer.toString(game.getPassionFruitSeedQuantity()));

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

     */

    /**
     * Called to initialize a controller after its root element has been
     * completely processed.
     *
     * @param location  The location used to resolve relative paths for the root object, or
     *                  <tt>null</tt> if the location is not known.
     * @param resources The resources used to localize the root object, or <tt>null</tt> if
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        market = new Market();
        this.game = Game.factory();
        dragonBuyPrice.setText(Integer.toString(market.getPBuy(Items.DRAGONS)));
        watermelonBuyPrice.setText(Integer.toString(market.getPBuy(Items.WATERMELONS)));
        pineappleBuyPrice.setText(Integer.toString(market.getPBuy(Items.PINEAPPLES)));
        beanBuyPrice.setText(Integer.toString(market.getPBuy(Items.BEANS)));

        dragonSellPrice.setText(Integer.toString(market.getPSell(Items.DRAGONS)));
        watermelonSellPrice.setText(Integer.toString(market.getPSell(Items.WATERMELONS)));
        pineappleSellPrice.setText(Integer.toString(market.getPSell(Items.PINEAPPLES)));
        beanSellPrice.setText(Integer.toString(market.getPSell(Items.BEANS)));

        // Quantities for the new seeds in the market.
        dragonQMarket.setText(Integer.toString(game.getDragSeedQ()));
        watermelonQMarket.setText(Integer.toString(game.getWatSeedQ()));
        pineappleQMarket.setText(Integer.toString(game.getPinSeedQ()));
        beanQMarket.setText(Integer.toString(game.getBeanSeedQ()));

        //crop and seed quantities for the market
        raspberryCrop.setText(Integer.toString(game.getRaspberryCropQ()));
        strawberryCrop.setText(Integer.toString(game.getStrawberryCropQ()));
        grapeCrop.setText(Integer.toString(game.getGrapeFruitCropQ()));
        passionFruitCrop.setText(Integer.toString(game.getPassionFruitCropQ()));
        raspberrySeed.setText(Integer.toString(game.getRaspberrySeedQuantity()));
        strawberrySeed.setText(Integer.toString(game.getStrawberrySeedQuantity()));
        grapeSeed.setText(Integer.toString(game.getGrapeSeedQuantity()));
        passionFruitSeed.setText(Integer.toString(game.getPassionFruitSeedQuantity()));

        // The farmer can sell crops and seeds from his inventory;
        raspberryCSellPrice.setText(Integer.toString(market.getPSell(Items.RASPBERRYC)));
        strawberryCSellPrice.setText(Integer.toString(market.getPSell(Items.STRAWBERRYC)));
        grapeCSellPrice.setText(Integer.toString(market.getPSell(Items.GRAPEC)));
        passionCSellPrice.setText(Integer.toString(market.getPSell(Items.PASSIONC)));

        raspberrySSellPrice.setText(Integer.toString(market.getPSell(Items.RASPBERRYS)));
        strawberrySSellPrice.setText(Integer.toString(market.getPSell(Items.STRAWBERRYS)));
        grapeSSellPrice.setText(Integer.toString(market.getPSell(Items.GRAPES)));
        passionSSellPrice.setText(Integer.toString(market.getPSell(Items.PASSIONS)));

        // The farmer can buy crops and seeds from the market;
        raspberryCBuyPrice.setText(Integer.toString(market.getPBuy(Items.RASPBERRYC)));
        strawberryCBuyPrice.setText(Integer.toString(market.getPBuy(Items.STRAWBERRYC)));
        grapeCBuyPrice.setText(Integer.toString(market.getPBuy(Items.GRAPEC)));
        passionCBuyPrice.setText(Integer.toString(market.getPBuy(Items.PASSIONC)));

        raspberrySBuyPrice.setText(Integer.toString(market.getPBuy(Items.RASPBERRYS)));
        strawberrySBuyPrice.setText(Integer.toString(market.getPBuy(Items.STRAWBERRYS)));
        grapeSBuyPrice.setText(Integer.toString(market.getPBuy(Items.GRAPES)));
        passionSBuyPrice.setText(Integer.toString(market.getPBuy(Items.PASSIONS)));

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
        //render();
    }

    @FXML
    private void leave(ActionEvent event) {
        Stage stage = (Stage) leave.getScene().getWindow();
        stage.close();
    }

    @FXML
    void initData(Market market, Game game) {
        this.market = market;
        this.game = game;
        //render();
    }

    @FXML
    private void changeScreen(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("Ifarmui.fxml"));
        Parent root3 = loader.load();
        Main.getPrimaryStage().setScene(new Scene(root3, 800, 800));
        Main.getPrimaryStage().show();
    }
}


