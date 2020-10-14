import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
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

    private final int maxMarketCapacity = 30;

    @FXML
    private Label marketLabel;


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

    @FXML
    private Label dragonSQ, watermelonSQ, pineappleSQ, beanSQ;

    // starts out with a full market capacity of 25, must buy first before you sell

    @FXML
    private void sell(ActionEvent event) {
        if (game.getTotalMarketQuantity() < maxMarketCapacity) {
            switch (((Button) event.getSource()).getId()) {
                case "dragonSell":
                    if (game.getDragSeedQ() > 0) {
                        game.setMoney((int) (game.getMoney() + market.getPSell(Items.DRAGONS)));
                        game.addDragSeed(-1);
                        game.changeDragSeedQMarket(1);
                    }
                    break;
                case "watermelonSell":
                    if (game.getWatSeedQ() > 0) {
                        game.setMoney((int) (game.getMoney() + market.getPSell(Items.WATERMELONS)));
                        game.addWatSeed(-1);
                        game.changeWatSeedQMarket(1);
                    }
                    break;
                case "pineappleSell":
                    if (game.getPinSeedQ() > 0) {
                        game.setMoney((int) game.getMoney() + market.getPSell(Items.PINEAPPLES));
                        game.addPinSeed(-1);
                        game.changePinSeedQMarket(1);
                    }
                    break;
                case "beanSell":
                    if (game.getBeanSeedQ() > 0) {
                        game.setMoney((int) game.getMoney() + market.getPSell(Items.BEANS));
                        game.addBeanSeed(-1);
                        game.changeBeanSeedQMarket(1);
                    }
                    break;
                case "raspberryCSell":
                    if (game.getRaspberryCropQ() > 0) {
                        game.setMoney((int) game.getMoney() + market.getPSell(Items.RASPBERRYC));
                        game.addRaspberryCrop(-1);
                        game.changeRaspberryCropQMarket(1);
                    }
                    break;
                case "strawberryCSell":
                    if (game.getStrawberryCropQ() > 0) {
                        game.setMoney((int) game.getMoney() + market.getPSell(Items.STRAWBERRYC));
                        game.addStrawberryCrop(-1);
                        game.changeStrawberryCropQMarket(1);
                    }
                    break;
                case "grapeCSell":
                    if (game.getGrapeFruitCropQ() > 0) {
                        game.setMoney((int) game.getMoney() + market.getPSell(Items.GRAPEC));
                        game.addGrapeCrop(-1);
                        game.changeGrapeCropQMarket(1);
                    }
                    break;
                case "passionCSell":
                    if (game.getPassionFruitCropQ() > 0) {
                        game.setMoney((int) game.getMoney() + market.getPSell(Items.PASSIONC));
                        game.addPassionFruitCrop(-1);
                        game.changePassionFruitCropQMarket(1);
                    }
                    break;
                case "raspberrySSell":
                    if (game.getRaspberrySeedQuantity() > 0) {
                        game.setMoney((int) game.getMoney() + market.getPSell(Items.RASPBERRYS));
                        game.addRaspberrySeed(-1);
                        game.changeRaspberrySeedQuantityMarket(1);
                    }
                    break;
                case "strawberrySSell":
                    if (game.getStrawberrySeedQuantity() > 0) {
                        game.setMoney((int) game.getMoney() + market.getPSell(Items.STRAWBERRYS));
                        game.addStrawberrySeed(-1);
                        game.changeStrawberrySeedQuantityMarket(1);
                    }
                    break;
                case "grapeSSell" :
                    if ( game.getGrapeSeedQuantity() > 0) {
                        game.setMoney((int) game.getMoney() + market.getPSell(Items.GRAPES));
                        game.addGrapeSeed(-1);
                        game.changeGrapeSeedQuantityMarket(1);
                    }
                    break;
                case "passionSSell" :
                    if (game.getPassionFruitSeedQuantity() > 0) {
                        game.setMoney((int) game.getMoney() + market.getPSell(Items.PASSIONS));
                        game.addPassionFruitSeed(-1);
                        game.changePassionFruitSeedQuantityMarket(1);
                    }
                    break;
                default:
                    break;
            }
            render();
        }
    }

    @FXML
    private void buy(ActionEvent event) {
        if (game.getTotalMarketQuantity() > 0) {
            switch (((Button) event.getSource()).getId()) {
                case "dragonBuy":
                    if ((game.getMoney() - market.getPBuy(Items.DRAGONS) >= 0)
                            && game.getTotalInventoryQuantity() < game.getInventoryCapacity()
                            && game.getDragSeedQMarket() > 0) {
                        game.setMoney((int) game.getMoney() - market.getPBuy(Items.DRAGONS));
                        game.changeDragSeedQMarket(-1);
                        game.addDragSeed(1);
                    }
                    break;
                case "watermelonBuy":
                    if ((game.getMoney() - market.getPBuy(Items.WATERMELONS) >= 0)
                            && game.getTotalInventoryQuantity() < game.getInventoryCapacity()
                            && game.getWatSeedQMarket() > 0) {
                        game.setMoney((int) game.getMoney() - market.getPBuy(Items.WATERMELONS));
                        game.changeWatSeedQMarket(-1);
                        game.addWatSeed(1);
                    }
                    break;
                case "pineappleBuy":
                    if ((game.getMoney() - market.getPBuy(Items.PINEAPPLES) >= 0)
                            && game.getTotalInventoryQuantity() < game.getInventoryCapacity()
                            && game.getPinSeedQMarket() > 0) {
                        game.setMoney((int) game.getMoney() - market.getPBuy(Items.PINEAPPLES));
                        game.changePinSeedQMarket(-1);
                        game.addPinSeed(1);
                    }
                    break;
                case "beanBuy":
                    if ((game.getMoney() - market.getPBuy(Items.BEANS) >= 0)
                            && game.getTotalInventoryQuantity() < game.getInventoryCapacity()
                            && game.getBeanSeedQMarket() > 0) {
                        game.setMoney((int) game.getMoney() - market.getPBuy(Items.BEANS));
                        game.changeBeanSeedQMarket(-1);
                        game.addBeanSeed(1);
                    }
                    break;
                case "raspberryCBuy":
                    if ((game.getMoney() - market.getPBuy(Items.RASPBERRYC) >= 0)
                            && game.getTotalInventoryQuantity() < game.getInventoryCapacity()
                            && game.getRaspberryCropQMarket() > 0) {
                        game.setMoney((int) game.getMoney() - market.getPBuy(Items.RASPBERRYC));
                        game.changeRaspberryCropQMarket(-1);
                        game.addRaspberryCrop(1);
                    }
                    break;
                case "strawberryCBuy":
                    if ((game.getMoney() - market.getPBuy(Items.STRAWBERRYC) >= 0)
                            && game.getTotalInventoryQuantity() < game.getInventoryCapacity()
                            && game.getStrawberryCropQMarket() > 0) {
                        game.setMoney((int) game.getMoney() - market.getPBuy(Items.STRAWBERRYC));
                        game.changeStrawberryCropQMarket(-1);
                        game.addStrawberryCrop(1);
                    }
                    break;
                case "grapeCBuy":
                    if ((game.getMoney() - market.getPBuy(Items.GRAPEC) >= 0)
                            && game.getTotalInventoryQuantity() < game.getInventoryCapacity()
                            && game.getGrapeCropQMarket() > 0) {
                        game.setMoney((int) game.getMoney() - market.getPBuy(Items.GRAPEC));
                        game.changeGrapeCropQMarket(-1);
                        game.addGrapeCrop(1);
                    }
                    break;
                case "passionCBuy" :
                    if ((game.getMoney() - market.getPBuy(Items.PASSIONC) >= 0)
                            && game.getTotalInventoryQuantity() < game.getInventoryCapacity()
                            && game.getPassionFruitCropQMarket() > 0) {
                        game.setMoney((int) game.getMoney() - market.getPBuy(Items.PASSIONC));
                        game.changePassionFruitCropQMarket(-1);
                        game.addPassionFruitCrop(1);
                    }
                    break;
                case "raspberrySBuy" :
                    if ((game.getMoney() - market.getPBuy(Items.RASPBERRYS) >= 0)
                            && game.getTotalInventoryQuantity() < game.getInventoryCapacity()
                            && game.getRaspberrySeedQuantityMarket() > 0) {
                        game.setMoney((int) game.getMoney() - market.getPBuy(Items.RASPBERRYS));
                        game.changeRaspberrySeedQuantityMarket(-1);
                        game.addRaspberrySeed(1);
                    }
                    break;
                case "strawberrySBuy" :
                    if ((game.getMoney() - market.getPBuy(Items.STRAWBERRYS) >= 0)
                            && game.getTotalInventoryQuantity() < game.getInventoryCapacity()
                            && game.getStrawberrySeedQuantityMarket() > 0) {
                        game.setMoney((int) game.getMoney() - market.getPBuy(Items.STRAWBERRYS));
                        game.changeStrawberrySeedQuantityMarket(-1);
                        game.addStrawberrySeed(1);
                    }
                    break;
                case "grapeSBuy" :
                    if ((game.getMoney() - market.getPBuy(Items.GRAPES) >= 0)
                            && game.getTotalInventoryQuantity() < game.getInventoryCapacity()
                            && game.getGrapeSeedQuantityMarket() > 0) {
                        game.setMoney((int) game.getMoney() - market.getPBuy(Items.GRAPES));
                        game.changeGrapeSeedQuantityMarket(-1);
                        game.addGrapeSeed(1);
                    }
                    break;
                case "passionSBuy":
                    if ((game.getMoney() - market.getPBuy(Items.PASSIONS) >= 0)
                            && game.getTotalInventoryQuantity() < game.getInventoryCapacity()
                            && game.getPassionFruitSeedQuantityMarket() > 0) {
                        game.setMoney((int) game.getMoney() - market.getPBuy(Items.PASSIONS));
                        game.changePassionFruitSeedQuantityMarket(-1);
                        game.addPassionFruitSeed(1);
                    }
                default:
                    break;
            }
            render();
        }
    }

    public void render(){
        marketLabel.setText("Market Capacity: " + game.getTotalMarketQuantity() + "/" + maxMarketCapacity);

        dragonBuyPrice.setText(Integer.toString(market.getPBuy(Items.DRAGONS)));
        watermelonBuyPrice.setText(Integer.toString(market.getPBuy(Items.WATERMELONS)));
        pineappleBuyPrice.setText(Integer.toString(market.getPBuy(Items.PINEAPPLES)));
        beanBuyPrice.setText(Integer.toString(market.getPBuy(Items.BEANS)));

        dragonSellPrice.setText(Integer.toString(market.getPSell(Items.DRAGONS)));
        watermelonSellPrice.setText(Integer.toString(market.getPSell(Items.WATERMELONS)));
        pineappleSellPrice.setText(Integer.toString(market.getPSell(Items.PINEAPPLES)));
        beanSellPrice.setText(Integer.toString(market.getPSell(Items.BEANS)));

        // Quantities for the new seeds in the market.
        dragonQMarket.setText(Integer.toString(game.getDragSeedQMarket()));
        watermelonQMarket.setText(Integer.toString(game.getWatSeedQMarket()));
        pineappleQMarket.setText(Integer.toString(game.getPinSeedQMarket()));
        beanQMarket.setText(Integer.toString(game.getBeanSeedQMarket()));

        //crop and seed quantities for the market
        raspberryCrop.setText(Integer.toString(game.getRaspberryCropQMarket()));
        strawberryCrop.setText(Integer.toString(game.getStrawberryCropQMarket()));
        grapeCrop.setText(Integer.toString(game.getGrapeCropQMarket()));
        passionFruitCrop.setText(Integer.toString(game.getPassionFruitCropQMarket()));
        raspberrySeed.setText(Integer.toString(game.getRaspberrySeedQuantityMarket()));
        strawberrySeed.setText(Integer.toString(game.getStrawberrySeedQuantityMarket()));
        grapeSeed.setText(Integer.toString(game.getGrapeSeedQuantityMarket()));
        passionFruitSeed.setText(Integer.toString(game.getPassionFruitSeedQuantityMarket()));

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
        dragonSQ.setText(Integer.toString(game.getDragSeedQ()));
        watermelonSQ.setText(Integer.toString(game.getWatSeedQ()));
        pineappleSQ.setText(Integer.toString(game.getPinSeedQ()));
        beanSQ.setText(Integer.toString(game.getBeanSeedQ()));


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
    public void initialize(URL location, ResourceBundle resources) {
        market = new Market();
        this.game = Game.factory();
        marketLabel.setText("Market Capacity: " + game.getTotalMarketQuantity() + "/" + maxMarketCapacity);
        dragonBuyPrice.setText(Integer.toString(market.getPBuy(Items.DRAGONS)));
        watermelonBuyPrice.setText(Integer.toString(market.getPBuy(Items.WATERMELONS)));
        pineappleBuyPrice.setText(Integer.toString(market.getPBuy(Items.PINEAPPLES)));
        beanBuyPrice.setText(Integer.toString(market.getPBuy(Items.BEANS)));

        dragonSellPrice.setText(Integer.toString(market.getPSell(Items.DRAGONS)));
        watermelonSellPrice.setText(Integer.toString(market.getPSell(Items.WATERMELONS)));
        pineappleSellPrice.setText(Integer.toString(market.getPSell(Items.PINEAPPLES)));
        beanSellPrice.setText(Integer.toString(market.getPSell(Items.BEANS)));

        // Quantities for the new seeds in the market.
        dragonQMarket.setText(Integer.toString(game.getDragSeedQMarket()));
        watermelonQMarket.setText(Integer.toString(game.getWatSeedQMarket()));
        pineappleQMarket.setText(Integer.toString(game.getPinSeedQMarket()));
        beanQMarket.setText(Integer.toString(game.getBeanSeedQMarket()));

        //crop and seed quantities for the market
        raspberryCrop.setText(Integer.toString(game.getRaspberryCropQMarket()));
        strawberryCrop.setText(Integer.toString(game.getStrawberryCropQMarket()));
        grapeCrop.setText(Integer.toString(game.getGrapeCropQMarket()));
        passionFruitCrop.setText(Integer.toString(game.getPassionFruitCropQMarket()));

        raspberrySeed.setText(Integer.toString(game.getRaspberrySeedQuantityMarket()));
        strawberrySeed.setText(Integer.toString(game.getStrawberrySeedQuantityMarket()));
        grapeSeed.setText(Integer.toString(game.getGrapeSeedQuantityMarket()));
        passionFruitSeed.setText(Integer.toString(game.getPassionFruitSeedQuantityMarket()));

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
        dragonSQ.setText(Integer.toString(game.getDragSeedQ()));
        watermelonSQ.setText(Integer.toString(game.getWatSeedQ()));
        pineappleSQ.setText(Integer.toString(game.getPinSeedQ()));
        beanSQ.setText(Integer.toString(game.getBeanSeedQ()));


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
        render();
    }

    @FXML
    private void changeScreen(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("Ifarmui.fxml"));
        Parent root3 = loader.load();
        Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        window.setScene(new Scene(root3, 800, 800));
        window.show();
    }
}


