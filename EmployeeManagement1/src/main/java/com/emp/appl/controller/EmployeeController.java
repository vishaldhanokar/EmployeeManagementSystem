package com.emp.appl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.emp.appl.entity.Employee;
import com.emp.appl.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	EmployeeService ss;

	// to get all employee details
	@GetMapping("/getallEmp")
	public List<Employee> getallEmp() {
		return ss.getallEmp();
	}

	// for insert employee in database
	@PostMapping("/insEmp")
	public String insEmp(@RequestBody Employee ee) {
		String s = ss.insEmp(ee);
		return s;

	}

	// to delete employee from database
	@DeleteMapping("/delEmp/{empid}")
	public String deleteEmp(@PathVariable int empid) {
		return ss.deleteEmp(empid);
	}

	// for updating the employee details
	@PutMapping("/updtEmp")
	public boolean updtEmp(@RequestBody Employee emp) {
		return ss.updtEmp(emp);

	}

	// to get Single Employee Details.
	@GetMapping("/getSingEmp/{empid}")
	public Object getSingleEmp(@PathVariable int empid) {
		return ss.getSingleEmp(empid);

	}

	// to get salary greater than 25000
	@GetMapping("/salGreater25000")
	public List<Employee> greaterThan25000() {
		List<Employee> lt = ss.greaterThan25000();
		return lt;
	}
	
	//to perform between condition on experience
	@GetMapping("/expbetn4_10")
	public List<Employee> experienceBetn() {
		return ss.experienceBetn();
	}
	
	//to get all position equals developer
	@GetMapping("/positionDeveloper")
	public List<Employee> empProfileDeveloper() {
		return ss.empProfileDeveloper();
	}
	
	//to get all not developer position
	@GetMapping("/notPositionDeveloper")
	public List<Employee> profileNotDeveloper() {
		return ss.profileNotDeveloper();
	}
	
	//to get employee whose having max salary
	@GetMapping("/maxSalary")
	public List<Employee> maxSalary() {
		return ss.maxSalary();
	}
	
	//to get employee whose having min experience
	@GetMapping("/minExpEmployee")
	public String minExpEmp() {
		String res = ss.minExpEmp();
		return res;
	}
	
	//to get sum of all employee Salary
	@RequestMapping("/sumOfSal")
	public List sumOfSalarys() {
		return ss.sumOfSalarys();
	}

}
