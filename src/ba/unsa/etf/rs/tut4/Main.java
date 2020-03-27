package ba.unsa.etf.rs.tut4;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/drugizad.fxml"));
        primaryStage.setTitle("Kasa");
        primaryStage.setScene(new Scene(root, 500, 450));
        primaryStage.show();
    }

    public static void main(String[] args) {
      try {
          ArrayList<Artikal> lista = new ArrayList<>();
          Artikal artikal = new Artikal("HLB001,Hljeb,1");
          lista.add(artikal);
          Artikal art1 = new Artikal("MLK001,Mlijeko,1.50");
          lista.add(art1);
          Artikal art2 = new Artikal("UL001", "Ulje", 2.00);
          lista.add(art2);
          Artikal art3 = new Artikal("SK001", "Sok", 2.50);
          lista.add(art3);
          Artikal art4 = new Artikal("SCR001", "Secer", 1.80);
          lista.add(art4);


          Artikal.izbaciDuplikate(lista);

      } catch(Exception e){
          System.out.println(e.getMessage());
      }
      launch(args);
    }
}
