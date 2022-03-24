import groovy.json.JsonBuilder;
import org.json.JSONArray;
import org.json.JSONObject;
import servers.HandleServer;
import users.Users;

import java.io.IOException;
import java.net.ServerSocket;

public class MainServer {
    static Users<String> testUser;


    public static void main(String[] args) throws IOException {
        JSONObject test = new JSONObject();
        test.put("author","testUser");
        test.put("msgId","sjwdkjw");
        test.put("limit",5);

        JSONObject test2 = new JSONObject();
        test2.put("author","dhj");
        test2.put("msgId"," dsdwgs");
        test2.put("limit",0);

        JSONArray msg = new JSONArray();
        msg.put(test);
        msg.put(test2);
        System.out.println(msg);
    }
}
