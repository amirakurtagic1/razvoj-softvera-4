package ba.unsa.etf.rs.tut4;

import com.sun.media.jfxmediaimpl.platform.gstreamer.GSTPlatform;
import javafx.event.ActionEvent;
import javafx.scene.control.TextArea;
import java.util.ArrayList;

import static ba.unsa.etf.rs.tut4.Artikal.izbaciDuplikate;

public class Contoller {
    public TextArea Unos;
    public TextArea Ispis;

    public void onClick(ActionEvent actionEvent) {

        String s = Unos.getText();
        String[] razdvojeni = s.split("\\n");

        ArrayList<Artikal> listaArtikala = new ArrayList<Artikal>();
       // Artikal l = new Artikal("jedan,", "dva,", 3);
        //listaArtikala.add(l);
        for (String s1 : razdvojeni) {
            listaArtikala.add(new Artikal(s1));
        }


        ArrayList<Artikal> bezDuplikata = izbaciDuplikate(listaArtikala);

        for (Artikal a: bezDuplikata
             ) {
            String tekst = a.getSifra() + "," + a.getNaziv() + "," + a.getCijena();
            Ispis.setText(tekst);
        }

        ArrayList<Artikal> nova1 = new ArrayList<>();



    }
}
