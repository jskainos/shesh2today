package model;

import java.time.LocalDate;

public class Employee {
	private int employeeNum;
	private String name;
	private String niNumber;
	private String department;
	private LocalDate dob;
	
	public Employee(String name) {
		this.name = name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
}
