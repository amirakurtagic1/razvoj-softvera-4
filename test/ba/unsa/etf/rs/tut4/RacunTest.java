package ba.unsa.etf.rs.tut4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RacunTest {

    @Test
    void test1() {
        Racun r = new Racun();
        r.dodajStavku(new Artikal("HLB", "Hljeb", 1.1), 2);
        r.dodajStavku(new Artikal("JAJ", "Jaje", 0.25), 5);
        assertEquals(3.45, r.ukupanIznos());
    }

    @Test
    void testPrazno() {
        Racun r = new Racun();
        assertEquals(0, r.ukupanIznos());
    }

    @Test
    void getArtikal() {
        Racun.StavkaRacuna racun = new Racun.StavkaRacuna(new Artikal("HLB", "Hljeb", 1.1), 2);
        assertEquals(new Artikal("HLB", "Hljeb", 1.1), racun.getArtikal());
    }

    @Test
    void setArtikal() {
        Racun.StavkaRacuna racun = new Racun.StavkaRacuna(new Artikal("HLB", "Hljeb", 1.1), 2);
        racun.setArtikal(new Artikal("Dr","Drugo",1.2));
        assertEquals(new Artikal("Dr", "Drugo", 1.2), racun.getArtikal());

    }

    @Test
    void getKolicina() {
        Racun.StavkaRacuna racun = new Racun.StavkaRacuna(new Artikal("HLB", "Hljeb", 1.1), 2);
        assertEquals(2, racun.getKolicina());
    }

    @Test
    void setKolicina() {
        Racun.StavkaRacuna racun = new Racun.StavkaRacuna(new Artikal("HLB", "Hljeb", 1.1), 2);
        racun.setKolicina(3);
        assertEquals(3, racun.getKolicina());
    }
}