import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;


public class UDPServer {
    public static void main(String[] args) {
        try{
            DatagramSocket datagramSocket = new DatagramSocket(55555);

            byte[] readBuffer = new byte[1024];
            byte[] writeBuffer = null;

            System.out.println("Server is running...");
            
            while(true){
                DatagramPacket receivePacket = new DatagramPacket(readBuffer, readBuffer.length);

                datagramSocket.receive(receivePacket);

                String line = new String(receivePacket.getData());

                writeBuffer = line.toUpperCase().getBytes();
                InetAddress clientAddress = receivePacket.getAddress();
                int clientPort = receivePacket.getPort();

                DatagramPacket sendPacket = new DatagramPacket(writeBuffer, writeBuffer.length, clientAddress, clientPort);
                datagramSocket.send(sendPacket);
                System.out.println("Sent! ");
            }
        } catch (Exception e) 
        {
            e.printStackTrace();
        }
    }
}
