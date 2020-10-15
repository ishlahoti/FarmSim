import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.stage.Stage;
import org.hamcrest.Matchers;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.loadui.testfx.GuiTest;
import org.loadui.testfx.controls.impl.VisibleNodesMatcher;
import org.testfx.api.FxToolkit;
import org.testfx.framework.junit.ApplicationTest;

import java.io.IOException;

import static org.junit.Assert.assertEquals;


public class M3Test extends ApplicationTest {

    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("WelcomeScreen.fxml"));
        //primaryStage.setTitle("Farm Simulation");
        Scene scene = new Scene(root, 800, 800);
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @Before
    public void setUp() throws Exception {
        clickOn("#start");
        GuiTest.waitUntil("#submit", Matchers.is(VisibleNodesMatcher.visible()));
    }

    @After
    public void tearDown() throws Exception {
        FxToolkit.hideStage();
        release(new KeyCode[]{});
        release(new MouseButton[]{});
    }

    @Test
    public void checkInitialInventory() {
        Game game = Game.factory();
        TextField name = (TextField) GuiTest.find("#name");
        name.setText("Name");
        ChoiceBox<String> startingSeed = GuiTest.find("#startingSeed");
        Platform.runLater(() -> startingSeed.setValue("Grape"));
        clickOn("#submit");
        GuiTest.waitUntil("#inventory", Matchers.is(VisibleNodesMatcher.visible()));
        clickOn("#inventory");
        GuiTest.waitUntil("#grapeSeedQuantity", Matchers.is(VisibleNodesMatcher.visible()));
        int grapeQuantity = game.getGrapeSeedQuantity();
        int grapeExpected = game.getStartingSeedQuantity();
        int passionFruitQuantity = game.getPassionFruitSeedQuantity();
        assertEquals(grapeExpected, grapeQuantity);
        assertEquals(0, passionFruitQuantity);
    }

    @Test
    public void checkMoneyBuy() {
        Game game = Game.factory();
        TextField name = (TextField) GuiTest.find("#name");
        name.setText("Name");
        clickOn("#submit");
        GuiTest.waitUntil("#market", Matchers.is(VisibleNodesMatcher.visible()));
        clickOn("#market");
        GuiTest.waitUntil("#watermelonBuy", Matchers.is(VisibleNodesMatcher.visible()));
        clickOn("#watermelonBuy");
        double money = game.getMoney();
        assertEquals(56, money, 0);
        clickOn("#watermelonSell");
    }

    @Test
    public void checkMoneySell() {
        Game game = Game.factory();
        TextField name = (TextField) GuiTest.find("#name");
        name.setText("Name");
        clickOn("#submit");
        GuiTest.waitUntil("#market", Matchers.is(VisibleNodesMatcher.visible()));
        clickOn("#market");
        GuiTest.waitUntil("#strawberrySSell", Matchers.is(VisibleNodesMatcher.visible()));
        clickOn("#strawberrySSell");
        double money = game.getMoney();
        assertEquals(64, money, 0);
        clickOn("#strawberrySBuy");
    }

    @Test
    public void checkInventoryBuy() {
        Game game = Game.factory();
        TextField name = (TextField) GuiTest.find("#name");
        name.setText("Name");
        clickOn("#submit");
        GuiTest.waitUntil("#market", Matchers.is(VisibleNodesMatcher.visible()));
        clickOn("#market");
        GuiTest.waitUntil("#watermelonBuy", Matchers.is(VisibleNodesMatcher.visible()));
        clickOn("#watermelonBuy");
        int quantity = game.getWatSeedQ();
        assertEquals(1, quantity);
        clickOn("#watermelonSell");
    }
    @Test
    public void checkInventorySell() {
        Game game = Game.factory();
        TextField name = (TextField) GuiTest.find("#name");
        name.setText("Name");
        clickOn("#submit");
        GuiTest.waitUntil("#market", Matchers.is(VisibleNodesMatcher.visible()));
        clickOn("#market");
        GuiTest.waitUntil("#strawberrySSell", Matchers.is(VisibleNodesMatcher.visible()));
        clickOn("#strawberrySSell");
        int quantity = game.getStrawberrySeedQuantity();
        int expected = game.getStartingSeedQuantity() - 1;
        assertEquals(expected, quantity);
        clickOn("#strawberrySBuy");
    }
}
