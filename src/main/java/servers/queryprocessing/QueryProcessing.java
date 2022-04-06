package servers.queryprocessing;

import org.json.simple.parser.ParseException;
import servers.Responses;

import java.io.IOException;
import java.net.Socket;

public interface QueryProcessing {
    void setSocket(Socket socket);
    void setRequest(String request);
    Responses executeProcess() throws IOException, ParseException;
}
