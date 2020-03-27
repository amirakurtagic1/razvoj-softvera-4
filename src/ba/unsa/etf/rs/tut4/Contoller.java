package ba.unsa.etf.rs.tut4;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextArea;
import java.util.ArrayList;

import static ba.unsa.etf.rs.tut4.Artikal.izbaciDuplikate;

public class Contoller {
    public TextArea Unos;
    public TextArea Ispis;
    public ChoiceBox<Artikal> item;
    public Spinner kolicina;
    public TextArea racun;


    String tekst = new String();
    ArrayList<Artikal> bezDuplikata = new ArrayList<>();
    ArrayList<Artikal> lista1 = new ArrayList<>();


    public void onClick(ActionEvent actionEvent) {

        String s = Unos.getText();
        String[] razdvojeni = s.split("\\n");

        ArrayList<Artikal> listaArtikala = new ArrayList<Artikal>();
       // Artikal l = new Artikal("jedan,", "dva,", 3);
        //listaArtikala.add(l);
        for (String s1 : razdvojeni) {
            listaArtikala.add(new Artikal(s1));
        }



        bezDuplikata = izbaciDuplikate(listaArtikala);
        //nova1 = bezDuplikata;
          //  String tekst = new String();
        for (Artikal a: bezDuplikata) {
                lista1.add(a);
                 tekst =tekst +  a.getSifra() + "," + a.getNaziv() + "," + a.getCijena() + System.lineSeparator();
            Ispis.setText(tekst);
        }
            ObservableList<Artikal> obsList = FXCollections.observableList(lista1);
            item.setItems(obsList);
            item.getSelectionModel().selectFirst();

    }


        String red = new String();
         double ukupno;

    public void Add(ActionEvent actionEvent) {

                Artikal art = new Artikal();
                double cijena;
                int kol;
                art = item.getValue();
                String sifra = new String();
                sifra = art.getSifra();
                cijena = art.getCijena();
                kol = (int) kolicina.getValue();
                ukupno = ukupno + cijena*kol;
               // String red = new String();

                red = red + sifra + "     " + kol + "     " + cijena*kol + System.lineSeparator();
                racun.setText(red + "UKUPNO         " + ukupno);
    }


}
