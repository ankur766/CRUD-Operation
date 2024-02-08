package com.ankur.action;

import java.util.List;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.ankur.manager.Employeemanager;
import com.ankur.pojo.Employee;

@CrossOrigin

public class EmployeeAction {
	
	
	Employee employees;
	
	int employeeId;
	int noemployee;

	


	public int getNoemployee() {
		return noemployee;
	}
	public void setNoemployee(int noemployee) {
		this.noemployee = noemployee;
	}


	public Employeemanager employeemanager;
	
	public List<Employee>employee;
	
	
	public void setEmployees(Employee employees) {
		this.employees = employees;
	}
	public Employee  getEmployees(Employee employees) {
		return employees;
	}
	
	
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	
	
	public List<Employee> getEmployee() {
		return employee;
	}
	public void setEmployee(List<Employee> employee) {
		this.employee = employee;
	}
	
	
	public String getemployee() {
	
	ApplicationContext context  = new ClassPathXmlApplicationContext("applicationContext.xml");
	
	
	 employeemanager=(Employeemanager) context.getBean("employeeManagerImpl");
	 
	 
	 String msg = "error";
	 
	 employee=employeemanager.getemployess();
	
		
		
	if(employee!=null)
	{	
		 msg = "success";
			
				
	}
	return msg;
		
	}
	
	
	public String addemployees() {
		ApplicationContext context  = new ClassPathXmlApplicationContext("applicationContext.xml");
		 employeemanager=(Employeemanager) context.getBean("employeeManagerImpl");
		 
		 String msg = "ERROR_IN_INSERTING_ORDER_DETAILS_DATA";
		 employees=employeemanager.addemployees(employees);
		 if (employees != null) {
				msg = "INSERTED_ORDER_DETAILS_DATA";
			}
		 
		 	return msg;
	}
	
	public String UpdateEmployee()
	{
		ApplicationContext context  = new ClassPathXmlApplicationContext("applicationContext.xml");
		 employeemanager=(Employeemanager) context.getBean("employeeManagerImpl");
		 int result =employeemanager.UpdateEmployee(employees);
		 String msg = "ERROR_IN__Update_DATA";
		 if (result != 0) {
				msg = "Update_DETAILS_DATA";
			}
		 
		 	return msg;
		
	}
	
	
	
	
	public String deleteEmployee()
	{
		ApplicationContext context  = new ClassPathXmlApplicationContext("applicationContext.xml");
		 employeemanager=(Employeemanager) context.getBean("employeeManagerImpl");
		 int result =employeemanager.deleteEmployee( employeeId);
		 String msg = "ERROR_IN_Delete_ORDER_DETAILS_DATA";
		 if (result != 0) {
				msg = "Deleted_ORDER_DETAILS_DATA";
			}
		 
		 	return msg;
		
	}
	

	public String  noEmployee()
	{
		ApplicationContext context  = new ClassPathXmlApplicationContext("applicationContext.xml");
		 employeemanager=(Employeemanager) context.getBean("employeeManagerImpl");
		 
		 int result =employeemanager.noEmployee(noemployee);
		 System.out.println("Total no of " + result);
			
		 String msg = "error";
			if(result!=0)
			{	
				 msg = "success";
					
						
			}
			return msg;
		 
		
		
	}
	
	
	


	
	
	
	
}
