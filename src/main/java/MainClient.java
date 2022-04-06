import factories.Factory;
import org.json.simple.JSONObject;
import requests.Requests;
import users.NetworkUser;
import users.Users;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class MainClient {
    static Users<String> testUser;


    static Scanner keyboardInput = new Scanner(System.in);
    public static void main(String[] args) throws IOException {
        testUser = new NetworkUser("@aliou","localhost",12345);
        System.out.println(testUser);
        do {
            System.out.println("Veuillez choisir une option:");
            System.out.println("1. Publication de message\n" +
                    "2. Répondre à une publication\n" +
                    "3. Consulter un message\n" +
                    "4. Récupérer la liste des derniers messages\n" +
                    "5. Republier un message");
            Requests request = select(Integer.parseInt(keyboardInput.next()));
            if (request == null)
                System.out.println("Choix invalide.");
            testUser.shareMessage(request);
            System.out.println("Voulez-vous continuer (Y/N):");

        } while (keyboardInput.next().compareToIgnoreCase("Y") == 0);

    }

    public static Requests select(int number) throws IOException {
        Factory factory = new Factory();
        switch (number) {
            case 1:
                return factory.createPublishRequest(testUser);
            case 2:
                return factory.createReplyMSGRequest(testUser);
            case 3:
                return factory.createReceiveMSGRequest();
            case 4:
                return factory.createReceiveMSGIDRequest();
            case 5:
                return factory.createRepublishRequest(testUser);
            default:
                return null;

        }
    }
}
