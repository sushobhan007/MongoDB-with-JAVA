import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import org.bson.types.ObjectId;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

public class UpdateUserMongoDb {
    public static void main(String[] args) throws ParseException {
        //Creating MongoClient
        MongoClient mongo = new MongoClient("localhost",27017);
        //Accessing the DataBase
        MongoDatabase mongoDb = mongo.getDatabase("myDb");
        Calendar calendar = Calendar.getInstance();
        Date dateLU = calendar.getTime();
        mongoDb.getCollection("users").updateOne(
                new BasicDBObject("_id",2),
                new BasicDBObject("$set", new BasicDBObject("label","Developer"))
        );
        //Updating the Last Updating Time
        mongoDb.getCollection("users").updateOne(
                new BasicDBObject("_id",new ObjectId("6202466f7a748256c6a62270")),
                new BasicDBObject("$set",new BasicDBObject("lu",dateLU.getTime()))
        );
        System.out.println("Document Updated successfully...");
    }
}
