package controllers;

import requests.Requests;

import java.io.IOException;

public interface Sharers {
    public void share(Requests request) throws IOException;
}
