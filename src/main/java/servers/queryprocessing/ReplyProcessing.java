package servers.queryprocessing;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import servers.ErrorResponse;
import servers.Responses;

import java.io.IOException;
import java.util.Date;
import java.util.Scanner;

public class ReplyProcessing extends AbstractQueryProcessing {

    @Override
    public Responses executeProcess() throws IOException, ParseException {

        separate();
        JSONObject jsonObjectFile  = getJsonObjectFile(publishAuthorsFile);

        Scanner headerScanner = new Scanner(header);
        headerScanner.next();
        Scanner scanner = new Scanner(headerScanner.next()).useDelimiter(":");
        scanner.next();
        String author = scanner.next();
        scanner = new Scanner(headerScanner.next()).useDelimiter(":");
        scanner.next();
        String msgID = scanner.next();

        long id = new Date().getTime();
        if (jsonObjectFile.containsKey(author)) {
            JSONObject jsonAuthor = (JSONObject) jsonObjectFile.get(author);
            JSONObject listMessage  = (JSONObject) jsonAuthor.get("listMessage");
            if (listMessage.containsKey(msgID)) {
                JSONObject jsonID = new JSONObject();
                jsonID.put("replyToId",msgID);
                jsonID.put("text",message);
                listMessage.put(id,jsonID);
                ;
            }
            jsonAuthor.replace("listMessage",listMessage);
            jsonObjectFile.replace(author,jsonAuthor);
            JSONObject jsonMessagePublished = getJsonObjectFile(messagePublishedFile);
            jsonMessagePublished.put(id,author);
            write(jsonMessagePublished,messagePublishedFile);
            write(jsonObjectFile,publishAuthorsFile);
            return new OkResponse();
        }

    return new ErrorResponse();
    }

    private String getHeaderNextValue() {
        return null;
    }
}
