package com.example.se2_einzelbeispiel;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class EinzelBspThread  extends Thread{
    public String matrNr;
    public String antwortServer;

    //Konstruktor
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

        try {
            //wie aus VO Folien
            //BufferedReader inFromUser= new BufferedReader(new InputStreamReader(System.in)); -> brauchen wir hier nicht

            //create client socket, connect to server
            Socket clientSocket= new Socket("se2-isys.aau.at", 53212);

            //Create output stream attached to socket, schicke MatrNr zum Server
            DataOutputStream outToServer= new DataOutputStream(clientSocket.getOutputStream());

            //create input stream attached to socket, gibt mir was zurück
            BufferedReader inFromServer=new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            //sentence=inFromUser.readLine(); -> brauchen wir hier nicht

            //sends Matrikelnummer to server, +'\n' damit man weiß es endet
            outToServer.writeBytes(matrNr +'\n');

            //reads line from server, saves it in antwortServer
            this.antwortServer=inFromServer.readLine();

            //schließen
            clientSocket.close();

        } catch (IOException e){
            //throw Exception when not able to connect
            this.antwortServer="ERROR while connecting";

        }
    }

}
