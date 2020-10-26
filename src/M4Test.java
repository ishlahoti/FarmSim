import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
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


public class M4Test extends ApplicationTest {

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
        GuiTest.waitUntil("#name", Matchers.is(VisibleNodesMatcher.visible()));
        TextField name = GuiTest.find("#name");
        name.setText("Name");
        ChoiceBox<String> startingSeed = GuiTest.find("#startingSeed");
        Platform.runLater(() -> startingSeed.setValue("Grape"));
        clickOn("#submit");
    }

    @After
    public void tearDown() throws Exception {
        Game.reset();
        Farm.reset();
        FxToolkit.hideStage();
        release(new KeyCode[]{});
        release(new MouseButton[]{});
    }

    @Test
    public void checkWaterIncrease() {
        GuiTest.waitUntil("#wat0", Matchers.is(VisibleNodesMatcher.visible()));
        clickOn("#wat0");
        int actual = Integer.parseInt(((Label) GuiTest.find("#water0")).getText());
        assertEquals(11, actual);
    }

    @Test
    public void checkWaterDecrease() {
        GuiTest.waitUntil("#nextDay", Matchers.is(VisibleNodesMatcher.visible()));
        clickOn("#nextDay");
        int actual = Integer.parseInt(((Label) GuiTest.find("#water0")).getText());
        assertEquals(9, actual);
    }

    @Test
    public void checkPlantSurvivesUntilNextDay() {
        GuiTest.waitUntil("#text0", Matchers.is(VisibleNodesMatcher.visible()));
        String original = ((Label) GuiTest.find("#text0")).getText();
        for (int i = 0; i < 7; i++) {
            GuiTest.waitUntil("#wat0", Matchers.is(VisibleNodesMatcher.visible()));
            clickOn("#wat0");
        }
        String current = ((Label) GuiTest.find("#text0")).getText();
        assertEquals(original, current);
    }
    @Test
    public void checkPlantDiesAfterNextDay() {
        for (int i = 0; i < 7; i++) {
            GuiTest.waitUntil("#wat0", Matchers.is(VisibleNodesMatcher.visible()));
            clickOn("#wat0");
        }
        GuiTest.waitUntil("#nextDay", Matchers.is(VisibleNodesMatcher.visible()));
        clickOn("#nextDay");
        String actual = ((Label) GuiTest.find("#text0")).getText().substring(0, 4);
        assertEquals("Dead", actual);
    }

    @Test
    public void checkDeadPlantIsCleared() {
        for (int i = 0; i < 7; i++) {
            GuiTest.waitUntil("#wat0", Matchers.is(VisibleNodesMatcher.visible()));
            clickOn("#wat0");
        }
        GuiTest.waitUntil("#nextDay", Matchers.is(VisibleNodesMatcher.visible()));
        clickOn("#nextDay");
        GuiTest.waitUntil("#harvest", Matchers.is(VisibleNodesMatcher.visible()));
        clickOn("#harvest");
        String actual = ((Label) GuiTest.find("#text0")).getText();
        assertEquals("Empty", actual);
    }

    @Test
    public void checkPlantSeed() {
        // kill whatever is in plot 0 first so we can guarantee that it's empty before
        // planting the new grape seed
        for (int i = 0; i < 7; i++) {
            GuiTest.waitUntil("#wat0", Matchers.is(VisibleNodesMatcher.visible()));
            clickOn("#wat0");
        }
        GuiTest.waitUntil("#nextDay", Matchers.is(VisibleNodesMatcher.visible()));
        clickOn("#nextDay");
        GuiTest.waitUntil("#harvest", Matchers.is(VisibleNodesMatcher.visible()));
        clickOn("#harvest");
        GuiTest.waitUntil("#inventory", Matchers.is(VisibleNodesMatcher.visible()));
        clickOn("#inventory");
        clickOn("#inventory");
        GuiTest.waitUntil("#grapePlant", Matchers.is(VisibleNodesMatcher.visible()));
        clickOn("#grapePlant");
        clickOn("#grapePlant");
        clickOn("#goToFarm");
        GuiTest.waitUntil("#text0", Matchers.is(VisibleNodesMatcher.visible()));
        String actual = ((Label) GuiTest.find("#text0")).getText();
        assertEquals("Grape Seed", actual);
    }

    @Test
    public void checkPlantGrows() {
        // kill whatever is in plot 0 first so we can guarantee that it's empty before
        // planting the new grape seed
        for (int i = 0; i < 7; i++) {
            GuiTest.waitUntil("#wat0", Matchers.is(VisibleNodesMatcher.visible()));
            clickOn("#wat0");
        }
        // water level here is 16
        GuiTest.waitUntil("#nextDay", Matchers.is(VisibleNodesMatcher.visible()));
        clickOn("#nextDay");
        GuiTest.waitUntil("#harvest", Matchers.is(VisibleNodesMatcher.visible()));
        clickOn("#harvest");
        GuiTest.waitUntil("#harvest", Matchers.is(VisibleNodesMatcher.visible()));
        clickOn("#harvest");
        // next day twice more so water level falls to 14
        for (int i = 0; i < 2; i++) {
            GuiTest.waitUntil("#nextDay", Matchers.is(VisibleNodesMatcher.visible()));
            clickOn("#nextDay");
        }
        GuiTest.waitUntil("#inventory", Matchers.is(VisibleNodesMatcher.visible()));
        clickOn("#inventory");
        GuiTest.waitUntil("#grapePlant", Matchers.is(VisibleNodesMatcher.visible()));
        clickOn("#grapePlant");
        GuiTest.waitUntil("#goToFarm", Matchers.is(VisibleNodesMatcher.visible()));
        clickOn("#goToFarm");
        clickOn("#goToFarm");
        GuiTest.waitUntil("#nextDay", Matchers.is(VisibleNodesMatcher.visible()));
        clickOn("#nextDay");
        String actual = ((Label) GuiTest.find("#text0")).getText();
        assertEquals("Immature Grape Plant", actual);
    }
}
