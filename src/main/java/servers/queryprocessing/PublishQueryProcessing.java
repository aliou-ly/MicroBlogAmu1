package servers.queryprocessing;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import servers.Responses;

import java.io.IOException;
import java.util.Date;
import java.util.Scanner;

public class PublishQueryProcessing extends AbstractQueryProcessing {


    @Override
    public Responses executeProcess() throws IOException, ParseException {
        separate();
        JSONObject jsonObjectFile = getJsonObjectFile(publishAuthorsFile);

        Scanner headerScanner = new Scanner(this.header);
        long id  = new Date().getTime();
        headerScanner.next();
        headerScanner = new Scanner(headerScanner.next()).useDelimiter(":");
        headerScanner.next();
        String author = headerScanner.next();

        JSONObject idJson = new JSONObject();
        idJson.put("republished",false);
        idJson.put("text:",message);

        if (jsonObjectFile.containsKey(author)) {
            JSONObject details  = (JSONObject) jsonObjectFile.get(author);
            JSONObject listMessage  = (JSONObject) details.get("listMessage");

            listMessage.put(id,idJson);

            details.replace("listMessage",listMessage);
            jsonObjectFile.replace(author,details);
        } else {
            JSONObject listMessage = new JSONObject();
            listMessage.put(id,idJson);

            JSONObject newList = new JSONObject();
            newList.put("listMessage",listMessage);
            jsonObjectFile.put(author, newList);

        }
        JSONObject jsonMessagePublished = getJsonObjectFile(messagePublishedFile);
        jsonMessagePublished.put(id,author);
        write(jsonMessagePublished,messagePublishedFile);
        write(jsonObjectFile, publishAuthorsFile);

        return null;
    }
}
