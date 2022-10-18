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
                BufferedReader readerServer = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                // luong ghi
                PrintWriter writerServer = new PrintWriter(socket.getOutputStream());

                //doc du lieu tu luong doc
                String line = readerServer.readLine();

                System.out.println("Received data!");
                System.out.println("Sent: " + line.toUpperCase());
                writerServer.println("UpperCase Success!");
                writerServer.println("Close connection!");
                
                // day du lieu dem ra khoi bo dem
                writerServer.flush();

                //dong cac luong
                readerServer.close();
                writerServer.close();
                socket.close();
            }
        } catch (Exception e) 
        {
            e.printStackTrace();
        }
    }
}
