package Examen.servidor;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class servidor implements Serializable {
    private String ncliente;
    private String nplataforma;
    private String plataforma;
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ArrayList<Plataforma> lista_plataformas = new ArrayList<Plataforma>();
        ArrayList<String> lista_plats = new ArrayList<String>();
        int puerto = 6000;
        ServerSocket servidor = new ServerSocket(puerto);
        Socket cliente = null;
        while (true) {

            cliente = servidor.accept();
            ObjectInputStream inObjeto = new ObjectInputStream(cliente.getInputStream());
            Cliente c = (Cliente) inObjeto.readObject();
            Plataforma p = (Plataforma) inObjeto.readObject();
            Scanner sc = new Scanner(System.in);
            switch (p.getOpcions()) {
                case 1:
                    lista_plataformas.add(p);
                    lista_plats.add(p.getPlataforma());
                    System.out.println("Plataforma dada de alta");
                    break;
                case 2:
                    System.out.println("introduce el nombre del cliente");
                    p.setCliente(sc.nextLine());
                    String salida = "";
                    while (!salida.equals("salir")) {
                        System.out.println("En que plataformas te quieres registrar escribe salir para salir");
                        salida = sc.nextLine().toLowerCase(Locale.ROOT);
                        servidor s = new servidor();
                        for (int i = 0; i < lista_plataformas.size(); i++) {
                            if (lista_plataformas.get(i).getPlataforma().equals(salida)) {
                                lista_plataformas.get(i).setCliente(salida);



                            } else {
                                System.out.println("Plataforma no encontrada");
                            }
                        }


                    }
                    break;
                case 3:
                    //solicita el nombre de la plataforma donde se va a registrar el contenido y valida si existe
                    System.out.println("Introduce el nombre de la plataforma");
                    String plataformaregistro = sc.nextLine();

                    for (int i = 0; i < lista_plataformas.size(); i++) {
                        if (lista_plataformas.get(i).getPlataforma().equals(plataformaregistro)) {
                            p.setPlataformaregistrado(plataformaregistro);
                            break;
                        } else {
                            System.out.println("Plataforma no encontrada");
                        }
                    }
                    break;
                case 4:
                    for (int i = 0; i < lista_plataformas.size(); i++) {
                        if (lista_plataformas.get(i).getPlataforma().equals(lista_plats.get(i))) {
                            System.out.println("Nombre: " + lista_plataformas.get(i).getPlataforma()+"(" + lista_plataformas.get(i).getAñoproduccion()+")"+" Nota "+lista_plataformas.get(i).getNotacontenido());
                            }}
                    break;
                case 5:
                    //salida del programa
                    System.out.println("Gracias por utilizar plataformingg");
                    break;


    }

            if ( p.getOpcions()== 5) {
                System.out.println("y hasta otra vez");
                break;
            }
}

    }}




