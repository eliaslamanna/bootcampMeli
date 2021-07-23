package ejercicios;

/*Desarrollar un programa para mostrar los primeros n múltiplos de m, siendo n y m valores que el usuario ingresará por consola.
Recordá que un número a es múltiplo de b si a es divisible por b.
*/

import java.util.Scanner;

public class Ejercicio2 {

    public void calcularMultiplos() {
        System.out.print("Ingrese el numero del cual quiere los multiplos: ");
        int m = new Scanner(System.in).nextInt();

        System.out.print("Ingrese la cantidad de multiplos que quiere: ");
        int n = new Scanner(System.in).nextInt();

        for(int i = 1; i <= n; i ++) {
            System.out.println(i * m);
        }
    }

}
