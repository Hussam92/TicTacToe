package com.itani.api;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

// Server starts a connection via socket
// Clients connect to the server via socket and sends messages
public class Server implements Runnable {
    
    @Override
    public void run() {
        try (// TODO Auto-generated method stub
            ServerSocket serverSocket = new ServerSocket(8000)) {
            Socket client = serverSocket.accept();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    class ClientHandler implements Runnable {
        
        @Override
        public void run() {
            // TODO Auto-generated method stub
            
        }
    }
}
