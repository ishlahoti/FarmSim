import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.net.URL;
import java.util.ResourceBundle;

public class InventoryController implements Initializable {
    @FXML
    GridPane gridPane = new GridPane();
    @FXML
    Label error;

    String[][] inventory = new String[3][4]; //max 12 items in inventory for now

    public void addItem(String s) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++)
            if (inventory[i][j] == null) {
                inventory[i][j] = s;
                Label item = new Label(inventory[i][j]);
                item.setFont(new Font("Verdana", 15));
                item.setTextFill(Color.web("#0076a3"));
                gridPane.add(item, i, j, 1, 1);
                return;
            }
        }
        error.setText("Your inventory is full-you cannot add more items");
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        addItem("Strawberry");
        addItem("Raspberry");
        addItem("Passion Fruit");
        addItem("Grape");

    }
}
