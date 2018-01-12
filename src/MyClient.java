import java.net.*;
import java.io.*;

/**
 * @author : akira.shinohara
 * @since : 2018/01/12
 */
public class MyClient {
    public static void main(String[] args) {
        MyClientSocket mcs = new MyClientSocket();
    }
}

class MyClientSocket {
    Socket socket;
    
    MyClientSocket() {
        try {
            Socket socket = new Socket(InetAddress.getByName("127.0.0.0"), 1234);
        } catch (IOException err) {
            System.out.println(err.toString());
        }
    }
}