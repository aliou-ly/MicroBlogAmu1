package requests.messages;

import users.Authors;
import users.Users;

import java.util.Date;

public class TextMessage implements Messages {
    private String msgId;
    private String text;
    private boolean read;
    private Users<String> author;
    private Date sendDate;

    public TextMessage(Users<String> author) {
        this.author = author;
        this.read = false;
        this.sendDate = new Date();
    }

    @Override
    public String getID() {
        return msgId;
    }

    @Override
    public String toString() {

        return author.toString()+" "+sendDate+ "\n"
                +text;
    }

    @Override
    public Authors getAuthor() {
        return author;
    }

    @Override
    public boolean isReaded() {
        return read;
    }


    public void setRead(boolean read) {
        this.read = read;
    }

    @Override
    public void setText(String message) {
        this.text = message;
    }

    public void setMsgId(String msgId) {
        this.msgId = msgId;
    }
}
