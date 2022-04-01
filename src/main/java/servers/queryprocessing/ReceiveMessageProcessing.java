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
            JSONObject jsonObject = getJsonObjectFile(publishAuthorsFile);
            String author = publishedMessage.get(msgID).toString();
            JSONObject jsonAuthor = (JSONObject) jsonObject.get(author);
            JSONObject jsonMessage  = (JSONObject) jsonAuthor.get("listMessage");
            JSONObject jsonID = (JSONObject) jsonMessage.get(msgID);
            StringBuilder builder = new StringBuilder();
            builder.append(author)
                    .append(" "+msgID);
            if (jsonID.containsKey("replyToId")) {
                builder.append(" replyToId:")
                        .append(jsonID.get("replyToId"));
            }
            if (jsonID.containsKey("republished")) {
                builder.append(" republished:")
                        .append(jsonID.get("republished"));
            };
            builder.append("\n").append(jsonID.get("text"));
            return new MsgResponse(builder.toString());
        }
        return new ErrorResponse();
    }
    
}
