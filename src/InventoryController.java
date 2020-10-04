import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.net.URL;
import java.util.ResourceBundle;

public class InventoryController implements Initializable {
    @FXML
    GridPane gridPane = new GridPane();
    @FXML
    Label error;

    Item[][] inventory = new Item[3][4]; //max 12 items in inventory for now. array version of inventory for list

    public void addItem(String s) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                if (inventory[i][j] == null) {
                    Item item = new Item(s, 1);
                    inventory[i][j] = item;
                    Label item1 = new Label(item.getInfo());
                    item1.setFont(new Font("Verdana", 15));
                    item1.setTextFill(Color.web("#0076a3"));
                    gridPane.add(item1, i, j, 1, 1);
                    return;
                }
            }
            error.setText("Your inventory is full-you cannot add more items");
        }
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        addItem("Strawberry Seed");
        addItem("Raspberry Seed");
        addItem("Passion Fruit Seed");
        addItem("Grape Seed");

    }
}
