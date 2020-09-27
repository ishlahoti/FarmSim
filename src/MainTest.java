import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.stage.Stage;
import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.loadui.testfx.GuiTest;
import org.testfx.api.FxToolkit;
import org.testfx.framework.junit.ApplicationTest;
import org.hamcrest.Matchers;
import org.loadui.testfx.controls.impl.VisibleNodesMatcher;

import static org.junit.Assert.*;



public class MainTest extends ApplicationTest {
    static Stage primaryStage;

    @Override
    public void start(Stage primaryStage) throws IOException {
        this.primaryStage = primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("Config.fxml"));
//        primaryStage.setTitle("Farm Simulation"); //feel free to replace w/ something more creative
        Scene scene = new Scene(root, 800, 800);
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @Before
    public void setUp() throws Exception {
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
        System.out.println(name);

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
    public void testNameTrim() {
        TextField name = (TextField) GuiTest.find("#name");
        name.setText(" space before name");
        clickOn("#submit");
        GuiTest.waitUntil("#name", Matchers.is(VisibleNodesMatcher.visible()));
        TextField newName = (TextField) GuiTest.find("#name");
        assertEquals(" space before name", newName.getText());
    }

    @Test
    public void testDefaultDifficulty() {
        ChoiceBox<String> difficulty = (ChoiceBox<String>) GuiTest.find("#difficulty");
        difficulty.setValue("Easy");
        clickOn("#submit");
        GuiTest.waitUntil("#difficulty", Matchers.is(VisibleNodesMatcher.visible()));
        ChoiceBox<String> newDiff = (ChoiceBox<String>) GuiTest.find("#difficulty");
        assertEquals("Easy", newDiff.getValue());
    }

    @Test
    public void testDefaultStartingSeed() {
        ChoiceBox<String> startingSeed = (ChoiceBox<String>) GuiTest.find("#startingSeed");
        startingSeed.setValue("Strawberry");
        clickOn("#submit");
        GuiTest.waitUntil("#startingSeed", Matchers.is(VisibleNodesMatcher.visible()));
        ChoiceBox<String> newStartingSeed = (ChoiceBox<String>) GuiTest.find("#startingSeed");
        assertEquals("Strawberry", newStartingSeed.getValue());
    }


}