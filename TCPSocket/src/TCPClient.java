import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class TCPClient {
    public static void main(String[] args) {
        try{
            Socket socket = new Socket("localhost", 55555);
            System.out.println("Connected to server!");

            // luong doc
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            // luong ghi
            PrintWriter writer = new PrintWriter(socket.getOutputStream());

            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter data: ");
            String line = scanner.nextLine();

            System.out.println("Sent data!");
            writer.println(line);
            writer.flush();

            String lineSent = reader.readLine();
            System.out.println("Received: " + lineSent);

            System.out.println("Received: " + reader.readLine());
            
             //dong cac luong
             reader.close();
             writer.close();
             socket.close();
        } catch (Exception e) 
        {
            e.printStackTrace();
        }
    }
}
