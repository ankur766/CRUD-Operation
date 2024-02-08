package com.ankur.daoImpl;


import java.util.ArrayList;
import java.util.List;


import com.ankur.dao.BankDAO;
import com.ankur.pojo.BankName;




import static com.mongodb.client.model.Filters.eq;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Sorts;
import com.mongodb.client.model.Updates;


public class BankDAOImpl implements  BankDAO {
	
	


	
	
	
	@Override
	public List<BankName> getBankName() {
		
		
		MongoClient client = MongoClients.create("mongodb+srv://sandyankurkumar:1234@cluster0.wxxaqai.mongodb.net/?retryWrites=true&w=majority");
        MongoDatabase db = client.getDatabase("vendor");
        MongoCollection col = db.getCollection("bankName");
		 List<BankName> bankNames = new ArrayList<>();

	        try {
	            // Perform a find to get all documents in the collection
	            FindIterable<Document> documents = col.find();

	            // Iterate through the documents and convert them to BankName objects
	            for (Document doc : documents) {
	                bankNames.add(new BankName(
	                        doc.getInteger("id"),
	                        doc.getString("bankName")
	                ));
	            }

	            return bankNames;
	        } catch (Exception e) {
	            throw new RuntimeException("Error fetching bank names from MongoDB: " + e.getMessage(), e);
	        }
	    }
	




	@Override
	public BankName addBankName(BankName bankname) {
		
		
		MongoClient client = MongoClients.create("mongodb+srv://sandyankurkumar:1234@cluster0.wxxaqai.mongodb.net/?retryWrites=true&w=majority");
        MongoDatabase db = client.getDatabase("vendor");
        MongoCollection col = db.getCollection("bankName");
		
		 try {
			// Find the highest existing id in the collection
	            Bson maxIdFilter = Filters.exists("id");
	            Document maxIdDocument = (Document) col.find(maxIdFilter).sort(Sorts.descending("id")).first();

	            int maxId = 0;
	            if (maxIdDocument != null) {
	                maxId = maxIdDocument.getInteger("id", 0);
	            }

	            // Increment the id for the new Employee
	            bankname.setId(maxId + 1);
				try {
				Document doc = new Document("id", bankname.getId())
					        .append("bankName", bankname.getBankName());
					
					 col.insertOne(doc);
					 
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

	            // Insert the Document into the MongoDB collection
	           

	            // Set the auto-incremented id for the returned BankName object
	            

	        } catch (Exception e) {
	            throw new RuntimeException("Error adding bank name to MongoDB: " + e.getMessage(), e);
	        }

	        return bankname;
		
	}


}
