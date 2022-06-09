package Puente;

import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int longitud = 0;

        int numjuga = 0;

        System.out.println("Introduzca el numero de jugadores:");
        numjuga = s.nextInt();
        int[] lista_jugadores = new int[numjuga];
        for (int i = 0; i < numjuga; i++) {
            lista_jugadores[i] = i + 1;
        }

        System.out.println("Introduzca la longitud del puente:");
        longitud = s.nextInt();
        Puente p = new Puente(longitud, lista_jugadores);

        System.out.println("Este es el puente que se ha construido:");
        p.dibujarpuente();

        System.out.print("\nComienza el juego...");
        for (int i = 0; i < numjuga; i++) {
            Hilo h = new Hilo(p, lista_jugadores[i]);
            h.start();
        }

    }

}
