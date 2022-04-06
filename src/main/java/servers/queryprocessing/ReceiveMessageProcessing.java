package servers.queryprocessing;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import servers.ErrorResponse;
import servers.Responses;

import java.io.IOException;
import java.util.Scanner;

public class ReceiveMessageProcessing extends AbstractQueryProcessing {

    @Override
    public Responses executeProcess() throws IOException, ParseException {
        separate();
        JSONObject publishedMessage = getJsonObjectFile(messagePublishedFile);
        Scanner headerScanner = new Scanner(header);
        headerScanner.next();
        Scanner scanner = new Scanner(headerScanner.next()).useDelimiter(":");
        scanner.next();
        String msgID = scanner.next();

        if (publishedMessage.containsKey(msgID)) {
            String author = (String) publishedMessage.get(msgID);
            String text = getMessage(author,msgID);
            if (text != null)
                return new MsgResponse(text);
        }
        return new ErrorResponse();
    }

    private String getMessage(String author, String msgID) throws IOException, ParseException {
        JSONObject jsonObject = getJsonObjectFile(publishAuthorsFile);

        if (!jsonObject.containsKey(author))
            return null;
        JSONObject jsonAuthor = (JSONObject) jsonObject.get(author);
        JSONObject listMessage = (JSONObject) jsonAuthor.get("listMessage");

        if (!listMessage.containsKey(msgID))
            return null;
        JSONObject jsonID = (JSONObject) listMessage.get(msgID);
        StringBuilder text = new StringBuilder();

        text.append("ID:"+msgID);

        if (jsonID.containsKey("replyToId"))
            text.append(" replyToId:"+jsonID.get("replyToId"));
        if (jsonID.containsKey("republished"))
            text.append(" republished:"+jsonID.get("republished"));

        text.append("\n"+jsonID.get("text"));

        return text.toString();

    }
    
}
