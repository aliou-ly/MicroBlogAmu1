package requests.headers;

import users.Users;

public class SubscribeHeaderToUser {
    private Users<String> author;

    public SubscribeHeaderToUser(Users<String> author) {
        this.author = author;
    }

    @Override
    public String toString() {

        return super.toString()
                .concat(" author:"+author);
    }
}
