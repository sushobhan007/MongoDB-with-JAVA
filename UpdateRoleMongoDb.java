import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

public class UpdateRoleMongoDb {
    public static void main(String[] args) throws ParseException {
        //Creating MongoClient
        MongoClient mongo = new MongoClient("localhost",27017);
        //Accessing the DataBase
        MongoDatabase mongoDb = mongo.getDatabase("myDb");
        Calendar calendar = Calendar.getInstance();
        Date dateLU = calendar.getTime();
        //Updating the Document
        mongoDb.getCollection("roles").updateOne(
                new BasicDBObject("_id",""),
                new BasicDBObject("$set", new BasicDBObject("label","developer"))
        );
        mongoDb.getCollection("roles").updateOne(
                new BasicDBObject("_id",""),
                new BasicDBObject("$set", new BasicDBObject("lu",dateLU.getTime()))
        );
        System.out.println("Document Updated successfully...");
    }
}
