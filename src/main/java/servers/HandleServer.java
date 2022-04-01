package servers;

import org.json.simple.parser.ParseException;
import servers.queryprocessing.QueryProcessing;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class HandleServer extends Thread {
    private Socket socket;
    private PrintWriter out;
    private BufferedReader in;
    private QueryProcessingGenerator<QueryProcessing,String> generator;

    public HandleServer(Socket socket) throws IOException {
        this.socket = socket;
        this.out = new PrintWriter(this.socket.getOutputStream());
        this.in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        this.generator = new ProcessingGenerator();
    }

    @Override
    public synchronized void run() {
        String buffer = null;

        StringBuilder builder  = new StringBuilder();
        Scanner scanner1 = new Scanner(in);

        if (scanner1.hasNextLine()) {
            while (scanner1.hasNextLine())
                builder.append(scanner1.nextLine()+"\n");

            buffer = builder.toString();
        }


        if (buffer != null) {
            Scanner scanner = new Scanner(buffer);
            QueryProcessing queryProcessing;
            queryProcessing = generator.accept(scanner.next());

            queryProcessing.setSocket(this.socket);
            queryProcessing.setRequest(buffer);

            try {
                queryProcessing.executeProcess();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

        out.close();
        try {
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
