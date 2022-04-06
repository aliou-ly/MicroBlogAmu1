package servers.queryprocessing;

import servers.AbstractResponses;

public class MsgResponse extends AbstractResponses {
    protected MsgResponse(String message) {
        super("MSG");
        this.message = message;
    }
}
