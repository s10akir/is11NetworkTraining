import java.net.*;
import java.io.*;

/**
 * @author : akira.shinohara
 * @since : 2018/01/12
 */
public class MyServer {
    public static void main(String[] args) {
        MyServerSocket mss = new MyServerSocket();
    }
}

class MyServerSocket {
    ServerSocket server;
    Socket socket;
    BufferedWriter bw;

    MyServerSocket() {
        try {
            server = new ServerSocket(1234);
            while (true) {
                socket = server.accept();
                bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                bw.write("スマホrpgは今これをやってるよ。今のジョブはこれ! -> https://www.hellowork.go.jp/ ");
                bw.newLine();
                bw.flush();
            }
//            bw.close();
//            socket.close();
        } catch (IOException err) {
            System.out.println(err.toString());
        }
    }
}