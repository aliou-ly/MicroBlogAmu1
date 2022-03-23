package controllers;

import requests.Requests;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class NetworkSharer implements Sharers{

    @Override
    public void share(Requests request) throws IOException {
        Socket socketUser = new Socket("localhost", 12345);
        PrintWriter out  = new PrintWriter(socketUser.getOutputStream());

        out.println(request.getHeader());
        out.println(request.getMessage());

        out.flush();
        out.close();
        socketUser.close();

    }
}
