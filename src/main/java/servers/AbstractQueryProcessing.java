package servers;

import java.net.Socket;

public class AbstractQueryProcessing implements QueryProcessing {
    private Socket socket;

    @Override
    public void setSocket(Socket socket) {
        this.socket =  socket;
    }
}
