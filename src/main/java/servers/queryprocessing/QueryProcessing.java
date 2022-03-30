package servers.queryprocessing;

import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.net.Socket;

public interface QueryProcessing {
    void setSocket(Socket socket);
    void setRequest(String request);
    void executeProcess() throws IOException, ParseException;
}
