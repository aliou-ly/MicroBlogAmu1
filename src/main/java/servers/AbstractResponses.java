package servers;

public abstract class AbstractResponses implements Responses {
    protected String header;
    protected String message  = null;

    protected AbstractResponses(String header) {
        this.header = header;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(this.header);
        if (message != null) {
            builder.append("\n"+message);
        }
        return builder.toString();
    }
}