import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import users.NetworkUser;
import users.Users;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Iterator;

public class MainServer {
    static Users<String> testUser;


    public static void main(String[] args) throws IOException, ParseException {
        testUser  = new NetworkUser("@testUser","localhost",12345);
        Reader reader = Files.newBufferedReader(Path.of("Publish.json"));
        JSONParser parser = new JSONParser();
        JSONArray jsonArray = (JSONArray) parser.parse(reader);
       // System.out.println(jsonArray);

        for (Iterator it = jsonArray.stream().iterator(); it.hasNext(); ) {
            JSONObject jsonObject1 = (JSONObject) it.next();
            if (jsonObject1.containsKey("@testUser")) ;
                JSONObject details = (JSONObject) jsonObject1.get("@testUser");
                JSONArray ListMessage  = (JSONArray) details.get("Message List");
                System.out.println(ListMessage);
                JSONObject newMessage = new JSONObject();
                newMessage.put("id2","bidue");
                newMessage.put("text","bdjceaoks");
                ListMessage.add(newMessage);

            try (FileWriter file = new FileWriter("Publish.json")) {
                //We can write any JSONArray or JSONObject instance to the file
                file.write(String.valueOf(jsonArray));
                file.flush();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
