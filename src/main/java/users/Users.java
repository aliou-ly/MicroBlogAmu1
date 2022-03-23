package users;

import requests.messages.Messages;
import requests.Requests;

import java.io.IOException;

public interface Users<E> extends Authors {

    public void shareMessage(Requests request) throws IOException;
    public void readMessage(Messages message);
    public void register(Users<E> user);
    public void unRegisters(Users<E> user);
}
