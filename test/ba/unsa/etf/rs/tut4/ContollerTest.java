package ba.unsa.etf.rs.tut4;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;

import java.awt.*;
import java.util.ArrayList;

@ExtendWith(ApplicationExtension.class)

class ContollerTest {
    @Start
    public void start (Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/drugizad.fxml"));
        primaryStage.setTitle("Kasa");
        primaryStage.setScene(new Scene(root, 500, 450));
        primaryStage.show();
        primaryStage.setResizable(false);
        primaryStage.toFront();
    }

    @Test
    void ProvjeriUnos(FxRobot robot){

        Button button = robot.lookup("#button").queryButton();
        assertNotNull(button);
        robot.clickOn("#Unos");
        robot.write("Jedan,jedan,1\nDva,dva,2");
        robot.clickOn(button);
       // TextArea ispis = new TextArea();
        TextArea ispis =  robot.lookup("#Ispis").queryAs(TextArea.class);
        assertEquals(true, ispis.getText().contains("Jedan,jedan,1.0\nDva,dva,2.0"));

    }



}