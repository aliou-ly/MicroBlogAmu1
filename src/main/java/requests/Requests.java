package requests;

import requests.headers.Headers;
import requests.messages.Messages;
import responses.Responses;

public interface Requests {

    Headers getHeader();
    Messages getMessage();
    Responses getResponse();
    void setResponse(Responses response);
}
