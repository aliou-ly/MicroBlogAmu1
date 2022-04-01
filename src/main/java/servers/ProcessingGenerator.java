package servers;

import servers.queryprocessing.PublishQueryProcessing;
import servers.queryprocessing.QueryProcessing;
import servers.queryprocessing.ReplyProcessing;
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
            case "REPLY":
                return new ReplyProcessing();
            default:
                return null;

        }
    }
}
