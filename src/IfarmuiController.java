import java.io.IOException;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.stage.Popup;


public class IfarmuiController implements Initializable {
    @FXML
    private Label day;
    @FXML
    private Label money;
    @FXML
    private Label name;
    @FXML
    private Label text0, text1, text2, text3, text4, text5, text6, text7, text8, text9;
    private Label[] plots;

    @FXML
    private GridPane grid;

    @FXML
    private Button inventory;
    private Game game = Game.factory();
    private static boolean alreadyExecuted;

    @FXML
    private void difficultyLabel() {
            String difficulty = this.game.getDifficulty();
            int mon = 0;
            switch (difficulty) {
                case "Easy":
                    mon = 60;
                    break;
                case "Medium":
                    mon = 40;
                    break;
                case "Hard":
                    mon = 20;
                    break;
                default:
                    break;
            }
            this.game.setMoney(mon);
    }

    @FXML
    private void harvest(ActionEvent event) throws IOException {
        int numMature = 0;
        for (Label plot : plots) {
            String text = plot.getText();
            if (text.contains("Mature")) {
                numMature++;
                plot.setText("Empty Plot");

                String lower = text.toLowerCase();
                if (lower.contains("strawberry"))
                    game.addStrawberryCrop(1);
                else if (lower.contains("raspberry"))
                    game.addRaspberryCrop(1);
                else if (lower.contains("passion fruit"))
                    game.addPassionFruitCrop(1);
                else if (lower.contains("grape"))
                    game.addGrapeCrop(1);
            }
        }


        Label label;

        if (numMature == 0) {
            label = new Label("You don't have any mature plants to harvest!");
        } else {
            label = new Label("You harvested " + numMature + " mature plant" + (numMature == 1 ? "!" : "s!"));
        }

        Popup popup = new Popup();
        label.setStyle(" -fx-background-color: lightgray;");
        popup.getContent().add(label);
        label.setMinWidth(250);
        label.setMinHeight(50);
        label.setAlignment(Pos.CENTER);
        popup.show(Main.getPrimaryStage());
        popup.setAutoHide(true);
    }


    @FXML
    private void initializePlants(){
        String[] plantTypes = new String[3];
        plantTypes[0] = "seed";
        plantTypes[1] = "immature";
        plantTypes[2] = "mature";

        for (Label plot : plots) {
            String type = plantTypes[(new Random()).nextInt(plantTypes.length)];

            switch (type) {
                case "seed":
                    plot.setText(this.game.getSeed() + " Seed");
                    break;
                case "immature":
                    plot.setText("Immature " + this.game.getSeed() + " Plant");
                    break;
                case "mature":
                    plot.setText("Mature " + this.game.getSeed() + " Plant");
                    break;
                default:
                    break;
            }
        }
    }


    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.day.setText("Day " + this.game.getDay());
        this.name.setText(this.game.getName() + "'s Farm");
        if (!alreadyExecuted) {
            difficultyLabel();
            alreadyExecuted = true;
        }
        this.money.setText("Money $" + this.game.getMoney());

//        grid.setStyle("-fx-background-color: #000000; --fx-border-color: #c4c4c4;");
        plots =  new Label[] {text0,text1,text2,text3,text4,text5,text6,text7,text8,text9};
        this.initializePlants();
    }

    @FXML
    private void changeScreen(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("Inventory.fxml"));
        Parent root3 = (Parent) loader.load();
        Main.getPrimaryStage().setScene(new Scene(root3, 800, 800));
        Main.getPrimaryStage().show();
    }

    @FXML
    private void changeScreentoMarket(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("Market.fxml"));
        Parent root3 = (Parent) loader.load();
        Main.getPrimaryStage().setScene(new Scene(root3, 800, 800));
        Main.getPrimaryStage().show();
    }
}


