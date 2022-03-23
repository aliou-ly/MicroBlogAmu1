package factories;

import requests.headers.Headers;
import requests.messages.Messages;
import requests.Request;
import requests.Requests;
import users.Users;

import java.io.IOException;
import java.util.Scanner;

public class Factory implements RequestFactory {
    private final Scanner in = new Scanner(System.in);
    private final HeaderFactory headerFactory = new HeaderFactory();
    private final MessageFactory messageFactory  = new MessageFactory();
    private final UserFactory userFactory = new UserFactory();

    @Override
    public Requests createPublishRequest(Users<String> user) {

        System.out.println("Entrer le message à envoyer:\n");
        Messages msg = messageFactory.createMessage(user);
        Headers header = headerFactory.createPublishHeader(user);

        return new Request(header,msg);
    }

    @Override
    public Requests createReceiveMSGIDRequest() throws IOException {

        System.out.println("Synopsis : [@user] [#tag] [id] [limit default: 5]");
        Headers header = headerFactory.createReceiveMSGIDHeader(in.nextLine());

        return new Request(header, null);
    }

    @Override
    public Requests createReceiveMSGRequest() {
        System.out.println("Synopsis: Id");
        Headers header = headerFactory.createReceiveMSGHeader(in.nextLine());
        return new Request(header, null);
    }

    @Override
    public Requests  createReplyMSGRequest(Users<String> author) throws IOException {
        System.out.println("Synopsis: @userName id");
        String[] args = in.nextLine().split(" ");

        if (args.length != 2)
            throw new IllegalArgumentException();

        String userName = null;
        String msgId = null;

        for (String e: args) {
            if (e.charAt(0) == '@')
                userName = e;
            msgId =  e;
        }

        if (userName == null)
            throw new IllegalArgumentException();

        Users<String> userDest = userFactory.createUserWithDefaultServer(userName);
        Headers header = headerFactory.createReplyMSGHeader(userDest,msgId);

        System.out.println("Entrer le message à poster:");
        Messages msg = messageFactory.createMessage(author);

        return new Request(header,msg);
    }

    @Override
    public Requests createRepublishRequest(Users<String> author) {
        System.out.println("Synopsis: id" );
        Headers header  = headerFactory.createRepublishHeader(author, in.next());

        return new Request(header, null);
    }
}
