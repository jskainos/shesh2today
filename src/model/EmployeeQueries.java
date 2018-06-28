package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;


public class EmployeeQueries {

	public EmployeeQueries() {
	}

	public static ArrayList<Employee> getEmployees() {

		Connection c = utils.DBUtils.getConnection();
		ArrayList<Employee> emps = new ArrayList<Employee>();
		try {
			Statement s = c.createStatement();
			ResultSet rows = s.executeQuery(
					"SELECT emp_no AS `number`, CONCAT_WS(' ', first_name, last_name) AS `name`, salary FROM employees JOIN salaries USING(emp_no) WHERE to_date > NOW()");
			while (rows.next()) {
				emps.add(new Employee(rows.getString("name"),
						rows.getString("ni_number"), rows.getString("department"),
						rows.getString("dob"),
						rows.getString("address"), rows.getString("iban"),
						rows.getString("starting_salary")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return emps;
	}
	
	public static void insertEmployees(Employee emp) {
		String empQuery = "INSERT INTO employee(name, ni_number, department, dob) "
				+ "VALUES (\"" + emp.getName() + "\", \"" + emp.getNiNumber() 
				+ "\", \"" + emp.getDepartment() + "\", \"" + emp.getDob() + "\")";
		
		String payQuery = "INSERT INTO payroll(iban, starting_salary) VALUES (\"" 
		+ emp.getIban() + "\", \"" + emp.getSalary() + "\")";
		
		String addQuery = "INSERT INTO address(address, city, postcode) VALUES (\"" + emp.getAddress() + "\", \"testCity\", \"testPostcode\")";
		
		
		Connection c = utils.DBUtils.getConnection();
		try {
			Statement s = c.createStatement();
			s.executeUpdate(empQuery);
			s.executeUpdate(payQuery);
			s.executeUpdate(addQuery);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static ArrayList<Employee> generateEmployeesBUReport(String bu) {
	
		Connection c = utils.DBUtils.getConnection();
		ArrayList<Employee> emps = new ArrayList<Employee>();
		System.out.println("SELECT * FROM employee where department = \"" + bu + "\"");
		try {
			Statement s = c.createStatement();
			ResultSet rows = s.executeQuery(
					"SELECT * FROM employee where department = \"" + bu + "\"");
			while (rows.next()) {
				Employee e = new Employee(rows.getString(2), rows.getString(3),
						rows.getString(4), rows.getString(5));
				emps.add(e);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return emps;
	}

	

}
