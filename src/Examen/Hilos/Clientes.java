package Examen.Hilos;

import java.util.ArrayList;
import java.util.Scanner;

public class Clientes extends Thread {
    //se pedirá el nombre de los 2 clientes que van a hacer el pedido separados por un guión
    private String nombre1;
    private String nombre2;
    private Scanner sc;
    private int filas=0;
    private int columnas=0;
    String caja[][] = new String[filas][columnas];
    int identificador=0;
    ArrayList<Clientes> clientes = new ArrayList<Clientes>();
    private boolean consumido=false;



    public Clientes(String nombre1,String nombre2,String matriz[][]) {
        this.nombre1 = nombre1;
        this.nombre2 = nombre2;
        this.caja = matriz;

    }

    public Clientes() {

    }

    public void run() {
        Scanner sc = new Scanner(System.in);
        while (!sc.nextLine().contains("-")) {
            System.out.println("Introduce el nombre ambos clientes separado por un guión");
            String partes[] = sc.nextLine().split("-");
            if (!sc.nextLine().contains("-")) {
                System.out.println("Los nombres deben ir separados por un guión");
            } else {
                nombre1 = partes[0];
                nombre2 = partes[1];
            }
        }

        while (!sc.nextLine().contains("x")){
        //se piden las dimensiones de la caja de donuts una matriz que se forma de esas dimensione separadas por una x
        System.out.println("Introduce las dimensiones de la caja de donuts separadas por una x");
        if (!sc.nextLine().contains("x")){
            System.out.println("Las dimensiones deben ir separadas por una x");
        }else {
        String partes2[] = sc.nextLine().split("x");
        int filas = Integer.parseInt(partes2[0]);
        int columnas = Integer.parseInt(partes2[1]);
        //se crea la matriz con esas dimensiones
        caja = new String[filas][columnas];
        //se rellena la matriz con valores aleatorios del 1 al 80
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                caja[i][j] = Integer.toString((int) (Math.random() * 80 + 1));
            }
        }


    }

    }identificador++;
    clientes.add(new Clientes(nombre1,nombre2, caja));





    }
    //metodo para imprimir la matriz
    public void imprimirMatriz(){
        System.out.println("pedido nº"+identificador);
        System.out.println("cleintes: "+nombre1+" "+nombre2);
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                System.out.print(caja[i][j] + " ");
            }
            System.out.println();
        }
    }

    public ArrayList<Clientes> getClientes() {
        return clientes;
    }

    public void setConsumido(boolean consumido) {
        this.consumido = consumido;
    }

    public int getIdentificador() {
        return identificador;
    }

    public boolean isConsumido() {
        return consumido;
    }

    public String[][] getCaja() {
        return caja;
    }

    public String getNombre1() {
        return nombre1;
    }

    public String getNombre2() {
        return nombre2;
    }
}

