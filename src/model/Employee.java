package model;

import java.time.LocalDate;

public class Employee {
	private int employeeNum;
	private String name;
	private String niNumber;
	private String department;
	private String dob;
	private String address;
	private String iban;
	private String salary;
	
	
	public Employee(String name, String niNumber, String department, String dob, String address, String iban, String salary) {
		this.name = name;
		this.niNumber = niNumber;
		this.department = department;
		this.dob = dob;
		this.address = address;
		this.iban = iban;
		this.salary = salary;
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



	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}



	public String getIban() {
		return iban;
	}



	public void setIban(String iban) {
		this.iban = iban;
	}



	public String getSalary() {
		return salary;
	}



	public void setSalary(String salary) {
		this.salary = salary;
	}
	
}
