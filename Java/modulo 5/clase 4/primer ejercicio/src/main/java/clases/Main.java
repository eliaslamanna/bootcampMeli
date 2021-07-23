package clases;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        GuardaRopa guardaRopa = new GuardaRopa();

        Prenda prenda1 = new Pantalon("adidas", "medias");
        Prenda prenda2 = new Medias("nike", "zapatillas");

        List<Prenda> prendas = new ArrayList<>();
        prendas.add(prenda1);
        prendas.add(prenda2);

        int numeroIdentificador = guardaRopa.guardarPrendas(prendas);

        List<Prenda> prendasPersona = guardaRopa.devolverPrendas(numeroIdentificador);

        for(Prenda prenda : prendasPersona) {
            System.out.println(prenda.toString());
        }
    }

}
