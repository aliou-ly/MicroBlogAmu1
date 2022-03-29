package servers.queryprocessing;

import org.json.JSONObject;
import servers.queryprocessing.AbstractQueryProcessing;

import java.util.Scanner;

public class PublishQueryProcessing extends AbstractQueryProcessing {


    @Override
    public void executeProcess() {
        separate();
        String author, authorValue;
        Scanner scanner = new Scanner(this.header);
        scanner.next();
        Scanner scanner1 = new Scanner(scanner.next()).useDelimiter(":");
        author = scanner1.next();
        authorValue = scanner1.next();
        JSONObject jsonObject = new JSONObject();


    }
}
