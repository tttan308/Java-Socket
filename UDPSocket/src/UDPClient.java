import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;


public class UDPClient {
    public static void main(String[] args) {
        try{
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter your name: ");
            String name = scanner.nextLine();

            DatagramSocket datagramSocket = new DatagramSocket();

            byte[] readBuffer = new byte[1024];
            byte[] writeBuffer = null;

            InetAddress host = InetAddress.getByName("localhost");
            int port = 55555;

            DatagramPacket sendPacket = new DatagramPacket(name.getBytes(), name.getBytes().length, host, port);
            datagramSocket.send(sendPacket);
            System.out.println("Sent! ");

            DatagramPacket receivePacket = new DatagramPacket(readBuffer, readBuffer.length);
            datagramSocket.receive(receivePacket);

            String line = new String(receivePacket.getData());
            System.out.println("Received: " + line);
        } catch (Exception e) 
        {
            e.printStackTrace();
        }
    }
}
