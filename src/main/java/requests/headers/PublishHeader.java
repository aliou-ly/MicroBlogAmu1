package requests.headers;

import users.Users;

public class PublishHeader extends AbstractHeader {
    private Users<String> author;

    public PublishHeader(Users<String> author) {
        super("PUBLISH");
        this.author = author;

    }

    @Override
    public String toString() {

        return super.toString()
                    .concat(" author:"+author);
    }
}