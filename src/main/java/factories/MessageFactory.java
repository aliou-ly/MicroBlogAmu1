package factories;

import requests.messages.Messages;
import requests.messages.TextMessage;
import users.Users;

import java.util.NoSuchElementException;
import java.util.Scanner;

class MessageFactory {
    private Scanner in = new  Scanner(System.in);

    public Messages createMessage(Users<String> author) {
        Messages msg = new TextMessage(author);

        try {
            msg.setText(in.nextLine());
        } catch (NoSuchElementException e) {
            msg.setText(null);
        }
        return msg;
    }
}
