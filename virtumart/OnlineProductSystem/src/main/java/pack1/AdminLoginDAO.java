package pack1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Common.DBConnection;

public class AdminLoginDAO {

	AdminBean ab = null;

	AdminBean login(String username, String password) {
		try {
			// jdbc implementations
			Connection c = DBConnection.getCon();
//			String query="";
			PreparedStatement ps = c.prepareStatement("SELECT * FROM AdminTab58 WHERE UNAME=? AND PWORD=?");
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				ab = new AdminBean();
				ab.setUsername(username);
				ab.setPassword(password);
				ab.setFirstname(rs.getString(3));
				ab.setLastname(rs.getString(4));
				ab.setAddress(rs.getString(5));
				ab.setMailid(rs.getString(6));
				ab.setPhno(rs.getLong(7));
			}
			
			} catch (Exception e) {
			e.printStackTrace();
			}
		
			return ab;

	}

//	public boolean connection() {
//		Connection c=DBConnection.getCon();
//		return false;
//	}

}
