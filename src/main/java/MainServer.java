import groovy.json.JsonBuilder;
import org.json.JSONArray;
import org.json.JSONObject;
import servers.HandleServer;
import users.Users;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;

public class MainServer {
    static Users<String> testUser;


    public static void main(String[] args) throws IOException {
/*        JSONObject test = new JSONObject();
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
        System.out.println(msg);*/

        //Test

        JSONObject author = new JSONObject();
        author.put("author", "test");

        JSONObject author2 = new JSONObject();
        author2.put("author", "test");

        JSONObject messageDetails = new JSONObject();
        messageDetails.put("msgId", "okok");
        messageDetails.put("txt","blablabla");

        JSONObject messageDetails2 = new JSONObject();
        messageDetails2.put("msgId", "okokok");
        messageDetails2.put("txt","miamiamiam");

        //Add message to list
        JSONArray message = new JSONArray();
        message.put(messageDetails);
        message.put(messageDetails2);


        author.put("Message List", message);

        //Write JSON file
        try (FileWriter file = new FileWriter("test.json",true)) {
            //We can write any JSONArray or JSONObject instance to the file
            file.write(author.toString(4)+",\n");
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
