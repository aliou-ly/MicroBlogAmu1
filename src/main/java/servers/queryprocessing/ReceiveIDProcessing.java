package servers.queryprocessing;

import org.json.simple.parser.ParseException;
import servers.Responses;

import java.io.IOException;

public class ReceiveIDProcessing extends AbstractQueryProcessing{
    @Override
    public Responses executeProcess() throws IOException, ParseException {
        separate();
        return null;
    }
}
