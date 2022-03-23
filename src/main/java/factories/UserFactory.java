package factories;

import users.NetworkUser;
import users.Users;

import java.io.IOException;

public class UserFactory {

    public Users<String> createUserWithDefaultServer(String userName) throws IOException {
        return new NetworkUser(userName,"localhost", 12345);
    }

    public Users<String> createUser(String userName, String address, int port) throws IOException {
        return new NetworkUser(userName,address,port);
    }
}
