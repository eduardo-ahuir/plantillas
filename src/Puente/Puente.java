package Puente;

import java.util.Random;

public class Puente {
    private final int longitud;
    private final int[] jugadores;
    private char[][] puente;

    public Puente(int longitud, int[] lista) {
        this.longitud = longitud;
        this.jugadores = lista;
        this.puente = crearpuente();
    }


    public char[][] crearpuente() {
        Random r = new Random();
        int aleat = 0;
        puente = new char[2][longitud];
        for (int i = 0; i < longitud; i++) {
            aleat = (int) (r.nextDouble() * 2);
            if (aleat == 0) {
                puente[0][i] = 'T';
                puente[1][i] = 'N';
            } else {
                puente[0][i] = 'N';
                puente[1][i] = 'T';
            }
        }

        return puente;
    }

    public void dibujarpuente() {
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < longitud; j++) {
                System.out.print(puente[i][j] + " ");
            }
            if (i == 0) {
                System.out.println();
            }
        }
        System.out.println();
        boolean pinta_jugadores = false;
        for (int i = 0; i < jugadores.length; i++) {
            if (jugadores[i] != -1) {
                if (pinta_jugadores == false) {
                    System.out.print("Jugadores: ");
                    pinta_jugadores = true;
                }
                System.out.print(jugadores[i] + " ");

            }

        }

        if (pinta_jugadores == false) {
            System.out.println("GAME OVER");

        }

    }

    public int getLongitud() {
        return longitud;
    }

    public void Borrar_baldosa(int x, int y) {
        puente[x][y] = '-';
    }

    public void Eliminar_jugador(int num1) {
        int pos = 0;
        for (int i = 0; i < jugadores.length; i++) {
            if (jugadores[i] == num1) {
                pos = i;
                break;
            }
        }
        jugadores[pos] = -1;
    }

    public char getBaldosa(int x, int y) {
        return puente[x][y];
    }
}
