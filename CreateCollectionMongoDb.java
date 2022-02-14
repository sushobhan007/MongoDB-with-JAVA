import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.client.MongoDatabase;

public class CreateCollectionMongoDb {
    public static void main(String[] args) {
        //Creating MongoClient
        MongoClient mongo = new MongoClient("localhost",27017);
        //Creating MongoCredential
        MongoCredential credential = MongoCredential.createCredential("sampleUser","myDb","password".toCharArray());
        System.out.println("Connected to the database successfully...");
        //Accessing the DataBase
        MongoDatabase mongoDb = mongo.getDatabase("myDb");
        //Creating New Collection
        mongoDb.createCollection("roles");
        System.out.println("Collection named 'roles' created successfully...");
        mongoDb.createCollection("users");
        System.out.println("Collection named 'users' created successfully...");
    }
}
