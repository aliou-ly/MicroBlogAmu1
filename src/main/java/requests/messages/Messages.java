package requests.messages;

import users.Authors;

public interface Messages {

     String getID();

     String toString();

     Authors getAuthor();

    default boolean isReaded() {
        return false;
    }

    void setRead(boolean read);

    void setText(String message);
}
