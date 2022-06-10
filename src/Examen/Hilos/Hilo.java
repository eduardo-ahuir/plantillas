package Examen.Hilos;

import java.util.Scanner;

public class Hilo extends Thread {
    private String nombre;
    private  Clientes c;

    public Hilo(String nombre, Clientes c) {
        this.nombre = nombre;
        this.c = c;
    }
    public void run() {
        Scanner sc = new Scanner(System.in);
        synchronized (c){
            //se pide quese introduzca un numero y se comprueba si el numero existe dentro del array
            System.out.println("Introduce un numero");
            int numero = sc.nextInt();
            for (int i =0 ; i<c.getClientes().size();i++){
                if (c.getClientes().get(i).getIdentificador()==numero){
                    //se comprueba si el pedido ha sido consumido
                    if (!c.getClientes().get(i).isConsumido()){
                        //se escoge uan posicion de la caja de forma aleatoria y se establece su valor a las tres primeras letras de nombre
                        int fila = (int) (Math.random() * c.getCaja().length);
                        int columna = (int) (Math.random() * c.getCaja()[0].length);
                        c.getCaja()[fila][columna] = nombre.substring(0,3);
                        c.getClientes().get(i).setConsumido(true);
                        notify();
                        try {
                            wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }


                    }else {
                        System.out.println("El pedido ya ha sido consumido");
                        break;
                    }

                }

                if (i==c.getClientes().size()-1){
                    System.out.println("ERROR! No existe un pedido con ese id!");
                }


            }



    }
    }



}
