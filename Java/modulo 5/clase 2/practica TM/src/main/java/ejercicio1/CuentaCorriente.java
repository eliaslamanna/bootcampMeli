package ejercicio1;

public class CuentaCorriente {

    private double saldo;
    private String titular;
    private long cbu;

    public CuentaCorriente(double saldo, String titular, long cbu) {
        this.saldo = saldo;
        this.titular = titular;
        this.cbu = cbu;
    }

    public CuentaCorriente() {
        super();
    }

    public CuentaCorriente(CuentaCorriente cuentaACopiar) {
        this.saldo = cuentaACopiar.getSaldo();
        this.titular = cuentaACopiar.getTitular();
        this.cbu = cuentaACopiar.getCbu();
    }

    public void ingreso(double monto) {
        saldo += monto;
        System.out.println("Se agrego $" + monto + "a la cuenta.");
        System.out.println("Saldo actual: $" + this.saldo);
    }

    public void egreso(double monto) {
        if(this.saldo >= monto) {
            this.saldo -= monto;
            System.out.println("Se retiraron $" + monto + "de la cuenta.");
            System.out.println("Saldo actual: $" + this.saldo);
        }
        else {
            System.out.println("Dinero insuficiente para realizar transaccion.");
        }
    }

    public void reintegro(double monto, String servicio) {
        this.saldo += monto;
        System.out.println("Reintegro por: " + servicio);
        System.out.println("Saldo actual: $" + this.saldo);
    }

    public void transferencia(double monto, long cbu) {
        if(this.saldo >= monto) {
            this.saldo -= monto;
            System.out.println("Transferencia realizada con exito.");
            System.out.println("Monto transferencia: $" + monto);
            System.out.println("Destinatario: " + cbu);
        }
        else {
            System.out.println("Saldo insuficiente para realizar operacion");
        }
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public long getCbu() {
        return cbu;
    }

    public void setCbu(long cbu) {
        this.cbu = cbu;
    }
}
