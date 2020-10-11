
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

public class Market {

    private Hashtable plants;
    private Hashtable<String, Integer> goodsQ;
    private Hashtable<String, Integer> itemsPBuy;
    private Hashtable<String, Integer> itemsPSell;
    private int quantity;
    private Game game;
    private Items item;
    private Random rand;
    private static int basePrice = 2;
    private Set<String> key = plants.keySet();
    Iterator<String> itr = key.iterator();


    public Market() {
        itemsPBuy = new Hashtable<>();
        goodsQ = new Hashtable<>();
        itemsPSell = new Hashtable<>();

        while (itr.hasNext()) {
            String str = itr.next();
            int random = rand.nextInt(6 - 1) + 1;
            itemsPBuy.put(str, (int) ((int) basePrice + (item.getQuantity(str) * difficulty()) + random));
            goodsQ.put(str, item.getQuantity(str));
            itemsPSell.put(str, (int) ((int) basePrice + ((item.getQuantity(str) - 1) * difficulty() + random)));
        }
    }

    public int getPBuy(String plant) {
        return itemsPBuy.get(plant);
    }

    public int getQuantity(String plant) {
        return goodsQ.get(plant);
    }

    public int getPSell(String plant) {
        return itemsPSell.get(plant);
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

