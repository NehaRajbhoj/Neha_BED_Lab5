package com.greatlearning.employees.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.greatlearning.employees.model.Employee;
import com.greatlearning.employees.service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	
	@GetMapping("/greet")
	public String greet() {
		return "hello world";
	}
	
	@GetMapping("/demo")
	public Employee test() {
		return null;
		
	}
	
	@PostMapping("/addEmployee")
	public Employee addEmployee(@RequestParam("empid") int eid,
							@RequestParam("efname") String fname,
							@RequestParam("elname") String lname,
							@RequestParam("eemail") String mail	) {
		Employee e1 = new Employee();
		e1.setId(eid);
		e1.setFirstName(fname);
		e1.setLastName(lname);
		e1.setEmail(mail);
		
		return employeeService.addEmployee(e1);
		
		
	}
	
	@PostMapping("/addEmployeeByJson")
	public Employee addEmpolyee(@RequestBody Employee e1)
	{	
		return employeeService.addEmployee(e1);	
	}
	

	@GetMapping("/getEmployee")
	public Employee getEmployee(@RequestParam("empid") int eid)
	{
		return employeeService.getEmployee(eid);
	}
	
	@GetMapping("/getEmployeeByPath/{pid}")
	public Employee getEmployeeByPath(@PathVariable("pid") int eid)
	{
		return employeeService.getEmployee(eid);
	}
	
	@GetMapping("/getAllEmployees")
	public List<Employee> getAllEmployee()
	{
		return employeeService.getAllEmployees();
	}
	
	@DeleteMapping("/deleteEmployee")
	public String deleteEmployee(@RequestParam("empid") int eid)
	{
		employeeService.deleteEmployee(eid);
		return "Record Deleted";
	}
	
	@PutMapping("/updateEmployee")
	public Employee updateEmployee(@RequestParam("employeeid") int id,
							@RequestBody Employee e2)
	{
		return employeeService.updateEmployee(id,e2);
	}
	

	@GetMapping("/list")
	public String listEmployee(Model theModel)
	{
		List<Employee> listEmployee=employeeService.getAllEmployees();
		theModel.addAttribute("employees",listEmployee);
		return "employees/list-employees";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel)
	{
		Employee e3=new Employee();
		theModel.addAttribute("employee",e3);
		return "employee/employee-form";
	}
	
	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute("employee") Employee ez)
	{
		employeeService.addEmployee(ez);	
		return "redirect:/employees/list";
	}
	
	@PostMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("employeeId") int emid,
									Model theModel)
	{
		Employee employeedb=employeeService.getEmployee(emid);
		theModel.addAttribute("employee",employeedb);
		return "employees/employee-form";
	}
	
	@PostMapping("/delete")
	public String deleteMyEmployee(@RequestParam("employeeId") int eid)
	{
		employeeService.deleteEmployee(eid);
		return "redirect:/employees/list";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
