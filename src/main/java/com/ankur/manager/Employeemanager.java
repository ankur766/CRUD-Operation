package com.ankur.manager;

import java.util.List;

import com.ankur.pojo.Employee;

public interface Employeemanager {

	List<Employee> getemployess();

	Employee addemployees(Employee employees);

	int deleteEmployee(int employeeId);

	int UpdateEmployee(Employee employees);

	int noEmployee(int noemployee);

	


	



	 

}
