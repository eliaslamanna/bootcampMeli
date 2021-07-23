package ejercicio;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import java.io.FileReader;
import java.util.Comparator;
import java.util.Properties;

public class Main {

    public static void main(String[] args) {
        Sorter aux = (Sorter) MiFactory.getInstance("sorter");
        Integer[] arr = {9, 2, 1, 8, 5};

        aux.sort(arr, Comparator.naturalOrder());

        for(int i = 0; i < arr.length; i ++) {
            System.out.println(arr[i]);
        }

        String[] arrStr = {"bbb", "aba", "aaa", "abb", "ccc", "bbc"};

        aux.sort(arrStr, Comparator.naturalOrder());

        for(int i = 0; i < arrStr.length; i ++) {
            System.out.println(arrStr[i]);
        }

        System.out.println("-----------------------");

        Timer timer = new Timer();
        Integer[] numeros = new Integer[100];
        int pos = 0;
        for(int i = 100; i > 0; i --) {
            numeros[pos] = i;
            pos ++;
        }

        timer.start();
        aux.sort(numeros, Comparator.naturalOrder());
        timer.stop();

        System.out.println("Timer start: " + timer.getStartMs());
        System.out.println("Timer end: " + timer.getStopMs());
        System.out.println("Tiempo transcurrido: " + timer.elapsedTime());
    }
}
