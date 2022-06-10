package Examen.servidor;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;
import java.util.Locale;
import java.util.Scanner;

public class Cliente implements Serializable {
    Plataforma p = new Plataforma();
    String nombre;
    String nombrecontenido;
    String Añoproduccion;
    String tipocontenido;
    int notacontenido;

    String nombrecliente;


    int opcions=0;
    public static void main(String[] args) throws IOException {
        int puerto=6000;
        String host="localhost";


        System.out.println("Bienvenido a plataforming");
        System.out.println("Opcion 1 Dar de lata una plataforma");
        System.out.println("Opcion 2 Dar de lata un cliente");
        System.out.println("Opcion 3 Dar de lata un contenido");
        System.out.println("OPcion 4 Listado informativo");
        System.out.println("Opcion 5 Salir");

        Scanner sc = new Scanner(System.in);
        int opcion = sc.nextInt();
        Cliente c = new Cliente();
        Socket cliente = new Socket(host, puerto);

        while (opcion!=6){
        switch (opcion) {
            case 1:
                c.altaPlataforma((cliente));
                break;
            case 2:
                c.altaCliente((cliente));
                break;
            case 3:
                c.altaContenido((cliente));
                break;
             case 4:
                c.Listartodo((cliente));
                break;
            case 5:
                opcion=6;
                c.cerraservidor((cliente));
        }
        }




    }
    public  void altaPlataforma(Socket cliente)throws IOException {
        System.out.println("Introduce el nombre de la plataforma");
        Scanner sc = new Scanner(System.in);
        p.setPlataforma(sc.nextLine());
        ObjectOutputStream outObjeto = new ObjectOutputStream(cliente.getOutputStream());
        outObjeto.writeObject(p);
        outObjeto.close();
        p.setOpcions(1);



    }
    public void altaCliente(Socket cliente)throws IOException {
        ObjectOutputStream outObjeto = new ObjectOutputStream(cliente.getOutputStream());
        outObjeto.writeObject(p);
        outObjeto.close();
        p.setOpcions(2);
    }

    public void altaContenido(Socket cliente)throws IOException {

        ObjectOutputStream outObjeto = new ObjectOutputStream(cliente.getOutputStream());
        Cliente c = new Cliente();
        System.out.println("Introduce el tipo del contenido p para pelicula s para serie y d para documental");
        Scanner sc = new Scanner(System.in);
        if (sc.nextLine().toLowerCase(Locale.ROOT).equals("d")||sc.nextLine().toLowerCase(Locale.ROOT).equals("s")||sc.nextLine().toLowerCase(Locale.ROOT).equals("p")) {
            p.setTipocontenido(sc.nextLine());

        }else {
            System.out.println("Tipo de contenido no valido");
        }
        System.out.println("Introduce el nombre del contenido");
        String nombrecontenido = sc.nextLine();
        p.setNombrecontenido(nombrecontenido);
        if (p.getTipocontenido().equals("s")){
            p.getLista_series().add(nombrecontenido);
        }
        if (p.getTipocontenido().equals("d")){
            p.getLista_docus().add(nombrecontenido);
        }
        System.out.println("Introduce el año de produccion");
        p.setAñoproduccion(sc.nextLine());
        System.out.println("Introduce la nota del contenido entre 1 y 10");
        int nota=sc.nextInt();
        if (nota>0&&nota<11) {
            p.setNotacontenido(nota);
        }else {
            System.out.println("Nota no valida debe estar entre 1 y 10");
        }






        outObjeto.writeObject(p);
        outObjeto.close();
        p.setOpcions(3);
    }

    public void Listartodo(Socket cliente)throws IOException{
        ObjectOutputStream outObjeto = new ObjectOutputStream(cliente.getOutputStream());
        outObjeto.writeObject(p);
        outObjeto.close();
        p.setOpcions(4);
    }

    public void cerraservidor(Socket cliente)throws IOException{
        ObjectOutputStream outObjeto = new ObjectOutputStream(cliente.getOutputStream());
        outObjeto.writeObject(p);
        outObjeto.close();
        p.setOpcions(5);
    }

    }




