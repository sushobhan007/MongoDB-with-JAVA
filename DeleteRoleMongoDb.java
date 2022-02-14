import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.Document;

public class DeleteRoleMongoDb {
    public static void main(String[] args) {
        //Creating MongoClient
        MongoClient mongo = new MongoClient("localhost",27017);
        //Accessing the DataBase
        MongoDatabase mongoDb = mongo.getDatabase("myDb");

        MongoCollection<Document> collection = mongoDb.getCollection("roles");
        System.out.println("Collection named 'roles' selected...");
        collection.deleteOne(Filters.eq("_id",""));
        System.out.println("Document Deleted Successfully...");

    }
}
