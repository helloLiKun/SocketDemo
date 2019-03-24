package clients;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * Created by Administrator on 2019/3/24 0024.
 */
public class ExceuteHandler implements Runnable {
    Socket socket;

    public ExceuteHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            InputStream inputStream=socket.getInputStream();
            InputStreamReader inputStreamReader=new InputStreamReader(inputStream,"utf-8");
            BufferedReader bufferedReader=new BufferedReader(inputStreamReader);
            while (true){
                String read=bufferedReader.readLine();
                System.out.println("说:"+read);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
