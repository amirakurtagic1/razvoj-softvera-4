package ba.unsa.etf.rs.tut4;

import java.util.ArrayList;
import java.util.List;

public class Artikal {
    private String sifra;
    private String naziv;
    private double cijena;


    public Artikal() {}

    public Artikal(String sifra, String naziv, double cijena) {
        setSifra(sifra);
        setNaziv(naziv);
        setCijena(cijena);
    }

    public Artikal(String artikal) {
        String[] atributi = artikal.split(",");
        sifra = atributi[0];
        naziv = atributi[1];
        cijena = Double.parseDouble(atributi[2]);
        setSifra(sifra);
        setNaziv(naziv);
        setCijena(cijena);
    }

    public static ArrayList<Artikal> izbaciDuplikate(ArrayList<Artikal> lista)
    {

        for(int i = 0; i < lista.size(); i++)
        {
            for(int j = i+1; j < lista.size(); j++)
            {

               if (lista.get(i).equals(lista.get(j))) {
                   lista.remove(j);
                   j--;
               }
            }
        }
        return lista;
    }

    public String getSifra() {
        return sifra;
    }

    public void setSifra(String sifra) {
        if(sifra.isEmpty() || sifra.length() == 0) throw new IllegalArgumentException("Šifra je prazna");
        this.sifra = sifra;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        if(naziv.isEmpty() || naziv.length() == 0) throw new IllegalArgumentException("Naziv je prazan");
        this.naziv = naziv;
    }

    public double getCijena() {
        return cijena;
    }

    public void setCijena(double cijena) {
        if(cijena <= 0) throw new IllegalArgumentException("Cijena je negativna");
        this.cijena = cijena;
    }

    @Override
    public String toString() {
        return sifra + "," + naziv + "," + cijena;
    }

    @Override
    public boolean equals(Object o){
        if(!(o instanceof Artikal)) return false;
        Artikal a = (Artikal)o;
        if(!this.sifra.equals(a.sifra) || !this.naziv.equals(a.naziv) || this.cijena != a.cijena) return false;
        return true;
    }

}
