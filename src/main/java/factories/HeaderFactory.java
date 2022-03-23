package factories;

import groovyjarjarantlr4.v4.runtime.atn.PredicateTransition;
import org.apache.tools.ant.taskdefs.email.Header;
import requests.headers.*;
import requests.headers.builders.ReceiveMSGIDHeaderBuilder;
import users.Users;

import java.io.IOException;
import java.util.Scanner;

class HeaderFactory {
    private UserFactory userFactory = new UserFactory();

    public Headers createPublishHeader(Users<String> user) {
        return new PublishHeader(user);
    }

    public Headers createReceiveMSGIDHeader(String args) throws IOException {

        if (args.split(" ").length > 4)
            throw new IllegalArgumentException();
        Scanner scanner = new Scanner(args);

        ReceiveMSGIDHeaderBuilder builder = new ReceiveMSGIDHeaderBuilder();
        while (scanner.hasNext()) {
            if (scanner.hasNextInt()) {
                builder.setLimit(scanner.nextInt());
            }
            else {
             String e = scanner.next();
             if (e.charAt(0) == '@') {
                 builder.setAuthor(
                         userFactory.createUserWithDefaultServer(e)
                 );
             }
             else {
                 if (e.charAt(0) == '#')
                     builder.setTag(e);
                 else
                     builder.setMsgId(e);
             }
            }
        }
        return builder.build();
    }

    public Headers createReceiveMSGHeader(String msgId) {
        return new ReceiveMSGHeader(msgId);
    }

    public Headers createReplyMSGHeader(Users<String> author, String msgId) throws IOException {

        return new ReplyMSGHeader(author,msgId);
    }

    public Headers createRepublishHeader(Users<String> author, String msgId) {

        return new RepublishHeader(author,msgId);
    }
}
