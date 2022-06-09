package Puente;

import java.util.Random;

public class Hilo extends Thread {
    private Puente p;
    private int num;

    public Hilo(Puente p, int num) {
        this.p = p;
        this.num = num;
    }



    public void run() {
        int casilla = 0;
        boolean jugador_rip = false;

        synchronized (p) {
            System.out.println("Cruza el juagdor " + num);
            for (int i = 0; i < p.getLongitud(); i++) {
                casilla = decidecasilla(i);
                System.out.println("El jugador " + num + " cruza la casilla " + casilla);
                esperar(2);
                if (p.getBaldosa(casilla,i) == 'T') {
                    System.out.println("El cristal era templado");
                    p.Borrar_baldosa(casilla,i);
                    p.Eliminar_jugador(num);
                    jugador_rip = true;
                    esperar(2);
                    p.dibujarpuente();
                    break;
                }

            }
            if (jugador_rip==false) {
                System.out.println("El jugador " + num + " ha ganado");
            }
        }
    }

    public int decidecasilla(int num) {
        Random r = new Random();
        int aleat=0;
        if (p.getBaldosa(0,num) == '-') {
            return 1;
        }
        if (p.getBaldosa(1,num) == '-') {
            return 0;
        }
        aleat = (int)r.nextDouble()*2;
        return aleat;
    }

    public void esperar(int seg) {
        try {
            Thread.sleep(seg*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }







}
