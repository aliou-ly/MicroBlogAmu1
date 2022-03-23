package requests.headers;


import users.Users;

public class RepublishMSGHeader extends AbstractHeader {
    private String msgId;
    private Users<String> author;

    protected RepublishMSGHeader(String msgId, Users<String> author) {
        super("REPUBLISH");
        this.author = author;
        this.msgId = msgId;
    }

    @Override
    public String toString() {
        return null;
    }
}
