package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class SalesEmployeeQueries {

	public SalesEmployeeQueries() {
	}

	public static ArrayList<Employee> getSalesEmployees() {

		Connection c = utils.DBUtils.getConnection();
		ArrayList<Employee> emps = new ArrayList<Employee>();
		try {
			Statement s = c.createStatement();
			ResultSet rows = s.executeQuery(
					"Select * from sales join employee using (employee_number)");
			while (rows.next()) {
				emps.add(new Employee(rows.getString("name"),
						rows.getString("ni_number"), rows.getString("department"),
						rows.getString("dob"),
						rows.getString("address"),
						rows.getString("commissionRate"),
						rows.getString("totalSales")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return emps;
	}
	
	public static boolean insertEmployees(SalesEmployee emp) throws SQLException {
		String empQuery = "INSERT INTO employee(name, ni_number, department, dob) "
				+ "VALUES (\"" + emp.getName() + "\", \"" + emp.getNiNumber() 
				+ "\", \"" + emp.getDepartment() + "\", \"" + emp.getDob() + "\")";
		
		String payQuery = "INSERT INTO payroll(iban, starting_salary) VALUES (\"" 
		+ emp.getIban() + "\", \"" + emp.getSalary() + "\")";
		
		String addQuery = "INSERT INTO address(address, city, postcode) VALUES (\"" 
		+ emp.getAddress() + "\", \"testCity\", \"testPostcode\")";
		
		String addSalesQuery = "INSERT INTO sales(commissionRate, totalSales) VALUES (\"" 
				+ emp.getCommissionRate() + "\", \"" + emp.getTotalSales() + "\")";
		
		Connection c;
		c = utils.DBUtils.getConnection();
		Statement s = c.createStatement();
		s.executeUpdate(empQuery);
		s.executeUpdate(payQuery);
		s.executeUpdate(addQuery);
		s.executeUpdate(addSalesQuery);
		c.close();
		return true;
	}

	

}
