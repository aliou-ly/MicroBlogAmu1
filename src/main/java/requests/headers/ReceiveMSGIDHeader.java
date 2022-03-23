package requests.headers;

import users.Users;

public class ReceiveMSGIDHeader extends AbstractHeader{
    private Users<String> author;
    private String tag;
    private String msgId;
    private int limit;

    public ReceiveMSGIDHeader(Users<String> author, String tag, String msgId, int limit) {
        super("RCV_IDS");
        this.author = author;
        this.tag = tag;
        this.msgId = msgId;
        this.limit = limit;
    }

    @Override
    public String toString() {

        return super.toString()
                    .concat(" author:"+this.author)
                    .concat(" tag:"+this.tag)
                    .concat(" since_id:"+this.msgId)
                    .concat(" limit:"+this.limit);
    }




}
