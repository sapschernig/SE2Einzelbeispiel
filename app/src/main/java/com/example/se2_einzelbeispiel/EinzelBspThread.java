package com.example.se2_einzelbeispiel;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class EinzelBspThread  extends Thread{
    public String matrNr;
    public String antwortServer;

    public EinzelBspThread(String matrNr) {
        this.matrNr = matrNr;
    }

    public String getMatrNr() {
        return matrNr;
    }

    public void setMatrNr(String matrNr) {
        this.matrNr = matrNr;
    }

    public String getAntwortServer() {
        return antwortServer;
    }

    public void setAntwortServer(String antwortServer) {
        this.antwortServer = antwortServer;
    }

    @Override
    public void run() {
        String matrNr= this.matrNr;

        //BufferedReader inFromUser= new BufferedReader(new InputStreamReader(System.in));
        try {

            //create client socket, connect to server
            Socket clientSocket= new Socket("se2-isys.aau.at", 53212);

            //Create output stream attached to socket
            DataOutputStream outToServer= new DataOutputStream(clientSocket.getOutputStream());

            //create input stream attached to socket
            BufferedReader inFromServer=new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            //sends Matrikelnummer to server
            outToServer.writeBytes(matrNr +'\n');

            //reads line from server, saves it in antwortServer
            this.antwortServer=inFromServer.readLine();

            clientSocket.close();

        } catch (IOException e){
            //throw Exception when not able to connect
            this.antwortServer="ERROR while connecting";

        }
    }

}
