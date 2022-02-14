import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.bson.types.ObjectId;


public class DeleteUserMongoDb {
    public static void main(String[] args) {
        //Creating MongoClient
        MongoClient mongo = new MongoClient("localhost",27017);
        //Accessing the DataBase
        MongoDatabase mongoDb = mongo.getDatabase("myDb");

        MongoCollection<Document> collection = mongoDb.getCollection("users");
        System.out.println("Collection named 'users' selected...");

        collection.deleteMany(Filters.eq("_id", new ObjectId("6202466f7a748256c6a62270")));
        System.out.println("Document Deleted Successfully...");
    }
}
