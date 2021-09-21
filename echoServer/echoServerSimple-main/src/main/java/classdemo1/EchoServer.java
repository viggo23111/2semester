package classdemo1;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Locale;
import java.util.Scanner;

public class EchoServer {
    public static final int DEFAULT_PORT = 2345;
    private ServerSocket serverSocket;

    //Protocol
    //Send besked til klient lige efter han er connected

    private void handleClient(Socket socket) throws IOException {
        PrintWriter pw = new PrintWriter(socket.getOutputStream(),true);
        Scanner scanner = new Scanner(socket.getInputStream());
        pw.println("You are connected, send a string to make it uppercase, send 'stop' to stop the connection");
        String message = scanner.nextLine();
        while(!message.equals("stop")){
            pw.println(message.toUpperCase());
            message = scanner.nextLine();
        }
        pw.println("Connection is closing");
        socket.close();
    }

    private void startServer(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        System.out.println("Server started, listening on : " +port);

        while(true) {
            System.out.println("Waiting for a client");
            Socket socket = serverSocket.accept(); //Blocking call
            System.out.println("New client connected");
            handleClient(socket);
        }
    }

    public static void main(String[] args) throws IOException {
        int port = DEFAULT_PORT;
        if(args.length==1){
            try {
                port = Integer.parseInt(args[0]);
            }catch (NumberFormatException e){
                System.out.println("Invalid port number using default port:" + DEFAULT_PORT);
            }
        }
        new EchoServer().startServer(port);
    }
}
