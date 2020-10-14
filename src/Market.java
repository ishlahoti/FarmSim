import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Hashtable;
import java.util.Random;

public class Market {

    private Hashtable<Items, Integer> itemsPBuy;
    private Hashtable<Items, Integer> itemsPSell;
    private Game game;
    private Random rand;


    public Market() {
        game = Game.factory();
        itemsPBuy = new Hashtable<>();
        itemsPSell = new Hashtable<>();

        for (Items i: Items.values()) {
            //rand = new Random();
            //int random = rand.nextInt(6 - 1) + 1;
            itemsPBuy.put(i, (int) (i.getBasePrice() + (seasonPrice() * difficulty())));
            itemsPSell.put(i, (int) (i.getBasePrice() + (seasonPrice() - 1) * difficulty()));
        }
    }

    public int getPBuy(Items item) {
        return itemsPBuy.getOrDefault(item,0);
    }

    public int getPSell(Items item) {
        return itemsPSell.getOrDefault(item, 0);
    }

    private int seasonPrice() {
        if (game.getSeason().equals("Winter")) {
            return 4;
        } else if (game.getSeason().equals("Summer")){
            return 2;
        } else if (game.getSeason().equals("Fall")) {
            return 3;
        } else {
            return 1;
        }
    }

    private double difficulty() {
        if (game.getDifficulty().equals("Hard")) {
            return 0.1;
        } else if (game.getDifficulty().equals("Medium")) {
            return 0.3;
        } else {
            return 0.6;
        }
    }

    public void open(ActionEvent event, Game game) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("Market.fxml"));
        Parent tableViewParent = fxmlLoader.load();
        Scene tableViewScene = new Scene(tableViewParent);

        MarketController mpsc = fxmlLoader.getController();
        mpsc.initData(this, game);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        Stage newWindow = new Stage();

        newWindow.initOwner(window);
        newWindow.initModality(Modality.APPLICATION_MODAL);
        newWindow.setScene(tableViewScene);
        newWindow.sizeToScene();
        newWindow.showAndWait();
    }
}

