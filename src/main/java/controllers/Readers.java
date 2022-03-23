package controllers;

import requests.messages.Messages;

public interface Readers<E> {

    public void read(Messages message);
}
