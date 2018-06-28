package model;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import employee_stuff.Employee;

public class EmoloyeeQueries {

	public EmoloyeeQueries() {
	}

	public static ArrayList<Employee> getEmployees() {

		if (c == null) {
			c = getConnection();
		}
		ArrayList<Employee> emps = new ArrayList<Employee>();
		try {
			Statement s = c.createStatement();
			ResultSet rows = s.executeQuery(
					"SELECT emp_no AS `number`, CONCAT_WS(' ', first_name, last_name) AS `name`, salary FROM employees JOIN salaries USING(emp_no) WHERE to_date > NOW()");
			while (rows.next()) {
				emps.add(new Employee(rows.getInt("number"), rows.getFloat("salary"), rows.getString("name")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return emps;
	}
	
	public static void getEmployees(Employee emp) {

		if (c == null) {
			c = getConnection();
		}
		try {
			Statement s = c.createStatement();
			s.executeQuery("INSERT into Employee (Name) values (\'" + emp.getName() + "\'");
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return emps;
	}

	

}
