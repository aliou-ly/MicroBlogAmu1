import servers.HandleServer;
import users.Users;

import java.io.IOException;
import java.net.ServerSocket;

public class MainServer {
    static Users<String> testUser;


    public static void main(String[] args) throws IOException {
        new HandleServer(new ServerSocket(12345).accept()).run();

    }
}
