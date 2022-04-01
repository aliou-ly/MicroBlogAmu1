package servers;

import servers.queryprocessing.*;

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
            case "RCV_MSG":
                return new ReceiveMessageProcessing();
            default:
                return null;

        }
    }
}
