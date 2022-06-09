package servidor;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Random;
import java.util.Scanner;

public class Cliente {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        //Datos del Servidor al que enviar mensaje
        InetAddress IPServidor = InetAddress.getLocalHost();
        int puerto = 12345;
        //Datagrama de envio: puerto aleatorio para no solaparse con el puerto de otro jugador.
        Random r = new Random();
        int puertonum = (int)(r.nextDouble()*300 + 32000);
        DatagramSocket clientSocket = new DatagramSocket(puertonum);
        //Creación de un objet

        ByteArrayOutputStream bs = new ByteArrayOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(bs);
        out.writeObject(tirada);
        out.close();
        byte[] enviados = bs.toByteArray();
        //Creamos el datagrama que irá al servidor
        DatagramPacket envio = new DatagramPacket(enviados, enviados.length,IPServidor, puerto);
        //Realizamos el envio
        clientSocket.send(envio);
        //Recibiendo datagrama del servidor
        byte[] recibido = new byte[1024];
        DatagramPacket recibidor = new DatagramPacket(recibido, recibido.length);
        clientSocket.receive(recibidor);
        //Obtener el numero de caracteres
        ByteArrayInputStream bais = new ByteArrayInputStream(recibido);
        Tirada tirada2 = (Tirada)in.readObject();
        in.close


        clientSocket.close();


    }
    }
