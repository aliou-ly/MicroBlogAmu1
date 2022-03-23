package factories;

import requests.Requests;
import users.Users;

import java.io.IOException;

public interface RequestFactory {

    Requests createPublishRequest(Users<String> user);

    Requests createReceiveMSGIDRequest() throws IOException;

    Requests createReceiveMSGRequest();

    Requests  createReplyMSGRequest(Users<String> author) throws IOException;

    Requests createRepublishRequest(Users<String> author);
}
