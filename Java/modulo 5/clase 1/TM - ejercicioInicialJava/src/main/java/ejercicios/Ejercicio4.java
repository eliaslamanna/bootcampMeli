package ejercicios;

/*Desarrollar un programa para mostrar por consola los primeros n números primos, siendo n un valor que el usuario
ingresará por consola. */

import java.util.Scanner;

public class Ejercicio4 {

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

    public void calcularNPrimos() {

        System.out.print("Ingrese la cantidad de primos que quiere: ");
        int n = new Scanner(System.in).nextInt();

        int encontrados = 0;
        int numeroActual = 1;
        while(encontrados != n) {
            if(this.esPrimo(numeroActual)) {
                System.out.println(numeroActual);
                encontrados ++;
            }
            numeroActual ++;
        }

    }
}
