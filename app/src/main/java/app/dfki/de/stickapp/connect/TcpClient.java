package app.dfki.de.stickapp.connect;

import android.util.Log;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;

/**
 * Created by EmpaT on 31.12.2016.
 */

public class TcpClient {
    //Mein PC 192.168.2.101
    //Für Emulator 10.0.2.2
    //hiz guest and saarland 134.96.79.69
    private static final String SERVER_IP = "192.168.2.101"; //your computer IP address
    private static final int SERVER_PORT = 64000;
    byte[] sendData;

    public void run(String message){
        try {
            //create a socket to make the connection with the server
            DatagramSocket senderSocket = new DatagramSocket(SERVER_PORT);
            //here you must put your computer's IP address.
            InetAddress serverAddr = InetAddress.getByName(SERVER_IP);

            sendData = message.getBytes();

            DatagramPacket sendPacket = new DatagramPacket(sendData, message.length(), serverAddr, SERVER_PORT);
            senderSocket.send(sendPacket);
            senderSocket.close();

        } catch (Exception  e) {
            e.printStackTrace();
        }

    }
}
