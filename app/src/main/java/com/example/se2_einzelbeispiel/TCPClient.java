package com.example.se2_einzelbeispiel;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class TCPClient {

    public static void main(String[] args) throws Exception {
        String sentence;
        String modifiedSentence;

        //Create input Stream
        BufferedReader inFromUser= new BufferedReader(new InputStreamReader(System.in));

        //Create client socket, connect to Server
        Socket clientSocket = new Socket("se2-isys.aau.at", 53212);

        //Create output stream attached to socket
        DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());

        //Create input Stream attached to socket
        BufferedReader inFromServer= new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        sentence = inFromUser.readLine();

        //Send line to server
        outToServer.writeBytes(sentence+ '\n');

        //read line from server
        modifiedSentence=inFromServer.readLine();

        System.out.println("Antwort vom Server: "+modifiedSentence);

        clientSocket.close();
    }
}
