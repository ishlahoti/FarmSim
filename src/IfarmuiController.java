import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

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
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.TextAlignment;
import javafx.stage.Popup;
import javafx.stage.Stage;


public class IfarmuiController implements Initializable {
    @FXML
    private Label day;
    @FXML
    private Label money;
    @FXML
    private Label name;
    @FXML
    private Label text0;
    @FXML
    private Label text1;
    @FXML
    private Label text2;
    @FXML
    private Label text3;
    @FXML
    private Label text4;
    @FXML
    private Label text5;
    @FXML
    private Label text6;
    @FXML
    private Label text7;
    @FXML
    private Label text8;
    @FXML
    private Label text9;
    @FXML
    private Label water0;
    @FXML
    private Label water1;
    @FXML
    private Label water2;
    @FXML
    private Label water3;
    @FXML
    private Label water4;
    @FXML
    private Label water5;
    @FXML
    private Label water6;
    @FXML
    private Label water7;
    @FXML
    private Label water8;
    @FXML
    private Label water9;

    private Label[] plots;

    private Label[] waterPlots;

    @FXML
    private GridPane grid;

    @FXML
    private Button inventory;
    @FXML
    private Button market;
    private Game game = Game.factory();
    private Farm farm = Farm.factory();
    private static boolean alreadyExecuted = false;

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
        for (int i = 0; i < plots.length; i++) {
            String text = plots[i].getText();
            if (text.contains("Mature")) {
                numMature++;
                farm.editPlot(i, "Empty");
                plots[i].setText(farm.getPlots()[i]);

                String lower = text.toLowerCase();
                if (lower.contains("strawberry")) {
                    game.addStrawberryCrop(1);
                } else if (lower.contains("raspberry")) {
                    game.addRaspberryCrop(1);
                } else if (lower.contains("passion fruit")) {
                    game.addPassionFruitCrop(1);
                } else if (lower.contains("grape")) {
                    game.addGrapeCrop(1);
                }
            }
        }


        Label label;

        if (numMature == 0) {
            label = new Label("You don't have any mature plants to harvest!");
        } else {
            label = new Label("You harvested " + numMature + " mature plant"
                    + (numMature == 1 ? "!" : "s!"));
        }
        label.setText(label.getText() + "\nClick out of this box to exit");

        Popup popup = new Popup();
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
    private void initializePlants() {
        for (int i = 0; i < plots.length; i++) {
            String type = farm.getPlots()[i];
            switch (type) {
            case "seed":
                plots[i].setText(this.game.getSeed() + " Seed");
                break;
            case "immature":
                plots[i].setText("Immature " + this.game.getSeed() + " Plant");
                break;
            case "mature":
                plots[i].setText("Mature " + this.game.getSeed() + " Plant");
                break;
            default:
                plots[i].setText("Empty");
                break;
            }
            waterPlots[i].setText("" + 10);
            farm.editPlot(i, plots[i].getText());
        }
    }

    @FXML
    private void updatePlants() {
        for (int i = 0; i < plots.length; i++) {
            String type = farm.getPlots()[i];
            plots[i].setText(type);
        }
    }

    @FXML
    private void water(ActionEvent event) {
        Label label = new Label();
        Popup popup = new Popup();
        label.setStyle(" -fx-background-color: black;");
        label.setTextFill(Color.WHITE);
        popup.getContent().add(label);
        label.setAlignment(Pos.TOP_CENTER);
        label.setTextAlignment(TextAlignment.CENTER);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        popup.setAutoHide(true);
        switch (((Button) event.getSource()).getId()) {
            case "wat0" :
                if ((Integer.parseInt(water0.getText())) + 1 > 15) {
                    plots[0].setText("Dead");
                    farm.editPlot(0, plots[0].getText());
                    label.setText("You over-watered your plant and it died!");
                    popup.show(window);
                }
                else {
                    int curval = Integer.parseInt(water0.getText()) + 1;
                    waterPlots[0].setText("" + curval);
                }
                break;
            case "wat1" :
                if ((Integer.parseInt(water1.getText())) + 1 > 15) {
                    plots[1].setText("Dead");
                    farm.editPlot(1, plots[1].getText());
                    label.setText("You over-watered your plant and it died!");
                    popup.show(window);
                }
                else {
                    int curval = Integer.parseInt(water1.getText()) + 1;
                    waterPlots[1].setText("" + curval);
                }
                break;
            case "wat2" :
                if ((Integer.parseInt(water2.getText())) + 1 > 15) {
                    plots[2].setText("Dead");
                    farm.editPlot(2, plots[2].getText());
                    label.setText("You over-watered your plant and it died!");
                    popup.show(window);
                }
                else {
                    int curval = Integer.parseInt(water2.getText()) + 1;
                    waterPlots[2].setText("" + curval);
                }
                break;
            case "wat3" :
                if ((Integer.parseInt(water3.getText())) + 1 > 15) {
                    plots[3].setText("Dead");
                    farm.editPlot(3, plots[3].getText());
                    label.setText("You over-watered your plant and it died!");
                    popup.show(window);
                }
                else {
                    int curval = Integer.parseInt(water3.getText()) + 1;
                    waterPlots[3].setText("" + curval);
                }
                break;
            case "wat4" :
                if ((Integer.parseInt(water4.getText())) + 1 > 15) {
                    plots[4].setText("Dead");
                    farm.editPlot(4, plots[4].getText());
                    label.setText("You over-watered your plant and it died!");
                    popup.show(window);
                }
                else {
                    int curval = Integer.parseInt(water4.getText()) + 1;
                    waterPlots[4].setText("" + curval);
                }
                break;
            case "wat5" :
                if ((Integer.parseInt(water5.getText())) + 1 > 15) {
                    plots[5].setText("Dead");
                    farm.editPlot(5, plots[5].getText());
                    label.setText("You over-watered your plant and it died!");
                    popup.show(window);
                }
                else {
                    int curval = Integer.parseInt(water5.getText()) + 1;
                    waterPlots[5].setText("" + curval);
                }
                break;
            case "wat6" :
                if ((Integer.parseInt(water6.getText())) + 1 > 15) {
                    plots[6].setText("Dead");
                    farm.editPlot(6, plots[6].getText());
                    label.setText("You over-watered your plant and it died!");
                    popup.show(window);
                }
                else {
                    int curval = Integer.parseInt(water6.getText()) + 1;
                    waterPlots[6].setText("" + curval);
                }
                break;
            case "wat7" :
                if ((Integer.parseInt(water7.getText())) + 1 > 15) {
                    plots[7].setText("Dead");
                    farm.editPlot(7, plots[7].getText());
                    label.setText("You over-watered your plant and it died!");
                    popup.show(window);
                }
                else {
                    int curval = Integer.parseInt(water7.getText()) + 1;
                    waterPlots[7].setText("" + curval);
                }
                break;
            case "wat8" :
                if ((Integer.parseInt(water8.getText())) + 1 > 15) {
                    plots[8].setText("Dead");
                    farm.editPlot(8, plots[8].getText());
                    label.setText("You over-watered your plant and it died!");
                    popup.show(window);
                }
                else {
                    int curval = Integer.parseInt(water8.getText()) + 1;
                    waterPlots[8].setText("" + curval);
                }
                break;
            case "wat9" :
                if ((Integer.parseInt(water9.getText())) + 1 > 15) {
                    plots[9].setText("Dead");
                    farm.editPlot(9, plots[9].getText());
                    label.setText("You over-watered your plant and it died!");
                    popup.show(window);
                }
                else {
                    int curval = Integer.parseInt(water9.getText()) + 1;
                    waterPlots[9].setText("" + curval);
                }
                break;
        }
    }


    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.day.setText("Day " + this.game.getDay());
        this.name.setText(this.game.getName() + "'s Farm");
        plots = new Label[]{text0, text1, text2, text3, text4, text5, text6, text7, text8, text9};
        waterPlots = new Label[]{water0, water1, water2, water3, water4, water5, water6, water7, water8, water9};
        if (!alreadyExecuted) {
            this.initializePlants();
            difficultyLabel();
            alreadyExecuted = true;
        }
        else {
            this.updatePlants();
        }
        this.money.setText(String.format("Money $%10.2f", this.game.getMoney()));
    }

    @FXML
    private void changeScreen(ActionEvent event) throws IOException {
        FXMLLoader loader
                = new FXMLLoader(getClass().getClassLoader().getResource("Inventory.fxml"));
        Parent root3 = (Parent) loader.load();
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(new Scene(root3, 800, 800));
        window.show();
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


