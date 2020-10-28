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
    @FXML
    private Label fert0;
    @FXML
    private Label fert1;
    @FXML
    private Label fert2;
    @FXML
    private Label fert3;
    @FXML
    private Label fert4;
    @FXML
    private Label fert5;
    @FXML
    private Label fert6;
    @FXML
    private Label fert7;
    @FXML
    private Label fert8;
    @FXML
    private Label fert9;

    private Label[] plots;

    private Label[] waterPlots;

    private Label[] fertPlots;

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
        int numDead = 0;
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
                } else if (lower.contains("dragon fruit")) {
                    game.addDragCrop(1);
                } else if (lower.contains("grape")) {
                    game.addGrapeCrop(1);
                } else if (lower.contains("watermelon")) {
                    game.addWatCrop(1);
                } else if (lower.contains("pineapple")) {
                    game.addPinCrop(1);
                } else if (lower.contains("bean stalk")) {
                    game.addBeanCrop(1);
                }
            } else if (text.contains("Dead")) {
                numDead++;
                farm.editPlot(i, "Empty");
                plots[i].setText(farm.getPlots()[i]);
            }
        }


        Label label;

        if (numMature == 0 && numDead == 0) {
            label = new Label("You don't have any mature plants to harvest "
                    + "or any dead crops to clean!");
        } else if (numMature > 0 && numDead == 0) {
            label = new Label("You harvested " + numMature + " mature plant"
                    + (numMature == 1 ? "!" : "s!"));
        } else if (numMature == 0 && numDead > 0) {
            label = new Label("You cleaned " + numDead + " dead plant"
                    + (numDead == 1 ? "!" : "s!"));
        } else {
            label = new Label("You harvested " + numMature + " mature plant"
                    + (numMature == 1 ? "" : "s") + " and cleaned " + numDead
                    + " dead plant" + (numDead == 1 ? "!" : "s!"));
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
            plots[i].setText(farm.getPlots()[i]);
            waterPlots[i].setText("" + 10);
            fertPlots[i].setText("" + 0);
        }
    }

    @FXML
    private void updatePlants() {
        for (int i = 0; i < plots.length; i++) {
            String type = farm.getPlots()[i];
            plots[i].setText(type);
        }
        for (int i = 0; i < waterPlots.length; i++) {
            String type = farm.getWaterPlots()[i];
            waterPlots[i].setText(type);
        }
        for (int i = 0; i < fertPlots.length; i++) {
            String type = farm.getFertilizePlots()[i];
            fertPlots[i].setText(type);
        }
    }

    private void plotGrowthCycle() {
        String[] growthStage = new String[6];
        growthStage[0] = "Seed";
        growthStage[1] = "Sprout";
        growthStage[2] = "Immature";
        growthStage[3] = "Ripening";
        growthStage[4] = "Mature";
        growthStage[5] = "Dead";
        String[] farmPlot = farm.getPlots();

        for (int i = 0; i < farmPlot.length; i++) {
            if (farm.getWaterPlotLevel(i) > 0 && farm.getWaterPlotLevel(i) <= 15) {
                if (farmPlot[i].contains(growthStage[0])) {
                    farm.editPlot(i, this.farm.getPlantInPlot(i) + " " + growthStage[1]);
                } else if (farmPlot[i].contains(growthStage[1])) {
                    farm.editPlot(i, growthStage[2] + " " + this.farm.getPlantInPlot(i) + " Plant");
                } else if (farmPlot[i].contains(growthStage[2])) {
                    farm.editPlot(i, growthStage[3] + " " + this.farm.getPlantInPlot(i) + " Plant");
                } else if (farmPlot[i].contains(growthStage[3])) {
                    farm.editPlot(i, growthStage[4] + " " + this.farm.getPlantInPlot(i) + " Plant");
                } else if (farmPlot[i].contains(growthStage[4])) {
                    farm.editPlot(i, growthStage[4] + " " + this.farm.getPlantInPlot(i) + " Plant");
                }
                else if (farmPlot[i].contains(growthStage[5])) {
                    farm.editPlot(i, growthStage[5] + " " + this.farm.getPlantInPlot(i) + " Plant");
                }
            } else if (!farmPlot[i].contains("Empty")) {
                farm.editPlot(i, growthStage[5] + " " + this.farm.getPlantInPlot(i) + " Plant");
            }
        }
    }

    @FXML
    private void water(ActionEvent event) {
        // get plot number to edit from the number at the end of the button clicked
        String buttonText = ((Button) event.getSource()).getId();
        int buttonNum = Integer.parseInt(buttonText.substring(buttonText.length() - 1));
        // get new water level in plot after watering
        int waterLevel = Integer.parseInt(waterPlots[buttonNum].getText()) + 1;
        // update water level in the plot
        farm.editWaterPlot(buttonNum, "" + waterLevel);
        waterPlots[buttonNum].setText("" + waterLevel);
    }

    @FXML
    private void fertilize(ActionEvent event) {
        // get plot number to edit from the number at the end of the button clicked
        String buttonText = ((Button) event.getSource()).getId();
        int buttonNum = Integer.parseInt(buttonText.substring(buttonText.length() - 1));
        // get new water level in plot after watering
        int fertLevel = Integer.parseInt(fertPlots[buttonNum].getText()) + 1;
        // update water level in the plot
        farm.editFertilizePlot(buttonNum, "" + fertLevel);
        fertPlots[buttonNum].setText("" + fertLevel);
    }


    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.day.setText("Day " + this.game.getDay());
        this.name.setText(this.game.getName() + "'s Farm");
        plots = new Label[]{text0, text1, text2, text3, text4, text5, text6, text7, text8, text9};
        waterPlots = new Label[]{water0, water1, water2, water3, water4, water5, water6, water7,
                                 water8, water9};
        fertPlots = new Label[]{fert0, fert1, fert2, fert3, fert4, fert5, fert6, fert7, fert8, fert9};
        if (!alreadyExecuted) {
            this.initializePlants();
            difficultyLabel();
            alreadyExecuted = true;
        } else {
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

    @FXML
    private void nextDay(ActionEvent event) throws IOException {
        this.game.incrementDay();
        this.plotGrowthCycle();
        this.farm.evaporateWaterPlots();
        this.farm.evaporateFertilizePlots();
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("Ifarmui.fxml"));
        Parent root3 = (Parent) loader.load();
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(new Scene(root3, 800, 800));
        window.show();
    }
}


