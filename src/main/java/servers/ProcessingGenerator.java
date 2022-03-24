package servers;

import servers.QueryProcessingGenerator;
import servers.queryprocessing.PublishQueryProcessing;
import servers.queryprocessing.QueryProcessing;

public class ProcessingGenerator implements QueryProcessingGenerator<QueryProcessing,String> {
    @Override
    public QueryProcessing accept(String element) {

        return getProcessing(element);
    }

    private QueryProcessing getProcessing(String code) {
        switch (code) {
            case "PUBLISH":
                return new PublishQueryProcessing();
            default:
                return null;

        }
    }
}
