import util.Parser;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class WebServer {

    // server initialization
    private ServerSocket serverSocket = null;
    private Socket socket = null;
    private DataInputStream in = null;
    private int port;

    public WebServer(int port) {
        this.port = port;
    }

    public void start() {

        try {

            System.out.println("Starting server...");
            serverSocket = new ServerSocket(port);
            System.out.println("Server started on port " + port);

            System.out.println("Waiting for a client...");
            socket = serverSocket.accept();
            System.out.println("Client accepted");

            in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
            String line = "";

            while (!line.equals("Over")) {
                try {

                    line = in.readUTF();
                    System.out.println(line);

                } catch(Exception e) {

                    System.out.println("Error occurred while reading message: " + e);

                }
            }

            System.out.println("Closing connection");
            socket.close();
            in.close();

        } catch (Exception e) {

            System.out.println("Error occurred while starting server: " + e);

        }

    }

}
