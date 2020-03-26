package ba.unsa.etf.rs.tut4;


import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
      try {
          ArrayList<Artikal> lista = new ArrayList<>();
          Artikal artikal = new Artikal("Nesto,naziv,2");
          lista.add(artikal);
          Artikal art1 = new Artikal("Nesto,naziv,3.5");
          lista.add(art1);
          Artikal art2 = new Artikal("Nesto", "naziv", 3.5);
          lista.add(art2);

          Artikal.izbaciDuplikate(lista);

          for(int i = 0; i < lista.size(); i++)
          {
              System.out.println(lista.get(i));
          }
      } catch(Exception e){
          System.out.println(e.getMessage());
      }
    }
}
