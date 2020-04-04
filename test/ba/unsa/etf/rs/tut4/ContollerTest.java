package ba.unsa.etf.rs.tut4;

import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Spinner;
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
        robot.write("Sifra1,Proizvod1,1\nSifra2,Proizvod2,2");
        robot.clickOn(button);
       // TextArea ispis = new TextArea();
        TextArea ispis =  robot.lookup("#Ispis").queryAs(TextArea.class);
        assertEquals(true, ispis.getText().contains("Sifra1,Proizvod1,1.0\nSifra2,Proizvod2,2.0"));
    }

    @Test
    void IzbaciDuplikateTest(FxRobot robot){
        Button button = robot.lookup("#button").queryButton();
        assertNotNull(button);
        robot.clickOn("#Unos");
        robot.write("Sifra1,Proizvod1,1\nSifra2,Proizvod2,2\nSifra2,Proizvod2,2\n");
        robot.clickOn(button);
        robot.clickOn("#Unos");
        robot.write("Sifra1,Proizvod1,1");
        robot.clickOn(button);
        TextArea ispis =  robot.lookup("#Ispis").queryAs(TextArea.class);
        assertEquals(true, ispis.getText().contains("Sifra1,Proizvod1,1.0\nSifra2,Proizvod2,2.0"));
    }

    @Test
    void IspitivanjeArtikla(FxRobot robot){
        robot.clickOn("#Unos");
        robot.write("Sifra1,Proizvod1,1");
        robot.clickOn("#button");
        TextArea unos = robot.lookup("#Unos").queryAs(TextArea.class);
        Artikal artikal = new Artikal("Sifra2", "Proizvod2", 2);
        Artikal artikal1 = new Artikal();
        assertEquals("Sifra2", artikal.getSifra());
        assertEquals("Proizvod2", artikal.getNaziv());
        assertEquals(2.0, artikal.getCijena());
    }
    @Test
    void IspitivanjeAktuelnogRacuna(FxRobot robot){
        Button button = robot.lookup("#button").queryButton();
        assertNotNull(button);
        robot.clickOn("#Unos");
        robot.write("Sifra1,Proizvod1,1\nSifra2,Proizvod2,2\nSifra3,Proizvod3,3\n");
        robot.clickOn(button);
        robot.clickOn("#Tab2");
        ChoiceBox item = robot.lookup("#item").queryAs(ChoiceBox.class);
        robot.clickOn("#item");
        Platform.runLater(() -> item.show());
        try{
            Thread.sleep(200);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        robot.clickOn("Sifra2,Proizvod2,2.0");
        Spinner spinner = robot.lookup("#kolicina").queryAs(Spinner.class);
        robot.clickOn("kolicina");
        try{
            Thread.sleep(200);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        robot.write("2");
        robot.clickOn("#Dodaj");
        TextArea racun = robot.lookup("#racun").queryAs(TextArea.class);
        Racun racun1 = new Racun();
        racun1.dodajStavku(new Artikal("HLB", "Hljeb", 1.1), 2);


    }



}