package users;

import factories.Factory;
import requests.Requests;

import java.io.IOException;

public class MainClient {
    public static void main(String[] args) throws IOException {
        Users<String> testUser = new NetworkUser("@testUser5","localhost",12345);

        Requests requests = new Factory().createPublishRequest(testUser);
        testUser.shareMessage(requests);

        //Requests requests1 = new Factory().createRepublishRequest(testUser);
        //testUser.shareMessage(requests1);
        }

    }
