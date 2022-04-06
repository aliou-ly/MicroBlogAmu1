package servers.queryprocessing;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.net.Socket;
import java.nio.file.Files;
import java.util.Scanner;

public abstract class AbstractQueryProcessing implements QueryProcessing {
    protected Socket socket;
    protected String request;
    protected String header;
    protected String message;
    protected  Reader reader;
    private Scanner headerScanner;

    protected  static File publishAuthorsFile = new File("publish.json");
    protected static File messagePublishedFile = new File("listMessagePublished.json");


    protected JSONObject getJsonObjectFile(File file) throws IOException, ParseException { {

        setReader(file);
        JSONParser parser = new JSONParser();
        JSONObject jsonObject = (JSONObject) parser.parse(this.reader);

        return jsonObject;
    }

    }
    protected void setReader(File file) {
        synchronized (file) {
            try {
                reader = Files.newBufferedReader(file.toPath());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    protected void write(JSONObject jsonObject, File file) throws IOException {
            //We can write any JSONArray or JSONObject instance to the file

            synchronized (file) {
                FileWriter fileWriter = new FileWriter(file);
                fileWriter.write(jsonObject.toString());
                fileWriter.flush();
            }


    }
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
        //this.headerScanner = new Scanner(request).nextLine()
        StringBuilder stringBuilder = new StringBuilder();
        while (scanner.hasNextLine()) {
            stringBuilder.append(scanner.nextLine()+"\n");

        }
        message = stringBuilder.toString();
    }
    public boolean headerHasNextValue() {
        return true;
    }
}
