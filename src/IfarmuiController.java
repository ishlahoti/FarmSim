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
        for (Node plotNode : grid.getChildren()) {
            Label plot = (Label) plotNode;

            if (plot.getText().contains("Mature"))
                maturePlants.add(plot);
        }

        for (Label maturePlant : maturePlants) {
            maturePlant.setText("Empty Plot");
        }


        Label label;

        if (maturePlants.isEmpty())
            label = new Label("You don't have any mature plants to harvest!");
        else
            label = new Label("You harvested " + maturePlants.size() + " mature plants");

        // create a popup
        Popup popup = new Popup();

        // set background
        label.setStyle(" -fx-background-color: gray;");

        // add the label
        popup.getContent().add(label);

        // set size of label
        label.setMinWidth(80);
        label.setMinHeight(50);

        popup.show(Main.getPrimaryStage());
    }

    /*
    @FXML
    private static void initializePlants(){
        StackPane plot0 = new StackPane(), plot1 = new StackPane(), plot2 = new StackPane(), plot3 = new StackPane();
        StackPane plot4 = new StackPane(), plot5 = new StackPane(), plot6 = new StackPane(), plot7 = new StackPane();
        StackPane plot8 = new StackPane(), plot9 = new StackPane();

        System.out.println(plot0 == null);
        System.out.println("Style: " + plot0.getStyle());
        System.out.println("Style Class: " + plot0.getStyleClass());

        System.out.println(plot0.getChildren());
        plot0.getChildren().add(new Label("text"));
        plot0.getChildren().add(new ImageView("https://www.jing.fm/clipimg/full/20-200139_28-collection-of-apple-seed-clipart-cars-jeans.png"));
        System.out.println(plot0.getChildren());
        plot0.getChildren().get(1).setVisible(true);


//        String[] plantTypes = new String[3];
//        plantTypes[0] = "seedImage";
//        plantTypes[1] = "immaturePlantImage";
//        plantTypes[2] = "maturePlantImage";
//
//        for (StackPane plot : plots.getChildren()) {
//            plot.setStyle(plantTypes[(new Random()).nextInt(plantTypes.length)]);
//        }
    }
     */

    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.day.setText("Day " + this.game.getDay());
        this.name.setText(this.game.getName() + "'s Farm");

        this.text0.setText(this.game.getSeed() + " Seed");
        this.text1.setText("Mature " + this.game.getSeed() + " Plant");
        this.text2.setText("Immature " + this.game.getSeed() + " Plant");
        this.text3.setText("Immature " + this.game.getSeed() + " Plant");
        this.text4.setText(this.game.getSeed() + " Seed");

        this.text5.setText("Mature " + this.game.getSeed() + " Plant");
        this.text6.setText("Immature " + this.game.getSeed() + " Plant");
        this.text7.setText(this.game.getSeed() + " Seed");
        this.text8.setText(this.game.getSeed() + " Seed");
        this.text9.setText("Mature " + this.game.getSeed() + " Plant");

        this.difficultyLabel();
//        this.initializePlants();
    }
}


