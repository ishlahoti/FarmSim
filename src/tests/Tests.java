import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;

import jdk.jfr.StackTrace;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.loadui.testfx.GuiTest;
import org.testfx.api.FxToolkit;
import org.testfx.framework.junit.ApplicationTest;

import static org.junit.Assert.*;



public class MainTest extends ApplicationTest {
    static Stage primaryStage;

    @Override
    public void start(Stage primaryStage) throws IOException {
        this.primaryStage = primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("WelcomeScreen.fxml"));
        primaryStage.setTitle("Farm Simulation"); //feel free to replace w/ something more creative
        Scene scene = new Scene(root, 800, 800);
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @Test
    public void testError() {
        TextField name = (TextField) GuiTest.find("#name");

        name.setText("");
        clickOn("#Submit");

        Label error = (Label) GuiTest.find("#error");
        assertEquals("Please enter a name", error.getText());
    }

    @Test
    public void testName() {
        TextField name = (TextField) GuiTest.find("#name");

        name.setText("Test Name");
        clickOn("#Submit");

        assertEquals("Test name", name.getText());
    }
}