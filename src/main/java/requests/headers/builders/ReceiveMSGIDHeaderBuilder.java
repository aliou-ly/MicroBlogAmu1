package requests.headers.builders;

import requests.headers.ReceiveMSGIDHeader;
import users.Users;

public class ReceiveMSGIDHeaderBuilder {
    int defaultLimit = 5;

    private Users<String> author;
    private String tag;
    private String msgId;
    private int limit = defaultLimit;

    public void setAuthor(Users<String> author) {

        this.author = author;
    }

    public void setTag(String tag) {

        this.tag = tag;
    }

    public void setMsgId(String msgId) {
        this.msgId = msgId;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }


    public ReceiveMSGIDHeader build() {
        return new ReceiveMSGIDHeader(author,tag,msgId,limit);
    }
}
