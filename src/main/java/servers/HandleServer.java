package servers;

import javax.swing.plaf.ScrollBarUI;
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
        this.generator = new ProcessingGenetor();
    }

    @Override
    public void run() {
        String buffer = null;

        try {
            buffer = in.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (buffer != null) {
           Scanner scanner = new Scanner(buffer);
           while (scanner.hasNext()) {
                generator.accept(scanner.next()).setSocket(this.socket);
           }
           out.flush();
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