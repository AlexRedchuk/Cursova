package edu.lex.cursova;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.types.ObjectId;

public class MongoService {
    private static  MongoClient mongoClient;

    static {
        //Change host1, host2 and host3 as applicable to your atlas cluster
        mongoClient = new MongoClient(new MongoClientURI("mongodb+srv://admin:admin@cluster0-70cw9.mongodb.net/test?retryWrites=true&w=majority"));
    }

    public static String getMessage() {
        MongoDatabase database = mongoClient.getDatabase("edition");
        MongoCollection<Document> collection = database.getCollection("messages");
        Document query = new Document("_id", new ObjectId("5c60b282f066fe5f423c76b6"));
        Document result = collection.find(query).iterator().next();

        return result.getString("message");
    }
}