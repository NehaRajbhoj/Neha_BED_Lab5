package com.greatlearning.employees.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.greatlearning.employees.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

}
