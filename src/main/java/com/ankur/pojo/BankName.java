package com.ankur.pojo;

public class BankName {
	private int  id;
	private String  bankName;
	
	
	
		
	
	public BankName() {
		super();
	}



	public BankName(int id, String bankName) {
		super();
		this.id = id;
		this.bankName = bankName;
	}


	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}



	@Override
	public String toString() {
		return "BankName [id=" + id + ", bankName=" + bankName + "]";
	}

	
	

}
