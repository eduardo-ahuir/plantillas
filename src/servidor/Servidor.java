package servidor;

import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;

public class Servidor {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //Asocio el socket al puerto 12345 y me quedo esperando
        DatagramSocket serverSocket = new DatagramSocket(12345);
        byte[] recibidos = new byte[1024];
        DatagramPacket recibidor = new DatagramPacket(recibidos, recibidos.length);
        serverSocket.receive(recibidor);
        ByteArrayInputStream bais = new ByteArrayInputStream(recibidos);
        ObjectInputStream in = new ObjectInputStream(bais);
        Tirada tirada = (Tirada)in.readObject();
        //Direccion origen del mensaje
        InetAddress IPOrigen = recibidor.getAddress();
        int puertoOrigen = recibidor.getPort();
        //Creamos el datagrama que irá al cliente
        ByteArrayOutputStream bs = new ByteArrayOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(bs);
        out.writeObject(tirada);
        out.close();
        byte[] enviados = bs.toByteArray();
        DatagramPacket envio = new DatagramPacket(enviados, enviados.length, IPOrigen, puertoOrigen);
        //Realizamos el envio
        serverSocket.send(envio);
        serverSocket.close();







    }

}
