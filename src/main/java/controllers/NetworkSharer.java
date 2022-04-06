package controllers;

import requests.Requests;

import java.awt.desktop.SystemEventListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class NetworkSharer implements Sharers{

    @Override
    public void share(Requests request) throws IOException {
        Socket socketUser = new Socket("localhost", 12345);
        PrintWriter out  = new PrintWriter(socketUser.getOutputStream());
        BufferedReader in = new BufferedReader(new InputStreamReader(socketUser.getInputStream()));
        out.println(request);
        out.flush();
        System.out.println(in.ready());
        in.close();
        out.close();
        socketUser.close();

    }
}
