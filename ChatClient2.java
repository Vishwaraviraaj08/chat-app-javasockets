import java.io.*;
import java.net.*;

public class ChatClient2 {
    public static void main(String[] args) throws IOException {
        Socket socket = null;
        PrintWriter outMessage = null;
        BufferedReader inMessage = null;

        try {
            socket = new Socket("localhost", 8008);
            outMessage = new PrintWriter(socket.getOutputStream(), true);
            inMessage = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
            System.exit(0);
        }

        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        String userInput;
        while ((userInput = stdIn.readLine()) != null) {
            outMessage.println(userInput);
            System.out.println("client1: " + inMessage.readLine());
        }
        outMessage.close();
        inMessage.close();
        stdIn.close();
        socket.close();
    }
}
