package requests.headers;

public class ReceiveMSGHeader extends AbstractHeader {
    private String msgId;

    public ReceiveMSGHeader(String msgId) {
        super("RCV_MSG");
        this.msgId = msgId;
    }

    @Override
    public String toString() {

        return super.toString()
                .concat(" msg_id:"+msgId);
    }
}
