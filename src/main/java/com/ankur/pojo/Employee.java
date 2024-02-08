package com.ankur.pojo;
import org.bson.types.ObjectId;
public class Employee {
	 private int id;
	private String vendorName;
	private String vendorEmail;
    private String bankAccountNo;
   private String bankName;
   private String addressLine1;
   private String addressLine2;
   private String city;
   private String country;
   private String zipCode;
   
   
 


public Employee() {
	super();
}









public Employee(int id, String vendorName,String vendorEmail, String bankAccountNo, String bankName, String addressLine1,
		String addressLine2, String city, String country, String zipCode) {
	super();
	this.id = id;
	this.vendorName = vendorName;
	this.bankAccountNo = bankAccountNo;
	this.bankName = bankName;
	this.addressLine1 = addressLine1;
	this.addressLine2 = addressLine2;
	this.city = city;
	this.country = country;
	this.zipCode = zipCode;
}









public int getId() {
	return id;
}






public void setId(int id) {
	this.id = id;
}






public String getVendorName() {
	return vendorName;
}
public void setVendorName(String vendorName) {
	this.vendorName = vendorName;
}



public String getVendorEmail() {
	return vendorEmail;
}









public void setVendorEmail(String vendorEmail) {
	this.vendorEmail = vendorEmail;
}









public String getBankAccountNo() {
	return bankAccountNo;
}
public void setBankAccountNo(String bankAccountNo) {
	this.bankAccountNo = bankAccountNo;
}
public String getBankName() {
	return bankName;
}
public void setBankName(String bankName) {
	this.bankName = bankName;
}
public String getAddressLine1() {
	return addressLine1;
}
public void setAddressLine1(String addressLine1) {
	this.addressLine1 = addressLine1;
}
public String getAddressLine2() {
	return addressLine2;
}
public void setAddressLine2(String addressLine2) {
	this.addressLine2 = addressLine2;
}
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}
public String getCountry() {
	return country;
}
public void setCountry(String country) {
	this.country = country;
}
public String getZipCode() {
	return zipCode;
}
public void setZipCode(String zipCode) {
	this.zipCode = zipCode;
}









@Override
public String toString() {
	return "Employee [id=" + id + ", vendorName=" + vendorName + ",vendorEmail=" + vendorEmail+ ", bankAccountNo=" + bankAccountNo + ", bankName="
			+ bankName + ", addressLine1=" + addressLine1 + ", addressLine2=" + addressLine2 + ", city=" + city
			+ ", country=" + country + ", zipCode=" + zipCode + "]";
}
   
  

 
  
  
	     
			
		
	

}
