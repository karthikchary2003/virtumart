package pack1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Common.DBConnection;

public class AddProductDAO {
 
	int k=0 ;
	public   int insert(ProductBean pb) {
	try {
		Connection c = DBConnection.getCon();
		PreparedStatement ps = c.prepareStatement("INSERT INTO product58 VALUES(?,?,?,?)");
		ps.setString(1, pb.getProduct_code());
		ps.setString(2, pb.getProduct_name());
		ps.setDouble(3, pb.getProduct_price());
		ps.setInt(4, pb.getProductquantity());
		k=ps.executeUpdate();
	}catch (Exception e) {
		e.printStackTrace();
	}
	
		return k;
		
	}


}
