package ejercicio2;

public class Contador {

    private int valorActual;

    public Contador(int valorActual) {
        this.valorActual = valorActual;
    }

    public Contador() {
        super();
    }

    public Contador(Contador contadorACopiar) {
        this.valorActual = contadorACopiar.getValorActual();
    }

    public void aumentar() {
        valorActual ++;
    }

    public void decrementar() {
        valorActual --;
    }

    public int getValorActual() {
        return valorActual;
    }

    public void setValorActual(int valorActual) {
        this.valorActual = valorActual;
    }
}
