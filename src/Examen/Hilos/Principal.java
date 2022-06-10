package Examen.Hilos;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Clientes cliente = new Clientes();
        Scanner sc = new Scanner(System.in);
        System.out.println("Bienvenido al menu del Dunkin' Donuts");
        System.out.println("Opcion 1 realizar pedido");
        System.out.println("Opcion 2 consumir pedido");
        System.out.println("Opcion 3 salir");
        int opcion = sc.nextInt();
        switch (opcion) {
            case 1:
                cliente.start();
                break;
            case 2:
                Hilo h1 = new Hilo(cliente.getNombre1(), cliente);
                Hilo h2 = new Hilo(cliente.getNombre2(), cliente);



        }


}

}
