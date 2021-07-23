package ejercicios;

/*Desarrollar un programa para informar si un número n es primo o no, siendo n un valor que el usuario ingresará por consola.
Recordá que un número es primo cuando sólo es divisible por sí mismo y por 1.
*/

import java.util.Scanner;

public class Ejercicio3 {

    public boolean esPrimo(int n) {
        int divisores = 1;
        for(int i = 2; i <= n; i ++) {
            if(n % i == 0) {
                divisores ++;
                if(divisores > 2) {
                    return false;
                }
            }
        }
        return true;
    }

    public void chequerSiEsPrimo() {
        System.out.print("Ingrese el numero que quiere ver si es primo: ");
        int n = new Scanner(System.in).nextInt();

        if(this.esPrimo(n)) {
            System.out.println("Es primo");
        }
        else {
            System.out.println("No es primo");
        }
    }

}
