package servers.queryprocessing;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import servers.queryprocessing.AbstractQueryProcessing;

import java.io.IOException;
import java.util.Scanner;

public class ReplyProcesssing extends AbstractQueryProcessing {
    @Override
    public void executeProcess() throws IOException, ParseException {

        separate();
        JSONObject jsonObjectFile  = getJsonObjectFile(publishAuthorsFile);
        String author  = getHeaderNextValue();
        String msgID = getHeaderNextValue();
        if (jsonObjectFile.containsKey(author)) {
            JSONObject jsonAuthor = (JSONObject) jsonObjectFile.get(author);
            JSONObject listMessage  = (JSONObject) jsonAuthor.get("listMessage");
            if (listMessage.containsKey(msgID)) {
                JSONObject jsonID = new JSONObject();
                jsonID.put("replyToId",msgID);
                jsonID.put("text",message);
            }
        }
    }
}
