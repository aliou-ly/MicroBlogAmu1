package requests.headers;

import users.Users;

public class ReplyMSGHeader extends AbstractHeader{
    private String msgId;
    private Users<String> author;
    public ReplyMSGHeader(Users<String> author, String msgId) {
        super("REPLY");
        this.msgId = msgId;
        this.author = author;
    }

    @Override
    public String toString() {
        return super.toString()
                .concat("author:"+this.author)
                .concat(" reply_to_id:"+this.msgId);
    }
}
