package servers.queryprocessing;

import servers.queryprocessing.QueryProcessing;

import java.net.Socket;
import java.util.Scanner;

public abstract class AbstractQueryProcessing implements QueryProcessing {
    protected Socket socket;
    protected String request;
    protected String header;
    protected String message;

    @Override
    public void setSocket(Socket socket) {
        this.socket =  socket;
    }

    @Override
    public void setRequest(String request) {
        this.request = request;
    }

    void separate() {
        Scanner scanner = new Scanner(request);
        this.header  = scanner.nextLine();
        StringBuilder stringBuilder = new StringBuilder();

        while (scanner.hasNextLine()) {
            stringBuilder.append(scanner.hasNextLine());
        }
        message = stringBuilder.toString();
    }
}
