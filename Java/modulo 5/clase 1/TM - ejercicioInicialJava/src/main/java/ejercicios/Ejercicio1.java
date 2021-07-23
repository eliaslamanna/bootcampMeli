package ejercicios;

/*Desarrollar un programa para mostrar los primeros n números pares, siendo n un valor que el usuario ingresará por consola.
Recordá que un número es par cuando es divisible por 2.
*/

import java.util.Scanner;

public class Ejercicio1 {

    public int pedirInput() {
        //input por consola
        System.out.print("Ingrese la cantidad de numeros pares que quiere: ");
        Scanner input = new Scanner(System.in);
        return input.nextInt();
    }

    public void calcularPares() {
        int n = this.pedirInput();
        for(int i = 1; i <= n; i ++) {
            System.out.println(i * 2);
        }
    }


}
