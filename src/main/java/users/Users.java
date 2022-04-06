package users;

import requests.messages.Messages;
import requests.Requests;

import java.io.IOException;
import java.net.Socket;

public interface Users<E> extends Authors {

    void shareMessage(Requests request) throws IOException;
    void readMessage(Messages message);
    void register(Users<E> user);
    void unRegisters(Users<E> user);
    Socket getSocket();
    void closeSocket();

}
