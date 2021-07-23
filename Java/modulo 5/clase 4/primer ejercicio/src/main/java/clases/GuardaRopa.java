package clases;

import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardaRopa {

    private HashMap<Integer, List<Prenda>> prendas = new HashMap<>();
    private int contador = -1;

    public Integer guardarPrendas(List<Prenda> listaDePrenda) {
        this.contador ++;
        this.prendas.put(this.contador, listaDePrenda);
        return this.contador;
    }

    public void mostrarPrendas() {
        for (Map.Entry<Integer, List<Prenda>> entry : this.prendas.entrySet()) {
            System.out.println("Numero: " + entry.getKey());
            for(Prenda prenda : entry.getValue()) {
                System.out.println(prenda.toString());
            }
            System.out.println(" ");
        }
    }

    public List<Prenda> devolverPrendas(Integer numero) {
        return this.prendas.get(numero);
    }

    public HashMap<Integer, List<Prenda>> getPrendas() {
        return prendas;
    }

    public void setPrendas(HashMap<Integer, List<Prenda>> prendas) {
        this.prendas = prendas;
    }
}
