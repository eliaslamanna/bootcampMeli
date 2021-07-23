package ejercicio4;

public class Fraccion {

    private int numerador;
    private int denominador;

    //fraccion
    public void sumar(Fraccion fraccion) {
        if(this.denominador == fraccion.getDenominador()) {
            this.numerador += fraccion.getNumerador();
        }
        else {
            this.numerador = (this.numerador * fraccion.getDenominador()) + (fraccion.getNumerador() * this.getDenominador());
            this.denominador *= fraccion.getDenominador();
        }
        this.mostrarFraccion();
    }

    public void restar(Fraccion fraccion) {
        if(this.denominador == fraccion.getDenominador()) {
            this.numerador -= fraccion.getNumerador();
        }
        else {
            this.numerador = (this.numerador * fraccion.getDenominador()) - (fraccion.getNumerador() * this.getDenominador());
            this.denominador *= fraccion.getDenominador();
        }
        this.mostrarFraccion();
    }

    public void multiplicar(Fraccion fraccion) {
        this.numerador *= fraccion.getNumerador();
        this.denominador *= fraccion.getDenominador();
        this.mostrarFraccion();
    }

    public void dividir(Fraccion fraccion) {
        int numeradorAux = fraccion.getDenominador();
        int denominadorAux = fraccion.getNumerador();

        this.numerador *= numeradorAux;
        this.denominador *= denominadorAux;
        this.mostrarFraccion();
    }

    //enteros
    public void sumar(int numero) {
        this.numerador = this.numerador + (numero * this.getDenominador());

        this.mostrarFraccion();
    }

    public void restar(int numero) {
        this.numerador = this.numerador- (numero * this.getDenominador());

        this.mostrarFraccion();
    }

    public void multiplicar(int numero) {
        this.numerador *= numero;
        this.mostrarFraccion();
    }

    public void dividir(int numero) {
        this.denominador *= numero;
        this.mostrarFraccion();
    }

    public void mostrarFraccion() {
        System.out.println("Numerador: " + this.numerador);
        System.out.println("Denominador: " + this.denominador);
    }

    public int getNumerador() {
        return numerador;
    }

    public void setNumerador(int numerador) {
        this.numerador = numerador;
    }

    public int getDenominador() {
        return denominador;
    }

    public void setDenominador(int denominador) {
        this.denominador = denominador;
    }
}
