import factories.Factory;
import groovy.json.JsonBuilder;
import groovy.json.JsonParser;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONWriter;
import requests.Requests;
import servers.HandleServer;
import users.NetworkUser;
import users.Users;

import java.io.FileWriter;
import java.io.IOException;
import java.net.ServerSocket;
import java.util.Scanner;

public class MainServer {
    static Users<String> testUser;


    public static void main(String[] args) throws IOException {
        testUser = new NetworkUser("@testUser","localhost",12345);
        JSONObject jsonObject = new JSONObject();
        Factory factory = new Factory();
        Requests request = factory.createPublishRequest(testUser);
        System.out.println(request);
        Scanner scanner = new Scanner(request.toString());
        scanner.next();
        Scanner scanner1 = new Scanner(scanner.next()).useDelimiter(":");
        jsonObject.put(scanner1.next(),scanner1.next());
        StringBuilder message  = new StringBuilder();
        while (scanner.hasNextLine())
            message.append("\n").append(scanner.nextLine());
        jsonObject.put("message",message);
        System.out.println("\njsonObjet: "+jsonObject);


    }
}
