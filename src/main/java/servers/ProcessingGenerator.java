package servers;

import servers.QueryProcessingGenerator;
import servers.queryprocessing.PublishQueryProcessing;
import servers.queryprocessing.QueryProcessing;
import servers.queryprocessing.RepublishProcessing;

public class ProcessingGenerator implements QueryProcessingGenerator<QueryProcessing,String> {
    @Override
    public QueryProcessing accept(String element) {

        return getProcessing(element);
    }

    private QueryProcessing getProcessing(String code) {
        switch (code) {
            case "PUBLISH":
                return new PublishQueryProcessing();
            case "REPUBLISH":
                return new RepublishProcessing();
            default:
                return null;

        }
    }
}
