package ServerClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;

public class Client {

    static int port = 6600;

    public static void main(String[] args) {
        System.out.println("\t\t Simple Client");
        System.out.println("\t\t================\n\n");

        try {
            InetAddress ipAddress = InetAddress.getLocalHost(); // Replace with server IP if necessary
            try (Socket socket = new Socket(ipAddress, port);
                 BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

                System.out.println("Server is connected....\n\n");

                String input = in.readLine();
                if (input != null) {
                    System.out.println("Server Says: " + input);
                } else {
                    System.out.println("No message received from the server.");
                }

                System.out.println("Closing Connection.....");
            }
        } catch (IOException e) {
            System.err.println("Error occurred while connecting to the server: " + e.getMessage());
        }
    }
}
