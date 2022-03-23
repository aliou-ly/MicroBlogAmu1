package requests.headers;

import users.Users;

public class RepublishHeader extends AbstractHeader{

    Users<String> author;
    String msgId;

    public RepublishHeader(Users<String> author, String msgId) {
        super("REPUBLISH");
        this.author = author;
        this.msgId = msgId;
    }

    @Override
    public String toString() {

        return super.toString()
                .concat(" author:"+this.author)
                .concat(" msg_id:"+this.msgId);
    }
}
