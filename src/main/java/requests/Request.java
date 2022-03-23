package requests;

import requests.headers.Headers;
import requests.messages.Messages;
import responses.Responses;

public class Request implements Requests {

    private Headers header;
    private Messages message;
    private Responses response;

    public Request(Headers header, Messages message) {
        this.header = header;
        this.message = message;
    }

    @Override
    public Messages getMessage() {
        return message;
    }

    @Override
    public Responses getResponse() {
        return null;
    }

    @Override
    public void setResponse(Responses response) {

    }

    @Override
    public Headers getHeader() {
        return header;
    }


}
