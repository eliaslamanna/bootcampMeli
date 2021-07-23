package ejercicio5;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Fecha {

    private GregorianCalendar fecha;

    public Fecha() {
        super();
    }

    public Fecha(int anio, int mes, int dia) {
        this.fecha = new GregorianCalendar(anio, mes, dia);
    }

    public void addDay() {
        this.fecha.add((GregorianCalendar.DAY_OF_MONTH), 1);
    }

    public void validateDate() {
        this.fecha.setLenient(false);
        try {
            System.err.println(this.fecha.get(Calendar.DAY_OF_MONTH));
            System.err.println(this.fecha.get(Calendar.YEAR));
            System.err.println(this.fecha.get(Calendar.MONTH));
        }
        catch (Exception e) {
            System.out.println("La fecha es incorrecta");;
        }
    }

    public GregorianCalendar getFecha() {
        return fecha;
    }

    public void setFecha(GregorianCalendar fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Fecha{" +
                "fecha=" + fecha +
                '}';
    }
}
