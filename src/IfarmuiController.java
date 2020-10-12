import java.net.URL;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;


public class IfarmuiController implements Initializable {
    @FXML
    private Label day;
    @FXML
    private Label money;
    @FXML
    private Label name;
    @FXML
    private GridPane grid;
    @FXML
    private StackPane plot1;
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


//        String[] plantTypes = new String[3];
//        plantTypes[0] = "seedImage";
//        plantTypes[1] = "immaturePlantImage";
//        plantTypes[2] = "maturePlantImage";
//
//        for (StackPane plot : plots.getChildren()) {
//            plot.setStyle(plantTypes[(new Random()).nextInt(plantTypes.length)]);
//        }
    }

    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.day.setText("Day " + this.game.getDay());
        this.name.setText(this.game.getName() + "'s Farm");
        this.difficultyLabel();
        this.initializePlants();
    }
}


