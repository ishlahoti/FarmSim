import java.io.IOException;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.TextAlignment;
import javafx.stage.Popup;
import sun.awt.image.ImageWatched;


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

    private Game game = Game.factory();

    public IfarmuiController() {
    }

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
        this.money.setText("Money: $" + mon);


    }

    @FXML
    private void harvest(ActionEvent event) throws IOException {
        List<Label> maturePlants = new LinkedList<>();
        for (Label plot : plots) {
//            Label plot = (Label) plotNode;

            if (plot.getText().contains("Mature"))
                maturePlants.add(plot);
        }

        for (Label maturePlant : maturePlants) {
            maturePlant.setText("Empty Plot");
            // add to inventory
        }


        Label label;

        int numMature = maturePlants.size();
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
        this.difficultyLabel();

        plots =  new Label[] {text0,text1,text2,text3,text4,text5,text6,text7,text8,text9};
        this.initializePlants();
    }
}


