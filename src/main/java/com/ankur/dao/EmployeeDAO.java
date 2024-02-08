package com.ankur.dao;

import java.util.List;

import com.ankur.pojo.Employee;

public interface EmployeeDAO {

	List<Employee> getemployess();

	Employee addemployees(Employee employees);

	int deleteEmployee(int employeeId);

	int UpdateEmployee(Employee employees);

	int noEmployee(int noemployee);



	

	

}
