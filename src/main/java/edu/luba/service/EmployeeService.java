package edu.luba.service;

import java.util.List;

import edu.luba.model.Employee;

public interface EmployeeService {
	
	void addEmployee(Employee employee);
	
	void updateEmployee(Employee employee);
	
	Employee getEmployee(int id);
	
	void removeEmployee(int id);
	
	List<Employee> listEmployees();

}
