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
    BufferedReader br;
    String buf;

    MyClientSocket() {
        try {
            socket = new Socket(InetAddress.getByName("127.0.0.1"), 1234);
            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            buf = br.readLine();
            System.out.println(buf);
            br.close();
            socket.close();
        } catch (IOException err) {
            System.out.println(err.toString());
        }
    }
}