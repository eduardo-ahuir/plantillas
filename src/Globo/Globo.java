package Globo;

import java.util.Random;

public class Globo extends Thread{
    private int maximo;
    private int actual;
    private String jugador;
    private String nombre1;
    private String nombre2;
    private boolean explotado;

    public Globo(String nombre1, String nombre2){
        explotado = false;
        this.maximo= valor_aleatorio();
        this.nombre1 = nombre1;
        this.nombre2 = nombre2;



}
//metodo valor aleatorio
    public int valor_aleatorio(){
        Random r = new Random();
        int aleat = (int) (r.nextDouble() * 50+100);
        return aleat;
    }
    public void setJugador(String jugador){
        this.jugador = jugador;
    }
    public String getJugador(){
        return jugador;
    }
    public Boolean getExplotado(){
        return explotado;
    }




    public void run(){
        Random r = new Random();
        int aleat = 0;
        while(actual<maximo){
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            aleat = (int) (r.nextDouble() * 5+10);
            if (actual+aleat>=maximo){
                explotado = true;
                System.out.println("El globo ha explotado");
                break;

        }else {
            actual = actual+aleat;
            System.out.println("El globo lleva hinchado " + actual+" de " + maximo);
        }
    }//while
        System.out.println("El jugador que lo llevaba era " + jugador);
        if (jugador.equals(nombre1)){
            System.out.println("El jugador " + nombre2 + " ha ganado");

        if (jugador.equals(nombre2)){
            System.out.println("El jugador " + nombre1 + " ha ganado");
        }
    }




}//run
} //class
