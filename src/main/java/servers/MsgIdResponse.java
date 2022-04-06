package servers;

public class MsgIdResponse extends AbstractResponses{

    protected MsgIdResponse(String message) {
        super("MSG_IDS");
        this.message = message;
    }
}
