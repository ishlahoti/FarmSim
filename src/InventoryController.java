import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class InventoryController implements Initializable {

    @FXML
    Label error;
    @FXML
    Label raspberrySeedQuantity;
    @FXML
    Label strawberrySeedQuantity;
    @FXML
    Label passionFruitSeedQuantity;
    @FXML
    Label grapeSeedQuantity;
    @FXML
    Label strawberryCropQ;
    @FXML
    Label raspberryCropQ;
    @FXML
    Label passionFruitCropQ;
    @FXML
    Label grapeCropQ;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Game game = Game.factory();
        raspberrySeedQuantity.setText("" + game.getRaspberrySeedQuantity());
        strawberrySeedQuantity.setText("" + game.getStrawberrySeedQuantity());
        passionFruitSeedQuantity.setText("" + game.getPassionFruitSeedQuantity());
        grapeSeedQuantity.setText("" + game.getGrapeSeedQuantity());
        strawberryCropQ.setText("" + game.getStrawberryCropQ());
        raspberryCropQ.setText("" + game.getRaspberryCropQ());
        passionFruitCropQ.setText("" + game.getPassionFruitCropQ());
        grapeCropQ.setText("" + game.getGrapeFruitCropQ());
    }
    @FXML
    private void changeScreen(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("Ifarmui.fxml"));
        Parent root3 = (Parent) loader.load();
        Main.getPrimaryStage().setScene(new Scene(root3, 800, 800));
        Main.getPrimaryStage().show();
    }
}
