package model;

import java.time.LocalDate;

public class Employee {
	private int employeeNum;
	private String name;
	private String niNumber;
	private String department;
	private String dob;
	
	public Employee(String name, String niNumber, String department, String dob) {
		this.name = name;
		this.niNumber = niNumber;
		this.department = department;
		this.dob = dob;
	}
	
	
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void postToDB() {
		EmployeeQueries.insertEmployees(this);
	}

	public int getEmployeeNum() {
		return employeeNum;
	}

	public String getNiNumber() {
		return niNumber;
	}

	public void setNiNumber(String niNumber) {
		this.niNumber = niNumber;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}
	
}
