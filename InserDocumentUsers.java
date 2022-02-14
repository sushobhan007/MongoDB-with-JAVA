import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import static java.util.Arrays.asList;

public class InserDocumentUsers {
    public static void main(String[] args) throws ParseException {
        //Creating MongoClient
        MongoClient mongo = new MongoClient("localhost",27017);
        //Accessing the DataBase
        MongoDatabase mongoDb = mongo.getDatabase("myDb");
        //Selecting New Collection
        MongoCollection<Document> collection = mongoDb.getCollection("users");
        System.out.println("Collection named 'users' selected...");
        //Inserting into Document
        SimpleDateFormat dateformatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        String creationTime = "08-02-2022 12:00:00";
        String lastLoginTime = "08-02-2022 12:02:02";
        String lastUpdate = "08-02-2022 02:53:20";
        long expDate = -1;
        Date dateCT = dateformatter.parse(creationTime);
        Date dateLLT = dateformatter.parse(lastLoginTime);
        Date dateLU = dateformatter.parse(lastUpdate);
        Document document = new Document("email","sushobhan.mudi@globalids.com")
                .append("fullName","Sushobhan Mudi").append("ct",dateCT.getTime())
                .append("organizationId", "205a517a-89ed-4f1a-b1a0-aa3d47d34a4f")
                .append("lastLoginTime",dateLLT.getTime()).append("loginAttempts",0)
                .append("roles", asList(new Document("id",1).append("expiryDate",expDate).append("label","developer"),
                                new Document("id",2).append("expiryDate",expDate).append("label","admin"),
                                new Document("id",3).append("expiryDate",expDate).append("label","Information Architect"),
                                new Document("id",4).append("expiryDate",expDate).append("label","Application Owner")))
                .append("lu",dateLU.getTime());

        collection.insertOne(document);
        System.out.println("Document Inserted successfully...");
    }
}