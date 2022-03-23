package servers;

public class ProcessingGenetor implements QueryProcessingGenerator<QueryProcessing,String> {
    @Override
    public QueryProcessing accept(String element) {
        return null;
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
