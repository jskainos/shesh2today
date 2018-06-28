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
				emps.add(new Employee(rows.getString("name")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return emps;
	}
	
	public static void insertEmployees(Employee emp) {
		System.out.println(emp.getName());
		String query = "INSERT into employee (name, ni_number, dob, department) values (\"" + emp.getName() + "\", \"1\", \"24\", \"BU\");";

		System.out.println(query);
		Connection c = utils.DBUtils.getConnection();
		try {
			Statement s = c.createStatement();
			s.executeUpdate(query);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	

}
