package app.dfki.de.stickapp.connect;

import android.util.Log;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

/**
 * Created by EmpaT on 31.12.2016.
 */

public class TcpClient {
    //Mein PC 192.168.2.101
    //Für Emulator 10.0.2.2
    private static final String SERVER_IP = "192.168.2.101"; //your computer IP address
    private static final int SERVER_PORT = 64000;


    // used to send messages
    private PrintWriter mBufferOut;

    /**
     * Sends the message entered by client to the server
     *
     * @param message text entered by client
     */
    private void sendMessage(String message) {
        if (mBufferOut != null && !mBufferOut.checkError()) {
            mBufferOut.println(message);
            mBufferOut.flush();
        }
    }

    /**
     * Close the connection and release the members
     */
    public void stopClient() {
        Log.i("Debug", "stopClient");

        if (mBufferOut != null) {
            mBufferOut.flush();
            mBufferOut.close();
        }
        mBufferOut = null;
    }

    public void run(String message){
        try {
            //here you must put your computer's IP address.
            InetAddress serverAddr = InetAddress.getByName(SERVER_IP);

            //create a socket to make the connection with the server
            Socket socket = new Socket(serverAddr, SERVER_PORT);

            //sends the message to the server
            mBufferOut = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
            sendMessage(message);
            socket.close();

        } catch (Exception  e) {
            e.printStackTrace();
        }

    }
}
