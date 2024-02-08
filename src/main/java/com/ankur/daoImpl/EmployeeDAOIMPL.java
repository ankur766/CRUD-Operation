package com.ankur.daoImpl;


import java.util.ArrayList;
import java.util.List;

import com.ankur.dao.EmployeeDAO;
import com.ankur.pojo.Employee;

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
public class EmployeeDAOIMPL implements  EmployeeDAO  {
	
	@Override
	public List<Employee> getemployess() {
		// TODO Auto-generated method stub
		MongoClient client = MongoClients.create("mongodb+srv://sandyankurkumar:1234@cluster0.wxxaqai.mongodb.net/?retryWrites=true&w=majority");
        MongoDatabase db = client.getDatabase("vendor");
        MongoCollection col = db.getCollection("vendor");
		
		List<Employee> employeesList = new ArrayList<>();

        try {
            // Perform a find to get all documents in the collection
            FindIterable<Document> documents = col.find();

            // Iterate through the documents and convert them to Employee objects
            MongoCursor<Document> cursor = documents.iterator();
            while (cursor.hasNext()) {
                Document doc = cursor.next();

                // Convert Document to Employee
                Employee employee = new Employee();
                employee.setId(doc.getInteger("id"));
                employee.setVendorName(doc.getString("vendor_name"));
                employee.setBankAccountNo(doc.getString("bank_account_no"));
                employee.setVendorEmail(doc.getString("vendor_email"));
                employee.setBankName(doc.getString("bank_name"));
                employee.setAddressLine1(doc.getString("address_line1"));
                employee.setAddressLine2(doc.getString("address_line2"));
                employee.setCity(doc.getString("city"));
                employee.setCountry(doc.getString("country"));
                employee.setZipCode(doc.getString("zip_code"));

                employeesList.add(employee);
                System.out.println("size of data "+employeesList.size());
                
            }
        } catch (Exception e) {
            throw new RuntimeException("Error fetching employees from MongoDB: " + e.getMessage(), e);
        }

        return employeesList;
    }
		
	

	@Override
	public Employee addemployees(Employee employees) {
		
		MongoClient client = MongoClients.create("mongodb+srv://sandyankurkumar:1234@cluster0.wxxaqai.mongodb.net/?retryWrites=true&w=majority");
        MongoDatabase db = client.getDatabase("vendor");
        MongoCollection col = db.getCollection("vendor");
        try {
            // Find the highest existing id in the collection
            Bson maxIdFilter = Filters.exists("id");
            Document maxIdDocument = (Document) col.find(maxIdFilter).sort(Sorts.descending("id")).first();

            int maxId = 0;
            if (maxIdDocument != null) {
                maxId = maxIdDocument.getInteger("id", 0);
            }

            // Increment the id for the new Employee
            employees.setId(maxId + 1);

            // Convert Employee object to Document
            Document doc = new Document("id", employees.getId())
                    .append("vendor_name", employees.getVendorName())
                    .append("vendor_email", employees.getVendorEmail())
                    .append("bank_account_no", employees.getBankAccountNo())
                    .append("bank_name", employees.getBankName())
                    .append("address_line1", employees.getAddressLine1())
                    .append("address_line2", employees.getAddressLine2())
                    .append("city", employees.getCity())
                    .append("country", employees.getCountry())
                    .append("zip_code", employees.getZipCode());

            // Insert the Document into the MongoDB collection
            col.insertOne(doc);
            return employees;

            
        } catch (Exception e) {
            throw new RuntimeException("Error adding employee to MongoDB: " + e.getMessage(), e);
        }
        
        
	}

	
	
	
	@Override
	public int deleteEmployee(int employeeId) {
		
		MongoClient client = MongoClients.create("mongodb+srv://sandyankurkumar:1234@cluster0.wxxaqai.mongodb.net/?retryWrites=true&w=majority");
        MongoDatabase db = client.getDatabase("vendor");
        MongoCollection col = db.getCollection("vendor");
		  int result = 0;

	        try {
	            // Use the deleteOne method to delete a document based on the employeeId
	            col.deleteOne(Filters.eq("id", employeeId));

	            // If no exception occurred during the deletion, set the result to 1
	            result = 1;
	        } catch (Exception e) {
	            throw new RuntimeException("Error deleting employee from MongoDB: " + e.getMessage(), e);
	        }

	        return result;
		
	}

	@Override
	public int UpdateEmployee(Employee employees) {
		

		MongoClient client = MongoClients.create("mongodb+srv://sandyankurkumar:1234@cluster0.wxxaqai.mongodb.net/?retryWrites=true&w=majority");
        MongoDatabase db = client.getDatabase("vendor");
        MongoCollection col = db.getCollection("vendor");
		  int update = 0;

	        try {
	            // Use the updateOne method to update a document based on the employee's id
	            col.updateOne(
	                    Filters.eq("id", employees.getId()),
	                    Updates.combine(
	                            Updates.set("vendor_name", employees.getVendorName()),
	                            Updates.set("bank_account_no", employees.getBankAccountNo()),
	                            Updates.set("bank_name", employees.getBankName()),
	                            Updates.set("address_line1", employees.getAddressLine1()),
	                            Updates.set("address_line2", employees.getAddressLine2()),
	                            Updates.set("city", employees.getCity()),
	                            Updates.set("country", employees.getCountry()),
	                            Updates.set("zip_code", employees.getZipCode())
	                    )
	            );

	            // If no exception occurred during the update, set the result to 1
	            update = 1;
	        } catch (Exception e) {
	            throw new RuntimeException("Error updating employee in MongoDB: " + e.getMessage(), e);
	        }

	        return update;	
	        
	}



	@Override
	public int noEmployee(int noemployee) {

		MongoClient client = MongoClients.create("mongodb+srv://sandyankurkumar:1234@cluster0.wxxaqai.mongodb.net/?retryWrites=true&w=majority");
        MongoDatabase db = client.getDatabase("vendor");
        MongoCollection col = db.getCollection("vendor");
        
        long count ;
		
        try {
            // Use countDocuments to get the count of documents in the collection
            count = col.countDocuments();
            
            System.out.println("Number of employees: " + count);
            
          
            
            
        } catch (Exception e) {
            throw new RuntimeException("Error fetching employee count from MongoDB: " + e.getMessage(), e);
        } finally {
            // Close the MongoDB client in a finally block to ensure it's always closed
            client.close();
        }
        
        
        return (int) count;
	}
	
	
	
	

	
	


}
	


