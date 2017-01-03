package app.dfki.de.stickapp.connect;

import android.os.AsyncTask;

import app.dfki.de.stickapp.connect.TcpClient;

/**
 * Created by EmpaT on 30.12.2016.
 */
public class CommandSender extends AsyncTask<String, Integer, TcpClient> {

    TcpClient mTcpClient;
    @Override
    protected TcpClient doInBackground(String... params) {
        //we create a TCPClient object and
        mTcpClient = new TcpClient();
        mTcpClient.run(params[0]);
        return null;
    }
}
