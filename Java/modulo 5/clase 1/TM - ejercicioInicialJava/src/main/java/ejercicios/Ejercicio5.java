package ejercicios;

/*Desarrollar un programa para mostrar por consola los primeros n números naturales que tienen al menos m dígitos d,
siendo n, m y d valores que el usuario ingresará por consola.
Por ejemplo: si el usuario ingresa n=5, m=2 y d=3, el programa deberá mostrar por consola los primeros 5 números
naturales que tienen, al menos, 2 dígitos 3. En este caso la salida será: 33, 133, 233, 303, 313.

Según cómo decidas encarar la solución de este ejercicio, es probable que necesites utilizar recursos que aún no hemos
estudiado. El desafío consiste en googlear cómo utilizar dichos recursos y ¡utilizarlos!
*/

import java.util.Scanner;

public class Ejercicio5 {

    private int m;
    private int n;
    private String d;

    public void pedirValores() {
        System.out.print("Ingrese la cantidad de numero enteros que quiere: ");
        this.n = new Scanner(System.in).nextInt();

        System.out.print("Ingrese la cantidad de digitos que quiere: ");
        this.m = new Scanner(System.in).nextInt();

        System.out.print("Ingrese el digito que quiere: ");
        this.d = new Scanner(System.in).nextLine();
    }

    public void calcularEnteros() {
        this.pedirValores();
        int encontrados = 0;
        int numeroActual = 0;
        while(encontrados != n) {
            int numberSize = Integer.toString(numeroActual).length();
            int digitosEncontrados = 0;
            if(numberSize >= this.m) {
                for(int i = 0; i < numberSize; i ++) {
                    String digitoActual = String.valueOf(String.valueOf(numeroActual).charAt(i));
                    if(d.equals(digitoActual)) {
                        digitosEncontrados ++;
                        if(digitosEncontrados == m) {
                            encontrados ++;
                            System.out.println(numeroActual);
                        }
                    }
                }
            }
            numeroActual ++;
        }
    }
}
