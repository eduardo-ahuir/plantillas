package Globo;

import java.util.Scanner;

public class Hilo extends Thread {
    private String nombre;
    private Globo g;
    private Scanner sc;

    public Hilo(String nombre, Globo g, Scanner sc) {
        {
            this.nombre = nombre;
            this.g = g;
            this.sc = sc;
        }

    }

    public void run() {
        Scanner sc = new Scanner(System.in);
        synchronized (g) {
            while (!g.getExplotado()){
                System.out.println("Turno del jugador " + nombre);
                g.setJugador(nombre);
                String partes[] = sc.nextLine().split(";");
                System.out.println(partes[1]);
                int respuestaok=Integer.parseInt(partes[2]);
                int respuesta=-1;
                while (respuesta!=respuestaok){
                    System.out.println("Introduce la respuesta");
                    respuesta = sc.nextInt();
                    if(g.getExplotado()){
                        System.out.println("Da igual el globo ya ha explotado");;
                        break;
                    }
                    if (respuesta<respuestaok){
                        System.out.println("MAS");
                    }
                    if (respuesta>respuestaok){
                        System.out.println("MENOS");
                    }
                    if (respuesta==respuestaok){
                        System.out.println("Correcto");
                    }
                }
                if (g.getExplotado()){
                    break;
                }
                g.notify();
                try {
                    g.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }
            g.notifyAll();
        }


    }















}