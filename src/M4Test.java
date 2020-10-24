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
    }

    @After
    public void tearDown() throws Exception {
        FxToolkit.hideStage();
        release(new KeyCode[]{});
        release(new MouseButton[]{});
    }

    @Test
    public void checkWaterIncrease() {
        Farm farm = Farm.factory();
        TextField name = (TextField) GuiTest.find("#name");
        name.setText("Name");
        ChoiceBox<String> startingSeed = GuiTest.find("#startingSeed");
        Platform.runLater(() -> startingSeed.setValue("Grape"));
        clickOn("#submit");
        GuiTest.waitUntil("#wat0", Matchers.is(VisibleNodesMatcher.visible()));
        clickOn("#wat0");
        int actual = farm.getWaterPlotLevel(0);
        assertEquals(11, actual);
        farm.editWaterPlot(0, "10");
    }

    @Test
    public void checkWaterDecrease() {
        Farm farm = Farm.factory();
        TextField name = (TextField) GuiTest.find("#name");
        name.setText("Name");
        ChoiceBox<String> startingSeed = GuiTest.find("#startingSeed");
        Platform.runLater(() -> startingSeed.setValue("Grape"));
        clickOn("#submit");
        GuiTest.waitUntil("#nextDay", Matchers.is(VisibleNodesMatcher.visible()));
        clickOn("#nextDay");
        int actual = farm.getWaterPlotLevel(0);
        assertEquals(9, actual);
        farm.editWaterPlot(0, "10");
    }

    @Test
    public void checkPlantSurvivesUntilNextDay() {
        Farm farm = Farm.factory();
        TextField name = (TextField) GuiTest.find("#name");
        name.setText("Name");
        ChoiceBox<String> startingSeed = GuiTest.find("#startingSeed");
        Platform.runLater(() -> startingSeed.setValue("Grape"));
        clickOn("#submit");
        String original = farm.getPlots()[0];
        for (int i = 0; i < 7; i++) {
            GuiTest.waitUntil("#wat0", Matchers.is(VisibleNodesMatcher.visible()));
            clickOn("#wat0");
        }
        String current = farm.getPlots()[0];
        assertEquals(original, current);
        farm.editWaterPlot(0, "10");
    }
    @Test
    public void checkPlantDiesAfterNextDay() {
        Farm farm = Farm.factory();
        TextField name = (TextField) GuiTest.find("#name");
        name.setText("Name");
        ChoiceBox<String> startingSeed = GuiTest.find("#startingSeed");
        Platform.runLater(() -> startingSeed.setValue("Grape"));
        clickOn("#submit");
        for (int i = 0; i < 7; i++) {
            GuiTest.waitUntil("#wat0", Matchers.is(VisibleNodesMatcher.visible()));
            clickOn("#wat0");
        }
        GuiTest.waitUntil("#nextDay", Matchers.is(VisibleNodesMatcher.visible()));
        clickOn("#nextDay");
        String actual = farm.getPlots()[0].substring(0, 4);
        assertEquals("Dead", actual);
        farm.editWaterPlot(0, "10");
    }

    @Test
    public void checkDeadPlantIsCleared() {
        Farm farm = Farm.factory();
        TextField name = (TextField) GuiTest.find("#name");
        name.setText("Name");
        ChoiceBox<String> startingSeed = GuiTest.find("#startingSeed");
        Platform.runLater(() -> startingSeed.setValue("Grape"));
        clickOn("#submit");
        for (int i = 0; i < 7; i++) {
            GuiTest.waitUntil("#wat0", Matchers.is(VisibleNodesMatcher.visible()));
            clickOn("#wat0");
        }
        GuiTest.waitUntil("#nextDay", Matchers.is(VisibleNodesMatcher.visible()));
        clickOn("#nextDay");
        GuiTest.waitUntil("#harvest", Matchers.is(VisibleNodesMatcher.visible()));
        clickOn("#harvest");
        String actual = farm.getPlots()[0];
        assertEquals("Empty", actual);
        farm.editWaterPlot(0, "10");
    }

    @Test
    public void checkPlantSeed() {
        Farm farm = Farm.factory();
        TextField name = (TextField) GuiTest.find("#name");
        name.setText("Name");
        ChoiceBox<String> startingSeed = GuiTest.find("#startingSeed");
        Platform.runLater(() -> startingSeed.setValue("Grape"));
        // kill whatever is in plot 0 first so we can guarantee that it's empty before
        // planting the new grape seed
        clickOn("#submit");
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
        assertEquals("Grape Seed", farm.getPlots()[0]);
        farm.editWaterPlot(0, "10");
    }

    @Test
    public void checkPlantGrows() {
        Farm farm = Farm.factory();
        TextField name = (TextField) GuiTest.find("#name");
        name.setText("Name");
        ChoiceBox<String> startingSeed = GuiTest.find("#startingSeed");
        Platform.runLater(() -> startingSeed.setValue("Grape"));
        // kill whatever is in plot 0 first so we can guarantee that it's empty before
        // planting the new grape seed
        clickOn("#submit");
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
        assertEquals("Immature Grape Plant", farm.getPlots()[0]);
        farm.editWaterPlot(0, "10");
    }
}
