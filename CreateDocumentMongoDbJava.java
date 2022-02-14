import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CreateDocumentMongoDbJava {
    public static void main(String[] args) throws ParseException {
        //Creating MongoClient
        MongoClient mongo = new MongoClient("localhost",27017);
        //Accessing the DataBase
        MongoDatabase mongoDb = mongo.getDatabase("myDb");
        //Selecting New Collection
        MongoCollection<Document> collection = mongoDb.getCollection("roles");
        System.out.println("Collection named 'roles' selected...");
        //Inserting into Document
        SimpleDateFormat dateformatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        String ct = "07-02-2022 04:20:20";
        Date date = dateformatter.parse(ct);
        Document document = new Document("_id","")
                .append("label","admin")
                .append("description","Users with administrative role can create new users, assign roles and grants and change various other configurations.")
                .append("ct",date.getTime())
                .append("type","System Default");
        collection.insertOne(document);
        System.out.println("Document Inserted successfully...");
    }
}


