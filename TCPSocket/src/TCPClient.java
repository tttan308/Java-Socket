import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class TCPClient {
    public static void main(String[] args) {
        try{
            Socket socket = new Socket("127.0.0.1", 55555);
            System.out.println("Connected to server!");

            // luong doc
            BufferedReader readerClient = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            // luong ghi
            PrintWriter writerClient = new PrintWriter(socket.getOutputStream());

            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter data: ");
            String line = scanner.nextLine();

            System.out.println("Sent data!");
            writerClient.println(line);
            writerClient.flush();
;
            System.out.println("Received: " + readerClient.readLine());
            System.out.println(readerClient.readLine());
            
             //dong cac luong
             readerClient.close();
             writerClient.close();
             socket.close();
        } catch (Exception e) 
        {
            e.printStackTrace();
        }
    }
}
