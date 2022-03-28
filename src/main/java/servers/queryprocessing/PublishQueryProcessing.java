package servers.queryprocessing;

import org.json.JSONArray;
import org.json.JSONObject;
import servers.queryprocessing.AbstractQueryProcessing;

import java.io.FileWriter;
import java.io.IOException;

public class PublishQueryProcessing extends AbstractQueryProcessing {


    @Override
    public void executeProcess() {
        separate();

        // Author Section
        JSONObject author = new JSONObject();
        author.put("author", this.header);

        // Structure of the message - TODO - Generate the id
        JSONObject messageDetails = new JSONObject();
        messageDetails.put("msgId", "test");
        messageDetails.put("txt",this.message);

        //Add message to list
        // L'idée aurait normalement été d'interroger s'il l'auteur est déjà dans notre fichier que ça rajoute
        // le message à la suite de la liste déjà existante.
        JSONArray message = new JSONArray();
        message.put(messageDetails);
        // Attach the messages to the user
        author.put("Message List", message);

        //Write JSON file
        try (FileWriter file = new FileWriter("test.json",true)) {
            //We can write any JSONArray or JSONObject instance to the file
            file.write(author.toString(4)+",\n");
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
