package com.emp.appl.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Employee {

	private int empid;
	private String empname;
	private String position;
	private int salary;
	private int experience;

	@Id
	public int getEmpid() {
		return empid;
	}

	public void setEmpid(int empid) {
		this.empid = empid;
	}

	public String getEmpname() {
		return empname;
	}

	public void setEmpname(String empname) {
		this.empname = empname;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	@Override
	public String toString() {
		return "Employee [empid=" + empid + ", empname=" + empname + ", position=" + position + ", salary=" + salary
				+ ", experience=" + experience + "]";
	}

}
