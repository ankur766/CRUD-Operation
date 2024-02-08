package com.ankur.connection;
import static com.mongodb.client.model.Filters.eq;



import org.bson.Document;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class MongoDB {
	public static void main (String[]args) {
		
			MongoClient client=MongoClients.create("mongodb+srv://sandyankurkumar:1234@cluster0.wxxaqai.mongodb.net/?retryWrites=true&w=majority");
			MongoDatabase db=client.getDatabase("vendor");
			MongoCollection col=db.getCollection("vendor");
			Document sampleDoc= new Document("id","1").append("name", "jhon Smith");
	       col.insertOne( sampleDoc);
	}
		

}
