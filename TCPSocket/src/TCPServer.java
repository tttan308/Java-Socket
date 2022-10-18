import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
    public static void main(String[] args) {
        try{
            ServerSocket server = new ServerSocket(55555);
            System.out.println("Server is running...");
            
            while(true){
                // accept lang nghe yeu cau ma client gui toi
                Socket socket = server.accept();
                // luong doc
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                // luong ghi
                PrintWriter writer = new PrintWriter(socket.getOutputStream());

                //doc du lieu tu luong doc
                String line = reader.readLine();

                System.out.println("Received data!");
                writer.println("Sent: " + line.toUpperCase());

                // day du lieu dem ra khoi bo dem
                writer.flush();

                //dong cac luong
                reader.close();
                writer.close();
                socket.close();
            }
        } catch (Exception e) 
        {
            e.printStackTrace();
        }
    }
}
