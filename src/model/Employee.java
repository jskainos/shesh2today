package model;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.regex.*;
import java.util.ArrayList;

public class Employee {
	private int employeeNum;
	private String name;
	private String niNumber;
	private String department;
	private String dob;
	private String address;
	private String iban;
	private String salary;
	
	public Employee() {
		
	}
	
	public Employee(String name, String niNumber, String department, 
			String dob, String address, String iban, String salary) {
		this.name = name;
		this.niNumber = niNumber;
		this.department = department;
		this.dob = dob;
		this.address = address;
		this.iban = iban;
		this.salary = salary;
	}
	
	
	public Employee(String name, String dob, String niNumber, String department) {
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
	
	private boolean validate() {
		return Pattern.matches("[A-Za-z\\s]+", getName()) && 
				Pattern.matches("^\\s*[a-zA-Z]{2}(?:\\s*\\d\\s*){6}[a-zA-Z]?\\s*$", getNiNumber()) &&
				Pattern.matches("[A-Za-z\\s]+", getDepartment()) &&
				Pattern.matches("^\\d{2}-\\d{2}-\\d{4}$", getDob()) &&
				Pattern.matches("[A-Za-z\\s0-9]+", getAddress()) &&
				Pattern.matches("[0-9]{9}", getIban()) &&
				Pattern.matches("[0-9]+([,.][0-9]{1,2})?", getSalary());
	}
	

	public boolean postToDB() {
		if (validate()) {
			try {
				EmployeeQueries.insertEmployees(this);
				return true;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}
	
	public ArrayList<Employee> generateBUReport(String department) {
		ArrayList<Employee> empList = EmployeeQueries.generateEmployeesBUReport(department);
		return empList;
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

	@Override
	public String toString() {
		return "Employee [employeeNum=" + employeeNum + ", name=" + name + ", niNumber=" + niNumber + ", department="
				+ department + ", dob=" + dob + ", address=" + address + ", iban=" + iban + ", salary=" + salary + "]";
	}
	
}
