package com.ankur.action;

import java.util.List;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ankur.manager.BankManager;

import com.ankur.pojo.BankName;


@RestController
@RequestMapping("/Struts2Project")  // This sets the base path for all methods in this class
@CrossOrigin(origins = "*", maxAge = 3600)  // Specify your frontend domain
public class BankNameAction {
	 BankManager bankManager;
	
	BankName bankname;
	
	
	List<BankName>banknames;
	public BankName getBankname() {
		return bankname;
	}
	public void setBankname(BankName bankname) {
		this.bankname = bankname;
	}
	
	public List<BankName> getBanknames() {
		return banknames;
	}
	public void setBanknames(List<BankName> banknames) {
		this.banknames = banknames;
	}
	
	

	@GetMapping("/getBankName")	
	public String getBankName() {
		
		ApplicationContext context  = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		
		 bankManager= (BankManager) context.getBean("bankManagerImpl");
		 
		 
		 String msg = "error";
		 
		 banknames= bankManager.getBankName();
		
			System.out.println(banknames.size());
			System.out.println(banknames);
			
		 msg = "success";
				
					
		
		return msg;
			
		}
	
	
	  @PostMapping("/addBankName")
	public String addBankName() {
		
		ApplicationContext context  = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		
		 bankManager= (BankManager) context.getBean("bankManagerImpl");
		
		 
		 String msg = "ERROR_IN_INSERTING_DETAILS_DATA";
		 
		 System.out.println("Bank name"+bankname);
		 bankname=bankManager.addBankName(bankname);
		 if (bankname != null) {
				msg = "INSERTED__DETAILS_DATA";
			}
		 
		 
		 
		 	return msg;
	}
	
		
	
	
	
	

}
