package com.example.se2_einzelbeispiel;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class EinzelBspThread  extends Thread{
    public String MatrNr;
    public String antwortServer;

    public String getMatrNr() {
        return MatrNr;
    }

    public void setMatrNr(String matrNr) {
        this.MatrNr = matrNr;
    }

    public String getAntwortServer() {
        return antwortServer;
    }

    public void setAntwortServer(String antwortServer) {
        this.antwortServer = antwortServer;
    }

    @Override
    public void run() {
        Socket clientSocket=null;
        try {
            //create client socket, connect to server
            clientSocket= new Socket("se2-isys.aau.at", 53212);

            //Create output stream attached to socket
            DataOutputStream outToServer= new DataOutputStream(clientSocket.getOutputStream());

            //create input stream attached to socket
            BufferedReader inFromServer=new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            //sends Matrikelnummer to server
            outToServer.writeBytes(this.MatrNr +'\n');

            //reads line from server, saves it in antwortServer
            this.antwortServer=inFromServer.readLine();

        } catch (IOException e){
            //throw Exception when not able to connect
            this.antwortServer="ERROR while connecting";

        } finally {

        }
    }
}
