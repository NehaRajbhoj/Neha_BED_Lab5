package com.greatlearning.employees.service;

import java.util.List;

import com.greatlearning.employees.model.Employee;

public interface EmployeeService {
	Employee addEmployee(Employee e1);
	Employee getEmployee(int eid);
	List<Employee> getAllEmployees();
	void deleteEmployee(int eid);
	Employee updateEmployee(int id, Employee e2);
	

}
