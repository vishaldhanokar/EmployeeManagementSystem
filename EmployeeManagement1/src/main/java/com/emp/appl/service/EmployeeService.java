package com.emp.appl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.emp.appl.dao.EmployeeDao;
import com.emp.appl.entity.Employee;

@Service
public class EmployeeService {

	@Autowired
	EmployeeDao dd;
	
	
	public List<Employee> getallEmp() {
		return dd.getallEmp();
		
	}

	public String insEmp(Employee ee) {
		return dd.insEmp(ee);
		
	}

	public String deleteEmp(int empid) {
		return dd.deleteEmp(empid);
		
	}

	public boolean updtEmp(Employee emp) {
		return dd.updtEmp(emp);
		
	}

	public Object getSingleEmp(int empid) {
		return dd.getSingleEmp(empid);
		
	}

	public List<Employee> greaterThan25000() {
		return dd.greaterThan25000();
		
	}

	public List<Employee> experienceBetn() {
		return dd.experienceBetn();
		
	}

	public List<Employee> empProfileDeveloper() {
		return dd.empProfileDeveloper();
		
	}

	public List<Employee> profileNotDeveloper() {
		return dd.profileNotDeveloper();
		
	}

	public List<Employee> maxSalary() {
		return dd.maxSalary();
		
	}

	public String minExpEmp() {
		return dd.minExpEmp();
		
	}

	public List sumOfSalarys() {
		return dd.sumOfSalarys();
		
	}

	
}
