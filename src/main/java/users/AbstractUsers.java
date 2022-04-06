package users;

import controllers.Readers;
import controllers.Sharers;
import requests.messages.Messages;
import requests.Requests;

import java.io.IOException;
import java.net.Socket;

public class AbstractUsers<E> implements Users<E> {
   protected String name;
   protected Sharers sharer;
   protected Readers<E> reader;


   protected AbstractUsers(String name, Sharers sharer, Readers<E> reader) {
       this.name = name;
       this.sharer = sharer;
       this.reader = reader;
   }


    @Override
    public String toString() {
        return name;
    }

    @Override
    public void shareMessage(Requests request) throws IOException {
        this.sharer.share(request);
    }

    @Override
    public void readMessage(Messages message) {
        this.reader.read(message);
    }

    @Override
    public void register(Users<E> user) {

    }

    @Override
    public void unRegisters(Users<E> user) {

    }

    @Override
    public Socket getSocket() {
        return null;
    }

    @Override
    public void closeSocket() {

    }
}
