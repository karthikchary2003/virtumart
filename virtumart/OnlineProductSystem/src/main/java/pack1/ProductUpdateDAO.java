package pack1;

import java.sql.Connection;
import java.sql.PreparedStatement;

import Common.DBConnection;

public class ProductUpdateDAO {
	
	int k=0;
	public int update(ProductBean pb) {
	
		
		try {
			Connection c=DBConnection.getCon();
			PreparedStatement ps=c.prepareStatement(" UPDATE PRODUCT58 SET PPRICE=? , PQUANTITY=? WHERE PCODE=?");
			ps.setDouble(1, pb.getProduct_price());
			ps.setInt(2, pb.getProductquantity());
			ps.setString(3, pb.getProduct_code());
			k=ps.executeUpdate();
			
		
			
			
			
			
		} catch (Exception e) {
	e.printStackTrace();
		}
		
		return k;
		
	}
	
	

}
