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

    MyServerSocket() {
        try {
            server = new ServerSocket(1234);
            socket = server.accept();
            socket.close();
        } catch (IOException err) {
            System.out.println(err.toString());
        }
    }
}