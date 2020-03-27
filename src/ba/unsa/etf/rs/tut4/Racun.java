package ba.unsa.etf.rs.tut4;

import ba.unsa.etf.rs.tut4.Artikal.*;

import java.util.ArrayList;

public class Racun {

    static class StavkaRacuna {
        Artikal artikal;
        int kolicina;

        public StavkaRacuna(Artikal artikal, int kolicina) {
            this.artikal = artikal;
            this.kolicina = kolicina;
        }

        public Artikal getArtikal() {
            return artikal;
        }

        public void setArtikal(Artikal artikal) {
            this.artikal = artikal;
        }

        public int getKolicina() {
            return kolicina;
        }

        public void setKolicina(int kolicina) {
            this.kolicina = kolicina;
        }
    }

        ArrayList<StavkaRacuna> listaStavki;

    public Racun() {
        listaStavki = new ArrayList<>();
    }


    public void dodajStavku(Artikal artikal, int i) {
            StavkaRacuna stavka = new StavkaRacuna(artikal,i);
            listaStavki.add(stavka);
    }


    public double ukupanIznos() {
        double suma = 0;
        for(int i= 0; i < listaStavki.size();i++)
        {
            StavkaRacuna stavka1;
            double broj;
            stavka1 = listaStavki.get(i);
            broj = stavka1.getKolicina() * stavka1.artikal.getCijena();
            suma = suma + broj;
        }

    return suma;
}
}