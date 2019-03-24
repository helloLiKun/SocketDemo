package server;

import clients.ExceuteHandler;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Administrator on 2019/3/24 0024.
 */
public class ServerSocketDemo {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket=new ServerSocket(8888);
//        ExecutorService executorService=Executors.newCachedThreadPool();
        while(true){
            Socket socket=serverSocket.accept();
            System.out.println(socket.getLocalAddress()+"链接成功！");
//            executorService.execute(new ExceuteHandler(socket));
            new Thread(new ExceuteHandler(socket)).start();
        }

    }

}
