package utils;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DBUtils {

	public DBUtils() {
		// TODO Auto-generated constructor stub
	}

	private static Connection getConnection() {
		String user;
		String password;
		String host;
		Connection c;
		try (FileInputStream propsStream = new FileInputStream("employeesdb.properties")){
			//Class.forName("com.mysql.jdbc.Driver");

			Properties props = new Properties();
			props.load(propsStream);

			user 		= props.getProperty("user");
			password 	= props.getProperty("password");
			host	 	= props.getProperty("host");

			if (user == null || password == null || host == null)
				throw new IllegalArgumentException(
						"Properties file must exist and must contain user, password, and host properties.");

			c = DriverManager.getConnection("jdbc:mysql://" + host + "/employees?useSSL=false", user, password);
			return c;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
