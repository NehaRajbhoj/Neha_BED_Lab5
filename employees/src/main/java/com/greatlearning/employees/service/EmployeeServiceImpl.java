package com.greatlearning.employees.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatlearning.employees.model.Employee;
import com.greatlearning.employees.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	EmployeeRepository employeerepository;
	
	public Employee addEmployee(Employee e1) {
		return employeerepository.save(e1);
	}
	
	public Employee getEmployee(int eid) {
		return employeerepository.findById(eid).get();
	}
	
	public List<Employee> getAllEmployees() {
		return employeerepository.findAll();
	}
	
	public void deleteEmployee(int eid) {
		employeerepository.deleteById(eid);
	}
	
	public Employee updateEmployee(int id, Employee e2) {
		Employee employeedb=getEmployee(id);
		employeedb.setFirstName(e2.getFirstName());
		employeedb.setLastName(e2.getLastName());
		employeedb.setEmail(e2.getEmail());
		return employeerepository.save(employeedb);
	}
	
	
	
	
	
	
	
	
}





