import java.io.*;
import java.net.*;

public class ChatServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;
        Socket clientSocket1 = null;
        Socket clientSocket2 = null;

        try {
            serverSocket = new ServerSocket(8008);
            System.out.println("Server started.");
            System.out.println("Waiting for clients to connect...");

            clientSocket1 = serverSocket.accept();
            System.out.println("Client 1 connected.");
            PrintWriter out1 = new PrintWriter(clientSocket1.getOutputStream(), true);
            BufferedReader in1 = new BufferedReader(new InputStreamReader(clientSocket1.getInputStream()));

            clientSocket2 = serverSocket.accept();
            System.out.println("Client 2 connected.");
            PrintWriter out2 = new PrintWriter(clientSocket2.getOutputStream(), true);
            BufferedReader in2 = new BufferedReader(new InputStreamReader(clientSocket2.getInputStream()));

            String inputLine1, inputLine2;
            while (true) {
                if ((inputLine1 = in1.readLine()) != null) {
                    System.out.println("Client 1: " + inputLine1);
                    out2.println(inputLine1);
                }
                if ((inputLine2 = in2.readLine()) != null) {
                    System.out.println("Client 2: " + inputLine2);
                    out1.println(inputLine2);
                }
            }
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
            System.exit(1);
        } finally {
            if (clientSocket1 != null) {
                clientSocket1.close();
            }
            if (clientSocket2 != null) {
                clientSocket2.close();
            }
            if (serverSocket != null) {
                serverSocket.close();
            }
        }
    }
}
