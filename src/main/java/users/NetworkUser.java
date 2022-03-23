package users;

import controllers.NetworkSharer;

import java.io.IOException;

public class NetworkUser extends AbstractUsers<String> implements NetworkUsers {
    private String host;
    private int port;

    public NetworkUser(String nameUser, String host, int port) throws IOException {

        super(nameUser,new NetworkSharer(),null);
        this.host = host;
        this.port = port;
    }

    @Override
    public int getPort() {
        return port;
    }

    @Override
    public String getHost() {
        return host;
    }
}
