package server;

import java.io.*;
import java.net.*;
import java.util.*;


public class ChatServer {
    private static final int PORT = 12345; // Server port
    private static Map<String, PrintWriter> clients = Collections.synchronizedMap(new HashMap<>());

    public static void main(String[] args) {
        System.out.println("Chat Server started...");
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            while (true) {
                Socket clientSocket = serverSocket.accept();
                new ClientHandler(clientSocket).start();
            }
        } catch (IOException e) {
            System.err.println("Error starting server: " + e.getMessage());
        }
    }

    private static class ClientHandler extends Thread {
        private Socket socket;
        private String userId;
        private PrintWriter out;

        public ClientHandler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try (
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            ) {
                out = new PrintWriter(socket.getOutputStream(), true);
                userId = "User" + socket.getPort(); // Assign unique ID
                clients.put(userId, out);
                broadcastMessage("Server: " + userId + " has joined the chat.");

                String message;
                while ((message = in.readLine()) != null) {
                    broadcastMessage(userId + ": " + message);
                }
            } catch (IOException e) {
                System.err.println("Error handling client: " + e.getMessage());
            } finally {
                if (userId != null) {
                    clients.remove(userId);
                    broadcastMessage("Server: " + userId + " has left the chat.");
                }
                try {
                    socket.close();
                } catch (IOException e) {
                    System.err.println("Error closing socket: " + e.getMessage());
                }
            }
        }

        private void broadcastMessage(String message) {
            synchronized (clients) {
                for (PrintWriter clientOut : clients.values()) {
                    clientOut.println(message);
                }
            }
        }
    }
}
