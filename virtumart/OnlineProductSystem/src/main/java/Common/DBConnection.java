package Common;

import static Common.DBInfo.*;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

	//static variable
	private static Connection con=null; 

	//default constructor
	private DBConnection() {
	}

	//static block which executes when the class loads
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(dburl, name, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//getCon method which returns the con-connection
	public static Connection getCon() {
		return con;

	}
}
