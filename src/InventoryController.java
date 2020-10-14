import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

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
    @FXML
    Label pinCropQ;
    @FXML
    Label pinSeedQ;
    @FXML
    Label beanCropQ;
    @FXML
    Label beanSeedQ;
    @FXML
    Label dragCropQ;
    @FXML
    Label dragSeedQ;
    @FXML
    Label watCropQ;
    @FXML
    Label watSeedQ;
    @FXML
    Button farm;
    @FXML
    Button market;



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
        watCropQ.setText("" + game.getWatCropQ());
        watSeedQ.setText("" + game.getWatSeedQ());
        dragCropQ.setText("" + game.getDragCropQ());
        dragSeedQ.setText("" + game.getDragSeedQ());
        beanCropQ.setText("" + game.getBeanCropQ());
        beanSeedQ.setText("" + game.getBeanSeedQ());
        pinCropQ.setText("" + game.getPinCropQ());
        pinSeedQ.setText("" + game.getPinSeedQ());
    }
    @FXML
    private void changeScreen(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("Ifarmui.fxml"));
        Parent root3 = (Parent) loader.load();
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(new Scene(root3, 800, 800));
        window.show();
    }

    @FXML
    private void changeScreentoMarket(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("Market.fxml"));
        Parent root3 = (Parent) loader.load();
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(new Scene(root3, 800, 800));
        window.show();
    }
}
