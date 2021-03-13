package com.example.se2_einzelbeispiel;

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

    }
}
