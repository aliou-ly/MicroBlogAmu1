package servers.queryprocessing;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class PublishQueryProcessing extends AbstractQueryProcessing {
    public static Reader reader;

    static {
        try {
            reader = Files.newBufferedReader(Path.of("publish.json"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void  executeProcess() throws IOException, ParseException {
        separate();
        JSONParser parser = new JSONParser();
        JSONObject jsonObjectFile = (JSONObject) parser.parse(reader);
        Scanner headerScanner = new Scanner(this.header);
        long id  = new Date().getTime();
        headerScanner.next();
        headerScanner = new Scanner(headerScanner.next()).useDelimiter(":");
        headerScanner.next();
        String author = headerScanner.next();

        if (jsonObjectFile.containsKey(author)) {
            JSONObject details  = (JSONObject) jsonObjectFile.get(author);
            JSONObject listMessage  = (JSONObject) details.get("listMessage");
            listMessage.put(id,this.message);

            details.replace("listMessage",listMessage);
            jsonObjectFile.replace(author,details);
        } else {
            JSONObject listMessage = new JSONObject();
            listMessage.put(id,this.message);

            jsonObjectFile.put(author,
                    new JSONObject().put("listMessage",listMessage));

        }

        try (FileWriter file = new FileWriter("publish.json")) {
            //We can write any JSONArray or JSONObject instance to the file
            file.write(jsonObjectFile.toString());
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
