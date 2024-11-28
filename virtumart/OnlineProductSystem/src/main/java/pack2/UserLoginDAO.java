package pack2;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Common.DBConnection;

public class UserLoginDAO {
	
	
//	UserBean ub=null;
//	UserBean login(String username,String password) {
//		
//		try {
//			Connection c=DBConnection.getCon();
//			
//			PreparedStatement ps=c.prepareStatement("select * from usertab58 where uname=? and pword=?");
//			ps.setString(1, username);
//			ps.setString(2, password);
//			
//			ResultSet rs=ps.executeQuery();
//			if(rs.next()) {
//				ub=new UserBean();
//				ub.setUsername(username);
//				ub.setPassword(password);
//				ub.setFirstname(ub.getFirstname());
//				ub.setLastname(ub.getLastname());
//				ub.setAddress(ub.getAddress());
//				ub.setMailid(ub.getMailid());
//				ub.setPhno(ub.getPhno());
//			}
//			
//			
//		} catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}
//		
//		
//		
//		
//		
//		return ub;
//		
//	}
//	
//	
//	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	UserBean ub = null;

	UserBean login(String username, String password) {
		try {
			// jdbc implementations
			Connection c = DBConnection.getCon();
			 String query="SELECT * FROM USERTAB58 WHERE UNAME=? AND PWORD=?";
			PreparedStatement ps = c.prepareStatement(query);
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				ub = new UserBean();
				ub.setUsername(username);
				ub.setPassword(password);
				ub.setFirstname(rs.getString(3));
				ub.setLastname(rs.getString(4));
				ub.setAddress(rs.getString(5));
				ub.setMailid(rs.getString(6));
				ub.setPhno(rs.getString(7));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return ub;

	}

}
