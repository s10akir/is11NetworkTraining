import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

/**
 * @author : akira.shinohara
 * @since : 2018/02/09
 */
public class MyReceiver {
    public static void main(String[] args) {
        MyReceiverDatagram msd = new MyReceiverDatagram();
    }
}

class MyReceiverDatagram {
    DatagramPacket packet;
    MulticastSocket socket;

    MyReceiverDatagram() {
        try {
            byte buffer[] = new byte[65545];

            packet = new DatagramPacket(buffer, buffer.length);
            socket = new MulticastSocket(10008);

            socket.joinGroup(InetAddress.getByName("224.1.1.8"));


            while (true) {
                socket.receive(packet);
                System.out.println("[" + packet.getAddress() + "] "+ new String(buffer).trim());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
