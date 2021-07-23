package ejercicio2;

public class Rectangulo extends FiguraGeometrica {

    private double base;

    public Rectangulo(double base, double altura) {
        this.base = base;
        this.altura = altura;
    }

    private double altura;

    @Override
    public double area() {
        return this.base * this.altura;
    }
}
