package clients;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by Administrator on 2019/3/24 0024.
 */
public class SocketDemo1 {
    public static void main(String[] args) throws IOException {
        Socket socket=new Socket("localhost",8888);
        OutputStream os=socket.getOutputStream();
//        BufferedOutputStream osw=new BufferedOutputStream(os);
//        PrintWriter pw=new PrintWriter(osw,true);
        OutputStreamWriter osw=new OutputStreamWriter(os);
        BufferedWriter bw=new BufferedWriter(osw);
        Scanner scanner=new Scanner(System.in);
        while(true){
            String read=scanner.nextLine();
            System.out.println("发送："+read);
//            尽量使用PrintWriter,BufferedWriter默认只有遇到换行符才会刷新数据到服务器端，若使用bw，则需手动添加换行符
            bw.write(read+"\n");
            bw.flush();
//            pw.println(read);
        }
    }
}
