package servers.queryprocessing;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import servers.ErrorResponse;
import servers.Responses;

import java.io.IOException;
import java.util.Scanner;

public class RepublishProcessing extends AbstractQueryProcessing {

    @Override
    public Responses executeProcess() throws IOException, ParseException {
        separate();

        JSONParser parser  = new JSONParser();

        setReader(publishAuthorsFile);
        JSONObject jsonObjectFile = (JSONObject) parser.parse(reader);

        Scanner headerScanner = new Scanner(header);
        headerScanner.next();
        Scanner scanner = new Scanner(headerScanner.next()).useDelimiter(":");
        scanner.next();
        String author = scanner.next();
        scanner = new Scanner(headerScanner.next()).useDelimiter(":");
        scanner.next();
        String msgID = scanner.next();

        if (jsonObjectFile.containsKey(author)) {

            JSONObject authorJson = (JSONObject) jsonObjectFile.get(author);

            JSONObject listMessage = (JSONObject) authorJson.get("listMessage");

            if (listMessage.containsKey(msgID)) {

                JSONObject messageJson = (JSONObject) listMessage.get(msgID);
                messageJson.replace("republished",true);

                listMessage.replace(msgID,messageJson);


                authorJson.replace("listMessage",listMessage);
                jsonObjectFile.replace(author,authorJson);


                write(jsonObjectFile, publishAuthorsFile);
                return new OkResponse();

            }

        }
        return new ErrorResponse();
    }
}
