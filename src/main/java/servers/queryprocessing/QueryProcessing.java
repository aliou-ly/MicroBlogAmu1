package servers.queryprocessing;

import java.net.Socket;

public interface QueryProcessing {
    void setSocket(Socket socket);
    void setRequest(String request);
    void executeProcess();
}
