// import javafx.application.Application;
//import javafx.fxml.FXML;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
//import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.stage.Stage;
import java.io.IOException;

//import javafx.scene.control.Button;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.loadui.testfx.GuiTest;
//import org.testfx.api.FxAssert;
import org.testfx.api.FxToolkit;
import org.testfx.framework.junit.ApplicationTest;
import org.hamcrest.Matchers;
import org.loadui.testfx.controls.impl.VisibleNodesMatcher;
//import org.testfx.matcher.base.WindowMatchers;

import static org.junit.Assert.*;



public class MainTest extends ApplicationTest {

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
    public void testBlankName() {
        TextField name = (TextField) GuiTest.find("#name");

        name.setText("");
        clickOn("#submit");

        Label error = (Label) GuiTest.find("#error");
        assertEquals("Please enter a name", error.getText());
    }

    @Test
    public void testName() {
        TextField name = (TextField) GuiTest.find("#name");

        name.setText("Test Name");
        clickOn("#submit");

        assertEquals("Test Name", name.getText());
    }

    @Test
    public void testSpaceName() {
        TextField name = (TextField) GuiTest.find("#name");
        name.setText(" ");
        clickOn("#submit");
        Label error = (Label) GuiTest.find("#error");
        assertEquals("Please enter a name", error.getText());
    }

    @Test
    public void testNameTrimStart() {
        TextField name = (TextField) GuiTest.find("#name");
        name.setText(" space before name");
        clickOn("#submit");
        GuiTest.waitUntil("#name", Matchers.is(VisibleNodesMatcher.visible()));
        Label newName = (Label) GuiTest.find("#name");
        assertEquals("space before name's Farm", newName.getText());
    }

    @Test
    public void testNameTrimEnd() {
        TextField name = (TextField) GuiTest.find("#name");
        name.setText("space after name ");
        clickOn("#submit");
        GuiTest.waitUntil("#name", Matchers.is(VisibleNodesMatcher.visible()));
        Label newName = (Label) GuiTest.find("#name");
        assertEquals("space after name's Farm", newName.getText());
    }

    @Test
    public void testDefaultDifficulty() {
        ChoiceBox<String> difficulty = GuiTest.find("#difficulty");
        Platform.runLater(() -> difficulty.setValue("Easy"));
        clickOn("#submit");
        GuiTest.waitUntil("#difficulty", Matchers.is(VisibleNodesMatcher.visible()));
        ChoiceBox<String> newDiff = GuiTest.find("#difficulty");
        assertEquals("Easy", newDiff.getValue());
    }

    @Test
    public void testDefaultStartingSeed() {
        ChoiceBox<String> startingSeed = GuiTest.find("#startingSeed");
        startingSeed.setValue("Strawberry");
        clickOn("#submit");
        GuiTest.waitUntil("#startingSeed", Matchers.is(VisibleNodesMatcher.visible()));
        ChoiceBox<String> newStartingSeed = GuiTest.find("#startingSeed");
        assertEquals("Strawberry", newStartingSeed.getValue());
    }

    @Test
    public void testDefaultStartingSeasonSpring() {
        ChoiceBox<String> startingSeason = GuiTest.find("#startingSeason");

        startingSeason.setValue("Spring");
        clickOn("#submit");

        GuiTest.waitUntil("#startingSeason", Matchers.is(VisibleNodesMatcher.visible()));
        ChoiceBox<String> newStartingSeed = GuiTest.find("#startingSeason");
        assertEquals("Spring", newStartingSeed.getValue());
    }

    @Test
    public void alternateDifficulty() {
        ChoiceBox<String> difficulty = GuiTest.find("#difficulty");
        Platform.runLater(() -> difficulty.setValue("Medium"));
        clickOn("#submit");
        GuiTest.waitUntil("#difficulty", Matchers.is(VisibleNodesMatcher.visible()));
        ChoiceBox<String> newDiff = GuiTest.find("#difficulty");
        assertEquals("Medium", newDiff.getValue());
    }

    @Test
    public void alternateStartingSeed() {
        ChoiceBox<String> startingSeed = GuiTest.find("#startingSeed");
        Platform.runLater(() -> startingSeed.setValue("Grape"));
        clickOn("#submit");
        GuiTest.waitUntil("#startingSeed", Matchers.is(VisibleNodesMatcher.visible()));
        ChoiceBox<String> newStartingSeed = GuiTest.find("#startingSeed");
        assertEquals("Grape", newStartingSeed.getValue());
    }

}
