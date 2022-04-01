import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import servers.HandleServer;
import users.NetworkUser;
import users.Users;

import java.io.IOException;
import java.net.ServerSocket;

public class MainServer {
    static Users<String> testUser;


    public static void main(String[] args) throws IOException, ParseException {
        testUser  = new NetworkUser("@testUser","localhost",12345);

        while(true){
            new HandleServer(new ServerSocket(12345).accept()).run();
        }
    }
}

