package servers.queryprocessing;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import servers.queryprocessing.AbstractQueryProcessing;

import java.io.IOException;
import java.util.Scanner;

public class ReceiveMessageProcessing extends AbstractQueryProcessing {

    @Override
    public void executeProcess() throws IOException, ParseException {
        separate();
        JSONObject publishedMessage = getJsonObjectFile(messagePublishedFile);
        Scanner headerScanner = new Scanner(header);
        headerScanner.next();
        Scanner scanner = new Scanner(headerScanner.next()).useDelimiter(":");
        scanner.next();
        String msgID = scanner.next();
        if (publishedMessage.containsKey(msgID)) {
            JSONObject jsonObject = getJsonObjectFile(publishAuthorsFile);
            JSONObject jsonAuthor = (JSONObject) jsonObject.get(publishedMessage.get(msgID));
            JSONObject jsonMessage  = (JSONObject) jsonAuthor.get("listMessage");
            JSONObject jsonID = (JSONObject) jsonMessage.get(msgID);

        }
    }
    
}
