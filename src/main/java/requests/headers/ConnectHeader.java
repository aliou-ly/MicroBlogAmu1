package requests.headers;

import users.Users;

public class ConnectHeader extends AbstractHeader{
    private Users<String> author;

    public ConnectHeader(Users<String> author) {
        super("CONNECT");
        this.author = author;
    }
}
