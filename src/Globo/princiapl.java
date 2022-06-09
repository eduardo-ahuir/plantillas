package Globo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class princiapl {

    public static void main(String[] args) throws FileNotFoundException, InterruptedException {
        Scanner s = new Scanner(System.in);
        String nombre1 = "";
        String nombre2 = "";

        //abrimos el fichero preguntas.txt
        File fichero = new File("preguntas.txt");
        Scanner sc = null;
        try {
            sc = new Scanner(fichero);
        } catch (FileNotFoundException e) {
            System.out.println("No se ha encontrado el fichero");
        }

        //Creamos el recurso compartido globo
        System.out.println("Beinenvenido a la patata caliente");

        while (nombre1.equals("")) {
            System.out.println("Introduce el nombre del jugador 1:");
            nombre1 = s.nextLine();
}
        while (nombre2.equals("")) {
            System.out.println("Introduce el nombre del jugador 2:");
            nombre2 = s.nextLine();
        }

        Globo g = new Globo(nombre1, nombre2);
        g.start();
        Hilo h1 = new Hilo(nombre1,g,sc);
        Hilo h2 = new Hilo(nombre2,g,sc);
        h1.start();
        Thread.sleep(1000);
        h2.start();
}
}
