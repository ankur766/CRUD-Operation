package com.ankur.managerImpl;

import java.util.List;

import com.ankur.dao.EmployeeDAO;
import com.ankur.manager.Employeemanager;
import com.ankur.pojo.Employee;

public class EmployeemanagerImpl implements Employeemanager {
	
	EmployeeDAO employeeDao;
	
	

	public EmployeeDAO getEmployeeDao() {
		return employeeDao;
	}



	public void setEmployeeDao(EmployeeDAO employeeDao) {
		this.employeeDao = employeeDao;
	}



	@Override
	public List<Employee> getemployess() {
		// TODO Auto-generated method stub
		return employeeDao.getemployess();
	}



	@Override
	 public Employee addemployees(Employee employees) {
		// TODO Auto-generated method stub
		return  employeeDao.addemployees(employees);
	}



	@Override
	public int  deleteEmployee(int employeeId) {
		// TODO Auto-generated method stub
		return  employeeDao.deleteEmployee(employeeId);
	}



	


	@Override
	public int UpdateEmployee(Employee employees) {
		// TODO Auto-generated method stub
		return  employeeDao.UpdateEmployee( employees);
	}



	@Override
	public int noEmployee(int noemployee) {

		return employeeDao.noEmployee(noemployee);
	}



	
	




	
	

}
