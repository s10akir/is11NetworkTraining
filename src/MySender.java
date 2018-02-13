import java.io.IOException;
import java.net.*;

/**
 * @author : akira.shinohara
 * @since : 2018/02/09
 */
public class MySender {
    public static void main(String[] args) {
        MySenderDatagram msd = new MySenderDatagram();
    }
}

class MySenderDatagram {
    DatagramPacket packet;
    MulticastSocket socket;

    MySenderDatagram() {
        try {
            byte buffer[] = "スマホrpgは今これをやってるよ。今のジョブはこれ! -> https://afrel.co.jp ".getBytes();
            packet = new DatagramPacket(buffer, buffer.length, InetAddress.getByName("224.1.1.8"), 10008);
            socket = new MulticastSocket();

            while (true) {
                try {
                    Thread.sleep(1000);
                    socket.send(packet);
                } catch (InterruptedException err) {
                    err.printStackTrace();
                }
            }
        } catch (IOException err) {
            err.printStackTrace();
        }
    }
}