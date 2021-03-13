package com.example.se2_einzelbeispiel;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
    public static void main(String[] args) throws Exception {
        String clientSentence;
        String capitalizedSentence;

        //Erstellen von WelcomeSocket mit Port
        ServerSocket welcomeSocket = new ServerSocket(53212);

        while (true){
            Socket connectionSocket = welcomeSocket.accept();

            BufferedReader inFromClient= new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));

            DataOutputStream outToClient= new DataOutputStream(connectionSocket.getOutputStream());
            clientSentence=inFromClient.readLine();

            capitalizedSentence=clientSentence.toUpperCase()+'\n';

            outToClient.writeBytes(capitalizedSentence);
        }
    }
}
