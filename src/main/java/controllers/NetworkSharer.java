package controllers;

import requests.Requests;

import java.io.*;
import java.net.Socket;

public class NetworkSharer implements Sharers{

    @Override
    public void share(Requests request) throws IOException {
        Socket socketUser = new Socket("localhost", 12345);
        PrintWriter out  = new PrintWriter(socketUser.getOutputStream());
        BufferedReader in = new BufferedReader(new InputStreamReader(socketUser.getInputStream()));

        out.println(request);
        System.out.println(in.readLine());

        out.flush();
        out.close();
        in.close();
        socketUser.close();

    }
}
